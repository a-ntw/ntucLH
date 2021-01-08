package com.cp5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ShoppingCartApplication.class, args);

//		Product mobileProduct = new Mobile();
//		Product laptopProduct = new Laptop();

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Product s21 = context.getBean("smartPhone", Product.class);
		Product g14 = context.getBean("gamingLaptop", Product.class);

		System.out.println(" SmartPhone Details : " + s21);
		System.out.println(" Gaming Laptop Details : " + g14.toString());
	}
}
