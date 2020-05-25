package com.zopsmart.orderrepository.repository;

import com.zopsmart.orderrepository.entity.LineItem;
import com.zopsmart.orderrepository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, UUID> {
    LineItem findByProduct(Product product);
}
