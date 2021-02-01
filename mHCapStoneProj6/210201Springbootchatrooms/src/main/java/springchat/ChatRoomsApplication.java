package springchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatRoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatRoomsApplication.class, args);

		System.out.println("******************************************************");
		System.out.println("ChatRoomsApplication > http://localhost:8081/ to cont.");
		System.out.println("******************************************************");
	}
}

/* and url from other site to come to here, such as
 * <a href="http://localhost:8081"> Chat </a> 
 */