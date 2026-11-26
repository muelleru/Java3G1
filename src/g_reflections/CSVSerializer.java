package g_reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVSerializer {

    //    public static String serialize(Object o) {
//
//    }
    //   public static <T> String createHeader(T o) {
    public static String createHeader(Class meta) {
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
        return String.join(";", felder);
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
        return String.join(";", felder);
    }

    public static Object deserialize(String header, String csv, Class meta) {

        // "1;Hans;Maier"
        String[] headerFelder = header.split(";");
        String[] datenFelder = csv.split(";");
        Object obj = null;
        if (headerFelder.length != datenFelder.length) {
            throw new RuntimeException("DAS GEHT SO NICHT");
        }
        Map<String, String> felder = new HashMap<>();
        for (int i = 0; i < headerFelder.length; i++) {
            felder.put(headerFelder[i], datenFelder[i]);
        }
          /* Map:
            { "Nr" : 5,
              "Name" : "Max",
              "Farbe" : "Blau"
            }
           */
        try {
            obj = meta.getDeclaredConstructor().newInstance(); // meta.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Field field : meta.getDeclaredFields()) {
            field.setAccessible(true);
            CSVIgnore csvignore = field.getAnnotation(CSVIgnore.class);
            CSVName csvname = field.getAnnotation(CSVName.class);
            if (csvignore == null) {
                String attrName;
                if (csvname != null) {
                    attrName = csvname.name();
                } else {
                    attrName = field.getName();
                }
                try {
                     if (felder.containsKey(attrName)) {
                        if(field.getType() == int.class || field.getType() == Integer.class) {
                           field.set(obj, Integer.parseInt(felder.get(attrName)));
                        } else if(field.getType() == String.class) {
                            field.set(obj, felder.get(attrName));
                        } else {

                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }
}
