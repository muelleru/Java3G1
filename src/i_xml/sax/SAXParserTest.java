package i_xml.sax;

import global.Workable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserTest extends Workable {
    @Override
    public void doWork() {
     try {
         SAXParserFactory factory = SAXParserFactory.newInstance();
         factory.setFeature(
                 "http://apache.org/xml/features/disallow-doctype-decl",
                 true);

        SAXParser parser = factory.newSAXParser();
        File file = new File("personen.xml");
        parser.parse(file, new PersonenHandler());
     } catch (Exception e) {
         e.printStackTrace();
     }
    }
}

// DOM-Parser
// Document Object Model
