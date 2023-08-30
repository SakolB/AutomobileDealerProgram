import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import jakarta.persistence.*;
import ProjectFinal.*;
import ProjectFinal.Package;
public class ProjectfF {
    public static void menu()
    {
        System.out.println();
        System.out.println("Please choose an option:");
        System.out.println("1. Instantiate the model.");
        System.out.println("2. Find an automobile using VIN.");
        System.out.println("3. Find an automobile using feature.");
        System.out.println("0. Quit");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice)
        {
            case 0:
                System.exit(0);
                break;
            case 1:
                instantiateModel();
                menu();
                break;
            case 2:
                findVIN();
                menu();
                break;
            case 3:
                findFeature();
                menu();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void instantiateModel()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cars");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        ArrayList<Feature> a = new ArrayList<>();
        a.add(new Feature("leather seats"));
        a.add(new Feature("plug-in hybrid engine"));
        a.add(new Feature("power sliding doors"));
        a.add(new Feature("hands-free sliding doors"));
        a.add(new Feature("Amazon FireTV"));
        a.add(new Feature("rear-seat entertainment screens"));
        a.add(new Feature("all-wheel drive"));
        a.add(new Feature("adaptive criuse control"));
        for(Feature f: a)
        {
            em.persist(f);
            em.flush();
            em.clear();
        }
        ArrayList<Package> pA = new ArrayList<>();
        Set<Feature> f1 = new HashSet<>();
        f1.add(a.get(5));
        pA.add(new Package("Theater Package", f1));
        Set<Feature> f2 = new HashSet<>();
        f2.add(a.get(5));
        f2.add(a.get(4));
        pA.add(new Package("Amazon Theater Package", f2));
        Set<Feature> f3 = new HashSet<>();
        f3.add(a.get(7));
        pA.add(new Package("Safety Package", f3));
        for(Package p: pA )
        {
            em.persist(p);
            em.flush();
            em.clear();
        }
        ArrayList<Model> m = new ArrayList<>();
        Set<Feature> f4 = new HashSet<>();
        f4.add(a.get(2));
        m.add(new Model("Pacifica", 2022, f4));
        
        ArrayList<Trim> t = new ArrayList<>();
        t.add(new Trim("Touring", 30000, new HashSet<Feature>(), m.get(0)));
        ArrayList<AvailablePackage> avp = new ArrayList<>();
        avp.add(new AvailablePackage(pA.get(2), t.get(0), 3000));
        Set<Feature> f5 = new HashSet<>();
        f5.add(a.get(0));
        f5.add(a.get(3));
        t.add(new Trim("Limited", 34000, f5, m.get(0)));
        avp.add(new AvailablePackage(pA.get(1), t.get(1), 2500));
        Set<Feature> f6 = new HashSet<>();
        f6.add(a.get(0));
        f6.add(a.get(3));
        f6.add(a.get(5));
        f6.add(a.get(4));
        f6.add(a.get(6));
        t.add(new Trim("Pinnacle", 42000, f6, m.get(0)));
        Set<Feature> f7 = new HashSet<>();
        f7.add(a.get(2));
        f7.add(a.get(1));


        m.add(new Model("Pacifica Hybrid", 2022, f7));
        t.add(new Trim("Touring", 43000, new HashSet<Feature>(), m.get(1)));
        t.add(new Trim("Limited", 48000, f5, m.get(1)));
        avp.add(new AvailablePackage(pA.get(1), t.get(4), 2500));
        Set<Feature> f9 = new HashSet<>();
        f9.add(a.get(0));
        f9.add(a.get(3));
        f9.add(a.get(5));
        f9.add(a.get(4));
        t.add(new Trim("Pinnacle", 54000, f9, m.get(1)));


        m.add(new Model("Pacifica Hybrid", 2021, f7));
        t.add(new Trim("Touring", 41000, new HashSet<Feature>(), m.get(2)));
        avp.add(new AvailablePackage(pA.get(2), t.get(6), 3000));
        t.add(new Trim("Limited", 46000, f5, m.get(2)));
        avp.add(new AvailablePackage(pA.get(0), t.get(7), 2500));
        avp.add(new AvailablePackage(pA.get(2), t.get(7), 2000));
        Set<Feature> f8 = new HashSet<>();
        f8.add(a.get(0));
        f8.add(a.get(3));
        f8.add(a.get(5));
        f8.add(a.get(7));
        t.add(new Trim("Pinnacle", 52000, f8, m.get(2)));


        ArrayList<Automobile> auto = new ArrayList<>();
        auto.add(new Automobile("12345abcde", t.get(1)));
        Set<AvailablePackage> c1 = new HashSet<>();
        c1.add(avp.get(1));
        auto.get(0).setChosenPackages(c1);
        auto.add(new Automobile("67890abcde", t.get(5)));
        auto.add(new Automobile("99999aaaaa", t.get(8)));
        auto.add(new Automobile("aaaaa88888", t.get(6)));
        Set<AvailablePackage> c2 = new HashSet<>();
        c2.add(avp.get(3));
        auto.get(3).setChosenPackages(c2);
        auto.add(new Automobile("bbbbb77777", t.get(7)));
        Set<AvailablePackage> c3 = new HashSet<>();
        c3.add(avp.get(4));
        c3.add(avp.get(5));
        auto.get(4).setChosenPackages(c3);




        for(Model mo:m)
        {
            em.persist(mo);
            em.flush();
            em.clear();
        }

        for(Trim tr:t)
        {
            em.persist(tr);
            em.flush();
            em.clear();
        }
        
        for(AvailablePackage avpa:avp)
        {
            em.persist(avpa);
            em.flush();
            em.clear();
        }

        for(Automobile au: auto)
        {
            em.persist(au);
            em.flush();
            em.clear();
        }



        em.getTransaction().commit();
    }

