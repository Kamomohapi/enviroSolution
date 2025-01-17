package com.app.enviroSolution.Repository;

import com.enviro365.waste.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipRepositry  extends JpaRepository<RecyclingTip, Long> {

    RecyclingTip createTip( RecyclingTip tip);
    List<RecyclingTip> getAllTips();
    Optional<RecyclingTip> findById(Long id); 
    
}
