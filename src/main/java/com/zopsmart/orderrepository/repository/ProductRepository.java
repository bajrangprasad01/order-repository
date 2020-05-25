package com.zopsmart.orderrepository.repository;

import com.zopsmart.orderrepository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByDescription(String description);
}
