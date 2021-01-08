package com.cp5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration 
@PropertySource("classpath:myApp.properties")
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
		return e;
	}

}