    public static void findVIN()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cars");
        EntityManager em = factory.createEntityManager();
        System.out.println("Please enter the VIN of the vehicle to search");
        Scanner in = new Scanner(System.in);
        String fin = in.nextLine();
        var feature = em.createQuery("SELECT a FROM Automobiles a WHERE " + "a.vin = ?1", Automobile.class);
        feature.setParameter(1, fin);

        try{
            Automobile a = feature.getSingleResult();
            System.out.println();
            System.out.println(a);
        }catch(NoResultException ex)
        {
            System.out.println();
            System.out.println("There is no vehicle with that VIN");
        }

    }

    public static void findFeature()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cars");
        EntityManager em = factory.createEntityManager();
        System.out.println("Please enter feature to search for vehicles:(0 to quit)");
        Scanner in = new Scanner(System.in);
        String fin = in.nextLine();
        if(fin.equals("0"))
        {
            return;
        }
        var feature = em.createQuery("SELECT f FROM Features f WHERE "
            + "f.name = ?1", Feature.class);
        feature.setParameter(1, fin);
        boolean flag = true;
        Feature requested = new Feature();
        while(flag)
        {
            try {
                requested = feature.getSingleResult();
                flag = false;
            }
            catch (NoResultException ex) {
                System.out.println("There's no such feature.");
                System.out.println("Please enter feature to search for vehicles:(0 to quit)");
                fin = in.nextLine();
                if(fin.equals("0"))
                {
                    return;
                }
                feature = em.createQuery("SELECT f FROM Features f WHERE "
                + "f.name = ?1", Feature.class);
                feature.setParameter(1, fin);
            }
        } 

        var auto = em.createQuery("SELECT DISTINCT a FROM Automobiles a JOIN a.trim t JOIN t.feature tf JOIN t.model m JOIN m.feature mf LEFT JOIN a.chosenPackages cp LEFT JOIN cp.pac p LEFT JOIN p.feature pf WHERE tf.name = '"+ requested.getName()+"' or mf.name = '"+ requested.getName()+"' or pf.name = '"+ requested.getName()+"'" , Automobile.class);
        try{
            auto.getResultList();
            System.out.println("Vehicles that has "+ requested.getName() + ":");
            int i = 1;
            for(Automobile a: auto.getResultList())
            {
                System.out.println(i+ ") " + a.getVin());
                i++;
            }
        }catch(NoResultException ex)
        {
            System.out.println("There is no vehicle with that feature.");
        }
        

        



    }
    public static void main(String[] args) throws Exception {
        menu();
        


        //associationDemos();
        //equalityDemos();
    }

}
