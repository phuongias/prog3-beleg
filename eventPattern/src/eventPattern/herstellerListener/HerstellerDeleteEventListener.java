package eventPattern.herstellerListener;

import eventPattern.herstellerEvents.HerstellerDeleteEvent;
import automat.Automat;
import impl.HerstellerImpl;

public class HerstellerDeleteEventListener {

    Automat automat;

    public HerstellerDeleteEventListener(Automat automat){
        this.automat = automat;
    }

    public void onEvent(HerstellerDeleteEvent event) {

        HerstellerImpl herstellerAdded = automat.deleteHersteller(new HerstellerImpl(event.getHerstellerName()));

        if (herstellerAdded != null) {
            System.out.println("Hersteller erfolgreich gelöscht.");
        } else {
            System.out.println("Hersteller konnte nicht gelöscht werden.");
        }
    }
}
