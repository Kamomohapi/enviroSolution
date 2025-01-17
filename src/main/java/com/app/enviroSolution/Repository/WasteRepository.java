package com.app.enviroSolution.repository;

import com.app.enviroSolution.model.wasteCategory;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository <wasteCategory, Long>{

    List<wasteCategory> getAllWasteCategories();
    wasteCategory saveCategory (wasteCategory category);
    wasteCategory findCategoryById(long categoryId);
    wasteCategory updateCategory(Long categoryId, wasteCategory updatedCategory);
    Optional<wasteCategory> findByCategoryName(String categoryName);
}
