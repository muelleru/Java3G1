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
        workableList.add(new Lambdas().setActive(true));
        for(Workable workable : workableList) {
            if(workable.isActive()) {
                 workable.doWork();
            }
        }
    }

}
