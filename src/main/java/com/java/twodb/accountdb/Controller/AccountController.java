package com.java.twodb.accountdb.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.twodb.accountdb.Model.Account;
import com.java.twodb.accountdb.Repository.AccountRepository;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/test")
    public String test(){
        return "This Port Works!";
    }

    @PostMapping("/add")
    public Account addAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }

    @GetMapping("/all")
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }
}
