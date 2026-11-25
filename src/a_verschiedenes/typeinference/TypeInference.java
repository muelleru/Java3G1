package a_verschiedenes.typeinference;

import global.Workable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TypeInference extends Workable {
    @Override
    public void doWork() {

        var x = 20;
        x = 30;
        //GEHT NICHT x = "sdfsdf";
        int x2= 21;
        // Runnable ist ein Interface (functional)
        var r = new Runnable() {
            @Override
            public void run() {

            }
        }; // Objekt einer anonymen Klasse
        // new Thread(r).start();
        // r.run();

//        r = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }; // Erzeugt noch eine anonyme Klasse

        List<String> l1 = new ArrayList<>();
        l1.forEach(p-> System.out.println(p));

        //var r2 = p-> System.out.println(p);
        Consumer<String> r2 = p-> System.out.println(p);
        Consumer<String> r3 = p-> System.out.println(p);



    }
}
