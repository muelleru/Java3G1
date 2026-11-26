package d_streams;

import data.Geschlecht;
import data.Person;
import data.PersonenGenerator;
import global.Workable;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Streams extends Workable {

    public void test1() {
       List<Person> pliste =  PersonenGenerator.getInstance().createPersonen(100);
       // pliste.forEach(System.out::println);

       var stream1 = pliste.stream();
       Stream<Person> stream2 = pliste.stream();
       // WHERE
       var stream3 = stream2.filter( p-> p.getGeschlecht() == Geschlecht.Divers);
       stream3.forEach(System.out::println);

       var frauenU9000 = pliste.stream().
               filter( p-> p.getGehalt() > 9000).
               filter( p->p.getGeschlecht() == Geschlecht.Weiblich);


        pliste.add(new Person(90000,"Traude","Chef", LocalDate.ofYearDay(2020,100), 12000,Geschlecht.Weiblich ));


        // System.out.println(frauenU9000.count());
        //frauenU9000.forEach(System.out::println);
        List<Person> listeFrauen9000 = frauenU9000.toList();
    }



    @Override
    public void doWork() {
        test1();
    }
}
