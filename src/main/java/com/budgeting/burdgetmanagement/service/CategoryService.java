package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.entity.CategoryEntity;
import com.budgeting.burdgetmanagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryEntity>getAllCategories(){
        return categoryRepository.findAll();
    }
    public Optional<CategoryEntity> getCategory(Long id){
        return categoryRepository.findById(id);
    }
    public CategoryEntity saveCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }
    public CategoryEntity updateCategory(Long id, CategoryEntity category){
        CategoryEntity existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingCategory.setCategoryName(category.getCategoryName());
        return categoryRepository.save(existingCategory);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
