package co.ntuc;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

	@Autowired
	private UsersRepository repo;

	@RequestMapping("/users")
	public String ShowUsersList(Model model) {
		java.util.List<Users> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	
	@GetMapping("/users/new")
	public String ShowUserform(Model model) {
		model.addAttribute("Users", new Users());
		return "user_form";
	}

	@PostMapping("/users/save")
	public RedirectView saveUser(Users user, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setPhotos(fileName);
         
        Users savedUser = repo.save(user);
 
        String uploadDir = "user-photos/" + savedUser.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("/users", true);
	}
	
	@GetMapping("/users/edit/{id}")
	public String ShowEditForm(@PathVariable("id") Long id, Model model) {
		Users user =   repo.findById(id).get();
		model.addAttribute("Users", user);

		return "user_form";
	}

	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		repo.deleteById(id);;
		
		return "redirect:/users";
	}
}
