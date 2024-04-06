package eventPattern.herstellerListener;

import eventPattern.herstellerEvents.HerstellerAddEvent;
import automat.Automat;
import impl.HerstellerImpl;

public class HerstellerAddEventListener {
    private Automat automat;

    public HerstellerAddEventListener(Automat automat) {
        this.automat = automat;
    }


    public void onEvent(HerstellerAddEvent event) {

        boolean herstellerAdded = automat.addHersteller(new HerstellerImpl(event.getHerstellerName()));

        if (herstellerAdded) {
            System.out.println("Hersteller erfolgreich hinzugefügt.");
        } else {
            System.out.println("Hersteller konnte nicht hinzugefügt werden.");
        }
    }


}
