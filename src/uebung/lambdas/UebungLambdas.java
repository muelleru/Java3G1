package uebung.lambdas;

import global.Workable;

import java.util.function.BinaryOperator;
import java.util.function.DoubleFunction;

public class UebungLambdas extends Workable {

    interface Func {
        int asInt(int a, int b);
    }

    void a1() {
        Func add = (p1, p2) -> p1 + p2;
        Func sub = (p1, p2) -> p1 - p2;
        System.out.println(add.asInt(10, 12));
        System.out.println(sub.asInt(10, 12));
    }

    interface Operator {
        double asDouble(double a);
    }

    void a2() {
        Operator[] ops = {x -> x, x -> Math.sin(x), Math::cos, Math::tan};
        System.out.printf("| %10s | %10s | %10s | %10s |\n", "x", "sin", "cos", "tan");
        for (int i = 0; i <= (int) (20 * Math.PI); i++) {
            double x = i / 10.0;
            for (Operator op : ops) {
                System.out.printf("| %10.2f ", op.asDouble(x));
            }
            System.out.println("|");
        }
    }

    interface ThreeIntAdd {
        int calc(int a, int b, int c);
    }

    interface IntervallTester {
        boolean test(int min, int value, int max);
    }

    public void afg3() {
        ThreeIntAdd l1 = (a, b, c) -> a + b + c;
        IntervallTester tester = (a, b, c) -> a <= b && b <= c;
        System.out.println(l1.calc(10, 20, 30));
        System.out.println(tester.test(10, 20, 30));
    }

    public double eval(double x, DoubleFunction<Double> f) {
        return f.apply(x);
    }

    public void afg4() {
        System.out.println(eval(Math.PI, Math::sin));
        System.out.println(eval(2, x -> x * x));
    }


@FunctionalInterface
interface Newton {
        double calc(DoubleFunction<Double> f, DoubleFunction<Double> fs);
}

    public void afg5() {
        double nullstelle =  newton(x->x*x-4*x+4,x-> 2*x-4);
        System.out.println("X = " + Math.round(nullstelle*1000)/1000.0);

        Newton newtonLambda = (f,fs) -> {
            final double delta = 0.0000001;
            // f(x) => x^2 - 4x + 4 = 0
            // f'(x) => 2x - 4;
            double xn = 0;

            // Nullstelle bei x=2
            double d;
            do {
                double merker = xn;
                xn = xn - (f.apply(xn)/fs.apply(xn));
                d = xn-merker;
                System.out.println(xn);
            } while( Math.abs(d) > delta );
            return xn;
        };
        System.out.println("Lambda: X = " + Math.round(newtonLambda.calc(x->x*x-4*x+4,x-> 2*x-4)*1000)/1000.0);
    }
    public double newton(DoubleFunction<Double> f, DoubleFunction<Double> fs) {
        final double delta = 0.0000001;
        // f(x) => x^2 - 4x + 4 = 0
        // f'(x) => 2x - 4;
        double xn = 0;

        // Nullstelle bei x=2
        double d;
        do {
            double merker = xn;
            xn = xn - (f.apply(xn)/fs.apply(xn));
            d = xn-merker;
            System.out.println(xn);
        } while( Math.abs(d) > delta );
        return xn;
    }

    @Override
    public void doWork() {
        //a1();
        //a2();
        afg5();
    }

}
