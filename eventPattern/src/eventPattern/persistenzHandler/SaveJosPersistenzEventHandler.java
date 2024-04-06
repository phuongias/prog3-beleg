package eventPattern.persistenzHandler;

import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.persistentEvent.SaveJosPersistenzEvent;
import eventPattern.persistenzListener.SaveJosPersistenzEventListener;

import java.util.ArrayList;
import java.util.List;

public class SaveJosPersistenzEventHandler {

    private List<SaveJosPersistenzEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(SaveJosPersistenzEventListener listener) {
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

    public void handle(SaveJosPersistenzEvent event) {
        for (SaveJosPersistenzEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }

}
