package com.cp5;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

@SpringBootApplication
public class ExtResourcesTrApplication {

	public static void main(String[] args) throws Exception {

		// method 1
		Resource res = new FileSystemResource("/Users/antw/ntuc/mFCap5/myApp.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(res);
		System.out.println(" myApp.Properties == " + props);

		// method 2 thru SpringConfig and EMP
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		System.out.println( ctx.getBean("getEmp", Emp.class));
		

		// method 3 thru main/resources
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		String hwMsg = ctx.getMessage("msg1", null, Locale.US);
		String welMsg = ctx.getMessage("msg2", null, Locale.US);

		System.out.println("\t msg1 : " + hwMsg + "\n\t msg2 : " + welMsg);

		hwMsg = ctx.getMessage("msg1", null, Locale.FRANCE);
		welMsg = ctx.getMessage("msg2", null, Locale.FRANCE);

		System.out.println("\t msg1 : " + hwMsg + "\n\t msg2 : " + welMsg);

		hwMsg = ctx.getMessage("msg1", null, Locale.CHINA);
		welMsg = ctx.getMessage("msg2", null, Locale.CHINA);

		System.out.println("\t msg1 : " + hwMsg + "\n\t msg2 : " + welMsg);

	}

}
