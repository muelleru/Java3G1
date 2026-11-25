package a_verschiedenes.defaults;

public interface Tier  {
    String getName();
    String getRasse();
    void schreien();

    default void info() {
        System.out.println("Info: " + getName() + ", " + getRasse());
    }

}
