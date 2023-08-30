package ProjectFinal;

import java.util.*;
import jakarta.persistence.*;
@Entity(name = "Models")

@Table(name="Models",uniqueConstraints=
@UniqueConstraint(columnNames = {"name", "year"}))
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
    @JoinTable(name="modelFeatures",joinColumns=@JoinColumn(name="model_id"),inverseJoinColumns=@JoinColumn(name="Feature_id"))
    private Set<Feature> feature;
    //trim->model uni
    
    @OneToMany(mappedBy="model")
    private List<Trim> trim;


    

    public Model() {
    }
    

    public Model(String name, int year, Set<Feature> feature) {
        this.name = name;
        this.year = year;
        this.feature = feature;
        trim = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public Set<Feature> getFeature() {
        return feature;
    }

    public void setFeature(Set<Feature> feature) {
        this.feature = feature;
    }

    public List<Trim> getTrim() {
        return trim;
    }

    public void setTrim(List<Trim> trim) {
        this.trim = trim;
    }


    @Override
    public String toString() {
        return "Model [feature=" + feature + ", model_id=" + model_id + ", name=" + name + ", trim=" + trim + ", year="
                + year + "]";
    }
    
    
}

