package carDate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;


@SpringBootApplication
@EnableJdbcHttpSession
@ComponentScan(basePackages= {"carDate"})
public class CarDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDateApplication.class, args);
	}

}
