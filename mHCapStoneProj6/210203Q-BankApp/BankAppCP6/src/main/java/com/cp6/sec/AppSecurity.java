package com.cp6.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public AuthenticationProvider authprovider() {
		System.out.println("=======>>>>>>>>>>>>>>>>>>>> AppSecurity..");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService((UserDetailsService) userDetailService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
		
	}

//	@Override // ??  210204  
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authprovider());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("=======>>>>>>>>>>>>>>>>>>>> AppSecurity configure ..");
	
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/").hasAnyAuthority("USER", "MANAGER", "SALESPERSON", "ADMIN")
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
	

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		List<UserDetails> users= new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().
//				username("simon").
//				password("simon").
//				roles("USER").
//				build());
//		
//		users.add(User.withDefaultPasswordEncoder().
//				username("sridhar").
//				password("simon").
//				roles("USER").
//				build());
//			
//		return new InMemoryUserDetailsManager(users);
//	}

}
