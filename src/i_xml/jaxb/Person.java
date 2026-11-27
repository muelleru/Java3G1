package i_xml.jaxb;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

// public enum Geschlecht { Weiblich, Männlich, Divers }

@XmlRootElement(name = "Mitarbeiter")
public class Person  {
    @XmlAttribute(name="Id")
    private int id;
    @XmlAttribute(name="Vorname")
    private String vorname;
    @XmlAttribute(name="Nachname")
    private String nachname;
    //@XmlTransient
     @XmlJavaTypeAdapter(LocalDataAdapter.class)
     @XmlAttribute(name="Geburt")
    private LocalDate geburt;

    @XmlAttribute(name="Gehalt")
    private double gehalt; // Nicht serialisieren
    @XmlAttribute(name="Geschlecht")
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

    @XmlTransient
    public int getId() {
        return id;
    }
    public Person setId(int id) {
        this.id = id;
        return this;
    }
    @XmlTransient
    public String getVorname() {
        return vorname;
    }
    public Person setVorname(String vorname) {
        this.vorname = vorname;
        return this;
    }
    @XmlTransient
    public String getNachname() {
        return nachname;
    }

    public Person setNachname(String nachname) {
        this.nachname = nachname;
        return this;
    }
    @XmlTransient
    public LocalDate getGeburt() {
        return geburt;
    }

    public Person setGeburt(LocalDate geburt) {
        this.geburt = geburt;
        return this;
    }
    @XmlTransient
    public double getGehalt() {
        return gehalt;
    }

    public Person setGehalt(double gehalt) {
        this.gehalt = gehalt;
        return this;
    }
    @XmlTransient
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

