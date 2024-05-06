package com.codegym.service;

import com.codegym.model.Account;

public interface AccountService {
    Account findAccountByUsername(String username);

    void saveAccount(Account account);
}
