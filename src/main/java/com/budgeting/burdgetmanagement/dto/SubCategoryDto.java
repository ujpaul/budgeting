package com.budgeting.burdgetmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubCategoryDto {
    private Long subcategoryId;
    private Long categoryId;
    private String subCategoryName;
}
