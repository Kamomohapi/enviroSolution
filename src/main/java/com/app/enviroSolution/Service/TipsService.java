package com.app.enviroSolution.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.app.enviroSolution.model.RecyclingTip;
import com.app.enviroSolution.model.WasteCategory;
import com.app.enviroSolution.Repository.TipRepositry;
import com.app.enviroSolution.Repository.WasteRepository;

@Service


public class TipsService {

    private TipRepositry tipRepositry;

    private WasteRepository wasteRepository;

    public TipsService(TipRepositry _tipRepositry, WasteRepository wasteRepository)  {
        this.tipRepositry = _tipRepositry; 
        this.wasteRepository = wasteRepository;
    }

    public RecyclingTip createTip(RecyclingTip tip, string categoryName) {
        if (tip == null) {
            throw new IllegalArgumentException("Tip cannot be null.");
        }

        Optional<WasteCategory> wasteCategoryOptional = wasteRepository.findByCategoryName(categoryName);
        if (wasteCategoryOptional.isEmpty()) {
            throw new IllegalArgumentException("Waste category not found with name: " + categoryName);
        }
        tip.setWasteCategory(wasteCategoryOptional.get());
        
        return tipRepository.save(tip);
    }

    public List<RecyclingTip> getAllTips() {
        return tipRepository.findAll();
    }

    public RecyclingTip getTipById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid tip ID. The ID must be a positive number.");
        }
        Optional<RecyclingTip> tip = tipRepository.findById(id);
        if (tip.isEmpty()) {
            throw new IllegalArgumentException("Tip not found with ID: " + id);
        }
        return tip.get();
    }

    public void deleteTip(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid tip ID. The ID must be a positive number.");
        }
        if (!tipRepository.existsById(id)) {
            throw new IllegalArgumentException("Tip not found with ID: " + id);
        }
        tipRepository.deleteById(id);
    }
}
