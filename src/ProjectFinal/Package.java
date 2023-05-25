package ProjectFinal;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
@Entity
@Table(name="Packages")
public class Package {
    @Column(name="name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private int package_id;
    //package->feature
    @ManyToMany
    @JoinTable(name="package_feature",joinColumns=@JoinColumn(name="package_id"),inverseJoinColumns=@JoinColumn(name="Feature_id"))
    private Set<Feature> feature;
    //trim->package  association
    @OneToMany(mappedBy="pac")
    private Set<AvailablePackage> AVpackage;
    public Package(){}
    public Package( String name, int package_id){
    this.name= name;
    this.package_id= package_id;
    }
@Override
    public String toString() {
        return "package " + name + " (ID " + package_id + ")";
    }
    public int getPackageId() {
        return package_id;
    }
    public void setId(int id){
        this.package_id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
}
