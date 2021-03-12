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

import carDate.Home;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@Api(value = "EmployeeController", description = "Application user administration")
	@Controller
	public class EmployeeController {

		@Autowired
		private Home home;

		@Autowired
		private EmployeeDao employeeDao;

		@Autowired
		private RoleRepo roleRepo;

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
			if (!currFunc.equals("emp")) {
				currFunc = "emp";
				session.setAttribute("currFunc", currFunc);
			}

			currPage = (session.getAttribute("empCurrPage")==null)?1:(int) session.getAttribute("empCurrPage");
			session.setAttribute("empCurrPage", currPage);
			
			totalPages = (session.getAttribute("empTotalPages"))==null?1:(int) session.getAttribute("empTotalPages");
			session.setAttribute("empTotalPages", totalPages);

			pageSize = (session.getAttribute("empPageSize")==null)?5:(int) session.getAttribute("empPageSize");
			session.setAttribute("empPageSize", pageSize);

			nextPageSize = pageSize==5?10:(pageSize==10?20:5);
			session.setAttribute("empNextPageSize", nextPageSize);

			sortField = (session.getAttribute("empSortField")==null)?"empId":(String) session.getAttribute("empSortField");
			session.setAttribute("empSortField", sortField);
			
			sortDirection = (session.getAttribute("empSortDirection")==null)?"ASC":(String) session.getAttribute("empSortDirection");
			session.setAttribute("empSortDirection", sortDirection);

			pinCustId = (session.getAttribute("pinCustId")==null)?0:(long) session.getAttribute("pinCustId");
			session.setAttribute("pinCustId", pinCustId);

			pinVehId = (session.getAttribute("pinVehId")==null)?0:(long) session.getAttribute("pinVehId");
			session.setAttribute("pinVehId", pinVehId);

			return true;
		}

		
		@GetMapping("/empPage/{pageMvnt}")
		public String empPaginated(@PathVariable(value="pageMvnt") int pageMvnt,
				Model model, 
				HttpSession session) {
			if (!home.hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			switch (pageMvnt) {
			    case -9: currPage = 1; break;                            // go to first page
			    case -1: currPage = currPage > 1? currPage - 1:1; break; // go to prev page  
			    case  0: break;                                          // stay at curr page
			    case  1: currPage = currPage < totalPages? currPage + 1:totalPages; break;  // go to next page
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
			session.setAttribute("empName", home.getEmpName());
			return "Employees";
		}
		

		@GetMapping("/empSort/{sortField}")
		public String empSort(@PathVariable(value="sortField") String newSortField, 
				Model model, 
				HttpSession session) {
			
			if (!home.hasRole("ADMIN")) {return "/403";}
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

			if (!home.hasRole("ADMIN")) {return "/403";}
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
		@GetMapping("/empUpdaOts/{empId}")
		public String empUpdaOts(@PathVariable(value = "empId") long empId, 
				Model model, 
				HttpSession session) {

			if (!home.hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// Get customer from the Service
			Employee newEmp = new Employee();
			List<Role> roles = roleRepo.findAll();
			
			if (empId == 0) {
				newEmp.setIsActive(true);  // this method is not expected to be invoked with empId=0
			} else {
				if (empId > 0) {  // bring details of existing user into input area for editing
					Employee emp = employeeDao.getEmployeeById(empId);
					if (emp.getEmpName().equalsIgnoreCase(home.getEmpName())) {
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
					newEmp.setEmail(emp.getEmail().indexOf('@')>=0?emp.getEmail().substring(emp.getEmail().indexOf('@')):"");
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

			if (!home.hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			if (!bindingResult.hasErrors()) {
				Employee samenameEmployee = employeeDao.getEmployeeByEmpName(newEmp.getEmpName());
				if (newEmp.getEmpName().equalsIgnoreCase(home.getEmpName())) {
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
							model.addAttribute("newEmp", null);
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
		

		@GetMapping("/empDeleOts/{empId}")
		public String empDeleOts(@PathVariable(value = "empId") long empId,
				Model model, 
				HttpSession session) {
			if (!home.hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			// call delete customer method 
			Employee newEmp = employeeDao.getEmployeeById(empId);
			if (newEmp.getEmpName().equalsIgnoreCase(home.getEmpName())) {
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

			if (!home.hasRole("ADMIN")) {return "/403";}
			if (!loadSessionAttributes(session)) {return "redirect:/";}

			Boolean activate = empId > 0; // +ve id to activate, -ve to deactivate
			if (!activate) empId = - empId;
			Employee employee = employeeDao.getEmployeeById(empId);
			
			employee.setIsActive(activate);
			this.employeeDao.saveEmployee(employee);
			return empPaginated(0, model, session);
		}

	
}
