package com.moneymoney.account.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.dao.SavingsAccountDAO;
import com.moneymoney.account.factory.AccountFactory;
import com.moneymoney.exception.AccountNotFoundException;
import com.moneymoney.exception.InsufficientFundsException;
import com.moneymoney.exception.InvalidInputException;

@Service	
@Transactional(rollbackFor= {Throwable.class})
public class SavingsAccountServiceImpl implements SavingsAccountService {

	private AccountFactory factory;
	
	@Autowired
	private SavingsAccountDAO savingsAccountDAO;

	public SavingsAccountServiceImpl() {
		factory = AccountFactory.getInstance();
		//savingsAccountDAO = new SavingsAccountDAOImpl();
	}

	@Override
	public SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary)
			throws ClassNotFoundException, SQLException {
		SavingsAccount account = factory.createNewSavingsAccount(accountHolderName, accountBalance, salary);
		savingsAccountDAO.createNewAccount(account);
		return null;
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.getAllSavingsAccount();
	}

	@Override
	public void deposit(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException {
		if (amount > 0) {
			double currentBalance = account.getBankAccount().getAccountBalance();
			currentBalance += amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);

		}else {
			throw new InvalidInputException("Invalid Input Amount!");
		}
	}
	
	@Override
	public void withdraw(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException {
		double currentBalance = account.getBankAccount().getAccountBalance();
		if (amount > 0 && currentBalance >= amount) {
			currentBalance -= amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
//			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			//savingsAccountDAO.commit();
		} else {
			throw new InsufficientFundsException("Invalid Input or Insufficient Funds!");
		}
	}

	@Override
	public void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount)
			throws ClassNotFoundException, SQLException {
		
			deposit(receiver, amount);
			withdraw(sender, amount);

		}

	
	@Override
	public SavingsAccount updateAccount(SavingsAccount savingAccountToUpdate) throws ClassNotFoundException, SQLException {
		 return savingsAccountDAO.updateAccount(savingAccountToUpdate);
	}

	
	@Override
	public SavingsAccount getAccountById(int accountNumber) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		return savingsAccountDAO.getAccountById(accountNumber);
	}

	@Override
	public SavingsAccount getAccountByName(String nameToSearch) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		
		return savingsAccountDAO.getAccountByName(nameToSearch);
	}
	
	
	@Override
	public SavingsAccount deleteAccount(int accountNumber) throws ClassNotFoundException, SQLException {
		savingsAccountDAO.deleteAccount(accountNumber);
		return null;
	}
/*
	@Override
	public SavingsAccount searchAccount(String nameToSearch) throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.searchAccount(nameToSearch);
	}

*/

	@Override
	public List<SavingsAccount> getAccountByBalanceRange(double minimumBalance, double highestBalance) throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.getAccountByBalanceRange(minimumBalance, highestBalance);
	}

	@Override
	public List<SavingsAccount> sort(int choice, int toSortIn) throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.sort(choice,toSortIn);
	}

}
