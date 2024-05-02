package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<String> getProductType(){
      return productRepository.findAllTypes();
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public List<Product> findByType(String type){
        return productRepository.findProductByType(type);
    }
    public List<Product> findByName(String proName){
        return productRepository.getProductBySearchName(proName);
    }
    public List<Product> getProductsSortedByPriceAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "price");
        return productRepository.findAll(sort);
    }
    public List<Product> getProductsSortedByPriceDESC() {
        Sort sort = Sort.by(Sort.Direction.DESC, "price");
        return productRepository.findAll(sort);
    }
    public void save(Product product){
        productRepository.save(product);
    }



}
