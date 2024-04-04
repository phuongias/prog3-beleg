package eventPattern.herstellerEvents;

import impl.HerstellerImpl;
import impl.KuchenImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class HerstellerReadEvent {

    private Object source;
    private HashMap <HerstellerImpl,Integer> herstellerlisteUndAnzahlKuchen;

    public HerstellerReadEvent(Object source, HashMap<HerstellerImpl, Integer> herstellerlisteUndAnzahlKuchen) {
        this.source = source;
        this.herstellerlisteUndAnzahlKuchen = herstellerlisteUndAnzahlKuchen;
    }

    public Object getSource() {
        return source;
    }

    public HashMap<HerstellerImpl,Integer> getHerstellerListeUndAnzahlKuchen() {
        return herstellerlisteUndAnzahlKuchen;
    }
}
