package com.cp5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
		System.out.println("********************************************");
		System.out.println("SpringApplication > http://localhost:8080/ to cont.");
		System.out.println("********************************************");
	}

}
