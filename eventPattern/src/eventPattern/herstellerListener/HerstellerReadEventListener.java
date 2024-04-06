package eventPattern.herstellerListener;

import eventPattern.herstellerEvents.HerstellerReadEvent;
import automat.Automat;
import impl.HerstellerImpl;

import java.util.HashMap;
import java.util.Map;

public class HerstellerReadEventListener {
    private Automat automat;

    public HerstellerReadEventListener(Automat automat) {
        this.automat = automat;
    }


    public void onEvent(HerstellerReadEvent event) {

        /*HashMap<HerstellerImpl, Integer> herstellerListe = event.getHerstellerListeUndAnzahlKuchen();

        for (HerstellerImpl hersteller : herstellerListe.keySet()) {
            int kuchenAnzahl = herstellerListe.get(hersteller);
            System.out.println(hersteller.getName() + ": " + kuchenAnzahl + " Kuchen");
        }
*/

        HashMap<HerstellerImpl, Integer> herstellerUndKuchenanzahl = automat.getHerstellerUndKuchenanzahl();

        for (Map.Entry<HerstellerImpl, Integer> eintrag : herstellerUndKuchenanzahl.entrySet()) {
            HerstellerImpl hersteller = eintrag.getKey();
            int anzahlKuchen = eintrag.getValue();
            System.out.println("Hersteller: " + hersteller.getName() + ", Anzahl Kuchen: " + anzahlKuchen);
        }

    }
}
