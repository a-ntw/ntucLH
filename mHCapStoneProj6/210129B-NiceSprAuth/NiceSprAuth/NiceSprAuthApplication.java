package NiceSprAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@EnableJdbcHttpSession
@SpringBootApplication
public class NiceSprAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiceSprAuthApplication.class, args);
		System.out.println("********************************************");
		System.out.println("NiceSprAuthApplication > http://localhost:8080/ to cont.");
		System.out.println("********************************************");
	}

}
