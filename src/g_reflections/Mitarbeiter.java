package g_reflections;

public class Mitarbeiter {

    @CSVName(name = "Nr")
    private int id;
    @CSVName(name = "Name")
    private String name;
    @CSVName(name = "Farbe")
    private String farbe;
    @CSVIgnore
    private String spitzname;
    public Mitarbeiter() {
        this(0,"Markus","Blau","Blauer Klaus");
    }
    public Mitarbeiter(int id, String name, String farbe, String spitzname) {
        this.id = id;
        this.name = name;
        this.farbe = farbe;
        this.spitzname = spitzname;
    }

    public int getId() {
        return id;
    }
    public Mitarbeiter setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Mitarbeiter setName(String name) {
        this.name = name;
        return this;
    }

    public String getFarbe() {
        return farbe;
    }

    public Mitarbeiter setFarbe(String farbe) {
        this.farbe = farbe;
        return this;
    }

    public String getSpitzname() {
        return spitzname;
    }

    public Mitarbeiter setSpitzname(String spitzname) {
        this.spitzname = spitzname;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Mtarbeiter{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", farbe='").append(farbe).append('\'');
        sb.append(", spitzname='").append(spitzname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
