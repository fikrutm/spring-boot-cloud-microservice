package com.demo.user.controller;

import com.demo.user.entity.User;
import com.demo.user.response.Account;
import com.demo.user.response.ResponseTemplate;
import com.demo.user.srevice.UserService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
//        log.info("Inside getUserWithDepartment of UserController");
//        return userService.getUserWithDepartment(userId);
//    }

	@GetMapping("/users")
    public List<User> getUsers() {
		return userService.findAll();
	}
    
    @GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userService.findById(id);
	}

 // inject account for the customer /user

 	@RequestMapping("/user/account/{id}")
 	public User findById(@PathVariable("id") Integer id) {
 		User user = userService.findAll().stream().filter(it -> it.getUserId().intValue() == id.intValue()).findFirst()
 				.get();
 		List<Account> accounts = userService.getAccounts(id);
 		user.setAccounts(accounts);
 		System.err.print((user.getFirstName()+ " "+user.getAccounts()));
 		return user;
 	}
}
