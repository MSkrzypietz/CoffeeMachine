package observers;

import java.util.ArrayList;

public class CoffeeFlourLevelObserver {

    private ArrayList<ICoffeeFlourLevelListener> listeners = new ArrayList<>();

    public CoffeeFlourLevelObserver() {}

    public void coffeeFlourContainerIsFull() {
        for (ICoffeeFlourLevelListener listener : listeners)
            listener.coffeeFlourContainerIsFull();
    }

    public void addListener(ICoffeeFlourLevelListener listener) {
        this.listeners.add(listener);
    }

    public void remoteListener(ICoffeeFlourLevelListener listener) {
        this.listeners.remove(listener);
    }

}
