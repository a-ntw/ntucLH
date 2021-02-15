package carDate;

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

import carDate.emp.Employee;
import carDate.emp.EmployeeDao;
import carDate.emp.RoleRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

	@Api(value = "home", description = "Application home page")
	@Controller
	public class home {

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
				return "home"; // present home.html
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
		
		
}
