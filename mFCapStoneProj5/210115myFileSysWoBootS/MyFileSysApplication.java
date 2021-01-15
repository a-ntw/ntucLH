package com.cp5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFileSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFileSysApplication.class, args);
		System.out.println("********************************************");
		System.out.println("SpringApplication > http://localhost:8080/ to cont.");
		System.out.println("********************************************");
	}

}
