package carDate.emp;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@Api(value = "EmployeeController", description = "Application user administration")
	@Controller
	public class EmployeeController {

		@Autowired
		private EmployeeDao employeeDao;

		@Autowired
		private RoleRepo roleRepo;

		private Object principal;
		private String empName;


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
			try {
				currFunc = (String) session.getAttribute("currFunc");
			} catch (Exception e) {}
			if (currFunc==null || !currFunc.equalsIgnoreCase("ADM")) {
				currFunc = "ADM";
				session.setAttribute("currFunc", currFunc);
				currPage = 1;
				session.setAttribute("empCurrPage", currPage);
				totalPages = 1;
				session.setAttribute("empTotalPages", totalPages);
				pageSize = 5;
				session.setAttribute("empPageSize", pageSize);
				nextPageSize = pageSize==5?10:(pageSize==10?20:5);
				session.setAttribute("empNextPageSize", nextPageSize);
				sortField = "empId";
				session.setAttribute("empSortField", sortField);
				sortDirection = "ASC";
				session.setAttribute("empSortDirection", sortDirection);
				try {
					pinCustId = (long) session.getAttribute("pinCustId");
				} catch (Exception e) {
					pinCustId = 0;
					session.setAttribute("pinCustId", pinCustId);
				}
				try {
					pinVehId = (long) session.getAttribute("pinVehId");
				} catch (Exception e) {
					pinVehId = 0;
					session.setAttribute("pinAcctId", pinVehId);
				}
				return true;
			} else {
				try {
					currPage = (int) session.getAttribute("empCurrPage");
				} catch (Exception e) {
					currPage = 1;
					session.setAttribute("empCurrPage", currPage);
				}
				try {
					totalPages = (int) session.getAttribute("empTotalPages");
				} catch (Exception e) {
					totalPages = 1;
					session.setAttribute("empTotalPages", totalPages);
				}
				try {
					pageSize = (int) session.getAttribute("empPageSize");
				} catch (Exception e) {
					pageSize = 5;
					session.setAttribute("empPageSize", pageSize);
				}
				nextPageSize = pageSize==5?10:(pageSize==10?20:5);
				session.setAttribute("empNextPageSize", nextPageSize);
				try {
					sortField = (String) session.getAttribute("empSortField");
				} catch (Exception e) {
					sortField = "empId";
					session.setAttribute("empSortField", sortField);
				}
				try {
					sortDirection = (String) session.getAttribute("empSortDirection");
				} catch (Exception e) {
					sortDirection = "ASC";
					session.setAttribute("empSortDirection", sortDirection);
				}
				try {
					pinCustId = (long) session.getAttribute("pinCustId");
				} catch (Exception e) {
					pinCustId = 0;
					session.setAttribute("pinCustId", pinCustId);
				}
				try {
					pinVehId = (long) session.getAttribute("pinVehId");
				} catch (Exception e) {
					pinVehId = 0;
					session.setAttribute("pinVehId", pinVehId);
				}
				return true;
			} 
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
		          .anyMatch(r -> r.getAuthority().equals(role))) {
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

		@ApiOperation(value="carDate application entry point", tags="home")
		@RequestMapping("/")
		public String Welcome(Model model, HttpSession session) { 
			// Model is used to prepare data (using model.addAttribute) to be present on html page (using th:${})
			// Once presented on html, Model is gone.  That's why we need HttpSession to keep data to maintain 
			// the statefulness of the session.

			if (hasRole("ADMIN")) {
				session.setAttribute("empName", empName);
				return "redirect:/emp";
			}
			if ((hasRole("MANAGER")) || (hasRole("USER"))) {
				session.setAttribute("empName", empName);
				return "redirect:/cust";
			}
			return "redirect:/login";
		}


		@RequestMapping("/login")
		public String login() {
			System.out.println("\tlogin detected...");
				return "login";
		}
		
		@RequestMapping("/bye")
		public String bye(Model model) {
			model.addAttribute("optMsg", "You are logged out.");
			return "login";
		}
		
		
		@GetMapping("/emp") //this is the home page at root directory of the website to be triggered by a http GET. 
		public String viewHomePage(Model model, HttpSession session) {
			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}
			return empPaginated(0, model, session);
		}

		
		@GetMapping("/empPage/{pageMvnt}")
		public String empPaginated(@PathVariable(value="pageMvnt") int pageMvnt,
				Model model, 
				HttpSession session) {
			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			switch (pageMvnt) {
			    case -9: currPage = 1; break;                            // go to first page
			    case -1: currPage = currPage > 1? currPage - 1:1; break; // go to prev page  
			    case  0: break;                                          // stay at curr page
			    case  1: currPage = currPage < totalPages? totalPages + 1:totalPages; break;  // go to next page
			    case  9: currPage = totalPages; break;                   // go to last page
			    default: currPage = 1;
			}
			
			Employee newEmp = (Employee)model.getAttribute("newEmp");
			if (newEmp==null) {
				newEmp = new Employee();
				newEmp.setIsActive(true);
				model.addAttribute("newEmp", newEmp);
			}
			
			List<Role> roles = (List<Role>)model.getAttribute("roles");
			if (roles==null) {
				roles = roleRepo.findAll();
			}
			model.addAttribute("roles", roles);
			
			session.setAttribute("empCurrPage", currPage);
			Page <Employee> page = employeeDao.empPaginated(currPage, pageSize, sortField, sortDirection);
			session.setAttribute("empTotalPages", page.getTotalPages());
			if ((currPage > 1) && (currPage > page.getTotalPages())) {return empPaginated(9, model, session);}
			List <Employee> listEmps = page.getContent();
			model.addAttribute("listEmps", listEmps);
			session.setAttribute("empTotalItems", page.getTotalElements());
			
			return "Employees";
		}
		

		@GetMapping("/empSort/{sortField}")
		public String empSort(@PathVariable(value="sortField") String newSortField, 
				Model model, 
				HttpSession session) {
			
			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			if (newSortField.equals(sortField)) {
				currPage = (totalPages==0)?1:totalPages - currPage + 1;
				sortDirection = sortDirection.equalsIgnoreCase("ASC")?"DESC":"ASC";
			} else {  // if sortField is changed: go to page 1 and change sort order to  Asc 
				sortField = newSortField;
				currPage = 1;
				sortDirection = "ASC";
			}
			
			session.setAttribute("empCurrPage", currPage);
			session.setAttribute("empSortField", sortField);
			session.setAttribute("empSortDirection", sortDirection);
			return empPaginated(0, model, session);
		}


		@GetMapping("/empPageSize/{newPageSize}")
		public String empPageSize(@PathVariable(value="newPageSize") int newPageSize,
				Model model, 
				HttpSession session) {

			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			currPage = (((currPage - 1) * pageSize + 1) / newPageSize) + (((((currPage - 1) * pageSize + 1) % newPageSize)==0)?0:1);
			pageSize = newPageSize; 
			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("empCurrPage", currPage);
			session.setAttribute("empPageSize", pageSize);
			session.setAttribute("empNextPageSize", nextPageSize);
			return empPaginated(0, model, session);
		}

		
		@ApiOperation(value="Brings high-lighted user record to editing area for edit", response=Iterable.class, tags="home")
		@GetMapping("/empUpdateOts/{empId}")
		public String empUpdateOts(@PathVariable(value = "empId") long empId, 
				Model model, 
				HttpSession session) {

			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// Get customer from the Service
			Employee newEmp = new Employee();
			List<Role> roles = roleRepo.findAll();
			
			if (empId == 0) {
				newEmp.setIsActive(true);  // this method is not expected to be invoked with empId=0
			} else {
				if (empId > 0) {  // bring details of existing user into input area for editing
					Employee emp = employeeDao.getEmployeeById(empId);
					if (emp.getEmpName().equalsIgnoreCase(empName)) {
//						newEmp = new Employee();
						model.addAttribute("optMsg", "You are not allowed to modify your own employee record.");
					} else {
						newEmp.setEmpId(emp.getEmpId());
						newEmp.setEmpName(emp.getEmpName());
						newEmp.setEmpFullName(emp.getEmpFullName());
						newEmp.setPhoneNo(emp.getPhoneNo());
						newEmp.setEmail(emp.getEmail());
						newEmp.setJobTitle(emp.getJobTitle());
						newEmp.setIsActive(emp.getIsActive());
						newEmp.setPswdExpiry(emp.getPswdExpiry());
						newEmp.setUserExpiry(emp.getUserExpiry());
						newEmp.setRoles(emp.getRoles());
						model.addAttribute("optMsg", "Modify employee record and then click <Save>.");
					}
				} else { // copy details of an existing user into input area for editing into a new user
					Employee emp = employeeDao.getEmployeeById(-empId);
					newEmp.setEmpFullName(emp.getEmpFullName());
					newEmp.setJobTitle(emp.getJobTitle());
					newEmp.setIsActive(emp.getIsActive());
					newEmp.setPswdExpiry(emp.getPswdExpiry());
					newEmp.setUserExpiry(emp.getUserExpiry());
					newEmp.setRoles(emp.getRoles());
					model.addAttribute("optMsg", "Enter required details and then click <Save>.");
				}
			}
			model.addAttribute("newEmp", newEmp);
			model.addAttribute("roles", roles);
			return empPaginated(0, model, session);
		}

		
		@PostMapping("/empSaveOts")	
		public String empSaveOts(@Valid @ModelAttribute("newEmp")Employee newEmp, BindingResult bindingResult, 
				Model model, 
				HttpSession session) {

			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			if (!bindingResult.hasErrors()) {
				Employee samenameEmployee = employeeDao.getEmployeeByEmpName(newEmp.getEmpName());
				if (newEmp.getEmpName().equalsIgnoreCase(empName)) {
					model.addAttribute("optMsg", "You cannot save an employee with your own empName.");
				} else {
					if (samenameEmployee!=null) {  // there is a user in db with the same name
						if (newEmp.getEmpId()==samenameEmployee.getEmpId()) {  // updating existing user with same empId and empName
							if (newEmp.getPassword().isEmpty()) {
								newEmp.setPassword(samenameEmployee.getPassword());
							} else {
								newEmp.setPassword(encoder.encode(newEmp.getPassword()));  // need to encrypted the password here
							}
							employeeDao.saveEmployee (newEmp);
							newEmp = new Employee();
							model.addAttribute("newEmp", newEmp);
						} else {
							model.addAttribute("optMsg", "An employee with the empName [" + newEmp.getEmpName() + "] already exists.");
						}
					} else {  // saving/updating a user with a totally new username
						if (newEmp.getEmpId()==0) {  // if saving a new user, that's fine
							if (newEmp.getPassword().isEmpty()) {
								model.addAttribute("optMsg", "Please enter the initial password for this new user.");
							} else {
								newEmp.setPassword(encoder.encode(newEmp.getPassword()));  // need to encrypted the password here
								employeeDao.saveEmployee(newEmp);
								newEmp = new Employee();
								model.addAttribute("newEmp", newEmp);
							}
						} else { // updating an existing user with name username
							if (newEmp.getPassword().isEmpty()) {
								Employee sameidEmp = employeeDao .getEmployeeById(newEmp.getEmpId());
								newEmp.setPassword(sameidEmp.getPassword());
							} else {
								newEmp.setPassword(encoder.encode(newEmp.getPassword()));  // need to encrypted the password here
							}
							employeeDao.saveEmployee(newEmp);
							newEmp = new Employee();
							model.addAttribute("newEmp", newEmp);
						}
					}
				}
				return empPaginated(0, model, session); 
			} else {
				model.addAttribute("optMsg", "Please correct the validation errors.");
			}
			model.addAttribute("newUser", newEmp);
			return empPaginated(0, model, session);
		}
		

		@GetMapping("/empDeleteOts/{empId}")
		public String empDeleteOts(@PathVariable(value = "empId") long empId,
				Model model, 
				HttpSession session) {
			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// call delete customer method 
			Employee newEmp = employeeDao.getEmployeeById(empId);
			if (newEmp.getEmpName().equalsIgnoreCase(empName)) {
				model.addAttribute("optMsg", "You should not delete your own Employee record.");
			} else {
				this.employeeDao.deleteEmployeeById(empId);
				// this.userRepo.deleteById(empId);
			}
			return empPaginated(0, model, session);
		}

		@GetMapping("/empAndOts/{empId}")
		public String empAndOts(@PathVariable(value = "empId") long empId,
				Model model, HttpSession session) {

			if (!hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Boolean activate = empId > 0; // +ve id to activate, -ve to deactivate
			if (!activate) empId = - empId;
			Employee employee = employeeDao.getEmployeeById(empId);
			
			employee.setIsActive(activate);
			this.employeeDao.saveEmployee(employee);
			return empPaginated(0, model, session);
		}

	
}
