package com.app.enviroSolution.service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.enviroSolution.model.Guideline;
import com.app.enviroSolution.model.WasteCategory;
import com.app.enviroSolution.repository.GuidelineRepository;
import com.app.enviroSolution.repository.WasteRepository;

import java.util.List;

public class GuidelineService {

    private final GuidelineRepository guidelineRepository;
    private final WasteRepository wasteRepository;

    public GuidelineService(GuidelineRepository _guidelineRepository, WasteRepository _wasteRepository) {
         this.guidelineRepository = _guidelineRepository;
         this.wasteRepository = _wasteRepository;
    }

    public GuideLine createDisposal(GuideLine guideline, Long categoryId)
    {
        Optional <WasteCategory> category = wasteRepository.findById(categoryId);

        if(wasteCategory != null)
        {
            Guideline guidelineDisposal = new Guideline();
            guidelineDisposal.setGuidelineContent(guideline);
            guidelineDisposal.setWasteCategory(category.get());
            
            return guidelineRepository.save(guidelineDisposal);
        }else{
            throw new RuntimeException("Waste category not found.");
        }
    }

    public List<Guideline> getGuidelinesForCategory(Long wasteCategoryId)
    {
        return guidelineRepository.findAll().stream().
        filter(g->g.getWasteCategory().getId.equals(wasteCategoryId)).toList()
    }

}