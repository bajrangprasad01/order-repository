package com.zopsmart.orderrepository.service.impl;

import com.zopsmart.orderrepository.entity.Order;
import com.zopsmart.orderrepository.repository.OrderRepository;
import com.zopsmart.orderrepository.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(long id) {
        if (orderRepository.findById(id).isPresent()) {
            return orderRepository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
