package eventPattern.allergenHandler;

import eventPattern.allergenEvent.AllergenVorhandenListEvent;
import eventPattern.allergenListener.AllergenVorhandenListEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllergenVorhandenListEventHandler {

    private List<AllergenVorhandenListEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(AllergenVorhandenListEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(AllergenVorhandenListEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(AllergenVorhandenListEvent event) {
        for (AllergenVorhandenListEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }
}
