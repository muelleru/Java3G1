package global;

import a_verschiedenes.defaults.Defaults;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        List<Workable> workableList = new ArrayList<>();
        workableList.add(new Defaults().setActive(true));
        for(Workable workable : workableList) {
            if(workable.isActive()) {
                 workable.doWork();
            }
        }
    }

}
