package com.moneymoney.account.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moneymoney.account.SavingsAccount;
import com.moneymoney.account.service.SavingsAccountService;

@Controller
public class AccountController {
	@Autowired
	private SavingsAccountService savingsAccountService;

	@RequestMapping("/welcome")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/createAccountRequest")
	public String createAccount() {
		return "createAccountForm";
	}
	
	@RequestMapping("/createSavingAccount")
	public String createSavingAccount(HttpServletRequest request, Model model) throws ClassNotFoundException, SQLException {
		
		String name = request.getParameter("accountHolderName");
		String typeOfAccount = request.getParameter("accountType");
		double initialBalance = Double.parseDouble(request.getParameter("accountBalance"));
		boolean salaried = request.getParameter("salaried").equals("no") ? false : true;
		SavingsAccount account = savingsAccountService.createNewAccount(name, initialBalance,salaried);
		return "getAll";	
	}
	
	
	@RequestMapping("/getAll")
	public String getAllAccount(Model model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccount();
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}
	
	
}
