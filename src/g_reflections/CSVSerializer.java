package g_reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CSVSerializer {

    //    public static String serialize(Object o) {
//
//    }
    public static <T> String createHeader(T o) {
        Class meta = o.getClass();
        List<String> felder = new ArrayList<>();
        for (Field field : meta.getDeclaredFields()) {
            field.setAccessible(true);
            CSVIgnore csvignore = field.getAnnotation(CSVIgnore.class);
            CSVName csvname = field.getAnnotation(CSVName.class);
            if (csvignore == null) {
                // CSVIgnore ist nicht vorhanden
                if (csvname != null) {
                    //Csvname ist vorhanden
                    felder.add(csvname.name());
                } else {
                    //Csvname ist nicht vorhanden
                    felder.add(field.getName());
                }
            }
        }
        return String.join(";",felder);
    }


    public static <T> String serialize(T o) {
        Class meta = o.getClass();
        List<String> felder = new ArrayList<>();
        for (Field field : meta.getDeclaredFields()) {
            field.setAccessible(true);
            CSVIgnore csvignore = field.getAnnotation(CSVIgnore.class);
            CSVName csvname = field.getAnnotation(CSVName.class);
            if (csvignore == null) {
                // CSVIgnore ist nicht vorhanden
                try {
                    felder.add(field.get(o).toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return String.join(";",felder);
    }
}
