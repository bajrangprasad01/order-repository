package com.zopsmart.orderrepository.repository;

import com.zopsmart.orderrepository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
