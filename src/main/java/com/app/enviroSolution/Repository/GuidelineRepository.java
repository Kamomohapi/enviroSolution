package com.app.enviroSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.app.enviroSolution.model.WasteCategory;
import com.enviro365.waste.model.Guideline;

public interface GuidelineRepository  extends JpaRepository <Guideline, Long >{

    Guideline createDisposalGuideline(String guideline, Long wasteCategoryId);
    List<Guideline> getGuidelinesForCategory(Long wasteCategoryId)
}
