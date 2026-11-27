package h_serialize;

import data.Person;
import data.PersonenGenerator;
import global.Workable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializeTest extends Workable {


    @Override
    public void doWork() {
     //  testSerialize();
        testDeserialize();
    }
// Person{id=1, vorname='Heike', nachname='Schmid', geburt=1975-08-04, gehalt=6573.0, geschlecht=Weiblich}
// Person{id=1, vorname='Heike', nachname='Schmid', geburt=1975-08-04, gehalt=6573.0, geschlecht=Weiblich}
    void testDeserialize() {
        String fn = "person.bin";
        Path path = Path.of(fn);
        Person p = null;
        if (Files.exists(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn))) {
                Object obj =  ois.readObject();
                if(obj instanceof Person ) {
                    p = (Person)obj;
                    System.out.println(p);
                }
                System.out.println("DESERIALIZE OK");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(fn + " existiert nicht!");
        }
    }

    void testSerialize() {
        Person p = PersonenGenerator.getInstance().createPersonen(1).getFirst();
        //ObjectInputStream ois;
        //ObjectOutputStream oos;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"))) {
            System.out.println(p);
            oos.writeObject(p);
            System.out.println("SERIALISIERUNG OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
