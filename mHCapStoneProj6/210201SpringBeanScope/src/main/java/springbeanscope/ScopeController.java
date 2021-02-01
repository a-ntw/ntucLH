package springbeanscope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ScopeController {
	
	
	@Autowired
	RequestScopeBean requestScopeBean;
	
	@Autowired
	SessionScopeBean sessionScopeBean;
	
	@Autowired
	ApplicationScopeBean applicatioScopeBean;
	
	@RequestMapping("/scopes")
	public String showScopes(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5); 
		model.addAttribute("requestScopeBean",requestScopeBean);
		model.addAttribute("sessionScopeBean",sessionScopeBean);
		model.addAttribute("applicationScopeBean",applicatioScopeBean);
		
		System.out.println("Hello");
		
		return "scopes";
	}
	

}
