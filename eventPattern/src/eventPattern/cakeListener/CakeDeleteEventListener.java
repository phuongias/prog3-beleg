package eventPattern.cakeListener;

import eventPattern.cakeEvents.CakeDeleteEvent;
import automat.Automat;

public class CakeDeleteEventListener {

    private Automat automat;

    public CakeDeleteEventListener(Automat automat){
        this.automat = automat;
    }


    public void onEvent(CakeDeleteEvent event) {

        boolean deleted = automat.deleteKuchenById(event.getId());

        if (deleted) {
            System.out.println("Kuchen wurde gelöscht!");
        } else {
            System.out.println("Kuchen konnte nicht gelöscht werden!");
        }
    }
}