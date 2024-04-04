package eventPattern.cakeListener;

import eventPattern.cakeEvents.CakeReadEvent;
import eventPattern.cakeEvents.CakeUpdateEvent;
import impl.Automat;

import java.util.Scanner;

public class CakeUpdateEventListener {

    private Automat automat;

    public CakeUpdateEventListener (Automat automat){
        this.automat = automat;
    }


    public void onEvent(CakeUpdateEvent event) {

        boolean updated = automat.updateInspektiosdatum(event.getId());

        if (updated) {
            System.out.println("Kuchen wurde erfolgreich inspiziert.");
        } else {
            System.out.println("Kuchen konnte nicht inspiziert werden.");
        }


    }


}