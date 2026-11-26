package e_generics;

import global.Workable;

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
        t2();
    }


    public void t2() {
        ArrayList<Tier> tierliste = new ArrayList<>();
        tierliste.add(new Tier());
        tierliste.add(new Hund());
        tierliste.add(new Hamster());

        ArrayList<Hund> hundeliste = new ArrayList<>();
        hundeliste.add(new Hund());
        // hundeliste.add(new Tier());

    }

    public void t1() {
        MyArrayList<String> l1;
        MyArrayList<Integer> l2;
        ArrayList<Integer> l3;
        ArrayList<Double> l4;


    }
}
