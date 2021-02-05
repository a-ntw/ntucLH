package SpringManyToMany;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2DemoRestController", description = "REST APIs related to User Management")
@Controller
public class UserController {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private RoleRepository rolerepo;
	
//	@ApiOperation(value = "Get list of Users in the System ", response = Iterable.class, tags = "getUsers")
	@RequestMapping("/users")
	public String ShowUsersList(Model model) {
		java.util.List<Users> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

//	@ApiOperation(value = "Add new Users the System ", response = Iterable.class, tags = "AddUsers")
	@GetMapping("/users/new")
	public String ShowUserform(Model model) {
		List<Roles> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		model.addAttribute("Users", new Users());
		return "user_form";
	}
	
//	@ApiOperation(value = "Save Users the System ", response = Iterable.class, tags = "SaveUsers")
	@PostMapping("/users/save")
	public String saveUser(Users user) {
		repo.save(user);
		return "redirect:/users";
	}
	
//	@ApiOperation(value = "Edit Users in the System ", response = Iterable.class, tags = "EditUsers")
	@GetMapping("/users/edit/{id}")
	public String ShowEditForm(@PathVariable("id") Integer id, Model model) {
		Users user =   repo.findById(id).get();
		model.addAttribute("Users", user);
		
		List<Roles> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		
		return "user_form";
	}
	
//	@ApiOperation(value = "Delete Users the System ", response = Iterable.class, tags = "deleteUsers")
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);;
		
		return "redirect:/users";
		
	}
	
	
//	@GetMapping("/")
//    public String getPieChart(Model model) {
//		List<?> r = rolerepo.findR();
//		for(int i=0; i<r.size();i++)
//			System.out.println(r.toString());
//		
////        Map<String, Integer> graphData = new TreeMap<>();
////        graphData.put("2016", 147);
////        graphData.put("2017", 1256);
////        graphData.put("2018", 3856);
////        graphData.put("2019", 19807);
////        model.addAttribute("chartData", graphData);
//        return "google-charts";
//    }

	
	
	
	
}
