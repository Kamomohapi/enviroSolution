package com.app.enviroSolution.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.enviroSolution.Model.WasteCategory;
import com.app.enviroSolution.Repository.WasteRepository;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;;

@Service

public class WasteService {

    private final WasteRepository wasteRepo;

    public WasteService(WasteRepository _wasteRepo) {
        this.wasteRepo = _wasteRepo;
    }

    public WasteCategory saveCategory (WasteCategory category) {
        return wasteRepo.save(category);
    }

    public List<WasteCategory> getAllWasteCategories() {
        return wasteRepo.findAll();
    }

    public 

    public WasteCategory findCategoryById(Long categoryId) {
        return wasteRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public WasteCategory updateCategory(Long categoryId, WasteCategory updatedCategory) {
        WasteCategory category = findCategoryById(categoryId);
        category.setName(updatedCategory.getName());
        return wasteRepo.save(category);
    }
}
