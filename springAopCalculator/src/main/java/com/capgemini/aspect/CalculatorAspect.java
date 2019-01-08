package com.capgemini.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CalculatorAspect {

	Logger logger = Logger.getLogger(CalculatorAspect.class.getName());

	@Before("execution(* com.capgemini.app.service.Calculator.*(..))")
	public void logForBefore() {
		logger.info("Before-logging");
	}

	@Around("execution(* com.capgemini.app.service.Calculator.divide(..))")
	public void logForAround(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("around before");
		logger.info("function name is: " + pjp.getSignature());
		logger.info("parameters are :");
		Object[] parameters = pjp.getArgs();
		
		if((Double)parameters[1] == 0)
			throw new Exception();
		
		for (int i = 0; i < parameters.length; i++) {
			logger.info("value of parameter at " + i + " is " + parameters[i]);
		}

		pjp.proceed();

		logger.info("around after");
	}

	/*
	 * @AfterReturning(pointcut =
	 * "execution(* com.capgemini.app.service.Calculator.*(..))", returning =
	 * "retVal") public void afterReturning(Integer retVal) {
	 * logger.info("Returned value is " + retVal); }
	 */

	@AfterThrowing(pointcut = "execution(* com.capgemini.app.service.Calculator.*(..))", throwing = "ex")
	public void exceptionThrow(JoinPoint jp, Throwable ex) {
		logger.info("exception occured");
	}

}
