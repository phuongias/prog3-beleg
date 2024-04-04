package eventPattern.cakeEvents;

import impl.KuchenImpl;

import java.util.HashMap;


public class CakeReadEvent {
    private Object source;
    private HashMap<Integer, KuchenImpl> kuchenHashMap;

    public CakeReadEvent(Object source, HashMap<Integer, KuchenImpl> kuchenHashMap) {
        this.source = source;
        this.kuchenHashMap = kuchenHashMap;
    }

    public Object getSource() {
        return source;
    }

    public HashMap<Integer, KuchenImpl> getKuchenHashMap() {
        return kuchenHashMap;
    }
}