210126Bcrypt.png <img src="210126Bcrypt.png">

Welcome.html
``` html
<body>
	<h1 style="text-align:center">
	  <span>  Welcome to SpringBoot Security </span>
	  <br>
    <span th:text="${#authentication.getPrincipal().getUsername()}"></span>
  </h1>
</body>
```

Welcomeaop.html
``` html
  <body>
	  <h1 style="text-align:center">
	    <span>  You have been redirected here by Aspect Advice in Springboot </span>
	    <br>
      <span th:text="${#authentication.getPrincipal().getUsername()}"></span>
    </h1>
  </body>
```

UserControl.java
``` java
	@RequestMapping("/")
	public String Welcome() {
		System.out.println(" ====>  UserControl");
		return "Welcome";
	}

	@RequestMapping("/testaop")
	public String TestAop(Principal principal) {
		return "Welcomeaop";
	}
```

AppSecurity.java 
``` java
@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Bean
	public AuthenticationProvider authprovider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService((UserDetailsService) userDetailService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll();
	}
}
```

MyUserDetailService.java
``` java
@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users = repo.findByUsername(username);
		if(users==null)
			throw new UsernameNotFoundException(username);
		
		return new UserDetailImpl(users);
	}
}
```

Users.java
``` java
@Entity
public class Users {
	@Id
	private long id;
	private String username;
	private String password;
  ...
```

UserRepo.java 
``` java
public interface UserRepo extends JpaRepository<Users, Long>{
	
	Users findByUsername(String username);

}
```


CheckUser.java
``` java
@Aspect
@Component
public class CheckUser {
	
	private Object principal;
	private String user;
	
	@Around("execution(public String TestAop(..))")
	public String checkLoggerUser(ProceedingJoinPoint joinpoint) throws Throwable {
		
		principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(" ====>> CheckUser >> " + principal);
		
		if (principal instanceof UserDetails) {
			user = ((UserDetails) principal).getUsername();
		} else {
			user = principal.toString();
		}

		if (user.equals("ntuc")) {
			System.out.println("success");
			return "redirect:/error.html";
		}
		else {
			System.out.println("not success");
			return (String)joinpoint.proceed();
		}
	}
}
```

UserDetailImpl.java 
``` java
public class UserDetailImpl implements UserDetails {
	
	private Users users;

	public UserDetailImpl(Users users) {
		super();
		this.users = users;
	}	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return  users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
```

application.properties
```

# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
spring.datasource.username=hr
spring.datasource.password=oracle

management.endpoints.web.exposure.include=*
#management.endpoints.web.exposure.exclude=loggers
```

pom.xml
``` xml
    <dependency>
		    <groupId>org.thymeleaf.extras</groupId>
		     <artifactId>thymeleaf-extras-springsecurity5</artifactId>
		</dependency>
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
```

---
