package a_verschiedenes.records;

import global.Workable;

public class Records extends Workable {

    record Person(String vorname, String nachname) {
        public String getName() {
            return vorname + " "  + nachname;
        }
    }

    @Override
    public void doWork() {
        Punkt p1 = new Punkt(10,20); // Immutable: x und y sind final
        System.out.printf("%d %d\n",p1.x(),p1.y());
        Person person = new Person("Max","Mustermann");
        System.out.println(person.nachname());
        System.out.println(person.vorname());
        System.out.println(person.nachname); // wg. lokaler Definition
        //GEHT NICHT: person.nachname = "Mechthild";
        System.out.println(person.getName());

    }
}
