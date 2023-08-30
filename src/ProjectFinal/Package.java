package ProjectFinal;
import java.util.*;
import jakarta.persistence.*;
@Entity(name = "Packages")
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
    @JoinTable(name="package_features",joinColumns=@JoinColumn(name="package_id"),inverseJoinColumns=@JoinColumn(name="Feature_id"))
    private Set<Feature> feature;
    //trim->package  association
    @OneToMany(mappedBy="pac")
    private Set<AvailablePackage> AVpackage;

    

    public Package() {
    }
    
    public Package(String name, Set<Feature> feature) {
        this.name = name;
        this.feature = feature;
        AVpackage = new HashSet<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPackage_id() {
        return package_id;
    }
    public void setPackage_id(int package_id) {
        this.package_id = package_id;
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

    @Override
    public String toString() {
        return "Package [AVpackage=" + AVpackage + ", feature=" + feature + ", name=" + name + ", package_id="
                + package_id + "]";
    }
    

}
