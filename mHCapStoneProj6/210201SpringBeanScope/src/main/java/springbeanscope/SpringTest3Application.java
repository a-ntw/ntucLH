package springbeanscope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTest3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringTest3Application.class, args);
	}

}

/*singleton (Default Scope)
 * prototype 
 * request 
 * session 
 * application 
 * websocket
 * */
