package com.budgeting.burdgetmanagement.service;

import com.budgeting.burdgetmanagement.dto.SubCategoryDto;
import com.budgeting.burdgetmanagement.entity.CategoryEntity;
import com.budgeting.burdgetmanagement.entity.SubCategoryEntity;
import com.budgeting.burdgetmanagement.repository.CategoryRepository;
import com.budgeting.burdgetmanagement.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    public List<SubCategoryEntity> findAll(){
        return subCategoryRepository.findAll();
    }
    public Optional<SubCategoryEntity> findOne(Long id){
        return subCategoryRepository.findById(id);
    }
    public SubCategoryEntity saveSubCategory(SubCategoryDto subCategoryDto){
        CategoryEntity category = categoryRepository.findById(subCategoryDto.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        SubCategoryEntity subCategory = new SubCategoryEntity();
        subCategory.setCategory(category);
        subCategory.setSubCategoryName(subCategoryDto.getSubCategoryName());
        subCategory.setCreatedAt(LocalDate.now());
        return subCategoryRepository.save(subCategory);
    }
    public SubCategoryEntity updateSubCategory(Long id,SubCategoryDto subCategoryDto){
        CategoryEntity category = categoryRepository.findById(subCategoryDto.getCategoryId()).orElseThrow(()->new RuntimeException("Sub category not found"));
        SubCategoryEntity existingSubCategory = subCategoryRepository.findById(id).orElseThrow(()->new RuntimeException("Sub category not found"));
        existingSubCategory.setCategory(category);
        existingSubCategory.setSubCategoryName(subCategoryDto.getSubCategoryName());
        return subCategoryRepository.save(existingSubCategory);
    }
    public void deleteSubCategory(Long id){
        subCategoryRepository.deleteById(id);
    }
}
