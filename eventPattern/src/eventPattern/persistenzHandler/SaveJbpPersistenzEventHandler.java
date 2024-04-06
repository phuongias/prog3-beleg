package eventPattern.persistenzHandler;

import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.persistentEvent.SaveJbpPersistenzEvent;
import eventPattern.persistentEvent.SaveJosPersistenzEvent;
import eventPattern.persistenzListener.SaveJbpPersistenzEventListener;
import eventPattern.persistenzListener.SaveJosPersistenzEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveJbpPersistenzEventHandler {
    private List<SaveJbpPersistenzEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(SaveJbpPersistenzEventListener listener) {
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

    public void handle(SaveJbpPersistenzEvent event) throws IOException {
        for (SaveJbpPersistenzEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }

}
