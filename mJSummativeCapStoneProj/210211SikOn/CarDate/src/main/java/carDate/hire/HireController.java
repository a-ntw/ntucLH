package carDate.hire;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
		private HireDao hireDao;

		@Autowired
		private CustomerDao customerDao;

		@Autowired
		private EmployeeDao employeeDao;

		@Autowired
		private VehicleDao vehicleDao;

		@Autowired
		private VehStatusRepo vehStatusRepo;

		private Object principal;
		private String empName;


		int currPage;
		int totalPages;
		int pageSize;
		int nextPageSize;
		String sortField;
		String sortDirection;
		long pinCustId;
		long pinVehId;
		
		private boolean loadSessionAttributes(HttpSession session) {
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
		
		
		public boolean hasRole(String role) {

			System.out.println("\n\t Explicit authentication begins...");
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			empName = "";
			
			if (principal instanceof UserDetails) {
				empName = ((UserDetails) principal).getUsername();
				System.out.println("\t Authenticating User=" + empName + "  for Role=" + role + "...");
				System.out.println("\t authenticaed user has these roles=" + ((UserDetails) principal).getAuthorities());
				if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_".concat(role)))) {
					System.out.println("\t Explicit authentication ends with true.");
					return true;
				}
				System.out.println("\t Explicit authentication ends with false due to missing required Role " + role + ".");
				return false;
			} else {
				System.out.println("\t Explicit authentication ends with false due to missing UserDetails.");
				return false;
			}
		}

		
		@GetMapping("/hirePage/{pageMvnt}")
		public String hirePaginated(@PathVariable(value="pageMvnt") int pageMvnt,
				Model model, 
				HttpSession session) {
			if ((!hasRole("MANAGER")) && (!hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			switch (pageMvnt) {
			    case -9: currPage = 1; break;                            // go to first page
			    case -1: currPage = currPage > 1? currPage - 1:1; break; // go to prev page  
			    case  0: break;                                          // stay at curr page
			    case  1: currPage = currPage < totalPages? totalPages + 1:totalPages; break;  // go to next page
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
				newHire.setEmpFulfill(employeeDao.getEmployeeByEmpName(empName));
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
			session.setAttribute("empName", empName);
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

			if ((!hasRole("MANAGER")) && (!hasRole("USER"))) {return "/403";}
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
					newHire.setEmpReturn(employeeDao.getEmployeeByEmpName(empName));
					newHire.setDtsStart(hire.getDtsStart());
					newHire.setDtsEnd(hire.getDtsEnd());
					newHire.setDeposit(hire.getDeposit());
					newHire.setDailyRate(hire.getDailyRate());
					newHire.setHireFee(hire.getHireFee());
					newHire.setDtsEndActual(java.time.LocalDateTime.now());
					newHire.setHireFeeActual(computeFee(newHire.getDailyRate(), newHire.getDtsStart(), newHire.getDtsEnd(), newHire.getDtsEndActual()));
					model.addAttribute("optMsg", "Enter the actual return date time, click <Save> to confirm return of vehicle.");
				}
			}
			model.addAttribute("newHire", newHire);
			return hirePaginated(0, model, session);
		}

		
		@PostMapping("/hireSaveOts/{saveMode}")	
		public String hireSaveOts(@PathVariable(value="saveMode") String saveMode,
				@Valid @ModelAttribute("newHire")Hire newHire, BindingResult bindingResult, 
				Model model, 
				HttpSession session) {

			if ((!hasRole("MANAGER")) && (!hasRole("USER"))) {return "/403";}
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

				myCust = customerDao.getCustomerById(newHire.getCustomer().getCustId());
				if (myCust.getCurrHire()!=null) {
					model.addAttribute("optMsg", "Customer is already hiring the Vehicle " + myCust.getCurrHire().getVehicle().getVehLicPlate() + ".");
					return hirePaginated(0, model, session);
				}
				
				myVeh = vehicleDao.getVehicleById(newHire.getVehicle().getVehId());
				if (myVeh.getCurrHire()!=null) {
					model.addAttribute("optMsg", "Vehicle is currently hired by Customer " + myVeh.getCurrHire().getCustomer().getCustName() + ".");
					return hirePaginated(0, model, session);
				}

				// compute HireFee base on latest details:
				computedFee = computeFee(newHire.getDailyRate(), newHire.getDtsStart(), newHire.getDtsEnd(), newHire.getDtsEnd());
				
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
				computedFee = computeFee(newHire.getDailyRate(), newHire.getDtsStart(), newHire.getDtsEnd(), newHire.getDtsEndActual());
				
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
			model.addAttribute("newHire", null);
			return hirePaginated(0, model, session); 
		}
		

		private float computeFee(double dailyRate, LocalDateTime dtsStart, LocalDateTime dtsEnd, LocalDateTime dtsEndActual) {
			// TODO Auto-generated method stub
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
				feeIs = (float) (feeIs + (hireHours1 * dailyRate * 0.05));
			}

			// 2. compute no of days from dtsStart to planed dtsEnd, charge 100% of dailyRate/day.  Compute base on date, ignore actual hours.
			long hireDays1 = dtsStart.truncatedTo(ChronoUnit.DAYS).until(dtsEnd.truncatedTo(ChronoUnit.DAYS), ChronoUnit.DAYS);
			if (hireDays1 > 0) {
				System.out.println("\t Regular hire: Daily from " + dtsStart.truncatedTo(ChronoUnit.DAYS) + " to " + dtsEnd.truncatedTo(ChronoUnit.DAYS) + " for " + hireDays1 + " days = $" + (hireDays1 * dailyRate));
				feeIs = (float) (feeIs + (hireDays1 * dailyRate));
			}

			// 3. compute no of hours from standard return time to dtsEnd, if positive, means late return, charge late return fee=5% of dailyRate/hr.
			LocalDateTime dtsEnd2 = dtsEnd.truncatedTo(ChronoUnit.DAYS).plusHours(12); // this is the last return time for the Hire end day.
			long hireHours2 = dtsEnd2.until(dtsEnd.plusMinutes(59), ChronoUnit.HOURS);
			hireHours2 = (hireHours2<0)?0:hireHours2; 
			if (hireHours2 > 0) {
				System.out.println("\t Regular hire: Late return from " + dtsEnd2 + " to " + dtsEnd + " for " + hireHours2 + " hours = $" + (hireHours2 * dailyRate * 0.05));
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
					feeIs = (float) (feeIs + (hireHours3 * dailyRate * 0.05 * 1.1));
				}
				// 5. compute no of days from dtsEnd to planed dtsEndActual, charge 100% of dailyRate/day and apply 10% extra-time fee.  Compute base on date, ignore actual hours.
				long hireDays2 = dtsEnd.truncatedTo(ChronoUnit.DAYS).until(dtsEndActual.truncatedTo(ChronoUnit.DAYS), ChronoUnit.DAYS);
				if (hireDays2 > 0) {
					System.out.println("\t Extra time (10% levy): Daily Hire from " + dtsEnd.truncatedTo(ChronoUnit.DAYS) + " to " + dtsEndActual.truncatedTo(ChronoUnit.DAYS) + " for " + hireDays2 + " days = $" + (hireDays1 * dailyRate * 1.1));
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
					feeIs = (float) (feeIs + (hireHours4 * dailyRate * 0.05 * 1.1));
				}
			}
			System.out.println("\t Total fee " + feeIs);
			return feeIs;
		}


		@GetMapping("/hireDeleOts/{hireId}")
		public String hireDeleOts(@PathVariable(value = "hireId") long hireId,
				Model model, 
				HttpSession session) {
			if (!hasRole("MANAGER")) {return "/403";}
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

	
}
