package com.codegym.service;

import com.codegym.model.Account;
import com.codegym.model.AccountDetail;
import com.codegym.model.Role;
import com.codegym.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccountDetailService implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Username not right!");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        List<Role> roles = roleRepository.findAllByAccounts(accounts);

        for (Role accountRole : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(accountRole.getRole()));
        }

        /*AccountDetail
                .builder()
                .account(account)
                .build();*/

        return new AccountDetail(account,
                grantedAuthorities);
    }
}
