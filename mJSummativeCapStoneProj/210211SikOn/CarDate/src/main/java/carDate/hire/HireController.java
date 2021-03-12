package carDate.hire;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Color;

import carDate.Home;
import carDate.cust.Customer;
import carDate.cust.CustomerDao;
import carDate.emp.EmployeeDao;
import carDate.veh.Vehicle;
import carDate.veh.VehicleDao;
import carDate.veh.VehStatusRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@Api(value = "HireController", description = "Hire maintenance")
	@Controller
	public class HireController {

		@Autowired
		private Home home;

		@Autowired
		private HireDao hireDao;

		@Autowired
		private CustomerDao customerDao;

		@Autowired
		private EmployeeDao employeeDao;

		@Autowired
		private VehicleDao vehicleDao;

		@Autowired
		private VehStatusRepo vehStatusRepo;

		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
		DateTimeFormatter dtsFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
		String currFunc;
		int currPage;
		int totalPages;
		int pageSize;
		int nextPageSize;
		String sortField;
		String sortDirection;
		long pinCustId;
		long pinVehId;
		
		private boolean loadSessionAttributes(HttpSession session) {
			currFunc = (session.getAttribute("currFunc")==null)?"":(String) session.getAttribute("currFunc");
			if (!currFunc.equals("hire")) {
				currFunc = "hire";
				session.setAttribute("currFunc", currFunc);
			}

			currPage = (session.getAttribute("hireCurrPage")==null)?1:(int) session.getAttribute("hireCurrPage");
			session.setAttribute("hireCurrPage", currPage);
			
			totalPages = (session.getAttribute("hireTotalPages"))==null?1:(int) session.getAttribute("hireTotalPages");
			session.setAttribute("hireTotalPages", totalPages);

			pageSize = (session.getAttribute("hirePageSize")==null)?5:(int) session.getAttribute("hirePageSize");
			session.setAttribute("hirePageSize", pageSize);

			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("hireNextPageSize", nextPageSize);

			sortField = (session.getAttribute("hireSortField")==null)?"hireId":(String) session.getAttribute("hireSortField");
			session.setAttribute("hireSortField", sortField);
			
			sortDirection = (session.getAttribute("hireSortDirection")==null)?"ASC":(String) session.getAttribute("hireSortDirection");
			session.setAttribute("hireSortDirection", sortDirection);

			pinCustId = (session.getAttribute("pinCustId")==null)?0:(long) session.getAttribute("pinCustId");
			session.setAttribute("pinCustId", pinCustId);

			pinVehId = (session.getAttribute("pinVehId")==null)?0:(long) session.getAttribute("pinVehId");
			session.setAttribute("pinVehId", pinVehId);

			return true;
		}

		
		@GetMapping("/hirePage/{pageMvnt}")
		public String hirePaginated(@PathVariable(value="pageMvnt") int pageMvnt,
				Model model, 
				HttpSession session) {
			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			switch (pageMvnt) {
			    case -9: currPage = 1; break;                            // go to first page
			    case -1: currPage = currPage > 1? currPage - 1:1; break; // go to prev page  
			    case  0: break;                                          // stay at curr page
			    case  1: currPage = currPage < totalPages? currPage + 1:totalPages; break;  // go to next page
			    case  9: currPage = totalPages; break;                   // go to last page
			    default: currPage = 1;
			}

			Customer pinCust = new Customer();
			if (pinCustId>0) {
				pinCust = customerDao.getCustomerById(pinCustId);
			}
			pinCustId = pinCust.getCustId();
			model.addAttribute("pinCust", pinCust);
			model.addAttribute("pinCustId", pinCustId);
			
			Vehicle pinVeh = new Vehicle();
			if (pinVehId>0) {
				pinVeh = vehicleDao.getVehicleById(pinVehId);
			}
			pinVehId = pinVeh.getVehId();
			model.addAttribute("pinVeh", pinVeh);
			model.addAttribute("pinVehId", pinVehId);
			
			Hire newHire = (Hire)model.getAttribute("newHire");
			if (newHire==null) {
				newHire = new Hire();
				if ((pinCust.getIsActive()) && (pinCust.getCustLinked()!=null) && (pinCust.getCurrHire()==null)) {newHire.setCustomer(pinCust);}
				if (pinVeh.getVehStatus()==vehStatusRepo.findByName("FREE")) {
					newHire.setVehicle(pinVeh);
					newHire.setDailyRate(pinVeh.getDailyRate());
				}
				newHire.setEmpFulfill(employeeDao.getEmployeeByEmpName(home.getEmpName()));
				newHire.setDtsStart(java.time.LocalDateTime.now());
				newHire.setDtsEnd(newHire.getDtsStart().truncatedTo(ChronoUnit.DAYS).plusDays(1).plusHours(12));
			}
			model.addAttribute("newHire", newHire);
			
			session.setAttribute("hireCurrPage", currPage);
			Page <Hire> page = hireDao.hirePaginated(currPage, pageSize, sortField, sortDirection);
			session.setAttribute("hireTotalPages", page.getTotalPages());
			if ((currPage > 1) && (currPage > page.getTotalPages())) {return hirePaginated(9, model, session);}
			List <Hire> listHires = page.getContent();
			model.addAttribute("listHires", listHires);
			session.setAttribute("hireTotalItems", page.getTotalElements());
			session.setAttribute("empName", home.getEmpName());
			return "Hires";
		}
		

		@GetMapping("/hireSort/{sortField}")
		//change sortField, if same sortField given, change the sort direction
		public String hireSort(@PathVariable(value="sortField") String newSortField, 
				Model model, 
				HttpSession session) {
			
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			if (newSortField.equals(sortField)) {
				// if sortDirection reversed, mirror the page number so records currently on screen continue to be visible
				currPage = (totalPages==0)?1:totalPages - currPage + 1;
				sortDirection = sortDirection.equalsIgnoreCase("ASC")?"DESC":"ASC";
			} else {  
				// if sortField is changed: go to page 1 and change sort order to  Asc
				sortField = newSortField;
				currPage = 1;
				sortDirection = "ASC";
			}
			
			session.setAttribute("hireCurrPage", currPage);
			session.setAttribute("hireSortField", sortField);
			session.setAttribute("hireSortDirection", sortDirection);
			return hirePaginated(0, model, session);
		}


		@GetMapping("/hirePageSize/{newPageSize}")
		public String hirePageSize(@PathVariable(value="newPageSize") int newPageSize,
				Model model, 
				HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}
			// when page size is changed, current page is adjusted so that most of the 
			// records currently visible continue to appear in the new page.
			currPage = (((currPage - 1) * pageSize + 1) / newPageSize) + (((((currPage - 1) * pageSize + 1) % newPageSize)==0)?0:1);
			pageSize = newPageSize; 
			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("hireCurrPage", currPage);
			session.setAttribute("hirePageSize", pageSize);
			session.setAttribute("hireNextPageSize", nextPageSize);
			return hirePaginated(0, model, session);
		}


		@GetMapping("/hirePinCust/{theCustId}")
		public String hirePinCust(@PathVariable(value = "theCustId") long theCustId, 
	            Model model, HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Customer pinCust = new Customer();
			if (theCustId == 0) {
				// when theCustId is 0, unpin the pinned Customer
				pinCustId = 0;
				model.addAttribute("pinCust", pinCust);
				session.setAttribute("pinCustId", pinCustId);
			} 
			return hirePaginated(0, model, session);
		}


		@GetMapping("/hirePinVeh/{theVehId}")
		public String hirePinVeh(@PathVariable(value = "theVehId") long theVehId, 
	            Model model, HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Vehicle pinVeh = new Vehicle();
			if (theVehId == 0) {
				// when theVehId is 0, unpin the pinned Vehicle
				pinVehId = 0;
				model.addAttribute("pinVeh", pinVeh);
				session.setAttribute("pinVehId", pinVehId);
			} 
			return hirePaginated(0, model, session);
		}


		@ApiOperation(value="Brings high-lighted hire record to editing area for return", response=Iterable.class, tags="home")
		@GetMapping("/hireRetuOts/{hireId}")
		public String hireRetuOts(@PathVariable(value = "hireId") long hireId, 
				Model model, 
				HttpSession session) {

			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// Get hire from the Service
			Hire newHire = new Hire();
			
			if (hireId == 0) {
				// this method is not expected to be invoked with hireId=0
			} else {
				if (hireId > 0) {  // bring details of existing hire into input area for hire return
					Hire hire = hireDao.getHireById(hireId);
					if (hire.getEmpReturn()!=null) {
						model.addAttribute("optMsg", "Hire (" + hireId + ") is already returned.");
						return hirePaginated(0, model, session);
					}
					newHire.setHireId(hire.getHireId());
					newHire.setCustomer(hire.getCustomer());
					newHire.setVehicle(hire.getVehicle());
					newHire.setEmpFulfill(hire.getEmpFulfill());
					newHire.setEmpReturn(employeeDao.getEmployeeByEmpName(home.getEmpName()));
					newHire.setDtsStart(hire.getDtsStart());
					newHire.setDtsEnd(hire.getDtsEnd());
					newHire.setDeposit(hire.getDeposit());
					newHire.setDailyRate(hire.getDailyRate());
					newHire.setHireFee(hire.getHireFee());
					newHire.setDtsEndActual(java.time.LocalDateTime.now());
					newHire.setHireFeeActual(computeFee(newHire.getDailyRate(), newHire.getDtsStart(), newHire.getDtsEnd(), newHire.getDtsEndActual(), null, null, null));
					model.addAttribute("optMsg", "Enter the actual return date time, click <Save> to confirm return of vehicle.");
				}
			}
			model.addAttribute("newHire", newHire);
			return hirePaginated(0, model, session);
		}

		
		@PostMapping("/hireSaveOts/{saveMode}")	
		public String hireSaveOts(@PathVariable(value="saveMode") String saveMode,
				@Valid @ModelAttribute("newHire")Hire newHire, BindingResult bindingResult, 
//				HttpServletResponse response,
				Model model, 
				HttpSession session) {

			if ((!home.hasRole("MANAGER")) && (!home.hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}
			
			if (bindingResult.hasErrors()) {
				model.addAttribute("optMsg", "Please correct the validation errors.");
				return hirePaginated(0, model, session);
			}
			Vehicle myVeh = new Vehicle();
			Customer myCust = new Customer();
			float computedFee;
			
			if (newHire.getHireId()==0) { // this is a new Hire
				
				if (newHire.getDtsStart()==null) {
					model.addAttribute("optMsg", "Hire start date/times is mandatory.");
					return hirePaginated(0, model, session);
				}
				
				if (newHire.getDtsStart().isBefore(java.time.LocalDateTime.now().minusMinutes(30))) {
					model.addAttribute("optMsg", "Hire start time must be within the last 30 minutes.");
					return hirePaginated(0, model, session);
				}
	
				if (newHire.getDtsStart().isAfter(java.time.LocalDateTime.now().plusMinutes(30))) {
					model.addAttribute("optMsg", "Hire start time must be within the next 30 minutes.");
					return hirePaginated(0, model, session);
				}
	
				if (newHire.getDtsEnd()==null) {
					model.addAttribute("optMsg", "Hire end date/times is mandatory.");
					return hirePaginated(0, model, session);
				}
	
				if (newHire.getDtsEnd().isBefore(newHire.getDtsStart())) {
					model.addAttribute("optMsg", "Hire end date/time must be after start date/time.");
					return hirePaginated(0, model, session);
				}
	
				if ((newHire.getDtsEnd().getHour()<9) || (newHire.getDtsEnd().getHour()>20)) {
					model.addAttribute("optMsg", "Hire can only end during office open hours 09:00-20:59.");
					return hirePaginated(0, model, session);
				}

				myCust = newHire.getCustomer();
				if (myCust==null) {
					if (pinCustId==0) {
						model.addAttribute("optMsg", "Please pin the hiring customer first.");
					} else {
						Customer theCust = customerDao.getCustomerById(pinCustId);
						model.addAttribute("optMsg", "The pinned customer [" + theCust.getCustName()+"] is not eligible for hiring.");
					}
					return hirePaginated(0, model, session);
				}
				if (myCust.getCurrHire()!=null) {
					model.addAttribute("optMsg", "Customer is already hiring the Vehicle " + myCust.getCurrHire().getVehicle().getVehLicPlate() + ".");
					return hirePaginated(0, model, session);
				}
				
				myVeh = newHire.getVehicle();
				if (myVeh==null) {
					if (pinVehId==0) {
						model.addAttribute("optMsg", "Please select a vehicle by pinning it first.");
					} else {
						Vehicle theVeh = vehicleDao.getVehicleById(pinVehId);
						model.addAttribute("optMsg", "The pinned vehicle ["+ theVeh.getVehLicPlate()+"] is not available for hiring.");
					}
					return hirePaginated(0, model, session);
				}
				if (myVeh.getCurrHire()!=null) {
					model.addAttribute("optMsg", "Vehicle is currently hired by Customer " + myVeh.getCurrHire().getCustomer().getCustName() + ".");
					return hirePaginated(0, model, session);
				}

				// compute HireFee base on latest details:
				computedFee = computeFee(newHire.getDailyRate(), newHire.getDtsStart(), newHire.getDtsEnd(), newHire.getDtsEnd(), null, null, null);
				
				// if computed fee differ from fee on form:
				//      Send back the form to screen, with a message that the Hire fee has changed, click "Save" to commit hiring
				if (computedFee != newHire.getHireFee()) {
					newHire.setHireFee(computedFee);
					model.addAttribute("optMsg", "Fee computed, please click <Save> to confirm Hire.");
					return hirePaginated(0, model, session);
				}
				// if computed fee same as fee on form:
				//      if saveMode is "try", send back the form to screen, with a message the says click "Save" to commit hiring
				if (saveMode.equalsIgnoreCase("try")) {
					model.addAttribute("optMsg", "Please click <Save> to confirm Hire.");
					return hirePaginated(0, model, session);
				}
			} else {  // this is a Hire return
				if (newHire.getDtsEndActual()==null) {
					model.addAttribute("optMsg", "Actual Hire return date/times is mandatory.");
					return hirePaginated(0, model, session);
				}
				
				if (newHire.getDtsEndActual().isBefore(java.time.LocalDateTime.now().minusMinutes(30))) {
					model.addAttribute("optMsg", "Actual Hire return time must be within the last 30 minutes.");
					return hirePaginated(0, model, session);
				}
	
				if (newHire.getDtsEndActual().isAfter(java.time.LocalDateTime.now().plusMinutes(30))) {
					model.addAttribute("optMsg", "Actual Hire return time must be within the next 30 minutes.");
					return hirePaginated(0, model, session);
				}
				
				// compute HireFeeActual base on latest details:
				computedFee = computeFee(newHire.getDailyRate(), newHire.getDtsStart(), newHire.getDtsEnd(), newHire.getDtsEndActual(), null, null, null);
				
				// if computed fee differs from fee on form:
				//      Send back the form to screen, with a message that the Hire fee has changed, click "Save" to commit return
				if (computedFee != newHire.getHireFeeActual()) {
					newHire.setHireFeeActual(computedFee);
					model.addAttribute("optMsg", "Actual Fee computed, please click <Save> to confirm Return of Hire.");
					return hirePaginated(0, model, session);
				}

				// else if computed fee same as fee on form:
				//      if saveMode is "try", send back the form to screen, with a message the says click "Save" to commit return
				if (saveMode.equalsIgnoreCase("try")) {
					model.addAttribute("optMsg", "Please click <Save> to confirm return of Hire.");
					return hirePaginated(0, model, session);
				}
			}

			try {
				hireDao.saveHire (newHire);
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("optMsg", e.getMessage());
				return hirePaginated(0, model, session);
			}
			
			
			if (newHire.getDtsEndActual()==null) { // saving a new hire
				myVeh = vehicleDao.getVehicleById(newHire.getVehicle().getVehId());
				myVeh.setCurrHire(newHire);
				myVeh.setVehStatus(vehStatusRepo.findByName("HIRED"));
				myVeh.addHire(newHire);
				myCust = customerDao.getCustomerById(newHire.getCustomer().getCustId());
				myCust.setCurrHire(newHire);
				myCust.addHire(newHire);
			} else { // saving a hire return
				myVeh = vehicleDao.getVehicleById(newHire.getVehicle().getVehId());
				myVeh.setCurrHire(null);
				myVeh.setVehStatus(vehStatusRepo.findByName("FREE"));
				myCust = customerDao.getCustomerById(newHire.getCustomer().getCustId());
				myCust.setCurrHire(null);
			}
// the following works, but execution did not return to this method after geneeration of the PDF file.
// Need to find out how to make the execution return here and 			
//			try {
//				hirePdf(newHire.getHireId(), response);
//			} catch (Exception e) {}
			model.addAttribute("newHire", null);
			return hirePaginated(0, model, session); 
		}
		

		private float computeFee(double dailyRate, LocalDateTime dtsStart, LocalDateTime dtsEnd, LocalDateTime dtsEndActual, 
				PdfPTable table, PdfPCell cell, Font font) {
			// TODO Auto-generated method stub
			String myStr;
			if (dtsEndActual==null) {
				dtsEndActual = dtsEnd;
			}
			long hireHoursExtra = dtsEnd.until(dtsEndActual.plusMinutes(59), ChronoUnit.HOURS);
			System.out.print("\n\t Computing fee for daily rate " + dailyRate + " from " + dtsStart + " to " + dtsEnd);
			if (dtsEnd==dtsEndActual) {
				System.out.println(".");
			} else {
				System.out.println(" and extra time into " + dtsEndActual + ".");
			}
			float feeIs = 0;
			// 1. compute no of hours from dtsStart to the earlier of (standard collection time, dtsEnd)
			//    if positive, means early pickup, charge early fee=5% of dailyRate/hr.
			LocalDateTime dtsEnd1 = dtsStart.truncatedTo(ChronoUnit.DAYS).plusHours(14); // this is the earliest collection time for the Hire start day.
			if (dtsEnd.isBefore(dtsEnd1)) {
				dtsEnd1 = dtsEnd;
			}
			long hireHours1 = dtsStart.until(dtsEnd1.plusMinutes(59), ChronoUnit.HOURS);
			hireHours1 = (hireHours1<0)?0:hireHours1;
			if (hireHours1 > 0) {
				System.out.println("\t Regular hire: Early collection from " + dtsStart + " to " + dtsEnd1 + " for " + hireHours1 + " hours = $" + (hireHours1 * dailyRate * 0.05));
				if (table!=null) {
			        table.addCell("Early pick-up");
			        myStr = dtsFormat.format(dtsStart);
			        table.addCell(myStr);
			        myStr = dtsFormat.format(dtsEnd1);
			        table.addCell(myStr);
			        myStr = hireHours1 + " hrs";
			        cell.setPhrase(new Phrase(myStr, font));
			        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			        table.addCell(cell);
			        myStr = defaultFormat.format(dailyRate * 0.05);
			        cell.setPhrase(new Phrase(myStr, font));
			        table.addCell(cell);
			        myStr = defaultFormat.format(hireHours1 * dailyRate * 0.05);
			        cell.setPhrase(new Phrase(myStr, font));
			        table.addCell(cell);
				}
				feeIs = (float) (feeIs + (hireHours1 * dailyRate * 0.05));
			}

			// 2. compute no of days from dtsStart to planed dtsEnd, charge 100% of dailyRate/day.  Compute base on date, ignore actual hours.
			long hireDays1 = dtsStart.truncatedTo(ChronoUnit.DAYS).until(dtsEnd.truncatedTo(ChronoUnit.DAYS), ChronoUnit.DAYS);
			if (hireDays1 > 0) {
				System.out.println("\t Regular hire: Daily from " + dtsStart.truncatedTo(ChronoUnit.DAYS) + " to " + dtsEnd.truncatedTo(ChronoUnit.DAYS) + " for " + hireDays1 + " days = $" + (hireDays1 * dailyRate));
				if (table!=null) {
			        table.addCell("Daily rental");
			        myStr = dateFormat.format(dtsStart.truncatedTo(ChronoUnit.DAYS));
			        table.addCell(myStr);
			        myStr = dateFormat.format(dtsEnd.truncatedTo(ChronoUnit.DAYS));
			        table.addCell(myStr);
			        myStr = hireDays1 + " days";
			        cell.setPhrase(new Phrase(myStr, font));
			        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			        table.addCell(cell);
			        myStr = defaultFormat.format(dailyRate);
			        cell.setPhrase(new Phrase(myStr, font));
			        table.addCell(cell);
			        myStr = defaultFormat.format(hireDays1 * dailyRate);
			        cell.setPhrase(new Phrase(myStr, font));
			        table.addCell(cell);
				}
				
				feeIs = (float) (feeIs + (hireDays1 * dailyRate));
			}

			// 3. compute no of hours from standard return time to dtsEnd, if positive, means late return, charge late return fee=5% of dailyRate/hr.
			LocalDateTime dtsEnd2 = dtsEnd.truncatedTo(ChronoUnit.DAYS).plusHours(12); // this is the last return time for the Hire end day.
			long hireHours2 = dtsEnd2.until(dtsEnd.plusMinutes(59), ChronoUnit.HOURS);
			hireHours2 = (hireHours2<0)?0:hireHours2; 
			if (hireHours2 > 0) {
				System.out.println("\t Regular hire: Late return from " + dtsEnd2 + " to " + dtsEnd + " for " + hireHours2 + " hours = $" + (hireHours2 * dailyRate * 0.05));
				if (table!=null) {
			        table.addCell("Late return");
			        myStr = dtsFormat.format(dtsEnd2);
			        table.addCell(myStr);
			        myStr = dtsFormat.format(dtsEnd);
			        table.addCell(myStr);
			        myStr = hireHours2 + " hrs";
			        cell.setPhrase(new Phrase(myStr, font));
			        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			        table.addCell(cell);
			        myStr = defaultFormat.format(dailyRate * 0.05);
			        cell.setPhrase(new Phrase(myStr, font));
			        table.addCell(cell);
			        myStr = defaultFormat.format(hireHours2 * dailyRate * 0.05);
			        cell.setPhrase(new Phrase(myStr, font));
			        table.addCell(cell);
				}
				feeIs = (float) (feeIs + (hireHours2 * dailyRate * 0.05));
			}

			if (dtsEndActual.isAfter(dtsEnd)) { // Vehicle returned after agreed time, Hire fee must include extra-time at 10% levy
				// 4. compute no of hours from dtsEnd to the earlier of (standard collection time, if positive, means extra early pickup, charge early fee=5% of dailyRate/hr and apply 10% extra time fee.
				LocalDateTime dtsEnd3 = dtsEnd.truncatedTo(ChronoUnit.DAYS).plusHours(14); // this is the earliest collection time for the extra Hire start.
				if (dtsEndActual.isBefore(dtsEnd3)) {
					dtsEnd3 = dtsEndActual;
				}
				long hireHours3 = dtsEnd.until(dtsEnd3.plusMinutes(59), ChronoUnit.HOURS);
				hireHours3 = (hireHours3<0)?0:hireHours3; 
				if (hireHours3 > 0) {
					System.out.println("\t Extra time (10% levy): Early start from " + dtsEnd + " to " + dtsEnd3 + " for " + hireHours3 + " hours = $" + (hireHours3 * dailyRate * 0.05 * 1.1));
					if (table!=null) {
				        table.addCell("Early pick-up (overdue)");
				        myStr = dtsFormat.format(dtsEnd);
				        table.addCell(myStr);
				        myStr = dtsFormat.format(dtsEnd3);
				        table.addCell(myStr);
				        myStr = hireHours3 + " hrs";
				        cell.setPhrase(new Phrase(myStr, font));
				        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				        table.addCell(cell);
				        myStr = defaultFormat.format(dailyRate * 0.05 * 1.1);
				        cell.setPhrase(new Phrase(myStr, font));
				        table.addCell(cell);
				        myStr = defaultFormat.format(hireHours3 * dailyRate * 0.05 * 1.1);
				        cell.setPhrase(new Phrase(myStr, font));
				        table.addCell(cell);
					}
					feeIs = (float) (feeIs + (hireHours3 * dailyRate * 0.05 * 1.1));
				}
				// 5. compute no of days from dtsEnd to planed dtsEndActual, charge 100% of dailyRate/day and apply 10% extra-time fee.  Compute base on date, ignore actual hours.
				long hireDays2 = dtsEnd.truncatedTo(ChronoUnit.DAYS).until(dtsEndActual.truncatedTo(ChronoUnit.DAYS), ChronoUnit.DAYS);
				if (hireDays2 > 0) {
					System.out.println("\t Extra time (10% levy): Daily Hire from " + dtsEnd.truncatedTo(ChronoUnit.DAYS) + " to " + dtsEndActual.truncatedTo(ChronoUnit.DAYS) + " for " + hireDays2 + " days = $" + (hireDays2 * dailyRate * 1.1));
					if (table!=null) {
				        table.addCell("Daily rental (overdue)");
				        myStr = dateFormat.format(dtsEnd.truncatedTo(ChronoUnit.DAYS));
				        table.addCell(myStr);
				        myStr = dateFormat.format(dtsEndActual.truncatedTo(ChronoUnit.DAYS));
				        table.addCell(myStr);
				        myStr = hireDays2 + " days";
				        cell.setPhrase(new Phrase(myStr, font));
				        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				        table.addCell(cell);
				        myStr = defaultFormat.format(dailyRate * 1.1);
				        cell.setPhrase(new Phrase(myStr, font));
				        table.addCell(cell);
				        myStr = defaultFormat.format(hireDays2 * dailyRate * 1.1);
				        cell.setPhrase(new Phrase(myStr, font));
				        table.addCell(cell);
					}
					feeIs = (float) (feeIs + (hireDays2 * dailyRate * 1.1));
				}
				// 6. compute no of hours from standard return time to dtsEndActual, if positive, means extra late return, charge late return fee=5% of dailyRate/hr and apply 10% extra time fee.
				LocalDateTime dtsEnd4 = dtsEndActual.truncatedTo(ChronoUnit.DAYS).plusHours(12); // this is the last return time for the Hire end day.
				if (dtsEnd4.isBefore(dtsEnd3)) {
					dtsEnd4 = dtsEnd3;
				}
				if (dtsEnd4.isBefore(dtsEnd)) {
					dtsEnd4 = dtsEnd;
				}
				long hireHours4 = dtsEnd4.until(dtsEndActual.plusMinutes(59), ChronoUnit.HOURS);
				hireHours4 = (hireHours4<0)?0:hireHours4;
				if (hireHours4 > 0) {
					System.out.println("\t Extra time (10% levy): Late return from " + dtsEnd4 + " to " + dtsEndActual + " for " + hireHours4 + " hours = $" + (hireHours4 * dailyRate * 0.05 * 1.1));
					if (table!=null) {
				        table.addCell("Late return (overdue)");
				        myStr = dtsFormat.format(dtsEnd4);
				        table.addCell(myStr);
				        myStr = dtsFormat.format(dtsEndActual);
				        table.addCell(myStr);
				        myStr = hireHours4 + " hrs";
				        cell.setPhrase(new Phrase(myStr, font));
				        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				        table.addCell(cell);
				        myStr = defaultFormat.format(dailyRate * 0.05 * 1.1);
				        cell.setPhrase(new Phrase(myStr, font));
				        table.addCell(cell);
				        myStr = defaultFormat.format(hireHours4 * dailyRate * 0.05 * 1.1);
				        cell.setPhrase(new Phrase(myStr, font));
				        table.addCell(cell);
					}
					feeIs = (float) (feeIs + (hireHours4 * dailyRate * 0.05 * 1.1));
				}
			}
			if (table!=null) {
		        table.addCell("");
		        table.addCell("");
		        table.addCell("");
		        table.addCell("");
		        myStr = "Total";
		        cell.setPhrase(new Phrase(myStr, font));
		        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		        table.addCell(cell);
		        myStr = defaultFormat.format(feeIs);
		        cell.setPhrase(new Phrase(myStr, font));
		        table.addCell(cell);
			}
			System.out.println("\t Total fee " + feeIs);
			return feeIs;
		}


		@GetMapping("/hireDeleOts/{hireId}")
		public String hireDeleOts(@PathVariable(value = "hireId") long hireId,
				Model model, 
				HttpSession session) {
			if (!home.hasRole("MANAGER")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Hire myHire = hireDao.getHireById(hireId);
			if (myHire.getDtsEndActual()==null) {
				model.addAttribute("optMsg", "Hire ("+ hireId + ") is active and cannot be deleted.");
				return hirePaginated(0, model, session);
			}
//
//			if (!myHire.getDtsEndActual().plusDays(183).isBefore(java.time.LocalDateTime.now())) {
//				model.addAttribute("optMsg", "Hire ("+ hireId + ") should be retained for 183 days before it can be deleted.");
//				return hirePaginated(0, model, session);
//			}
			
			// call delete hire method
			Customer myCust = customerDao.getCustomerById(myHire.getCustomer().getCustId());
			try {
				myCust.removeHire(myHire);
			} catch(Exception e) {
				e.printStackTrace();
			}
			Vehicle myVeh = vehicleDao.getVehicleById(myHire.getVehicle().getVehId());
			try {
				myVeh.removeHire(myHire);
			} catch(Exception e) {
				e.printStackTrace();
			}

			try {
				this.hireDao.deleteHireById(hireId);
			} catch(DataIntegrityViolationException e) {
				e.printStackTrace();
				model.addAttribute("optMsg", "This Hire is related to other records in the database, it cannot be deleted.");
				return hirePaginated(0, model, session);
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("optMsg", e.getMessage());
				return hirePaginated(0, model, session);
			}
			
			return hirePaginated(0, model, session);
		}

		@GetMapping("/hirePdf/{hireId}")
	    public void hirePdf(@PathVariable(value = "hireId") long hireId,
	    		HttpServletResponse response) throws DocumentException, IOException {

			response.setContentType("application/pdf");
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Hires_" + hireId + ".pdf";
	        response.setHeader(headerKey, headerValue);

	        Hire myHire = hireDao.getHireById(hireId);
	         
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);

	        Font fontData = FontFactory.getFont(FontFactory.HELVETICA);
	        fontData.setSize(11);
	        fontData.setColor(Color.BLACK);
	        
	        Paragraph p = new Paragraph("CarDate Leisure Vehicle Hiring Company Limited", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(p);
	        p = new Paragraph("Vehicle Hiring Invoice", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(p);

	        
	        // print customer and vehicle details
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {3.5f, 1.5f, 3.0f, 3.0f});
	        table.setSpacingBefore(10);
	         
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.DARK_GRAY);
	        cell.setPadding(5);
	         
	        font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);

	        PdfPCell cellData = new PdfPCell();
	        cellData.setPadding(5);
	        
	        cell.setPhrase(new Phrase("Customer ID", font));
	        table.addCell(cell);

	        String strId = "" + myHire.getCustomer().getCustId();
	        cellData.setPhrase(new Phrase(strId, fontData));
	        table.addCell(cellData);
	         
	        cell.setPhrase(new Phrase("Name", font));
	        table.addCell(cell);

	        cellData.setPhrase(new Phrase(myHire.getCustomer().getCustName(), fontData));
	        table.addCell(cellData);
	         
	        // new row
	        cell.setPhrase(new Phrase("Alternate contact", font));
	        table.addCell(cell);

	        strId = "" + myHire.getCustomer().getCustLinked().getCustId();
	        cellData.setPhrase(new Phrase(strId, fontData));
	        table.addCell(cellData);
	         
	        cell.setPhrase(new Phrase("Name", font));
	        table.addCell(cell);

	        cellData.setPhrase(new Phrase(myHire.getCustomer().getCustLinked().getCustName(), fontData));
	        table.addCell(cellData);
	         
	        // new row
	        cell.setPhrase(new Phrase("Vehicle Id", font));
	        table.addCell(cell);

	        strId = "" + myHire.getVehicle().getVehId();
	        cellData.setPhrase(new Phrase(strId, fontData));
	        table.addCell(cellData);
	         
	        cell.setPhrase(new Phrase("Daily rate", font));
	        table.addCell(cell);

	        strId = defaultFormat.format(myHire.getDailyRate());
	        cellData.setPhrase(new Phrase(strId, fontData));
	        table.addCell(cellData);

	         
	        // new row
	        cell.setPhrase(new Phrase("Brand", font));
	        table.addCell(cell);

	        cellData.setPhrase(new Phrase(myHire.getVehicle().getVehBrand(), fontData));
	        table.addCell(cellData);
	         
	        cell.setPhrase(new Phrase("License", font));
	        table.addCell(cell);

	        cellData.setPhrase(new Phrase(myHire.getVehicle().getVehLicPlate(), fontData));
	        table.addCell(cellData);
	         
	        // new row
	        cell.setPhrase(new Phrase("Model", font));
	        table.addCell(cell);

	        cellData.setPhrase(new Phrase(myHire.getVehicle().getVehModel(), fontData));
	        table.addCell(cellData);
	         
	        cellData.setPhrase(new Phrase(" ", font));
	        table.addCell(cellData);
	        table.addCell(cellData);
	         
	        document.add(table);
	        
	        
	        // print hire agreement
	        table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {2.0f, 3.0f, 2.0f, 3.0f});
	        table.setSpacingBefore(10);
	         
	        cell = new PdfPCell();
	        cell.setBackgroundColor(Color.DARK_GRAY);
	        cell.setPadding(5);
	         
	        font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Hiring Starts", font));
	        table.addCell(cell);

	        strId = dtsFormat.format(myHire.getDtsStart());
	        cellData.setPhrase(new Phrase(strId, fontData));
	        table.addCell(cellData);
	         
	        cell.setPhrase(new Phrase("Hiring Id", font));
	        table.addCell(cell);

	        strId = "" + myHire.getHireId();
	        cellData.setPhrase(new Phrase(strId, fontData));
	        table.addCell(cellData);
	         
	        // new row
	        cell.setPhrase(new Phrase("Agreed end", font));
	        table.addCell(cell);

	        strId = dtsFormat.format(myHire.getDtsEnd());
	        cellData.setPhrase(new Phrase(strId, fontData));
	        table.addCell(cellData);
	        
	        if (myHire.getDtsEndActual()==null) {
		        cellData.setPhrase(new Phrase(" ", fontData));
		        table.addCell(cellData);
		        table.addCell(cellData);
	        } else {
		        cell.setPhrase(new Phrase("Actual Return", font));
		        table.addCell(cell);
		        strId = dtsFormat.format(myHire.getDtsEndActual());
		        cellData.setPhrase(new Phrase(strId, fontData));
		        table.addCell(cellData);
	        }
	         
	        document.add(table);
	        
	        
	        
	        // print hire billing details
	        table = new PdfPTable(6);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {3.5f, 3f, 3f, 1.7f, 1.8f, 1.8f});
	        table.setSpacingBefore(10);

	        cell = new PdfPCell();
	        cell.setBackgroundColor(Color.DARK_GRAY);
	        cell.setPadding(5);
	         
	        font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Hire type", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Start", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("End", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Quantity", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Rate", font));
	        table.addCell(cell);
	        cell.setPhrase(new Phrase("Amount", font));
	        
	        table.addCell(cell);

	        // call fee computing method to generate billing details
	        double feeIs = computeFee(myHire.getDailyRate(), myHire.getDtsStart(), myHire.getDtsEnd(), myHire.getDtsEndActual(), table, cellData, fontData);

	        if (myHire.getDeposit()>0) {
	        	cellData.setPhrase(new Phrase("Deposit received", fontData));
		        table.addCell(cellData);
		        strId = dateFormat.format(myHire.getDtsStart());
	        	cellData.setPhrase(new Phrase(strId, fontData));
		        table.addCell(cellData);
		        table.addCell("");
		        table.addCell("");
		        table.addCell("");
		        strId = defaultFormat.format(myHire.getDeposit());
		        cellData.setPhrase(new Phrase(strId, fontData));
		        cellData.setHorizontalAlignment(Element.ALIGN_RIGHT);
		        table.addCell(cellData);

		        
		        table.addCell("");
		        table.addCell("");
		        table.addCell("");
		        table.addCell("");
	        	cellData.setPhrase(new Phrase("Balance", fontData));
		        table.addCell(cellData);
		        strId = defaultFormat.format(feeIs - myHire.getDeposit());
		        cellData.setPhrase(new Phrase(strId, fontData));
		        cellData.setHorizontalAlignment(Element.ALIGN_RIGHT);
		        table.addCell(cellData);
	        }

	         
	        document.add(table);

	        // Print customer acknowledge portion during vehicle pickup.
	        if (myHire.getDtsEndActual()==null) {
		        p = new Paragraph("I acknowledge that the said Vehicle is received in satisfactory condition:");
		        document.add(p);
		        p = new Paragraph(" ");
		        document.add(p);
		        document.add(p);
		        document.add(p);
		        document.add(p);
		        p = new Paragraph("Customer Signature and Date");
		        p.setAlignment(Paragraph.ALIGN_RIGHT);
		        document.add(p);
	        }
	        

	        
	        document.close();
	        
	    }

		
}
