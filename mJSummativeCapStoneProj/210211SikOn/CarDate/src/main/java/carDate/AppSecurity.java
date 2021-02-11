package carDate;

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
	
	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService((UserDetailsService) userDetailService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());  // https://bcrypt-generator.com/
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.csrf().disable()
 			.authorizeRequests().antMatchers("/login", "/login.css", "/login?error").permitAll()  // what is the significance of this /login?
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()                        // I suppose this means to look for @RequestMapping("/login") to perform login
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))   // I suppose this means /logout is the shortcut to initiate a logout.
			.logoutSuccessUrl("/bye").permitAll();                        // and that when it is done, it will look for @RequestMapping("/bye")
			
	}
	
}


