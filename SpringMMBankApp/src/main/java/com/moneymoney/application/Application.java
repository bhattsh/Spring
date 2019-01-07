package com.moneymoney.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moneymoney.account.ui.AccountCUI;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		AccountCUI accountCUI = context.getBean(AccountCUI.class);
		accountCUI.start();
	}

}
