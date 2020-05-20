package com.zopsmart.orderrepository.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public ResponseEntity<?> allOrders() {
        return ResponseEntity.ok().body("This is all order");
    }
}
