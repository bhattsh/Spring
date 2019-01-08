package com.capgemini.springAopCalculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.app.service.Calculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	Calculator calculator = context.getBean(Calculator.class);
    	calculator.divide(200, 10);
    }
}
