package i_xml.jdom;

import data.Person;
import global.Workable;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JDomParserTest extends Workable {
    @Override
    public void doWork() {
        test1();
    }

    public void test1() {
        SAXBuilder builder = new SAXBuilder();
        builder.setFeature(
                "http://apache.org/xml/features/disallow-doctype-decl",
                true
        );
        try {
            File file = new File("personen.xml");
            Document document = builder.build(file);
            Element root = document.getRootElement();
            System.out.println("ROOT: " + root.getName());
            List<Person> personList = new ArrayList<>();
            for (Element person : root.getChildren("person")) {
                // System.out.println(person);
                int id = person.getAttribute("id").getIntValue();
                String vn = person.getChild("vorname").getText();
                String nn = person.getChild("nachname").getText();
                personList.add(new Person().setVorname(vn).setNachname(nn).setId(id));
            }
            personList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
