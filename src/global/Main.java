package global;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        List<Workable> workableList = new ArrayList<>();
        // workableList.add();
        for(Workable workable : workableList) {
            if(workable.isActive()) {
                 workable.doWork();
            }
        }
    }

}
