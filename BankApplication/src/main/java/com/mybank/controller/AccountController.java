package com.mybank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.model.Account;
import com.mybank.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public Optional<Account> getAccountsById(@PathVariable(name = "id") Long id) {
		return accountRepository.findById(id);
	}
}
