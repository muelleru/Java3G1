package a_verschiedenes.defaults;

import global.Workable;

import java.util.ArrayList;
import java.util.List;

public class Defaults extends Workable {

    @Override
    public void doWork() {
        System.out.println("DEFAULTS");
        Tier hund = new Hund();
        hund.info();
        hund.schreien();
        // List ist ein Interface
        List<String> sliste = List.of("A","B","C");
        // of ist eine default-Methode des Interface List

        // Verwendung bei Initialisierung von Collections
        new ArrayList<String>(List.of("A","B","C"));

    }
}
