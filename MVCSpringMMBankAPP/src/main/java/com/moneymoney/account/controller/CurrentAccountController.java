package com.moneymoney.account.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moneymoney.account.CurrentAccount;
import com.moneymoney.account.service.CurrentAccountService;

@Controller
public class CurrentAccountController {

	@Autowired
	private CurrentAccountService currentAccountService;

	@RequestMapping("/createCurrentAccountRequest")
	public String createCurrentAccountRequest() {
		return "createCurrentAccountForm";
	}
	
	
	@RequestMapping("/createCurrentAccount")
	public String createCurrentAccount(@RequestParam("accountHolderName") String accountHolderName, @RequestParam("accountBalance") double initialBalance,
			@RequestParam("odLimit") double odLimit, Model model)
			throws ClassNotFoundException, SQLException {
		
		CurrentAccount currentAccount = currentAccountService.createNewAccount(accountHolderName, initialBalance, odLimit); 
		model.addAttribute("currentAccount", currentAccount);
		return "AccountDetails";
	}
	

	@RequestMapping("/getAllCurrentAccount")
	public String getAllCurrentAccount(Model model) throws ClassNotFoundException, SQLException {
		List<CurrentAccount> accounts = currentAccountService.getAllCurrentAccount();
		System.out.println(accounts);
		model.addAttribute("currentAccounts", accounts);
		return "AccountDetails";
	}

	
	
}
