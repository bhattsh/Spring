package com.capgemini.app.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

	public Double divide(double numberOne, double numberTwo) {
		System.out.println(numberOne+numberTwo);
		return numberOne/numberTwo;
	}
}
