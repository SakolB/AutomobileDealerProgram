package ProjectFinal;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
@Entity
@Table(name="AvailablePackage")
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
    private int id;
  /*  @JoinTable(name="Packageauto", joinColumns={@JoinColumn(name="AvaPakages_id"), inverseJoinColumns=@JoinColumn(name="Autos_id"))
    private Set<AvailablePackage> avapackage;*/
  /*  @ManyToMany(mappedBy="Packageauto")
      private Set<Automobile> autopackages;*/
    @OneToMany(mappedBy= "available")
    private Set<PackageAuto> getpackage;

}
