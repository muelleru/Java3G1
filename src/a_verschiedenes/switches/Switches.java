package a_verschiedenes.switches;

import global.Workable;

import java.util.Optional;

public class Switches extends Workable {
    @Override
    public void doWork() {
        test4();
    }

    public void test4() {

        Object obj = Integer.valueOf(99); // Objekte -128 ... 127 sind vordefiniert
        // Object obj2 = new Integer(99); // veraltet!!!!

        switch(obj) {
            case Integer i when i < 100 -> System.out.println("Kleiner Integer");
            case Integer i -> System.out.println("Integer mit Wert " + i);
            case String s -> System.out.println("Ein String");
            case Optional o -> {
                System.out.println("Opt: " + o.get());
            }
            case null -> System.out.println("GAR NICHTS");
            default -> System.out.println("ERRROR");
        }


    }

    public void test3() {
        int n = 1;
        String result2 = n==1 ? "OK": "NICHT OK";

        String result = switch(n) {
            case 1 -> "EINS";
            case 2 -> "ZWEI";
            case 3, 4 -> {
                yield "DREI oder VIER";
            }
            default -> "SONST";
        };
        System.out.println(result);
    }

    public void test2() {
        int n = 1;
        switch(n) {
            case 1 -> System.out.println("EINS");
            case 2 -> System.out.println("ZWEI");
            case 3, 4 -> {
                System.out.println("DREI");
                System.out.println("VIER");
            }
            default -> System.out.println("SONST");
        }
    }
    public void test1() {
        int n = 4;
        switch(n) {
            case 1:
                System.out.println("EINS");
                break;
            case 2:
                break;
            case 3: case 4:
                break;
            default:
                break;
        }
    }
}
