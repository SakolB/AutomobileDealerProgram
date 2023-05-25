import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import jakarta.persistence.*;
import ProjectFinal.*;
public class ProjectfF {
    // These demos show finding, creating, and updating individual objects.
    private static void basicDemos() {
        //List <Feature> a = new ArrayList<Feature>();
        // In true Java fashion, we can't just create an EntityManager; we have to first
        // create a Factory that can then create the Manager. Don't ask me why.

        // The parameter "demoDb" matches the "name" of our data source, set in
        // src/META-INF/persistence.xml.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cars");
        EntityManager em = factory.createEntityManager();
    }
    public static void main(String[] args) throws Exception {
        basicDemos();
        //associationDemos();
        //equalityDemos();
    }
}
