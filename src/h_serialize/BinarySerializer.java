package h_serialize;

import java.io.*;

public class BinarySerializer <T> {

    private String filename;

    public BinarySerializer(String fn) {
        filename = fn;
    }

    public void serialize(T object) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
        }
    }

    public T deserialize() throws IOException, ClassNotFoundException {
            try(ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename)
            )) {
                return (T)ois.readObject();
            }
    }


}
