package eventPattern.cakeHandler;

import eventPattern.cakeEvents.CakeDeleteEvent;
import eventPattern.cakeListener.CakeDeleteEventListener;

import java.util.ArrayList;
import java.util.List;

public class CakeDeleteEventHandler {

    private List<CakeDeleteEventListener> eventListenerList = new ArrayList<>();

    public boolean addListener(CakeDeleteEventListener listener){
        if(null != listener){
            return eventListenerList.add(listener);
        }
        return false;
    }

    public boolean removeListener(CakeDeleteEventListener listener){
        if(null != listener){
            return eventListenerList.remove(listener);
        }
        return false;
    }

    public void handle(CakeDeleteEvent event) {
        for (CakeDeleteEventListener listener : eventListenerList) {
            listener.onEvent(event);
        }
    }
}
