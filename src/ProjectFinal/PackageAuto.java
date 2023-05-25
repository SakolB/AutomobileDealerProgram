package ProjectFinal;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.*;
@Entity(name="packageauto")
public class PackageAuto{
@JoinColumn(name="id")
@ManyToOne
private AvailablePackage available;
@JoinColumn(name="Autos_id")
@ManyToOne
private Automobile auto;
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PackageAuto_id")
    private int id;


}