package com.cp5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Which will help configure your Spring Container / Framework

@Configuration
public class SpringConfig {

	@Bean // This method is the Constructor for that Bean
	public Product smartPhone() {
		Mobile m = new Mobile("Galaxy_S21", 2000.0);
		m.setMaker("Samsung");
		return m;
	}

	@Bean
	public Product gamingLaptop() {
		Laptop l = new Laptop("Asus_ROG", 3200.0);
		l.setOsType("Win10");
		return l;
	}

}
