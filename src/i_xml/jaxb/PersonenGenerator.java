package i_xml.jaxb;

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

    private String[] Nachnamen = {
            "Müller", "Maier", "Schmid", "Huber", "Alber", "Barth", "Kurth", "Dipfele", "Helbach", "Eising",
            "Wiese", "Deifel", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Schulz",
            "Hoffmann", "Schäfer", "Koch", "Bauer", "Richter", "Klein", "Wolf", "Schröder", "Neumann", "Schwarz",
            "Zimmermann", "Braun", "Krüger", "Hofmann", "Hartmann", "Lange", "Schmitt", "Werner", "Schmitz", "Krause",
            "Meier", "Lehmann", "Schulze", "Köhler", "Herrmann", "König", "Walter", "Mayer", "Fuchs", "Kaiser",
            "Lang", "Weiß", "Peters", "Scholz", "Jung", "Möller", "Hahn", "Keller", "Vogel", "Schubert",
            "Roth", "Frank", "Friedrich", "Beck", "Günther", "Berger", "Winkler", "Lorenz", "Baumann", "Albrecht",
            "Ludwig", "Simon", "Böhm", "Winter", "Krämer", "Schumacher", "Vogt", "Jäger", "Stein", "Otto",
            "Sommer", "Groß", "Seidel", "Heinrich", "Brandt", "Haas", "Schreiber", "Graf", "Dietrich", "Ziegler",
            "Kuhn", "Kühn", "Pohl", "Engel", "Horn", "Busch", "Bergmann", "Thomas", "Sauer", "Arnold"
    };

    private String[] VornamenM = {
            "Paul", "Peter", "Jürgen", "Stefan", "Dieter", "Sepp", "Karl", "Alexander", "Andreas", "Anton",
            "Armin", "Axel", "Benjamin", "Bernd", "Bernhard", "Björn", "Boris", "Carsten", "Christian", "Christoph",
            "Daniel", "David", "Dennis", "Dirk", "Dominik", "Eberhard", "Edgar", "Eduard", "Elias", "Emil",
            "Erhard", "Erich", "Erik", "Ernst", "Fabian", "Felix", "Florian", "Frank", "Franz", "Friedrich",
            "Georg", "Gerhard", "Günter", "Hans", "Harald", "Heiko", "Heinrich", "Heinz", "Helmut", "Herbert",
            "Hermann", "Holger", "Horst", "Hubert", "Jan", "Jens", "Joachim", "Johannes", "Jonas", "Jonathan",
            "Josef", "Julian", "Kai", "Kevin", "Klaus", "Konrad", "Kurt", "Lars", "Leon", "Leonard",
            "Lothar", "Luca", "Ludwig", "Lukas", "Manfred", "Marcel", "Marco", "Mario", "Markus", "Martin",
            "Matthias", "Max", "Maximilian", "Michael", "Moritz", "Niklas", "Nils", "Norbert", "Oliver", "Otto",
            "Patrick", "Philipp", "Rainer", "Ralf", "Reinhard", "Robert", "Sebastian", "Thomas", "Ulrich", "Wolfgang"
    };

    private String[] VornamenW = {
            "Paula", "Petra", "Jacqueline", "Stefanie", "Doris", "Tanja", "Claudia", "Alexandra", "Alina", "Amelie",
            "Andrea", "Angelika", "Anja", "Anna", "Annika", "Antonia", "Astrid", "Barbara", "Beate", "Birgit",
            "Brigitte", "Carina", "Carla", "Carolin", "Charlotte", "Christa", "Christiane", "Christina", "Christine", "Clara",
            "Cornelia", "Dagmar", "Daniela", "Diana", "Edith", "Elena", "Elisabeth", "Elke", "Ella", "Emilia",
            "Emma", "Erika", "Eva", "Evelyn", "Franziska", "Frieda", "Gabriele", "Gerda", "Gisela", "Greta",
            "Hanna", "Heidi", "Heike", "Helena", "Helga", "Hildegard", "Ida", "Ilse", "Inge", "Ingrid",
            "Irene", "Isabel", "Jana", "Janina", "Jasmin", "Jennifer", "Jessica", "Johanna", "Julia", "Karin",
            "Katharina", "Katja", "Kerstin", "Lara", "Laura", "Lea", "Lena", "Leonie", "Lilli", "Linda",
            "Lisa", "Luisa", "Lydia", "Maja", "Manuela", "Maria", "Marie", "Marion", "Martina", "Melanie",
            "Mia", "Monika", "Nadine", "Nicole", "Sabine", "Sandra", "Sarah", "Simone", "Susanne", "Ursula"
    };

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
