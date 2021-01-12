package com.cp5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration 
//@PropertySource("classpath:myApp.properties")
public class SpringConfig {
	
	@Value("${empName:Albert}")
	private String empName;
	
	@Value("${empAge:9}")
	private int empAge;
	
	@Value("${empCountry:MY}")
	private String empCountry;

	@Bean
	public Emp getEmp() {
		Emp e = new Emp(empName, empAge, empCountry);
//		Emp e = new Emp(empName, Integer.parseInt(empAge), empCountry);
		return e;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource ();
		messageSource.setBasenames("/messages");
		return messageSource;
	}

}