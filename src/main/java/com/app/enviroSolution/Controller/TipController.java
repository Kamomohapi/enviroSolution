package com.app.enviroSolution.Controller;
import com.app.enviroSolution.Service.TipService;
import com.app.enviroSolution.model.RecyclingTip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tips")
public class TipController {

   
    private final TipsService tipsService;

    public TipController(TipsService _tipsService) {
        this.tipsService = _tipsService;
    }

    // Create a new tip
    @PostMapping
    public ResponseEntity<?> createTip(@RequestBody RecyclingTip tip, string categoryName) {
        try {
            RecyclingTip createdTip = tipsService.createTip(tip,categoryName);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTip);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while creating the tip. Please try again.");
        }
    }

    // Retrieve all tips
    @GetMapping
    public ResponseEntity<?> getAllTips() {
        try {
            List<RecyclingTip> tips = tipsService.getAllTips();
            if (tips.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No tips found.");
            }
            return ResponseEntity.ok(tips);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving tips. Please try again.");
        }
    }

    // Retrieve a tip by its ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getTipById(@PathVariable Long id) {
        try {
            RecyclingTip tip = tipsService.getTipById(id);
            return ResponseEntity.ok(tip);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the tip. Please try again.");
        }
    }

    // Delete a tip by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTip(@PathVariable Long id) {
        try {
            tipsService.deleteTip(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the tip. Please try again.");
        }
    }
}