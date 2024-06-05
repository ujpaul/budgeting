package com.budgeting.burdgetmanagement.controller;

import com.budgeting.burdgetmanagement.entity.CategoryEntity;
import com.budgeting.burdgetmanagement.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<CategoryEntity> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Optional<CategoryEntity> getAllCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }
    @PostMapping("")
    public void saveCategory(@RequestBody CategoryEntity category){
        categoryService.saveCategory(category);
    }
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody CategoryEntity category){
        categoryService.updateCategory(id,category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
