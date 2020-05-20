package com.zopsmart.orderrepository.service;

import com.zopsmart.orderrepository.entity.Order;

import java.util.List;

public interface OrderService {
    public void saveOrder(Order order);
    public List<Order> getAllOrder();
    public Order getOrder(long id);
    public void deleteOrder(long id);
}
