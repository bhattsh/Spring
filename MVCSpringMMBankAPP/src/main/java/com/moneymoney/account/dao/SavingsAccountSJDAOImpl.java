package com.moneymoney.account.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.exception.AccountNotFoundException;

@Repository
@Primary
public class SavingsAccountSJDAOImpl implements SavingsAccountDAO{
	
	@Autowired
	JdbcTemplate template;
	
	Logger logger = Logger.getLogger(SavingsAccountSJDAOImpl.class.getName());
	
	
	public SavingsAccount createNewAccount(SavingsAccount account) {
		logger.info("hello from new DAO layer");
		
		template.update("INSERT INTO ACCOUNT( account_hn, account_balance, account_isSalary, account_type, odLimit) VALUES(?,?,?,?,?)", 
				new Object[] {account.getBankAccount().getAccountHolderName(),
						 account.getBankAccount().getAccountBalance(),account.isSalary(), "SA", null});
		
		SavingsAccount savingsAccount =  (SavingsAccount) template.queryForObject("SELECT * FROM account ORDER BY account_id  DESC LIMIT 1", new SavingsAccountMapper());
		return savingsAccount;
	}

	
	public SavingsAccount getAccountById(int accountNumber)
			throws AccountNotFoundException {
		
		SavingsAccount savingsAccount =  (SavingsAccount) template.queryForObject("SELECT * FROM account where account_id=?", new Object[] {accountNumber}, new SavingsAccountMapper());
		return savingsAccount;
	}

	
	public SavingsAccount deleteAccount(int accountNumber) {
		
	//	logger.info("deleting account.....");
		template.update("DELETE FROM account WHERE account_id=?", new Object[] {accountNumber});
		logger.info("account deleted successfully");
		return null;
	}

	
	public List<SavingsAccount> getAllSavingsAccount() {
		List<SavingsAccount> savingsAccountList =  template.query("SELECT * FROM account",new SavingsAccountMapper());
		return savingsAccountList;
	}

	
	public void updateBalance(int accountNumber, double currentBalance) {
		template.update("UPDATE ACCOUNT SET account_balance=? where account_id=?", new Object [] {currentBalance, accountNumber});
		
	}
	
	
	public SavingsAccount getAccountByName(String nameToSearch)
			throws AccountNotFoundException {
		SavingsAccount savingsAccount =  (SavingsAccount) template.queryForObject("SELECT * FROM account where account_hn=?", new Object[] {nameToSearch}, new SavingsAccountMapper());
		return savingsAccount;
	}

	
	public SavingsAccount updateAccount(SavingsAccount savingAccountToUpdate) {
		int rowsAffected = template.update("UPDATE ACCOUNT SET account_hn=?, account_balance=?, account_isSalary=? WHERE account_id=?",new Object[] {savingAccountToUpdate.getBankAccount().getAccountHolderName(),savingAccountToUpdate.getBankAccount().getAccountBalance(), savingAccountToUpdate.isSalary(),savingAccountToUpdate.getBankAccount().getAccountNumber()});
		
		return rowsAffected==0? null : (SavingsAccount) template.queryForObject("SELECT * FROM account where account_id=?", new Object[] {savingAccountToUpdate.getBankAccount().getAccountNumber()}, new SavingsAccountMapper());
	}

	
	public List<SavingsAccount> getAccountByBalanceRange(double minimumBalance, double highestBalance) {
		 return template.query("SELECT * FROM account where account_balance BETWEEN ? AND ?",new Object[] {minimumBalance,highestBalance},new SavingsAccountMapper()); 
	}

	
	public List<SavingsAccount> sort(int choice, int toSortIn) {
		// TODO Auto-generated method stub
		return null;
	}

}
