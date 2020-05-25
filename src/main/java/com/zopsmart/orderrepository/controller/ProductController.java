package com.zopsmart.orderrepository.controller;

import com.zopsmart.orderrepository.entity.Product;
import com.zopsmart.orderrepository.service.ProductService;
import com.zopsmart.orderrepository.service.impl.ProductServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok().body(productService.getProduct(id));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        try {
            productService.saveProduct(product);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.accepted().body(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
        productService.deleteById(id);
        return ResponseEntity.accepted().body("Product deleted successfully");
    }
}
