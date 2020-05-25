package com.zopsmart.orderrepository.controller;

import com.zopsmart.orderrepository.entity.Category;
import com.zopsmart.orderrepository.service.CategoryService;
import com.zopsmart.orderrepository.service.impl.CategoryServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(categoryService.getCategory(id));
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> addNewCategory(@RequestBody Category category) {
        try {
            categoryService.saveCategory(category);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body("Category save successfully");
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {
        categoryService.deleteById(id);
        return ResponseEntity.accepted().body("Category deleted successfully");
    }
}
