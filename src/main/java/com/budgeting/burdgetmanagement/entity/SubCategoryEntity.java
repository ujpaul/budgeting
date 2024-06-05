package com.budgeting.burdgetmanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subcategory")
@Data
@NoArgsConstructor
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCategoryId;
    private String subCategoryName;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    private LocalDate createdAt;

}
