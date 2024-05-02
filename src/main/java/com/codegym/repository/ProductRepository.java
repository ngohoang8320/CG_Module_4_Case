package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT p from Product p where p.name soundslike %?%")
@Query("SELECT p FROM Product p WHERE SOUNDEX(p.name) = SOUNDEX(?1)")
    public List<Product> getProductBySearchName(String proName);
    public List<Product> findProductByType(String type);
    @Query("SELECT DISTINCT p.type FROM Product p")
    List<String> findAllTypes();
}
