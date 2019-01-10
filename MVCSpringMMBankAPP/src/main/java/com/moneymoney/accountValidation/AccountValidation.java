package com.moneymoney.accountValidation;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.moneymoney.account.SavingsAccount;

@Component
@Aspect
public class AccountValidation {

	Logger logger = Logger.getLogger(AccountValidation.class.getName());

	@Around("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.withdraw(..))")
	public void validateWithdraw(ProceedingJoinPoint pjp) throws Throwable {
		
		Object []parameters = pjp.getArgs();
		SavingsAccount savingsAccount = (SavingsAccount) parameters[0];
		double amountToWithdraw = (Double)parameters[1];
		
		logger.info("amount to withdraw :"+amountToWithdraw);
		
		if(amountToWithdraw > savingsAccount.getBankAccount().getAccountBalance() )
			logger.info("Insufficient Balance");
		
		else if(amountToWithdraw<0)
			logger.info("please enter a valid amount");
		
		else 
		{
			pjp.proceed();
			logger.info("withdraw successfull");
		}
	}
	
	
	@Around("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.deposit(..))")
	public void validateDeposit(ProceedingJoinPoint pjp) throws Throwable {
				
		Object []parameters = pjp.getArgs();
		double amountToDeposit = (Double)parameters[1];
		
		logger.info("amount to deposit:"+amountToDeposit);
		
		if(amountToDeposit<0)
			logger.info("please enter a valid amount");
		else 
		{
			pjp.proceed();
			logger.info("around after");
		}
	}
	

	/*
	 * @Around("execution(* com.moneymoney.account.service.SavingsAccountServiceImpl.withdraw(..))"
	 * ) public void validateFundTransfer(ProceedingJoinPoint pjp) throws Throwable
	 * { logger.info("Before-logging");
	 * 
	 * Object []parameters = pjp.getArgs(); SavingsAccount savingsAccount =
	 * (SavingsAccount) parameters[0]; double amountToDeposit =
	 * (Double)parameters[1];
	 * 
	 * if(amountToDeposit<0) logger.info("please enter a valid amount"); else {
	 * pjp.proceed(); logger.info("around after"); } }
	 */
}
