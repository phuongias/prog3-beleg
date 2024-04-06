package eventPattern.herstellerHandler;

import eventPattern.herstellerEvents.HerstellerDeleteEvent;
import eventPattern.herstellerEvents.HerstellerReadEvent;
import eventPattern.herstellerListener.HerstellerDeleteEventListener;
import eventPattern.herstellerListener.HerstellerReadEventListener;

import java.util.ArrayList;
import java.util.List;

public class HerstellerReadEventHandler {
    private List<HerstellerReadEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(HerstellerReadEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(HerstellerReadEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(HerstellerReadEvent event) {
        for (HerstellerReadEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }
}
