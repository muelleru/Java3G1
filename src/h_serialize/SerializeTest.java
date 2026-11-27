package h_serialize;

import data.Person;
import data.PersonenGenerator;
import global.Workable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SerializeTest extends Workable {


    @Override
    public void doWork() {
        //  testSerialize();
        //   testDeserialize();
        testBinarySerializer();
    }

    void testBinarySerializer() {
        ArrayList<Person> pliste = new ArrayList<>(PersonenGenerator.getInstance().createPersonen(1000));
        ArrayList<Person> geladeneliste;
        BinarySerializer<ArrayList<Person>> serializer = new BinarySerializer<>("personenliste.bin");
        System.out.println("SPEICHERN");
        try {
            serializer.serialize(pliste);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("LADEN");
        try {
            geladeneliste = serializer.deserialize();
            geladeneliste.stream().limit(10).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Person{id=1, vorname='Heike', nachname='Schmid', geburt=1975-08-04, gehalt=6573.0, geschlecht=Weiblich}
// Person{id=1, vorname='Heike', nachname='Schmid', geburt=1975-08-04, gehalt=6573.0, geschlecht=Weiblich}
    void testDeserialize() {
        String fn = "person.bin";
        Path path = Path.of(fn);
        Person p = null;
        if (Files.exists(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn))) {
                Object obj = ois.readObject();
                if (obj instanceof Person) {
                    p = (Person) obj;
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
