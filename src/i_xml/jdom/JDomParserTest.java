package i_xml.jdom;

import global.Workable;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

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

    }
}
