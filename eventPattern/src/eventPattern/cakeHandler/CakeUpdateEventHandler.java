package eventPattern.cakeHandler;

import eventPattern.cakeEvents.CakeUpdateEvent;
import eventPattern.cakeListener.CakeUpdateEventListener;

import java.util.ArrayList;
import java.util.List;

public class CakeUpdateEventHandler {
    private List<CakeUpdateEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(CakeUpdateEventListener listener){
        if(null != listener){
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(CakeUpdateEventListener listener){
        if(null != listener){
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(CakeUpdateEvent event) {
        for (CakeUpdateEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }
}
