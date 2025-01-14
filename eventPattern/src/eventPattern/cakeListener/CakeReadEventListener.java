package eventPattern.cakeListener;

import eventPattern.cakeEvents.CakeReadEvent;
import automat.Automat;

public class CakeReadEventListener {

    private Automat automat;

    public CakeReadEventListener(Automat automat) {
        this.automat = automat;
    }


    public void onEvent(CakeReadEvent event) {


        for (int id = 0; id < automat.getMaxkapazitaet(); id++) {
            if (event.getKuchenHashMap().containsKey(id)) {
                System.out.println("Kuchen: " + event.getKuchenHashMap().get(id).getKuchensorte());
                System.out.println("Preis: " + event.getKuchenHashMap().get(id).getPreis());
                //System.out.println("Fachnummer: " + event.getKuchenHashMap().get(id));
                System.out.println("Fachnummer:" + event.getKuchenHashMap().get(id).getFachnummer());
                //System.out.println("Hersteller: " + event.getKuchenHashMap().get(id).getHersteller().getName());
                System.out.println("Haltbarkeit: " + event.getKuchenHashMap().get(id).getHaltbarkeit().toDays());
                //System.out.println("Naehrwert: " + event.getKuchenHashMap().get(id).getNaehrwert());
                //System.out.println("Allergene: " + event.getKuchenHashMap().get(id).getAllergene());
                System.out.println();
            }
        }

    }
}