package eventPattern.cakeHandler;

import eventPattern.cakeEvents.CakeReadEvent;
import eventPattern.cakeListener.CakeReadEventListener;

import java.util.ArrayList;
import java.util.List;

public class CakeReadEventHandler {

    private List<CakeReadEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(CakeReadEventListener listener){
        if(null != listener){
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(CakeReadEventListener listener){
        if(null != listener){
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(CakeReadEvent event) {
        for (CakeReadEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }
}
