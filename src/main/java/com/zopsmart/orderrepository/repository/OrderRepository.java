package com.zopsmart.orderrepository.repository;

import com.zopsmart.orderrepository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByBanner(String banner);
}
