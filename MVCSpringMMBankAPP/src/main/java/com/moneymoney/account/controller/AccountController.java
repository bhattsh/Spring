package com.moneymoney.account.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.service.SavingsAccountService;
import com.moneymoney.exception.AccountNotFoundException;

@Controller // context
public class AccountController {

	@Autowired
	private SavingsAccountService savingsAccountService;
	private boolean toSortIn=false;

	@RequestMapping("/welcome") // spring-mvc
	public String home() {
		return "index";
	}

	@RequestMapping("/createAccountRequest")
	public String createAccount() {
		return "createAccountForm";
	}

	@RequestMapping("/updateAccountRequest")
	public String searchAccount() {
		return "updateAccountForm";
	}

	@RequestMapping("/searchAccountToUpdate")
	public String getAccount(@RequestParam("accountNumber") int accountNumber, Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
		 model.addAttribute("account", account);
		return "AccountDetails";
	}
	
	@RequestMapping("/updateAccount")
	public String updateAccount(@RequestParam("accountNumber") int accountNumber, @RequestParam("newName") String accountHolderName,
			@RequestParam("accountBalance") double accountBalance,
			@RequestParam("accountType") String accountType,@RequestParam("newSalaried") String salaried, Model model)
			throws ClassNotFoundException, SQLException {
		
		boolean salariedOrNot = salaried.equalsIgnoreCase("yes")?true:false;
		SavingsAccount savingAccountToUpdate = new SavingsAccount(accountNumber, accountHolderName,accountBalance, salariedOrNot);
		savingAccountToUpdate = savingsAccountService.updateAccount(savingAccountToUpdate);
		model.addAttribute("account", savingAccountToUpdate);
		return "AccountDetails";
	}
	
	/*
	 * @RequestMapping("/createSavingAccount") public String
	 * createSavingAccount(HttpServletRequest request, Model model) throws
	 * ClassNotFoundException, SQLException {
	 * 
	 * String name = request.getParameter("accountHolderName"); String typeOfAccount
	 * = request.getParameter("accountType"); double initialBalance =
	 * Double.parseDouble(request.getParameter("accountBalance")); boolean salaried
	 * = request.getParameter("salaried").equals("no") ? false : true;
	 * SavingsAccount account = savingsAccountService.createNewAccount(name,
	 * initialBalance, salaried); return "redirect:getAll"; }
	 */
	@RequestMapping("/createSavingAccount")
	public String createSavingAccount(@RequestParam("accountHolderName") String accountHolderName, @RequestParam("accountBalance") double initialBalance,
			@RequestParam("accountType") String accountType,@RequestParam("salaried") String salaried, Model model)
			throws ClassNotFoundException, SQLException {
		
		boolean salariedOrNot = salaried.equalsIgnoreCase("yes")?true:false;
		
		SavingsAccount account = savingsAccountService.createNewAccount(accountHolderName,initialBalance, salariedOrNot); 
		model.addAttribute("account", account);
		return "AccountDetails";
	}
	
	
	@RequestMapping("/closeAccountRequest")
	public String deleteAccountRequest() {
		return "closeAccountForm";
	}
	
	@RequestMapping("/deleteAccount")			//not complete but working
	public String deleteAccount(@RequestParam("accountNumber") int accountToDelete) throws ClassNotFoundException, SQLException
	{
		savingsAccountService.deleteAccount(accountToDelete);
		return "redirect:getAll";
	}
	
	

