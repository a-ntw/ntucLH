
source: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/

210128NiceAdmin.png <img src="210128NiceAdmin.png">

main
``` java
@SpringBootApplication
public class NiceSprAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiceSprAuthApplication.class, args);
		System.out.println("********************************************");
		System.out.println("SpringApplication > http://localhost:8080/ to cont.");
		System.out.println("********************************************");
	}
```

NiceControl.java
``` java
@Controller
public class NiceControl {
	@GetMapping("/")
	public String goHome() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
```
pom.xml
``` xml
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
	</dependencies>
```

Login user: user
