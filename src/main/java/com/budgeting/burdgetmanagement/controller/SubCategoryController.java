package com.budgeting.burdgetmanagement.controller;

import com.budgeting.burdgetmanagement.dto.SubCategoryDto;
import com.budgeting.burdgetmanagement.entity.SubCategoryEntity;
import com.budgeting.burdgetmanagement.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category/subcategory")
@CrossOrigin
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @GetMapping("")
    public List<SubCategoryEntity> getAllSubcategores(){
        return subCategoryService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<SubCategoryEntity> getCategory(@PathVariable Long id){
        return subCategoryService.findOne(id);
    }
    @PostMapping("")
    public SubCategoryEntity saveCategory(@RequestBody SubCategoryDto subCategoryDto){
        return subCategoryService.saveSubCategory(subCategoryDto);
    }
    @PutMapping("/{id}")
    public SubCategoryEntity saveCategory(@PathVariable Long id, @RequestBody SubCategoryDto subCategoryDto){
        return subCategoryService.updateSubCategory(id,subCategoryDto);
    }
    @DeleteMapping("/{id}")
    public void deleteSubCategory(@PathVariable Long id){
       subCategoryService.deleteSubCategory(id);
    }
}
