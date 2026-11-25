package a_verschiedenes.nonnull;

import global.Workable;

import java.util.Locale;
import java.util.Objects;

public class Nonnull extends Workable {

    @Override
    public void doWork() {
        testString("ABC");
        testString(null);
    }

    public void testString(String s) {
        // Vorher testen ob Null
//        if(s != null) {
//            System.out.println(s.toLowerCase());
//        }

//        System.out.println(s != null ? s.toLowerCase():"***");

        // Objects.requireNonNull()
        try {
            System.out.println(Objects.requireNonNull(s));
            System.out.println(s.toLowerCase());
        } catch (Exception e) {
            System.out.println("s ist null - mach was ..." + e.getMessage());
        }

        // Objects.requireNonNullElse()
        String newS = Objects.requireNonNullElse(s,"***");



    }

}
