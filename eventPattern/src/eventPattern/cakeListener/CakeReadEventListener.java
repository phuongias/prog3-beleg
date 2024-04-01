package eventPattern.cakeListener;

import eventPattern.cakeEvents.CakeReadEvent;
import impl.Automat;

public class CakeReadEventListener {

    private Automat automat;

    public CakeReadEventListener(Automat automat) {
        this.automat = automat;
    }


    public void onEvent(CakeReadEvent event) {


        //automat.getKuchenHashMap();

        for (int id = 0; id < automat.maxkapazitaet; id++) {
            if (event.getKuchenHashMap().containsKey(id)) {
                System.out.println("Kuchen: " + event.getKuchenHashMap().get(id).getKuchensorte());
                System.out.println("Preis: " + event.getKuchenHashMap().get(id).getPreis());
                System.out.println("Fachnummer: " + event.getKuchenHashMap().get(id));
                System.out.println("Fachnummer:" + event.getKuchenHashMap().get(id).getFachnummer());
                /*System.out.println("Hersteller: " + event.getKuchenHashMap().get(id).getHersteller().getName());
                System.out.println("Haltbarkeit: " + event.getKuchenHashMap().get(id).getHaltbarkeit());
                System.out.println("Naehrwert: " + event.getKuchenHashMap().get(id).getNaehrwert());*/
                System.out.println("Allergene: " + event.getKuchenHashMap().get(id).getAllergene());
                System.out.println();
            }
        }

    }
}
