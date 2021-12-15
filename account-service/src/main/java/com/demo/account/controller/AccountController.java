package com.demo.account.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.account.entity.Account;
import com.demo.account.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private AccountService accountService;

	@PostMapping("/")
	public Account saveAccount(@RequestBody Account account) {
		log.info("Inside saveAccounts method of AccountController");
		return accountService.SaveAccount(account);
	}

	@GetMapping("/{id}")
	public Optional<Account> findByAccountId(@PathVariable("id") Long customerId) {
		log.info("Inside findAccountById method of AccountController");
		return accountService.findByAccountId(customerId);
	}

	
	@RequestMapping("/accounts")
	public List<Account> findAll() {
		return accountService.findAll();
	}
	
	//get customers account by customer id
		@RequestMapping("/accounts/user/{userId}")
		public List<Account> findByUserId(@PathVariable("userId") Integer userId)
		{
			return (List<Account>) accountService.findAll().stream().filter(it->it.getUserId().equals(userId.intValue())).collect(Collectors.toList());
		}

}
