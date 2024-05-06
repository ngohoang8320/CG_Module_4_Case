package com.codegym.service;

import com.codegym.model.Account;
import com.codegym.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);


    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
