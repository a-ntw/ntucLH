package springauth;

import java.util.List;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/login-error")
	public String loginerror() {
         return "login-error";
	}
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		String keyword = null;
		return listByPage(model,1, "name", "asc",keyword);
	}
	
	@GetMapping("/page/{pageNumber}")
	public String listByPage(Model model,@PathVariable("pageNumber") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir,
			@Param("keyword") String keyword)	{
		Page<Product> page = service.listAll(currentPage,sortField,sortDir,keyword);
		Long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<Product> listProducts = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "index";
	}
	
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
}
