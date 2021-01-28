package NiceSprAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NiceSprAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiceSprAuthApplication.class, args);
		System.out.println("********************************************");
		System.out.println("SpringApplication > http://localhost:8080/ to cont.");
		System.out.println("********************************************");
	}

}
