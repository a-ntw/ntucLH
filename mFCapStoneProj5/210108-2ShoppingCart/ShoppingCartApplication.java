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
		Product ipad = context.getBean("iPad", Product.class);

//		System.out.println(" SmartPhone Details : " + s21);
//		System.out.println(" Gaming Laptop Details : " + g14.toString());
//		System.out.println(" Tablet Details : " + ipad);
		
		// automatically ceate var name
		ShoppingCart myCart = context.getBean("shoppingCart",ShoppingCart.class);
		myCart.addItem(ipad);
		
		System.out.println(" My Shopping Cart " + myCart.getItems());
		
		ShoppingCart urCart = context.getBean(ShoppingCart.class);
		myCart.addItem(s21);
		
		System.out.println(" Your Shopping Cart " + urCart.getItems());
		
		/**
		 *  Every time you create a new POJO - do you have to make an entry into 
		 *  SpringConfig - NO 
		 *  
		 *  All Beans by default are Shared Singleton Objects ----  

		 */
	}
}
