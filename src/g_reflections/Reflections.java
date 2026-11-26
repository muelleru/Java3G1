package g_reflections;

import global.Workable;

public class Reflections extends Workable {
    @Override
    public void doWork() {
        t1();
    }

    private void t1() {
        Mitarbeiter m = new Mitarbeiter(42,"Horst", "Rot","Bummm");
        String csv = CSVSerializer.serialize(m);
        String header = CSVSerializer.createHeader(Mitarbeiter.class);
        System.out.println(csv);
        System.out.println(header);
        Mitarbeiter n =(Mitarbeiter)CSVSerializer.deserialize(header,csv,Mitarbeiter.class);
        System.out.println(n);
    }
}
