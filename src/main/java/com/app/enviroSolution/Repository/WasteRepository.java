package com.app.enviroSolution.Repository;

import com.app.enviroSolution.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteRepository extends JpaRepository <WasteCategory, Long>{

    List<WasteCategory> getAllWasteCategories();
    WasteCategory saveCategory (WasteCategory category);
    WasteCategory findCategoryById(Long categoryId);
    WasteCategory updateCategory(Long categoryId, WasteCategory updatedCategory)
    Optional<WasteCategory> findByCategoryName(String categoryName);
}
