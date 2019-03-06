package client;

import java.util.HashSet;
import java.util.Set;

public interface Observable {

    Set<Observer> observers = new HashSet<>();

    default boolean addObserver(Observer o) {
        return observers.add(o);
    }

    default boolean deleteObserver(Observer o) {
        return observers.remove(o);
    }

    default void notifyObservers() {
        Observer[] observersCopy = (Observer[]) observers.toArray();
        deleteObservers();

        for (Observer observer : observersCopy) {
            observer.update(this);
        }
    }

    default void deleteObservers() {
        observers.clear();
    }

    default int countObservers() {
        return observers.size();
    }

    String getName();
}
