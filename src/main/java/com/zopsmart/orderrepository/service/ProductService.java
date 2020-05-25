package com.zopsmart.orderrepository.service;

import com.zopsmart.orderrepository.entity.Product;
import javassist.NotFoundException;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(long id) throws NotFoundException;
    void saveProduct(Product product) throws NotFoundException;
    void deleteById(long id);
}
