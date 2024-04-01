package eventPattern.cakeListener;

import eventPattern.cakeEvents.CakeAddEvent;
import impl.Automat;
import impl.KuchenImpl;
import impl.Parser;


public class CakeAddEventListener {

    private Automat automat;

    public CakeAddEventListener(Automat automat) {
        this.automat = automat;
    }


    public void onEvent(CakeAddEvent event) {

        String addedKuchen = event.getKuchenInfo();
        KuchenImpl createdKuchen = Parser.parseKuchenInfo(addedKuchen);

        boolean checkHersteller = automat.getHerstellerListe().contains(createdKuchen.getHersteller());
        //System.out.println(checkHersteller);

        if (automat.isFull()) {
            System.out.println("Automat ist voll. Kuchen kann nicht hinzugefügt werden!");
        } else {
            if (checkHersteller) {
                automat.addKuchen(addedKuchen);
                if (createdKuchen != null) {
                    System.out.println("Kuchen wurde erfolgreich hinzugefügt!");
                } else {
                    System.out.println("Kuchen konnte nicht hinzugefügt weil Automat zu voll ist!");
                }
            } else {
                System.out.println("Hersteller nicht vorhanden. Kuchen konnte nicht hinzugefügt werden!");
            }
        }
    }

}