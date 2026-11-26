package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonenGenerator {

    // Singleton???
    private PersonenGenerator() {

    }

    private static PersonenGenerator instance = null;

    public static PersonenGenerator getInstance() {
        if (instance == null) {
            instance = new PersonenGenerator();
        }
        return instance;
    }

    private String[] Nachnamen =
            {"Müller", "Maier", "Schmid", "Huber", "Alber", "Barth", "Kurth", "Dipfele",
                    "Helbach", "Eising", "Wiese", "Deifel"};
    private String[] VornamenM =
            {"Paul", "Peter", "Jürgen", "Stefan", "Dieter", "Sepp", "Karl"};
    private String[] VornamenW =
            {"Paula", "Petra", "Jacqueline", "Stefanie", "Doris", "Tanja", "Claudia"};


    public List<Person> createPersonen(int count) {
        ArrayList<Person> pliste = new ArrayList<>();
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            Person p = new Person();
            p.setId(i + 1);
            p.setNachname(Nachnamen[rnd.nextInt(Nachnamen.length)]);
            p.setGeschlecht(rnd.nextInt(2) == 0 ? Geschlecht.Männlich : Geschlecht.Weiblich);
            if (p.getGeschlecht() == Geschlecht.Männlich) {
                p.setVorname(VornamenM[rnd.nextInt(VornamenM.length)]);
            } else {
                p.setVorname(VornamenW[rnd.nextInt(VornamenW.length)]);
            }
            if(rnd.nextInt(0,2000) == 1000) {
                p.setGeschlecht(Geschlecht.Divers);
            }
            p.setGehalt(2500+ rnd.nextInt(0,7500));
            p.setGeburt(LocalDate.ofYearDay(rnd.nextInt(1930,2010), rnd.nextInt(1,355)));
            pliste.add(p);
        }
        return pliste;
    }


}
