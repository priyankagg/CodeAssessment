package com.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
