package a_verschiedenes.collectioninit;

import global.Workable;

import java.util.*;

import static java.util.Map.entry;

public class CollectionInit extends Workable {
    @Override
    public void doWork() {
        List<String> l1 = List.of("Anton","Berta","Cäsar");
        // l1.add("Dora"); // l1 ist immutable!!!!
        Stack<String> stck = new Stack<>( );
        stck.addAll(l1);

        // Set.of
        HashSet<Integer> s1 = new HashSet<>(List.of(1,2,3,2,1,4,5,4));
        s1.forEach(System.out::println);
        System.out.println("*******************************");
        HashSet<Integer> s2 = new HashSet<>(Set.of(1,2,3,4,5));
        for (Integer i : s2) {
            System.out.println(i);
        }

        //
        Integer[] arr = {1,2,3,4,5,6,7,8};
        List<Integer> l3 = Arrays.asList(1,2,3,4,5,6,7,8);

        // Key-Value-Pair => Entry<K,V>
        Map<String, Integer> m = new HashMap<>( Map.of(
                "Eins",1,
                "Zwei",2,
                "Drei",3));
        System.out.println(m.get("Eins"));

        Map<Integer,String> m2 = new HashMap<>(Map.ofEntries(
            entry(1,"EINS"),
            entry(2,"ZWEI"),
            entry(3,"DREI")
        ));
        System.out.println(m2.get(2));
    }
}
