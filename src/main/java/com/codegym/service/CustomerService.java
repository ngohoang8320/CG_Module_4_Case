package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final EntityManager entityManager;
    private final ProductRepository productRepository;

    public CustomerService(EntityManager entityManager, ProductRepository productRepository) {
        this.entityManager = entityManager;
        this.productRepository = productRepository;
    }

}
