package uebung.lambdas;

import global.Workable;

import java.util.ArrayList;
import java.util.function.Consumer;

public class UebungLambdas2 extends Workable {
    class Aufgabe1 {
        /*
        Legen Sie ein neues Consolen-Projekt an und definieren Sie ein
        Delegate, so dass Sie Funktionen der Art
        f(int,int)->int
        aufrufen können. Definieren Sie Funktionen zur Addition und
        Multiplikation zweier Integer-Zahlen, deren Signatur zum Delegate
        passt. Rufen Sie beide Funktionen über ein Delegate mit Testwerten
        auf.
         */
        @FunctionalInterface
        interface IntegerOperation {
            int f(int a, int b);
        }

        public static int add(int x, int y) {
            return x + y;
        }

        public void run() {
            IntegerOperation op1 = Aufgabe1::add;
            IntegerOperation add = (p1, p2) -> {
                return p1 + p2;
            };
            IntegerOperation add2 = (p1, p2) -> p1 + p2; // return fällt weg
            IntegerOperation sub = (x, y) -> x - y;
            IntegerOperation sub2 = new IntegerOperation() {
                @Override
                public int f(int a, int b) {
                    return a - b;
                }
            };
            Consumer<Object> myprint = System.out::println;
            myprint.accept("TEST");

            Consumer<String> myprint2 = (x) -> System.out.println("*** " + x + " ***");
            myprint2.accept("TEST");

            ArrayList<String> liste = new ArrayList<>();
            ArrayList<String> l2 = new ArrayList<>();

            liste.forEach(myprint2);
            liste.forEach(System.out::println);

            liste.forEach((x) -> System.out.println(x.toUpperCase()));
            liste.forEach((x) -> {
                if (x.startsWith("A")) {
                    l2.add(x);
                }
            });
        }

    }

    class Aufgabe2 {
        /*
        Legen Sie ein neues Consolen-Projekt an, definieren Sie ein Feld von
        Delegates, initialisieren Sie es mit den Funktionen sin, cos, tan und
        geben Sie eine Wertetabelle von 0 .. 2*Pi in der Form
        x sin(x) cos(x) tan(x)
        in 0.1 Schritten aus (rufen Sie dazu die Funktionen im Feld auf)
        */
        interface DoubleFunction {
            double f(double a);
        }

        public void run() {
            // Array von Funktionen
            DoubleFunction[] funcarray = {x -> x, Math::sin, Math::cos, Math::tan};
            // Liste von Funktionen
            ArrayList<DoubleFunction> funclist = new ArrayList<>();
            funclist.add(x -> x);
            funclist.add(x -> Math.sin(x));
            funclist.add(Math::cos);
            funclist.add(Math::tan);

            //for(int i = 0; i <= 20*Math.PI; i++) {
            double x = 0.0;
            while (x <= 2 * Math.PI) {
                for (var func : funclist) {
                    System.out.printf("| %f ", func.f(x));
                }
                System.out.println();
                x += 0.1;
            }
        }

    }


    @Override
    public void doWork() {
        new Aufgabe2().run();
    }
}
