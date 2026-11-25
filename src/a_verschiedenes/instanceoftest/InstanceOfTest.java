package a_verschiedenes.instanceoftest;

import global.Workable;

public class InstanceOfTest extends Workable {
    static class Person {
        public String getName() {
            return "Max";
        }
    }

    @Override
    public void doWork() {

        Object p = new Person();
        if (p instanceof Person) {
            Person tmp = (Person) p; // Noch ein Zeiger auf die Person, aber vom Typ Person
            // System.out.println( p.getName() );
            System.out.println(tmp.getName());
            System.out.println(((Person) p).getName());
        }

        // Kurzform
        // Prüfung mit implizitem CASTING
        if(p instanceof Person tmp2) {
            System.out.println(tmp2.getName());
        }

    }
}
