package e_generics;

import data.Person;
import global.Workable;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Generics extends Workable {
    class Tier {
    }
    class Hund extends Tier {
    }
    class Hamster extends  Tier {
    }


    @Override
    public void doWork() {
        t4();
    }

    public void t4() {

        Class c = String.class;
        Class d = Hamster.class;

        ArrayList<Tier> l1 = new ArrayList<>();
        ArrayList<Hamster> l2 = new ArrayList<>();

        System.out.println(l1.getClass().equals(l2.getClass())); // true

        Class<ArrayList<Tier>> e = (Class<ArrayList<Tier>>)l1.getClass();
        System.out.println(e.getName());

        Class f = l1.getClass();
        System.out.println(f.getName());

        Person  p = new Person();
        Class meta = p.getClass();
        for(Field field : meta.getDeclaredFields()) {
            System.out.print(field.getName() + " => ");
            field.setAccessible(true);
            try {
                System.out.println(field.get(p));
            } catch (IllegalAccessException ex) {
               ex.printStackTrace();
            }
        }

    }


    public void addTier(ArrayList<? super Hamster> liste, Hamster tier) {
        liste.add(tier);
    }



    public void printListe(ArrayList<? extends Tier> liste) {
        System.out.println("TIERLISTE");
        for (Tier t : liste) {
            System.out.println("** " + t);
        }
        System.out.println("**********");
    }
    public void t3() {
        ArrayList<Tier> tierliste = new ArrayList<>();
        // addTier(tierliste, new Hund());
        addTier(tierliste, new Hamster());
        ArrayList<Hamster> hamsterliste = new ArrayList<>();
        addTier(hamsterliste, new Hamster());

        //printListe(hamsterliste);
    }

    public void t2() {
        ArrayList<Tier> tierliste = new ArrayList<>();
        tierliste.add(new Tier());
        tierliste.add(new Hund());
        tierliste.add(new Hamster());
        printListe(tierliste);

        ArrayList<Hund> hundeliste = new ArrayList<>();
        hundeliste.add(new Hund());
        // hundeliste.add(new Tier());
        printListe(hundeliste);
        ArrayList<Hamster> hamsterliste = new ArrayList<>();
        printListe(hamsterliste);

    }

    public void t1() {
        MyArrayList<String> l1;
        MyArrayList<Integer> l2;
        ArrayList<Integer> l3;
        ArrayList<Double> l4;


    }
}
