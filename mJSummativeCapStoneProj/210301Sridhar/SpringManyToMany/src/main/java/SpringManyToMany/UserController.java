package SpringManyToMany;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.lowagie.text.DocumentException;


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
	
	@GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Users> listUsers = repo.findAll();
         
       UserPDFExporter exporter = new UserPDFExporter(listUsers);
       exporter.export(response);
    }
	
	@GetMapping("/users/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
         
        List<Users> listUsers = repo.findAll();
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"User ID", "Username", "Password", "Roles", "Enabled"};
        String[] nameMapping = {"id", "username", "password", "roles", "enabled"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (Users user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
         
        csvWriter.close();
         
    }

	
	
	@GetMapping("/users/new")
	public String ShowUserform(Model model) {
		List<UserRole> roles = rolerepo.findAll();
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
	public String ShowEditForm(@PathVariable("id") Long id, Model model) {
		Users user =   repo.findById(id).get();
		model.addAttribute("Users", user);
		
		List<UserRole> roles = rolerepo.findAll();
		model.addAttribute("roles", roles);
		
		return "user_form";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		repo.deleteById(id);;
		
		return "redirect:/users";
		
	}
	

	
	
	
	
}
