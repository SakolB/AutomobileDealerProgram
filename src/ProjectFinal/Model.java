package ProjectFinal;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
@Entity
@Table(name="Model")
public class Model{
    @Column(name="name")
    private String name;
    @Column(name="year")
    private int year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="model_id")
    private int model_id;
    //model->feature
    @ManyToMany
    @JoinTable(name="modelFeature",joinColumns=@JoinColumn(name="model_id"),inverseJoinColumns=@JoinColumn(name="Feature_id"))
    private Set<Feature> feature;
    //trim->model uni
    @ManyToOne
    @JoinColumn(name= "trim_id")
    private Trim trim;

}

