package com.capgemini.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.app.bean.Organization;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 String confFile = "context.xml";
	        ConfigurableApplicationContext context 
	                                = new ClassPathXmlApplicationContext(confFile);
	        Organization organization = (Organization) context.getBean("organization");
	        System.out.println(organization.toString());
	        context.close();
    }
}
