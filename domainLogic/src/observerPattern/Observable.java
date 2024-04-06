package observerPattern;

public interface Observable {
    boolean register(Observer observer);
    boolean unregister(Observer observer);
    void notifyObserver();

}

