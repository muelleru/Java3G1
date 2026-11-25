package c_lambdas;

import global.Workable;

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

    }
    @Override
    public void doWork() {
        test1();
    }
}
