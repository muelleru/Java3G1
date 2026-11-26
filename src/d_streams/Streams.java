package d_streams;

import data.Person;
import data.PersonenGenerator;
import global.Workable;

import java.util.List;

public class Streams extends Workable {

    public void test1() {
       List<Person> pliste =  PersonenGenerator.getInstance().createPersonen(100);
       pliste.forEach(System.out::println);
    }



    @Override
    public void doWork() {
        test1();
    }
}
