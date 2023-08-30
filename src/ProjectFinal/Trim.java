package ProjectFinal;
import java.util.*;
import jakarta.persistence.*;
@Entity(name = "Trims")
@Table(name="Trims",uniqueConstraints=
    @UniqueConstraint(columnNames = {"model_id", "name"}))
//@Table (name="Trims")
public class Trim {
    @Column(name="name")
    private String name;
    @Column(name="cost")
    private double Cost;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trim_id")
    private int Id;
    //trim->feature
    @ManyToMany
    @JoinTable(name="Trimfeature",joinColumns=@JoinColumn(name="trim_id"),inverseJoinColumns=@JoinColumn(name="Feature_id"))
    private Set<Feature> feature;
    //auto->trim
/*@ManyToOne
    @JoinColumn(name="Auto_id")
    private Automobile auto;*/
    //trim->model uni
    
    
    //trim->package assioation
    @OneToMany(mappedBy="trim")
    private Set<AvailablePackage> AVpackage;
    @ManyToOne
    @JoinColumn(name= "model_id")
    private Model model;



    
    public Trim() {
    }
    
    public Trim(String name, double cost, Set<Feature> feature, Model model) {
        this.name = name;
        Cost = cost;
        this.feature = feature;
        this.model = model;
        AVpackage = new HashSet<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getCost() {
        return Cost;
    }
    public void setCost(double cost) {
        Cost = cost;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public Set<Feature> getFeature() {
        return feature;
    }
    public void setFeature(Set<Feature> feature) {
        this.feature = feature;
    }
   
    public Set<AvailablePackage> getAVpackage() {
        return AVpackage;
    }
    public void setAVpackage(Set<AvailablePackage> aVpackage) {
        AVpackage = aVpackage;
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Trim [AVpackage=" + AVpackage + ", Cost=" + Cost + ", Id=" + Id + ", feature=" + feature + ", model="
                + model + ", name=" + name + "]";
    }
    
}

