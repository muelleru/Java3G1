package i_xml.jaxb;

import global.Workable;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JAXBTest extends Workable {
    @Override

    public void doWork() {
        test1();

    }
    private void test2() {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Person p  = PersonenGenerator.getInstance().createPersonen(1).getFirst();
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("jaxbpersonen.xml");
            marshaller.marshal(p,file);
            System.out.println("OK");
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    private void test1() {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Person p  = PersonenGenerator.getInstance().createPersonen(1).getFirst();
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("jaxbpersonen.xml");
            marshaller.marshal(p,file);
            System.out.println("OK");
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

}
