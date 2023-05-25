package ProjectFinal;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
@Entity
@Table(name="features")
public class Feature {
    @Column(name="name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Feature_id")
    private int Feature_Id;
    
public Feature(){}
public Feature( String name, int Feature_id){
    this.name= name;
    this.Feature_Id= Feature_id;
    }
@Override
    public String toString() {
        return "Feature " + name + " (ID " + Feature_Id + ")";
    }
    public int getFeatureid() {
        return Feature_Id;
    }
    public void setId(int id){
        this.Feature_Id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
}