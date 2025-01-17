package com.app.enviroSolution.service;

import org.springframework.stereotype.Service;


import com.app.enviroSolution.model.wasteCategory;
import com.app.enviroSolution.repository.WasteRepository;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.stereotype.Repository;;

@Service

public class WasteService {

    private final WasteRepository wasteRepo;

    public WasteService(WasteRepository _wasteRepo) {
        this.wasteRepo = _wasteRepo;
    }

    public wasteCategory saveCategory (wasteCategory category) {
        return wasteRepo.save(category);
    }

    public List<wasteCategory> getAllWasteCategories() {
        return wasteRepo.findAll();
    }


    public wasteCategory findCategoryById(long categoryId) {
        return wasteRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
// {"conversationId":"c88d8111-fd67-42e6-b68a-5dffc891a4ff","source":"instruct"}

    public wasteCategory updateCategory(Long categoryId, wasteCategory updateCategory) {
        wasteCategory category = findCategoryById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        return wasteRepo.save(category);
    }
}
