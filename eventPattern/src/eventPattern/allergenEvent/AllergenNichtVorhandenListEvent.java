package eventPattern.allergenEvent;

import impl.KuchenImpl;

import java.util.HashMap;

public class AllergenNichtVorhandenListEvent {

    private Object source;

    private HashMap<Integer, KuchenImpl> kuchenHashMap;


    public AllergenNichtVorhandenListEvent(Object source, HashMap<Integer, KuchenImpl> kuchenHashMap){
        this.source = source;
        this.kuchenHashMap = kuchenHashMap;
    }

    public HashMap<Integer,KuchenImpl> getKuchenHashMap(){
        return kuchenHashMap;
    }
}
