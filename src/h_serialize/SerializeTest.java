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
        testSerialize();
    }

    void testDeserialize() {
        String fn = "person.bin";
        Path path = Path.of(fn);
        if (Files.exists(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fn))) {



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
