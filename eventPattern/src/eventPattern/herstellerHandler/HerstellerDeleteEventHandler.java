package eventPattern.herstellerHandler;

import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.herstellerEvents.HerstellerDeleteEvent;
import eventPattern.herstellerListener.HerstellerDeleteEventListener;

import java.util.ArrayList;
import java.util.List;

public class HerstellerDeleteEventHandler {
    private List<HerstellerDeleteEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(HerstellerDeleteEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(HerstellerDeleteEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(HerstellerDeleteEvent event) {
        for (HerstellerDeleteEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }
}
