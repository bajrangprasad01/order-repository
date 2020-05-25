package com.zopsmart.orderrepository.service.impl;

import com.zopsmart.orderrepository.entity.Category;
import com.zopsmart.orderrepository.entity.Product;
import com.zopsmart.orderrepository.repository.CategoryRepository;
import com.zopsmart.orderrepository.service.CategoryService;
import com.zopsmart.orderrepository.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductServiceImpl productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void saveCategory(Category category) throws NotFoundException {
        if (productService.getProduct(category.getProductId()) != null) {
            List<Product> products = category.getProducts();
            products.add(productService.getProduct(category.getProductId()));
            category.setProducts(products);
            categoryRepository.save(category);
            return;
        }
        throw new NotFoundException("Product Not found");
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
