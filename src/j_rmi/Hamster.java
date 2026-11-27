package j_rmi;

import java.io.Serializable;

public class Hamster implements Serializable {
    // evtl id; ...
    private int id;
    private String name;
    private String farbe;

    public Hamster( ) {
        this(-1,"Winfried","Grün");
    }

    public Hamster(int id, String name, String farbe) {
        this.id = id;
        this.name = name;
        this.farbe = farbe;
    }

    public int getId() {
        return id;
    }

    public Hamster setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hamster setName(String name) {
        this.name = name;
        return this;
    }

    public String getFarbe() {
        return farbe;
    }

    public Hamster setFarbe(String farbe) {
        this.farbe = farbe;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Hamster{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", farbe='").append(farbe).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
