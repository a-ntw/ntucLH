package com.cp5;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JdbcAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		VehicleDao vDao = context.getBean(VehicleDao.class);

//		Vehicle vehicle1 = new Vehicle("Temp1234", "Grey", 4, 7);
//		Vehicle vehicle2 = new Vehicle("Temp2234", "Yellow", 4, 7);
//		Vehicle vehicle3 = new Vehicle("Temp3234", "Pink", 4, 7);
//		Vehicle vehicle4 = new Vehicle("Temp4234", "Brown", 4, 7);
//		vDao.insert(Arrays.asList(vehicle1, vehicle2, vehicle3, vehicle4));

		Vehicle v = new Vehicle("VBG3456", "Chery Red", 7, 4);
//		Vehicle v = new Vehicle("ABC1234", "Sky Blue", 5, 5);

//		vDao.insert(v);
//		System.out.println(" Inserted Vehicle " + v);
//		
//		vDao.update(v);
//		System.out.println(" vehicle updated" + v);
//		
//		vDao.delete(v.getVehicleNo());
//		System.out.println(" vehicle deleted" + v)

		vDao.findByVehicleNo(v.getVehicleNo());
		System.out.println(" vehicle " + v);

		List<Vehicle> vehicles = vDao.findAll();
		vehicles.forEach(System.out::println);

		System.out.println(" Vehicle VBG3456 has the color " + vDao.getColor("VBG3456"));

		System.out.println(" Vehicle count " + vDao.getVehicleCount());
	}

}
