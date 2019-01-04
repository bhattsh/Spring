package com.capgemini.springBasics;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccessPropertiesFile {

	 public static void main(String a[]){
	        String confFile = "context.xml";
	        ConfigurableApplicationContext context 
	                                = new ClassPathXmlApplicationContext(confFile);
	        SpringBasic user = (SpringBasic) context.getBean("propertyConfig");
	        System.out.println(user.toString());
	        context.close();
	    }
}