package eventPattern.herstellerListener;

import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.herstellerEvents.HerstellerReadEvent;
import impl.Automat;
import impl.HerstellerImpl;
import impl.KuchenImpl;
import impl.Parser;

import java.util.HashMap;
import java.util.List;

public class HerstellerReadEventListener {
    private Automat automat;

    public HerstellerReadEventListener(Automat automat) {
        this.automat = automat;
    }


    public void onEvent(HerstellerReadEvent event) {

        HashMap<HerstellerImpl, Integer> herstellerListe = event.getHerstellerListeUndAnzahlKuchen();

        for (HerstellerImpl hersteller : herstellerListe.keySet()) {
            int kuchenAnzahl = herstellerListe.get(hersteller);
            System.out.println(hersteller.getName() + ": " + kuchenAnzahl + " Kuchen");
        }

    }
}
