package com.demo.user.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.demo.user.response.Account;
import com.demo.user.response.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;    
    private UserType userType;    
    @Transient
    private List<Account> accounts;
    
    
    public User(String firstName, String lastName, UserType userType) {
		super();
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
	}
}
