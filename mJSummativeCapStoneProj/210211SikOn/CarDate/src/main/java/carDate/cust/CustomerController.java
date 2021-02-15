package carDate.cust;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import org.springframework.web.bind.annotation.RequestMapping;

import carDate.veh.Vehicle;
import carDate.veh.VehicleDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@Api(value = "CustomerController", description = "Customer maintenance")
	@Controller
	public class CustomerController {

		@Autowired
		private CustomerDao customerDao;

		@Autowired
		private VehicleDao vehicleDao;

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
			currPage = (session.getAttribute("custCurrPage")==null)?1:(int) session.getAttribute("custCurrPage");
			session.setAttribute("custCurrPage", currPage);
			
			totalPages = (session.getAttribute("custTotalPages"))==null?1:(int) session.getAttribute("custTotalPages");
			session.setAttribute("custTotalPages", totalPages);

			pageSize = (session.getAttribute("custPageSize")==null)?5:(int) session.getAttribute("custPageSize");
			session.setAttribute("custPageSize", pageSize);

			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("custNextPageSize", nextPageSize);

			sortField = (session.getAttribute("custSortField")==null)?"custId":(String) session.getAttribute("custSortField");
			session.setAttribute("custSortField", sortField);
			
			sortDirection = (session.getAttribute("custSortDirection")==null)?"ASC":(String) session.getAttribute("custSortDirection");
			session.setAttribute("custSortDirection", sortDirection);

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

		
		@GetMapping("/custPage/{pageMvnt}")
		public String custPaginated(@PathVariable(value="pageMvnt") int pageMvnt,
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
			
			Customer newCust = (Customer)model.getAttribute("newCust");
			if (newCust==null) {
				newCust = new Customer();
				newCust.setIsActive(true);
				if (pinCust.getIsActive()) {newCust.setCustLinked(pinCust);}
				newCust.setDateUpd(java.time.LocalDate.now());
			}
			model.addAttribute("newCust", newCust);
			
			session.setAttribute("custCurrPage", currPage);
			Page <Customer> page = customerDao.custPaginated(currPage, pageSize, sortField, sortDirection);
			session.setAttribute("custTotalPages", page.getTotalPages());
			if ((currPage > 1) && (currPage > page.getTotalPages())) {return custPaginated(9, model, session);}
			List <Customer> listCusts = page.getContent();
			model.addAttribute("listCusts", listCusts);
			session.setAttribute("custTotalItems", page.getTotalElements());
			session.setAttribute("empName", empName);
			return "Customers";
		}
		

		@GetMapping("/custSort/{sortField}")
		//change sortField, if same sortField given, change the sort direction
		public String custSort(@PathVariable(value="sortField") String newSortField, 
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
			
			session.setAttribute("custCurrPage", currPage);
			session.setAttribute("custSortField", sortField);
			session.setAttribute("custSortDirection", sortDirection);
			return custPaginated(0, model, session);
		}


		@GetMapping("/custPageSize/{newPageSize}")
		public String custPageSize(@PathVariable(value="newPageSize") int newPageSize,
				Model model, 
				HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}
			// when page size is changed, current page is adjusted so that most of the 
			// records currently visible continue to appear in the new page.
			currPage = (((currPage - 1) * pageSize + 1) / newPageSize) + (((((currPage - 1) * pageSize + 1) % newPageSize)==0)?0:1);
			pageSize = newPageSize; 
			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("custCurrPage", currPage);
			session.setAttribute("custPageSize", pageSize);
			session.setAttribute("custNextPageSize", nextPageSize);
			return custPaginated(0, model, session);
		}

		
		@GetMapping("/custPin/{theCustId}")
		public String custPin(@PathVariable(value = "theCustId") long theCustId, 
	            Model model, HttpSession session) {

			if (!loadSessionAttributes(session)) {return "redirect:/";}

			if (theCustId >= 0) {
				// when theCustId is 0, unpin the pinned customer
				// when theCustId is >0, make it the pinned customer
				pinCustId = theCustId;
				Customer pinCust = new Customer();
				if (pinCustId > 0) {
					pinCust = customerDao.getCustomerById(pinCustId);
				}
				pinCustId = pinCust.getCustId();
				model.addAttribute("pinCust", pinCust);
				session.setAttribute("pinCustId", pinCustId);
				return custPaginated(0, model, session);
			} else {                  // else to make pinCust the alt contract of the customer
				// when theCustId is <0,:
				// when pinCustId = 0, clear custLinked for the customer whose custId = -theCustId
				// when pinCustId > 0, update custLinked tp the pinned customer for the customer whose custId = -theCustId
				theCustId = - theCustId;
				if (theCustId == pinCustId) {
					model.addAttribute("optMsg", "You cannot nominate a customer to be his/her own alternate contact.");
					return custPaginated(0, model, session);
				}
				Customer pinCust = new Customer();
				Customer myCust = customerDao.getCustomerById(theCustId);
				if (pinCustId == 0) {
					myCust.setCustLinked(null);
					myCust.setDateUpd(java.time.LocalDate.now());
				} else {
					myCust.setCustLinked(customerDao.getCustomerById(pinCustId));
					myCust.setDateUpd(java.time.LocalDate.now());
				}
//				System.out.println("\t About to saveCustoemr.");
//				customerDao.saveCustomer(myCust);
				return custPaginated(0, model, session);
			}
		}

		
		@ApiOperation(value="Brings high-lighted user record to editing area for edit", response=Iterable.class, tags="home")
		@GetMapping("/custUpdaOts/{custId}")
		public String custUpdaOts(@PathVariable(value = "custId") long custId, 
				Model model, 
				HttpSession session) {

			if ((!hasRole("MANAGER")) && (!hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// Get customer from the Service
			Customer newCust = new Customer();
			
			if (custId == 0) {
				newCust.setIsActive(true);  // this method is not expected to be invoked with custId=0
			} else {
				if (custId > 0) {  // bring details of existing customer into input area for editing
					Customer cust = customerDao.getCustomerById(custId);
					newCust.setCustId(cust.getCustId());
					newCust.setCustName(cust.getCustName());
					newCust.setNric(cust.getNric());
					newCust.setEmail(cust.getEmail());
					newCust.setPhoneNo(cust.getPhoneNo());
					newCust.setAddr1(cust.getAddr1());
					newCust.setAddr2(cust.getAddr2());
					newCust.setCity(cust.getCity());
					newCust.setDob(cust.getDob());
					newCust.setIsActive(cust.getIsActive());
					newCust.setDateUpd(java.time.LocalDate.now());
					newCust.setCustLinked(cust.getCustLinked());
					newCust.setCurrHire(cust.getCurrHire());
					newCust.setHires(cust.getHires());
					model.addAttribute("optMsg", "Modify customer record and then click <Save>.");
				} else { // copy details of an existing user into input area for editing into a new user
					Customer cust = customerDao.getCustomerById(-custId);
					newCust.setCustName(cust.getCustName());
					newCust.setAddr1(cust.getAddr1());
					newCust.setAddr2(cust.getAddr2());
					newCust.setCity(cust.getCity());
					newCust.setIsActive(true);
					newCust.setDateUpd(java.time.LocalDate.now());
					newCust.setCustLinked(cust.getCustLinked());
					model.addAttribute("optMsg", "Enter required details and then click <Save>.");
				}
			}
			model.addAttribute("newCust", newCust);
			return custPaginated(0, model, session);
		}

		
		@PostMapping("/custSaveOts")	
		public String custSaveOts(@Valid @ModelAttribute("newCust")Customer newCust, BindingResult bindingResult, 
				Model model, 
				HttpSession session) {

			if ((!hasRole("MANAGER")) && (!hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}
			
			if (bindingResult.hasErrors()) {
				model.addAttribute("optMsg", "Please correct the validation errors.");
				return custPaginated(0, model, session);
			}

			if ((newCust.getCustId()==0)  && (newCust.getIsActive()) && (!hasRole("MANAGER"))) {
				model.addAttribute("optMsg", "New customers can only be created at inactive status.");
				return custPaginated(0, model, session);
			}

			newCust.setDateUpd(java.time.LocalDate.now());

			try {
				customerDao.saveCustomer (newCust);
			} catch(DataIntegrityViolationException e) {
				e.printStackTrace();
				model.addAttribute("optMsg", "There is another customer with same NRIC or Email, or other problem, please correct the data and retry.");
				model.addAttribute("newCust", newCust);
				return custPaginated(0, model, session);
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("optMsg", e.getMessage());
				model.addAttribute("newCust", newCust);
				return custPaginated(0, model, session);
			}
			
			newCust = new Customer();
			model.addAttribute("newCust", null);
			return custPaginated(0, model, session); 
		}
		

		@GetMapping("/custDeleOts/{custId}")
		public String custDeleOts(@PathVariable(value = "custId") long custId,
				Model model, 
				HttpSession session) {
			if (!hasRole("MANAGER")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// call delete customer method 
			try {
				this.customerDao.deleteCustomerById(custId);
			} catch(DataIntegrityViolationException e) {
				e.printStackTrace();
				model.addAttribute("optMsg", "This customer is related to other customers as alt contact, or has recent hiring or hiring history, cannot delete.");
				return custPaginated(0, model, session);
			} catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("optMsg", e.getMessage());
				return custPaginated(0, model, session);
			}
			return custPaginated(0, model, session);
		}

		
		@GetMapping("/custAndOts/{custId}")
		public String custAndOts(@PathVariable(value = "custId") long custId,
				Model model, HttpSession session) {

			if ((!hasRole("MANAGER")) && (!hasRole("USER"))) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Boolean activate = custId > 0; // +ve id to activate, -ve to deactivate
			if (activate && !hasRole("MANAGER")) {
				model.addAttribute("optMsg", "Only MANAGER can re-activate a Customer.");
				return custPaginated(0, model, session);
			}

			if (!activate) custId = - custId;
			Customer customer = customerDao.getCustomerById(custId);
			
			customer.setDateUpd(java.time.LocalDate.now());
			customer.setIsActive(activate);
			// this.customerDao.saveCustomer(customer);
			return custPaginated(0, model, session);
		}

	
}
