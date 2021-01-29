
Using 'Nice Admin' Template from SpringAuth

Issues resolved on stuck at login page after the login

WebSecurityConfig.java

``` java
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login","/css/**","/img/**").permitAll()
		.antMatchers("/").hasAnyAuthority("USER", "MANAGER", "EDITOR", "ADMIN")
		.antMatchers("/new").hasAnyAuthority("ADMIN", "MANAGER")
		.antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
		.antMatchers("/delete/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.formLogin().loginPage("/login").successForwardUrl("/")
		.permitAll()
		.and()
		.logout().permitAll()
		.invalidateHttpSession(true)
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		;	

``` 

However, new issue that any create new, edit or delete will go back to login page
