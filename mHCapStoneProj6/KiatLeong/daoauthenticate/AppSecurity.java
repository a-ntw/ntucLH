package com.cp5.daoauthenticate;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin().permitAll()
//			.and()
//			.logout().permitAll();
					
			.antMatchers("/newUserForm", "/saveUser" , "/*.css").permitAll()			
			.antMatchers("/", "/bank").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
			.antMatchers("/showNewCustomerForm").hasAnyAuthority("ADMIN", "CREATOR")
			.antMatchers("/showFormForUpdate/**").hasAnyAuthority("ADMIN", "EDITOR")
			.antMatchers("/deleteCustomer/**", "/adminPage").hasAuthority("ADMIN")			
			.anyRequest().authenticated()			
			.and()
			.csrf().disable()			
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	}
	
	
}
