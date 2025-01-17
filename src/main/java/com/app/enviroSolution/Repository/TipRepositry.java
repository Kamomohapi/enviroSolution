package com.app.enviroSolution.repository;

import com.enviro365.waste.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TipRepositry  extends JpaRepository<RecyclingTip > {

    RecyclingTip createTip( RecyclingTip tip);
    List<RecyclingTip> getAllTips();
    Optional<RecyclingTip> findById(Long id); 
    
}
