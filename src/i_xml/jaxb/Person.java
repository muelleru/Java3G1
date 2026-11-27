package i_xml.jaxb;

import java.io.Serializable;
import java.time.LocalDate;

// public enum Geschlecht { Weiblich, Männlich, Divers }

public class Person  {

    private int id;
    private String vorname;
    private String nachname;
    private LocalDate geburt;
    private double gehalt; // Nicht serialisieren
    private Geschlecht geschlecht;

    public Person() {
        this(1, "Max", "Mustermann", LocalDate.ofYearDay(2000, 100), 2000, Geschlecht.Männlich);
    }

    public Person(int id, String vorname, String nachname, LocalDate geburt, double gehalt, Geschlecht geschlecht) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburt = geburt;
        this.gehalt = gehalt;
        this.geschlecht = geschlecht;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getVorname() {
        return vorname;
    }

    public Person setVorname(String vorname) {
        this.vorname = vorname;
        return this;
    }

    public String getNachname() {
        return nachname;
    }

    public Person setNachname(String nachname) {
        this.nachname = nachname;
        return this;
    }

    public LocalDate getGeburt() {
        return geburt;
    }

    public Person setGeburt(LocalDate geburt) {
        this.geburt = geburt;
        return this;
    }

    public double getGehalt() {
        return gehalt;
    }

    public Person setGehalt(double gehalt) {
        this.gehalt = gehalt;
        return this;
    }

    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public Person setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
        return this;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;

        return getId() == person.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(id);
        sb.append(", vorname='").append(vorname).append('\'');
        sb.append(", nachname='").append(nachname).append('\'');
        sb.append(", geburt=").append(geburt);
        sb.append(", gehalt=").append(gehalt);
        sb.append(", geschlecht=").append(geschlecht);
        sb.append('}');
        return sb.toString();
    }
}

