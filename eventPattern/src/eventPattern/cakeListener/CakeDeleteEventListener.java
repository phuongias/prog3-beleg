package eventPattern.cakeListener;

import eventPattern.cakeEvents.CakeDeleteEvent;
import impl.Automat;
import impl.KuchenImpl;
import impl.Parser;

import java.util.Scanner;

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