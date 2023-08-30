package ProjectFinal;
import java.util.*;
import jakarta.persistence.*;
@Entity(name = "Automobiles")
@Table(name="Automobiles")
  public class Automobile {
    @Column(name="vin",unique=true)
    private String vin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Autos_id")
    private int Autos_id;
    @ManyToMany
    //(mappedBy="Autos")
    //private Set<AvailablePackage> chosenPackages;
    
    @JoinTable(name="chosenPackages", joinColumns=@JoinColumn(name="Autos_id"), inverseJoinColumns=@JoinColumn(name="AvaPakages_id"))
    private Set<AvailablePackage> chosenPackages;
    
    @ManyToOne
    @JoinColumn(name="trim_id")
    private Trim trim;
      
    
    public Automobile() {
    }
    public Automobile(String vin, Trim trim) {
      this.vin = vin;
      this.trim = trim;
      chosenPackages = new HashSet<>();
    }
    public Trim getTrim(){
        return trim;
    }
    public void setTrim(Trim t){
    trim=t;}

    public String getVin() {
      return vin;
    }

    public void setVin(String vin) {
      this.vin = vin;
    }

    public int getAutos_id() {
      return Autos_id;
    }

    public void setAutos_id(int autos_id) {
      Autos_id = autos_id;
    }
    public Set<AvailablePackage> getChosenPackages() {
      return chosenPackages;
    }
    public void setChosenPackages(Set<AvailablePackage> chosenPackages) {
      this.chosenPackages = chosenPackages;
    }
    public Set<Feature> getFeatures()
    {
      Set<Feature> f = new HashSet<>();
      f.addAll(trim.getFeature());
      f.addAll(trim.getModel().getFeature());
      for(AvailablePackage avp: chosenPackages)
      {
        f.addAll(avp.getPac().getFeature());
      }
      return f;
    }
    public double stickerPrice(){
      double sticker;
      double total=0.0;
       for(AvailablePackage c: chosenPackages){
         total+=c.getCost();
       }
      sticker= getTrim().getCost()+ total;
      return sticker;
    }
    @Override
    public String toString() {
      String print = getTrim().getModel().getYear() + " " + getTrim().getModel().getName() + " " + getTrim().getName() + "\n";
      print += stickerPrice() + "\n";
      print += "Features:\n";
      ArrayList<String> fName = new ArrayList<>();
      for(Feature f: getFeatures())
      {
        fName.add(f.getName());
      }
      Collections.sort(fName);
      for(String s: fName)
      {
        print += s+ "\n";
      }
      return print;
    }

}


    

