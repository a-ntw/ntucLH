package ntuc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringSingletonApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringSingletonApplication.class, args);
		
//		System.out.println("Illustrate Singleton created run and destroy.");
		
		Product p = ctx.getBean(Product.class);
		p.Present();
		
		Product p1 = ctx.getBean(Product.class);
		p1.Present();
	}

}
