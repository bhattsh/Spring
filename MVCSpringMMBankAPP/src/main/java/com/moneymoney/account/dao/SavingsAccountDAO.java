package com.moneymoney.account.dao;

import java.sql.SQLException;
import java.util.List;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.exception.AccountNotFoundException;

public interface SavingsAccountDAO {
	
	SavingsAccount createNewAccount(SavingsAccount account); 
//	SavingsAccount updateAccount(SavingsAccount account);
	SavingsAccount getAccountById(int accountNumber) throws AccountNotFoundException;
	SavingsAccount deleteAccount(int accountNumber);
	List<SavingsAccount> getAllSavingsAccount();
	void updateBalance(int accountNumber, double currentBalance);
	
//	SavingsAccount updateAccount(int accountNumber, int toUpdate, String update) throws ClassNotFoundException, SQLException, AccountNotFoundException;
	SavingsAccount getAccountByName(String nameToSearch) throws AccountNotFoundException;
	SavingsAccount updateAccount(SavingsAccount savingAccountToUpdate);
	List<SavingsAccount> getAccountByBalanceRange(double minimumBalance,
			double highestBalance);


	List<SavingsAccount> sort(int choice, int toSortIn);

	//SavingsAccount searchAccount(String accountToSearch) throws ClassNotFoundException, SQLException;

	
	
}
