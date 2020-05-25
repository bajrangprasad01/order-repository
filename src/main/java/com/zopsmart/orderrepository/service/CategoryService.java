package com.zopsmart.orderrepository.service;

import com.zopsmart.orderrepository.entity.Category;
import javassist.NotFoundException;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategory(long id);
    void saveCategory(Category category) throws NotFoundException;
    void deleteById(long id);
}
