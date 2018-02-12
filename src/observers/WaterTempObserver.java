package observers;

import java.util.ArrayList;

public class WaterTempObserver {

    private ArrayList<IWaterTempListener> listeners = new ArrayList<>();

    public WaterTempObserver() {}

    public void waterIsHeated() {
        for (IWaterTempListener listener : listeners)
            listener.waterIsHeated();
    }

    public void addListener(IWaterTempListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(IWaterTempListener listener) {
        this.listeners.remove(listener);
    }

}
