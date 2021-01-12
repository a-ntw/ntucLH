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

//		Vehicle vehicle5 = new Vehicle("Temp5234", "Grey", 4, 7);
//		Vehicle vehicle6 = new Vehicle("Temp6234", "Yellow", 4, 7);
//		Vehicle vehicle7 = new Vehicle("Temp7234", "Pink", 4, 7);
//		Vehicle vehicle8 = new Vehicle("Temp8234", "Brown", 4, 7);
//		vDao.insert(Arrays.asList(vehicle5, vehicle6, vehicle7, vehicle8));

		Vehicle v = new Vehicle("XYZ3456", "Silver", 5, 4);
//		Vehicle v = new Vehicle("VBG3456", "Chery Red", 7, 4);
//		Vehicle v = new Vehicle("ABC1234", "Sky Blue", 5, 5);

		vDao.insert(v);
		System.out.println(" ==> Inserted Vehicle " + v);

		Vehicle v2 = new Vehicle("XYZ3456", "Golden", 5, 4);	
		vDao.update(v);
		System.out.println(" ==> vehicle updated" + v2);

		vDao.findByVehicleNo(v.getVehicleNo());
		System.out.println(" ==> FOUND vehicle " + v);

		List<Vehicle> vehicles = vDao.findAll();
		vehicles.forEach(System.out::println);

		System.out.println(" ==> Vehicle VBG3456 has the color " + vDao.getColor("VBG3456"));

		System.out.println(" ==> Vehicle count " + vDao.getVehicleCount());
		
//		vDao.delete("Temp8234");
		vDao.delete(v.getVehicleNo());
		System.out.println(" ==> vehicle deleted" + v);
	}

}
