import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data 

public class Guideline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long guidelineId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private WasteCategory wasteCategory;
    private String guidelineContent;


     // Getters and Setters
     public Long getGuidelineId() {
        return guidelineId;
    }

    public void setGuidelineId(Long guidelineId) {
        this.guidelineId = guidelineId;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getGuidelineContent() {
        return guidelineContent;
    }

    public void setGuidelineContent(String guidelineContent) {
        this.guidelineContent = guidelineContent;
    }
}
