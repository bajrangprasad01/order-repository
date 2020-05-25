package com.zopsmart.orderrepository.service.impl;

import com.zopsmart.orderrepository.entity.Category;
import com.zopsmart.orderrepository.entity.Product;
import com.zopsmart.orderrepository.repository.CategoryRepository;
import com.zopsmart.orderrepository.repository.ProductRepository;
import com.zopsmart.orderrepository.service.ProductService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) throws NotFoundException {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        throw new NotFoundException("Product Not found");
    }

    @Override
    public void saveProduct(Product product) throws NotFoundException {
        logger.info("Inside save product");
        if (categoryRepository.findById(product.getCategoryId()).isPresent()) {
            logger.info("Inside save product if condition");
            List<Category> categories = product.getCategories();
            categories.add(categoryRepository.findById(product.getCategoryId()).get());
            product.setCategories(categories);
            productRepository.save(product);
            return;
        }
        throw new NotFoundException("Category Not Found");
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
