package com.codegym.repository;

import com.codegym.model.Account;
import com.codegym.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByAccounts(List<Account> accounts);

    Role findByRole(String role);
}
