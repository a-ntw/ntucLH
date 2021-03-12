package carDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import carDate.emp.Employee;
import carDate.emp.EmployeeDao;
import carDate.emp.RoleRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@Api(value = "Home", description = "Application home page")
	@Controller
	public class Home {

		@Autowired
		private EmployeeDao employeeDao;

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

		
		
		public boolean hasRole(String role) {

			System.out.println("\n\t home Explicit authentication begins...");
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

		@ApiOperation(value="carDate application entry point", tags="home")
		@RequestMapping("/")
		public String Welcome(Model model, HttpSession session) { 
			System.out.println("\n\t Access to home page detected...");
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			empName = "";
			
			if (principal instanceof UserDetails) {
				empName = ((UserDetails) principal).getUsername();
				System.out.println("\t User=" + empName + " has been authenticated.");
				Employee meEmp = employeeDao.getEmployeeByEmpName(empName);
				model.addAttribute("meEmp", meEmp);
				return "Home"; // present home.html
			} else {
				model.addAttribute("optMsg", "Authentication failed.");
			}

			return "redirect:/login";
		}


		@RequestMapping("/login")
		public String login(Model model) {
			model.addAttribute("optMsg", "Please log in with your user name and password.");
			System.out.println("\tlogin detected...");
				return "login";
		}
		
		@RequestMapping("/bye")
		public String bye(Model model) {
			model.addAttribute("optMsg", "You are logged out.");
			return "login";
		}


		public String getEmpName() {
			return empName;
		}

		
}
