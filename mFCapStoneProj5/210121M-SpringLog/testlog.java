package ntuc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class testlog {

	Logger logger = LoggerFactory.getLogger(testlog.class);

	@RequestMapping("/")
	public String Hello() {

		logger.info("This is a info log!");

//		System.out.println("This is a info log");
		return "hello";
	}

	@RequestMapping("/something")
	public String DoSomething() {
		return "something";
	}

}
