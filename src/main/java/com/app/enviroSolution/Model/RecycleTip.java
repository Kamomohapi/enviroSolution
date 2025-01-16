import Lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class RecycleTip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long tipId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
    private String tipContent;


     // Getters and Setters
     public Long getTipId() {
        return tipId;
    }

    public void setTipId(Long tipId) {
        this.tipId = tipId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTipContent() {
        return tipContent;
    }

    public void setTipContent(String tipContent) {
        this.tipContent = tipContent;
    }
}
