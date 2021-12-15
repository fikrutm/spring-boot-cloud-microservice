package com.demo.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    //Account findByAccountId(Long accountId);
    
    
}
