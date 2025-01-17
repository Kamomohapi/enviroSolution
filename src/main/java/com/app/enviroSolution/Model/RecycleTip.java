package com.app.enviroSolution.model;
import com.app.enviroSolution.model.wasteCategory;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RecycleTip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tipId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Reference to the Category table
    private wasteCategory category;

    @Column(nullable = false)
    private String tipContent;
}