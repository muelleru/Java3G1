package global;

public abstract class Workable {

    private boolean isActive;
    abstract void doWork();

    public Workable() {
        setActive(true);
    }

    public boolean isActive() {
        return isActive;
    }
    public Workable setActive(boolean active) {
        isActive = active;
        return this;
    }
}
