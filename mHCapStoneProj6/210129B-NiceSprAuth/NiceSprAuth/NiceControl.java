package NiceSprAuth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NiceControl {
	@GetMapping("/")
	public String goHome() {
		return "login";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/basic_table")
	public String BasicTable() {
		return "basic_table";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
