
AppSecurity
===
##### top
[top]: topOfThePage


AppSecurity.java
``` java
package com.cp5;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		List<UserDetails> users= new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().
				username("simon").
				password("simon").
				roles("USER").
				build());
		
		users.add(User.withDefaultPasswordEncoder().
				username("sridhar").
				password("simon").
				roles("USER").
				build());
			
		return new InMemoryUserDetailsManager(users);
	}

}

```
#### pom.xml
may need to add dependency. Spring > Add Starter > Spring Security
``` xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```



210121AppSecurity.png <img src="210121AppSecurity.png">

#### application.properties
``` 
server.servlet.session.cookie.name=Customer_Management
server.servlet.session.cookie.max-age= 120
server.servlet.session.timeout=300
#server.port=8081
```

210121Session.png <img src="210121Session.png">

#### non-sql login on BankAppCP6
reference to mHCapStoneProj6/210203Q-BankApp/

210223BankAppCP6.png <img src="210223BankAppCP6.png">



---
[:top: Top](#top)
