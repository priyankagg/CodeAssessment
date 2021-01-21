package com.mybank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

	List<Transaction> getByAccountId(Long accountId);

	List<Transaction> getByAccountIdAndTransactiontimeBetween(Long accountId, Date fromdate, Date todate);

	List<Transaction> getByAccountIdAndTransactiontimeBetweenAndType(Long accountId, Date fromdate, Date todate,
			String trantype);

}
