package springModelattribute;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class ModelController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String username,
			@RequestParam String password) {
	
			model.put("username", username);
			return "success";
	}
	
//		@RequestMapping("/")
//		public ModelAndView getMain() {
//		ModelAndView mv = new ModelAndView("index");
//		return mv;
//		}
//		
//		@ModelAttribute("MyRequestObject")
//		public UserDetails addSomethingTORequestScope() {
//			UserDetails ud = new UserDetails();
//			ud.setEmail("test@test.com");
//			ud.setUsername("test");
//			ud.setId(10);
//			return ud;
//		}
//		
//		@RequestMapping("/adduser")
//		public ModelAndView adduser() {
//			ModelAndView mv = new ModelAndView("adduser");
//			mv.addObject("msg","AnnotatedController");
//			return mv;
//		}
//		
//		@RequestMapping(value="save", method=RequestMethod.POST)
//		public ModelAndView save(@ModelAttribute("User1")UserDetails User1) {
//		
//			ModelAndView mv= new ModelAndView("success");
//			mv.addObject("msg","AnnotatedController");
//			
//			return mv;
//			
//		}
	
}
	
