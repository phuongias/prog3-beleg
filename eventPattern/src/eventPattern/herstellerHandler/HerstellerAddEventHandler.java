package eventPattern.herstellerHandler;

import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.herstellerEvents.HerstellerAddEvent;
import eventPattern.herstellerListener.HerstellerAddEventListener;

import java.util.ArrayList;
import java.util.List;

public class HerstellerAddEventHandler {

    private List<HerstellerAddEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(HerstellerAddEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(HerstellerAddEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(HerstellerAddEvent event) {
        for (HerstellerAddEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }
}
