package d_streams;

import data.PersonenGenerator;
import global.Workable;

public class Streams extends Workable {

    public void test1() {
        PersonenGenerator.getInstance()
    }
    @Override
    public void doWork() {
        test1();
    }
}