	@RequestMapping("/withdrawRequest")
	public String withdrawRequest() {
		return "withdrawRequestForm";
	}
	
	
	@RequestMapping("/withdraw")
	public String withdraw(@RequestParam("accountNumber") int accountNumber, @RequestParam("amount") double amountToWithdraw) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount	savingsAccount = savingsAccountService.getAccountById(accountNumber);
		savingsAccountService.withdraw(savingsAccount, amountToWithdraw);
		return "withdrawSuccess";
	}
	
	@RequestMapping("/depositRequest")
	public String depositRequest() {
		return "depositRequestForm";
	}
	
	@RequestMapping("/deposit")
	public String deposit(@RequestParam("accountNumber") int accountNumber, @RequestParam("amount") double amountToDeposit) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount	savingsAccount = savingsAccountService.getAccountById(accountNumber);
		savingsAccountService.deposit(savingsAccount, amountToDeposit);	
		
		return "depositSuccess";
	}
	
	
	@RequestMapping("/moneyTransferRequest")
	public String moneyTransferRequest() {
		return "moneyTransferForm";
	}
	
	@RequestMapping("/transferMoney")
	public String transferMoney(@RequestParam("senderAccountNumber") int senderAccountNumber,
			@RequestParam("receiverAccountNumber") int receiverAccountNumber, @RequestParam("amount") double amountToTransfer) throws ClassNotFoundException, SQLException, AccountNotFoundException
	{
		SavingsAccount	senderSavingsAccount = savingsAccountService.getAccountById(senderAccountNumber);
		SavingsAccount	receiverSavingsAccount = savingsAccountService.getAccountById(receiverAccountNumber);
		
		savingsAccountService.fundTransfer(senderSavingsAccount, receiverSavingsAccount, amountToTransfer);		
		return "fundTransferSuccess";
	}
	
	
	@RequestMapping("/searchRequest")
	public String searchRequest() {
		return "searchBy";
	}
	
	@RequestMapping("/searchByAccountId")
	public String searchByAccountId() {
		return "searchByIdForm";
	}
	
	@RequestMapping("/searchById")
	public String searchById(@RequestParam("accountNumber") int accountNumber,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
		model.addAttribute("account", account);
		return "AccountDetails";
	}
	
	
	@RequestMapping("/searchByName")
	public String searchByAccountName() {
		return "searchByNameForm";
	}
	
	@RequestMapping("/searchByAccountName")
	public String searchByAccountName(@RequestParam("accountHolderName") String accountHolderName, Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = savingsAccountService.getAccountByName(accountHolderName);
		model.addAttribute("account", account);
		return "AccountDetails";
	}
	
	
	@RequestMapping("/searchByBalanceRange")
	public String searchByBalanceRange() {
		return "searchByBalanceRangeForm";
	}
	
	@RequestMapping("/searchAccountByBalanceRange")
	public String searchAccountByBalanceRange(@RequestParam("minimumBalance") double minimumBalance, @RequestParam("maximumBalance") int maximumBalance,
			Model model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> accounts = savingsAccountService.getAccountByBalanceRange(minimumBalance, maximumBalance);
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}
	
	@RequestMapping("/sortByName")
	public String sortByName(Model model) throws ClassNotFoundException, SQLException {
		
		List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccount();
		toSortIn = !toSortIn;
		final int sort = toSortIn == false ? 1 : -1;									//why it is forcing us to make it final
		Collections.sort(accounts, new Comparator<SavingsAccount>() {
			@Override
			public int compare(SavingsAccount accountOne, SavingsAccount accountTwo) {
				return sort* (accountOne.getBankAccount().getAccountHolderName().compareToIgnoreCase(accountTwo.getBankAccount().getAccountHolderName()));
			}
		});
		System.out.println(toSortIn);
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}
	
	
	@RequestMapping("/sortAccountById")
	public String sortByAccountId(Model model) throws ClassNotFoundException, SQLException {
		
		List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccount();
		toSortIn = !toSortIn;
		final int sort = toSortIn == false ? 1 : -1;									//why it is forcing us to make it final
		Collections.sort(accounts, new Comparator<SavingsAccount>() {
			@Override
			public int compare(SavingsAccount accountOne, SavingsAccount accountTwo) {
				if(accountOne.getBankAccount().getAccountNumber() >accountTwo.getBankAccount().getAccountNumber())
					return -1*sort;
				else if(accountOne.getBankAccount().getAccountNumber() < accountTwo.getBankAccount().getAccountNumber())
					return 1*sort;
				else
					return 0;
			}
		});
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}
	
	

	@RequestMapping("/sortAccountByIsSalried")
	public String sortAccountByIsSalaried(Model model) throws ClassNotFoundException, SQLException {
		
		List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccount();
		toSortIn = !toSortIn;
		final int sort = toSortIn == false ? 1 : -1;									//why it is forcing us to make it final
		Collections.sort(accounts, new Comparator<SavingsAccount>() {
			@Override
			public int compare(SavingsAccount accountOne, SavingsAccount accountTwo) {
				if(accountOne.isSalary() == accountTwo.isSalary())
					return 0*sort;
				else
					return sort*-1;
			}
		});
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}
	
	
	
	
	
	@RequestMapping("/getAll")
	public String getAllAccount(Model model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccount();
		System.out.println(accounts);
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}

}
