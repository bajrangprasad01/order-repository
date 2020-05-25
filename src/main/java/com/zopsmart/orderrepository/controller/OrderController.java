package com.zopsmart.orderrepository.controller;

import com.zopsmart.orderrepository.entity.Order;
import com.zopsmart.orderrepository.service.OrderService;
import com.zopsmart.orderrepository.service.impl.OrderServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<?> allOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrder());
    }

    @PostMapping("/addOrder")
    public ResponseEntity<?> saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return ResponseEntity.accepted().body(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getSingleOrder(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok().body(orderService.getOrder(id));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id")long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.accepted().body("Order Deleted" + id);
    }
}
