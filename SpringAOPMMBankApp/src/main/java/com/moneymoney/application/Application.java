package com.moneymoney.application;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moneymoney.account.ui.AccountCUI;

public class Application {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Application.class.getName());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		logger.info("getting object of AccountCUI class");
		AccountCUI accountCUI = context.getBean(AccountCUI.class);
		logger.info("object of AccountCUI class creation successfull");
		
		accountCUI.start();
	}

}
