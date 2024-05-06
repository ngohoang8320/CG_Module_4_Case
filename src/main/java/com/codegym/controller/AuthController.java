package com.codegym.controller;

import com.codegym.model.Account;
import com.codegym.model.Role;
import com.codegym.repository.RoleRepository;
import com.codegym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class AuthController {

    @Autowired
    AccountService accountService;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/register")
    public String toRegisterPage(Model model) {
        Account account = new Account();
        model.addAttribute("account",
                account);
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Account account) {
        Account checkAccount = accountService.findAccountByUsername(account.getUsername());
        if (checkAccount == null) {
            Account newAccount = new Account();
            newAccount.setUsername(account.getUsername());
            newAccount.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));

            Role role = roleRepository.findByRole("ROLE_USER");
//            Role role1 = roleRepository.findByRole("ROLE_ADMIN");

            List<Role> roleList = new ArrayList<>();

            roleList.add(role);

//            roleList.add(role1);

//            newAccount.setRoles(roleList);

            List<Account> accountList = new ArrayList<>(role.getAccounts());
//            List<Account> accountList1 = new ArrayList<>(role1.getAccounts());
            accountList.add(newAccount);
//            accountList1.add(newAccount);

            role.setAccounts(accountList);
//            role1.setAccounts(accountList1);

            accountService.saveAccount(newAccount);
        }
        return "redirect:register";
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "loginPage";
    }


}
