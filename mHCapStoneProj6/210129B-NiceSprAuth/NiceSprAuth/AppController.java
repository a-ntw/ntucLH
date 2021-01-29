package NiceSprAuth;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model, HttpSession session ) {
		System.out.println(" ========> AppController / viewHomePage ===> index.html ");
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		 session.setAttribute("favcolor", "blue");
		 session.setAttribute("product", listProducts.get(0).getName());
		 System.out.println("=======================  TEST");
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		System.out.println(" ========> AppController /new ===> new_product.html  ");
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		System.out.println(" ========> AppController /save ====> redirect:/ ");
		service.save(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		System.out.println(" ========> AppController /edit ====> return mav");
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		System.out.println(" ========> AppController /delete ====> redirect:/ ");
		service.delete(id);
		
		return "redirect:/";
	}
	
	@RequestMapping("/old")
	public String indexOld(Model model) {
		System.out.println(" ========> AppController / indexOld ===> indexOld ");
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "indexOld";
	}
	
	@RequestMapping("/nice")
	public String indexNice(Model model) {
		System.out.println(" ========> AppController / indexNice ===> indexNice ");
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "indexNice";
	}
	
	@RequestMapping("/manager")
	public String nsaProductMgr(Model model, HttpSession session) {
		System.out.println(" ========> AppController / nsaProductMgr ===> nsaProductMgr ");
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		 session.setAttribute("favcolor", "blue");
		 session.setAttribute("product", listProducts.get(0).getName());
		return "nsaProductMgr";
	}
	
//	@RequestMapping("/index")
//	public String viewIndexPage(Model model) {
//		System.out.println(" ========> AppController / viewIndexPage ===> index.html ");
//		List<Product> listProducts = service.listAll();
//		model.addAttribute("listProducts", listProducts);
//		return "index";
//	}
}
