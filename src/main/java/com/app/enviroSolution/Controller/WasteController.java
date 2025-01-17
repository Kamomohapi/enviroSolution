package com.app.enviroSolution.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.enviroSolution.model.wasteCategory;
import com.app.enviroSolution.service.WasteService;

@RestController
@RequestMapping("/waste")

public class WasteController {

    private final WasteService wasteService; 
    
    public WasteController(WasteService _wasteService) {
        this.wasteService = _wasteService;
    }

     @GetMapping
    public List<wasteCategory> getAllCategories() {
       
        try{
            List<wasteCategory> categories = wasteService.findAll();

            if (categories == null || categories.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No categories found.");
            }
            return ResponseEntity.ok(categories);

       } catch(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("An error occurred while retrieving categories. Please try again.");
       }
    }
    
     @GetMapping("/{id}")
    public wasteCategory getCategoryById(@PathVariable Long id) {
       
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid category ID. The ID must be a positive number.");
        }

        try{
            Optional<wasteCategory> category = wasteService.findById(id);

            if (category.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with ID: " + id);
            }
            return ResponseEntity.ok(category.get());

        }catch(Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while retrieving the category. Please try again.");
        }
    }

     @PostMapping
    public wasteCategory createCategory(@RequestBody wasteCategory category) {
        
        if (category == null) {
            return ResponseEntity.badRequest().body("Category data is required.");
        }
        
       try{
        wasteCategory savedCategory = wasteService.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

       }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while saving the category. Please try again.");

       }
    }

    @DeleteMapping("/{id}")
    public wasteCategory deleteCategory(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid category ID.");
        }

        try{
            Optional<wasteCategory> category = wasteService.findById(id);
        if (category.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with ID: " + id);
        }
        wasteService.delete(id);

        }catch(Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while deleting the category. Please try again.");
        }
    }
}
