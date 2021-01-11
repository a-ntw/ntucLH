package com.cp5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JdbcAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		VehicleDao vDao = context.getBean(VehicleDao.class);
		Vehicle v = new Vehicle("VBG3456", "Chery Red", 7, 4);
		vDao.insert(v);
	}

}
