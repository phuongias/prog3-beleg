package eventPattern.cakeHandler;

import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.cakeListener.CakeAddEventListener;


import java.util.ArrayList;
import java.util.List;

public class CakeAddEventHandler {
    private List<CakeAddEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(CakeAddEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(CakeAddEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(CakeAddEvent event) {
        for (CakeAddEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }


}
