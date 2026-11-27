package h_serialize;

import data.Person;
import data.PersonenGenerator;
import global.Workable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest extends Workable {


    @Override
    public void doWork() {
        testSerialize();
    }

    void testSerialize() {
        Person p = PersonenGenerator.getInstance().createPersonen(1).getFirst();
        //ObjectInputStream ois;
        //ObjectOutputStream oos;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"))) {
            oos.writeObject(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
