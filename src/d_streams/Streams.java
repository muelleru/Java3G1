package d_streams;

import data.Geschlecht;
import data.Person;
import data.PersonenGenerator;
import global.Workable;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams extends Workable {

    public void test1() {
        List<Person> pliste = PersonenGenerator.getInstance().createPersonen(100);
        // pliste.forEach(System.out::println);

        var stream1 = pliste.stream();
        Stream<Person> stream2 = pliste.stream();
        // WHERE
        var stream3 = stream2.filter(p -> p.getGeschlecht() == Geschlecht.Divers);
        stream3.forEach(System.out::println);

        var frauenU9000 = pliste.stream().
                filter(p -> p.getGehalt() > 9000).
                filter(p -> p.getGeschlecht() == Geschlecht.Weiblich);


        pliste.add(new Person(90000, "Traude", "Chef", LocalDate.ofYearDay(2020, 100), 12000, Geschlecht.Weiblich));


        // System.out.println(frauenU9000.count());
        //frauenU9000.forEach(System.out::println);
        List<Person> listeFrauen9000 = frauenU9000.toList();
    }

    public void test2() {
        // filter, forEach

        List<Person> pliste = PersonenGenerator.getInstance().createPersonen(1000);
        // map => verändert, die Resultats-Objekte
        // Vergleichbar SQL -> Select
        List<String> namensliste = pliste.stream().map(p -> p.getNachname()).toList();
        System.out.println(String.join(", ", namensliste));


        // Summe
        Optional<Double> gehalt = pliste.stream().map(p -> p.getGehalt()).
                reduce((p1, p2) -> {
                    if (p2 > p1)
                        return p2;
                    else
                        return p1;
                });
       // pliste.clear();
        Optional<Person> person = pliste.stream().max( (p1, p2) -> Double.compare(p1.getGehalt(),p2.getGehalt()) );
        if(person.isPresent()) {
            System.out.println(person.get());
        }
        if (gehalt.isPresent()) {
            System.out.println("GEHALT: " + gehalt.get());
        }

        double summe = 0.0;
        for (var p : pliste) {
            summe += p.getGehalt();
        }
        System.out.println("PRÜFSUMME: " + summe);

        // Select vorname, nachname
        // FROM pliste;
        // where id < 10
        var personen = pliste.stream().filter(p-> p.getId() < 10).map( p-> new Object() {
           String vn = p.getVorname();
           String nn = p.getNachname();
        }).toList();

        System.out.println(personen.getFirst().vn + " " + personen.getFirst().nn);

        // List.of()
        // toList liefer immutable List
        var personen2 = new ArrayList<>(pliste.stream().filter(p-> p.getId() < 10).toList());
        personen2.add(new Person());
        System.out.println(personen2);
    }

    public void test3() {

        List<Person> pliste = PersonenGenerator.getInstance().createPersonen(100);
        boolean b1 = pliste.stream().allMatch( p-> p.getGehalt() > 2601);
        boolean b2 = pliste.stream().anyMatch( p-> p.getGeburt().getYear() == 1980);
        System.out.println("Alle haben ein Gehalt > 2500: " + b1);
        System.out.println("Mindestens eine Person ist 1980 geboren: " + b2);

        long cnt = pliste.stream().filter( p-> p.getGeburt().getYear() == 1980).count();
        System.out.println("#1980: " + cnt);

        Optional<Person> firstOrEmpty = pliste.stream().filter( p-> p.getGeburt().getYear() == 1980).findFirst();
        if(firstOrEmpty.isPresent())
        {
            System.out.println(firstOrEmpty.get());
        } else {
            System.out.println("KEINEN GEFUNDEN");
        }

    }

    public void test4() {
        // Group
        List<Person> pliste = PersonenGenerator.getInstance().createPersonen(100);
        Map<String,List<Person>> countNamen = pliste.stream().collect(Collectors.groupingBy(p->p.getNachname()));
        for(var kvp : countNamen.entrySet()) {
            System.out.println(kvp.getKey() + " -> " + kvp.getValue().size());
        }
        for(var kvp : countNamen.entrySet()) {
            System.out.println(kvp.getKey() + " -> " + kvp.getValue());
        }
    }

    public void test5() {
        ArrayList<String> liste = new ArrayList<>(List.of("Anton", "Berta"));
        var stream1 = liste.stream().filter( x->x.length() == 5);  // .toList(); toList führt aus!!!!
        liste.add("ABCDE");
        liste.add("12345");
        stream1.forEach(System.out::println); // Verzögerte Ausführung
    }

    @Override
    public void doWork() {
        test5();
    }
}
