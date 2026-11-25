package a_verschiedenes.optional;

import global.Workable;

import java.util.Optional;

public class OptionalTest extends Workable {
    @Override
    public void doWork() {
        int zahl = 10; // hat keinen Nichts-Wert
        Integer zahl2 = 10; // Wrapper-Klasse umhüllt den nativen Typ
        zahl2 = null;       // Auto-Boxing und Nichts-Werte

        Optional<Integer> zahl3 = Optional.empty(); // Leer-Werte

        // zahl3 = 30; // FEHLER Kein Autoboxing
        zahl3 = Optional.of(30);
        if(zahl3.isEmpty()) {} // true  wenn zahl3 == empty
        if(zahl3.isPresent()) {}  // wenn nicht empty

        int zahl4 = zahl3.get(); // Integer wieder auspacken

    }
}
