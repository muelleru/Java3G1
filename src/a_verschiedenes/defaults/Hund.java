package a_verschiedenes.defaults;

public class Hund implements Tier {
    private String name ="Bello";
    private String rasse = "Dackel";
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getRasse() {
        return rasse;
    }
    @Override
    public void schreien() {
        System.out.println("WUFF WUFF");
    }
}
