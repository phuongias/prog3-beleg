package eventPattern.allergenHandler;

import eventPattern.allergenEvent.AllergenNichtVorhandenListEvent;
import eventPattern.allergenEvent.AllergenVorhandenListEvent;
import eventPattern.allergenListener.AllergenNichtVorhandenListEventListener;
import eventPattern.allergenListener.AllergenVorhandenListEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllergenNichtVorhandenListEventHandler {

    private List<AllergenNichtVorhandenListEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(AllergenNichtVorhandenListEventListener listener) {
        if (null != listener) {
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(AllergenNichtVorhandenListEventListener listener) {
        if (null != listener) {
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(AllergenNichtVorhandenListEvent event) {
        for (AllergenNichtVorhandenListEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }

}
