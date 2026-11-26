package g_reflections;

import global.Workable;

public class Reflections extends Workable {
    @Override
    public void doWork() {
        t1();
    }

    private void t1() {
        Mitarbeiter m = new Mitarbeiter();
        String csv = CSVSerializer.serialize(m);
        System.out.println(CSVSerializer.createHeader(m));
        System.out.println(CSVSerializer.serialize(m));
    }
}
