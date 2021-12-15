package com.demo.account;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.demo.account.entity.Account;
import com.demo.account.service.AccountService;



@SpringBootApplication
@EnableEurekaClient
public class AccountServiceApplication implements CommandLineRunner {
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Stream.of( new Account(2, "222222"),new Account(2, "222222"), new Account(3, "333333"),new Account(4, "444444"),new Account(1, "555555"),new Account(2, "666666") ,new Account(2, "777777")).forEach(account->accountService.SaveAccount(account));

	}
}
