package ProjectFinal;
import jakarta.persistence.*;
@Entity(name = "Features")
@Table(name="Features")
public class Feature {
    @Column(name="name",unique=true)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Feature_id")
    private int Feature_Id;

    public Feature() {
    }

    public Feature(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getFeature_Id() {
        return Feature_Id;
    }
    public void setFeature_Id(int feature_Id) {
        Feature_Id = feature_Id;
    }

    @Override
    public String toString() {
        return "Feature [Feature_Id=" + Feature_Id + ", name=" + name + "]";
    }
    

}