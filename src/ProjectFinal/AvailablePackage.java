package ProjectFinal;
import java.util.*;
import jakarta.persistence.*;
@Entity(name = "AvailablePackages")
@Table(name="AvailablePackages")
public class AvailablePackage {
  //trim->package with assicoation
  
  @JoinColumn(name="package_id")
  @ManyToOne
  private Package pac;
  
  @JoinColumn(name="trim_id")
  @ManyToOne
  private Trim trim;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="AvaPakages_id")
  private int AvaPakages_id;
  @Column(name="cost")
  private double cost;
  //@ManyToMany
  //@JoinTable(name="ChosenPackages", joinColumns=@JoinColumn(name="AvaPakages_id"), inverseJoinColumns=@JoinColumn(name="Autos_id"))
  //private Set<Automobile> Autos;
  @ManyToMany(mappedBy="chosenPackages")
    private Set<Automobile> Autos;
  

  public AvailablePackage() {
  }
  

  public AvailablePackage(Package pac, Trim trim, double cost) {
    this.pac = pac;
    this.trim = trim;
    this.cost = cost;
    Autos = new HashSet<>();
  }


  public Package getPac() {
    return pac;
  }
  
  

  public void setPac(Package pac) {
    this.pac = pac;
  }
  public Trim getTrim() {
    return trim;
  }
  public void setTrim(Trim trim) {
    this.trim = trim;
  }
  public int getAvaPakages_id() {
    return AvaPakages_id;
  }
  public void setAvaPakages_id(int avaPakages_id) {
    AvaPakages_id = avaPakages_id;
  }
  public double getCost() {
    return cost;
  }
  public void setCost(double cost) {
    this.cost = cost;
  }


  public Set<Automobile> getAutos() {
    return Autos;
  }


  public void setAutos(Set<Automobile> Autos) {
    this.Autos = Autos;
  }


  @Override
  public String toString() {
    return "AvailablePackage [Autos=" + Autos + ", AvaPakages_id=" + AvaPakages_id + ", cost=" + cost + ", pac=" + pac
        + ", trim=" + trim + "]";
  }
  
    
}
