package eventPattern.persistenzHandler;

import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.persistentEvent.LoadJosPersistenzEvent;
import eventPattern.persistenzListener.LoadJbpPersistenzEventListener;
import eventPattern.persistenzListener.LoadJosPersistenzEventListener;
import eventPattern.persistenzListener.SaveJosPersistenzEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoadJosPersistenzEventHandler {
    private List<LoadJosPersistenzEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(LoadJosPersistenzEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(LoadJbpPersistenzEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(LoadJosPersistenzEvent event) {
        for (LoadJosPersistenzEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }

}
