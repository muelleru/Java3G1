package g_reflections;

public class Mtarbeiter {

    @CSVName(name = "Nr")
    private int id;
    @CSVName(name = "Name")
    private String name;
    @CSVName(name = "Farbe")
    private String farbe;
    @CSVIgnore
    private String spitzname;

}
