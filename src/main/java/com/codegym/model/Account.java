package com.codegym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private LocalDate birth;
    private String phoneNumber;
    private String email;
    private String gender;

    @OneToOne(mappedBy = "account")//(cascade = CascadeType.REMOVE)
    private Wallet wallet;

//    @OneToMany(mappedBy = "account")
//    private List<Product> products;

    /*@ManyToMany(mappedBy = "accounts",
            fetch = FetchType.EAGER)
    private List<Role> roles;*/

//    @OneToMany(mappedBy = "account")
//    private List<CartItem> cartItems;

//    @OneToMany(mappedBy = "account")
//    private List<OrderedItem> orderedItems;
}
