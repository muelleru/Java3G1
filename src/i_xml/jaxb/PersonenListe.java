package i_xml.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XmlRootElement(name="Personen")
public class PersonenListe implements Iterable<Person> {

    @XmlElement(name = "Person")
    private List<Person> pliste;

    public PersonenListe() {
        pliste = new ArrayList<>();
    }

    public PersonenListe(int count) {
        pliste = PersonenGenerator.getInstance().createPersonen(count);
    }

    @Override
    public Iterator<Person> iterator() {
        return pliste.iterator();
    }

}
