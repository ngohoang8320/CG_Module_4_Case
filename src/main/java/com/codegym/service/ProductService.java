package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<String> getProductType() {
        return productRepository.findAllTypes();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByType(String type) {
        return productRepository.findProductByType(type);
    }

    public List<Product> findByName(String proName) {
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

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<List<Product>> getProductListByType() {
        List<List<Product>> productWithAllType = new ArrayList<>();
        for (String type : productRepository.findAllTypes()) {
            List<Product> productList = productRepository.findProductByType(type);
            productWithAllType.add(productList);
        }
        return productWithAllType;
    }
    public Product findById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get(); // Trả về giá trị của optionalProduct
        } else {
            throw new NoSuchElementException("Không tìm thấy sản phẩm với id: " + id);
        }
    }
}
