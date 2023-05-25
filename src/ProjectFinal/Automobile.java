package ProjectFinal;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
@Entity
@Table(name="Automobile")
  public class Automobile {
      @Column(name="vin")
      private String vin;
      @Column(name="color")
      private String color;
      @Id
      @Column(name="Autos_id")
      private int Autos_id;
     /* @ManyToMany(mappedBy="avapackage")
      private Set<AvailablePackage> aut;*/
      
    /*@JoinTable(name="Packageauto", joinColumns=@JoinColumn(name="Autos_id"), inverseJoinColumns=@JoinColumn(name="AvaPakages_id"))
    private Set<AvailablePackage> avapackage;*/
    @OneToMany(mappedBy= "auto")
    private Set<PackageAuto> getAuto;

    public Automobile(String vin, String color, int autos_id) {
      this.vin = vin;
      this.color = color;
      Autos_id = autos_id;
    }

    public String getVin() {
      return vin;
    }

    public void setVin(String vin) {
      this.vin = vin;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public int getAutos_id() {
      return Autos_id;
    }

    public void setAutos_id(int autos_id) {
      Autos_id = autos_id;
    }

    public Set<PackageAuto> getGetAuto() {
      return getAuto;
    }

    public void setGetAuto(Set<PackageAuto> getAuto) {
      this.getAuto = getAuto;
    }
    
  }

