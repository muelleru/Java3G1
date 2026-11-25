package c_lambdas;

import global.Workable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Lambdas extends Workable {

    // Funktionales Interface mit genau einer Methode
    @FunctionalInterface
    interface MyIntOperator {
        int doit(int a, int b);
    }
    interface MyOperator<T> {
        T doit(T a, T b);
    }
    interface MyConsumer<T> {
        void doit(T a);
    }
    interface MyPredicate<T> {
        boolean test(T a);
    }

    interface MyComparable<T> {
        int compareTo(T a, T b);
    }

    public void test2() {
        List<Integer> liste1 = new ArrayList<>(List.of(10,5,8,11,3,4,2,12,1));
        System.out.println(liste1);
        System.out.println("SORTIERE");
        sortiere(liste1, (x,y) -> x-y);
        System.out.println(liste1);
    }
    public <T> void sortiere(List<T> collection, MyComparable<T> compare) {
        for (int i = 0; i < collection.size()-1; i++) {
            for (int j = i+1; j < collection.size() ; j++) {
                if( compare.compareTo(collection.get(i),collection.get(j)) < 0) {
                //tauschen
                    T tmp = collection.get(i);
                    collection.set(i, collection.get(j));
                    collection.set(j, tmp);
                }
            }
        }
    }


    public void test1() {
        MyIntOperator op1 = (x,y) -> x*y;

        MyIntOperator op3 = new MyIntOperator() {
            @Override
            public int doit(int a, int b) {
                return 0;
            }
        };
        // op2 ist ein Zeiger/Referenz auf eine Funktion bzw. ein Funktionsobjekt
        IntBinaryOperator op2 = (x,y) -> x*y;

        System.out.println(op1.doit(10,20)); // 10 * 20
        System.out.println(op2.applyAsInt(10,20)); // 10 *20
        System.out.println(op3.doit(10,20)); // 0

        MyConsumer<String> c1 = (x) -> System.out.println("** " +  x + " **");
        c1.doit("TEST"); // macht ein println("** " ...

        c1 = System.out::println;

        c1.doit("TEST"); // macht ein println
    }



    @Override
    public void doWork() {
        test2();
    }
}
