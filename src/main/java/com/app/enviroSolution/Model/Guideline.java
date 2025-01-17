package com.app.enviroSolution.model;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity


public class Guideline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long guidelineId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private wasteCategory wasteCategory;
    private String guidelineContent;


     // Getters and Setters
     public Long getGuidelineId() {
        return guidelineId;
    }

    public void setGuidelineId(Long guidelineId) {
        this.guidelineId = guidelineId;
    }

    public wasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(wasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getGuidelineContent() {
        return guidelineContent;
    }

    public void setGuidelineContent(String guidelineContent) {
        this.guidelineContent = guidelineContent;
    }
}
