package com.cp5;

import java.io.IOException;
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

		Resource res = new FileSystemResource("/Users/antw/ntuc/mFCap5/myApp.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(res);
		System.out.println(" myApp.Properties == " + props);

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		System.out.println( context.getBean("getEmp", Emp.class));
	}

}
