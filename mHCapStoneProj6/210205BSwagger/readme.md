### Swagger
210205Swagger.png <img src="210205Swagger.png">

Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON. Swagger is used together with a set of open-source software tools to design, build, document, and use RESTful web services. Swagger includes automated documentation, code generation (into many programming languages), and test-case generation.
ref: https://en.wikipedia.org/wiki/Swagger_(software)

**login: simon/simon**

*http://localhost:8080/swagger-ui.html*


#### pom.xml
``` xml
		<dependency>
       <groupId>io.springfox</groupId>
       <artifactId>springfox-swagger2</artifactId>
       <version>2.6.1</version>
   </dependency>
 
   <dependency>
       <groupId>io.springfox</groupId>
       <artifactId>springfox-swagger-ui</artifactId>
       <version>2.6.1</version>
   </dependency>
```

#### SwaggerConfig.java
``` java
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
```

#### UserController.java
``` java
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2DemoRestController", description = "REST APIs related to User Management")
@Controller
public class UserController {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private RoleRepository rolerepo;
	
//	@ApiOperation(value = "Get list of Users in the System ", response = Iterable.class, tags = "getUsers")
	@RequestMapping("/users")
	public String ShowUsersList(Model model) {
		java.util.List<Users> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

```

* Need to save, restart the java *
