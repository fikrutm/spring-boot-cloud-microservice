package com.demo.account.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.account.entity.Account;
import com.demo.account.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AccountService.class);
	@Autowired
	private AccountRepository accountRepository;

	public Account SaveAccount(Account account) {
		log.info("Inside saveAccount o AccountService");
		return accountRepository.save(account);
	}

	public Optional<Account> findByAccountId(Long customerId) {
		log.info("Inside saveDepartment of DepartmentService");
		return accountRepository.findById(customerId);
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}
	
	public List<Account> findByCustomer(@PathVariable("userId") Integer userId)
	{
		return (List<Account>) accountRepository.findAll().stream().filter(it->it.getUserId().equals(userId.intValue())).collect(Collectors.toList());
	}
}
