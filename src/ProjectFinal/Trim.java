package ProjectFinal;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
@Entity
@Table (name="Trims")
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
    @ManyToOne
    @JoinColumn(name="Auto_id")
    private Automobile auto;
    //trim->model uni
    @OneToMany(mappedBy="trim")
    private List<Model> model;
    //trim->package assioation
    @OneToMany(mappedBy="trim")
    private Set<AvailablePackage> AVpackage;
}
