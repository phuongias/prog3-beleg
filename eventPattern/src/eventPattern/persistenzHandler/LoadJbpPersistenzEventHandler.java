package eventPattern.persistenzHandler;

import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.persistentEvent.LoadJbpPersistenzEvent;
import eventPattern.persistentEvent.LoadJosPersistenzEvent;
import eventPattern.persistenzListener.LoadJbpPersistenzEventListener;
import eventPattern.persistenzListener.LoadJosPersistenzEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadJbpPersistenzEventHandler {
    private List<LoadJbpPersistenzEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(LoadJbpPersistenzEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(LoadJosPersistenzEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(LoadJbpPersistenzEvent event) throws IOException {
        for (LoadJbpPersistenzEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }

}
