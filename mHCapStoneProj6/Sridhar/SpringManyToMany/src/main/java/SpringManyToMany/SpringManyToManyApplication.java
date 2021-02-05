package SpringManyToMany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringManyToManyApplication.class, args);
		
		System.out.println("*****************************************************");
		System.out.println("******** http://localhost:8080/swagger-ui.html ******");
		System.out.println("*****************************************************");
	}

}
