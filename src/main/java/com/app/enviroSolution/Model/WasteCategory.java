package com.app.enviroSolution.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

public class WasteCategory{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

    // Getters and Setters
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    } 
    
    public void getCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}