package SpringManyToMany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private RoleRepository rolerepo;
	
	@RequestMapping("/users")
	public String ShowUsersList(Model model) {
		java.util.List<Users> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	
	@GetMapping("/users/new")
	public String ShowUserform(Model model) {
		List<Roles> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		model.addAttribute("Users", new Users());
		return "user_form";
	}
	
	
	@PostMapping("/users/save")
	public String saveUser(Users user) {
		repo.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String ShowEditForm(@PathVariable("id") Integer id, Model model) {
		Users user =   repo.findById(id).get();
		model.addAttribute("Users", user);
		
		List<Roles> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		
		return "user_form";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);;
		
		return "redirect:/users";
		
	}
	

	
	
	
	
}
