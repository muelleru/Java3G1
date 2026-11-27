package global;

import a_verschiedenes.collectioninit.CollectionInit;
import a_verschiedenes.defaults.Defaults;
import a_verschiedenes.instanceoftest.InstanceOfTest;
import a_verschiedenes.nonnull.Nonnull;
import a_verschiedenes.optional.OptionalTest;
import a_verschiedenes.switches.Switches;
import a_verschiedenes.typeinference.TypeInference;
import b_topleveltolambda.toplevel.TopLevel;
import c_lambdas.Lambdas;
import d_streams.Streams;
import e_generics.Generics;
import g_reflections.Reflections;
import h_serialize.SerializeTest;
import i_xml.jaxb.JAXBTest;
import i_xml.jdom.JDomParserTest;
import i_xml.sax.SAXParserTest;
import j_rmi.RMIServer;
import uebung.lambdas.UebungLambdas;
import uebung.lambdas.UebungLambdas2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        List<Workable> workableList = new ArrayList<>();
        workableList.add(new Defaults().setActive(false));
        workableList.add(new Nonnull().setActive(false));
        workableList.add(new OptionalTest().setActive(false));
        workableList.add(new CollectionInit().setActive(false));
        workableList.add(new TypeInference().setActive(false));
        workableList.add(new Switches().setActive(false));
        workableList.add(new InstanceOfTest().setActive(false));
        workableList.add(new TopLevel().setActive(false));
        workableList.add(new Lambdas().setActive(false));
        workableList.add(new UebungLambdas().setActive(false));
        workableList.add(new UebungLambdas2().setActive(false));
        workableList.add(new Streams().setActive(false));
        workableList.add(new Generics().setActive(false));
        workableList.add(new Reflections().setActive(false));
        workableList.add(new SerializeTest().setActive(false));
        workableList.add(new SAXParserTest().setActive(false));
        workableList.add(new JDomParserTest().setActive(false));
        workableList.add(new JAXBTest().setActive(false));
        workableList.add(new RMIServer().setActive(true));
        for(Workable workable : workableList) {
            if(workable.isActive()) {
                 workable.doWork();
            }
        }
    }

}
