package com.mybank.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.model.Transaction;
import com.mybank.repository.TransactionRepository;

@RestController
public class TransactionController {
	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@GetMapping("/transactions/{id}")
	public Optional<Transaction> getTransactionById(@PathVariable("id") String id) {
		return transactionRepository.findById(id);
	}

	@GetMapping("/accounts/{accountId}/transactions")
	public List<Transaction> getByAccountId(@PathVariable(value = "accountId") Long accountId) {
		return transactionRepository.getByAccountId(accountId);
	}

	@GetMapping("/accounts/{accountId}/{fromdate}/{todate}/transactions")
	public List<Transaction> getByAccountIdAndTransactiontimeBetween(@PathVariable(value = "accountId") Long accountId,
			@PathVariable(value = "fromdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromdate,
			@PathVariable(value = "todate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date todate) {
		return transactionRepository.getByAccountIdAndTransactiontimeBetween(accountId, fromdate, todate);
	}

	@GetMapping("/accounts/{accountId}/{fromdate}/{todate}/{trantype}/transactions")
	public List<Transaction> getByAccountIdAndTransactiontimeBetweenAndType(
			@PathVariable(value = "accountId") Long accountId, @PathVariable(value = "fromdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromdate,
			@PathVariable(value = "todate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date todate, @PathVariable(name = "trantype") String trantype) {
		return transactionRepository.getByAccountIdAndTransactiontimeBetweenAndType(accountId, fromdate, todate, trantype);
	}

}
