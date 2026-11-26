package e_generics;

// Generische Klasse
// variabler Inhaltstyp T
public class MyArrayList<T> {

    private Object [] elemente;

    public T get(int index) {
        return (T)elemente[index];
    }
    public void add(T elem) {
        // ...
    }
}
