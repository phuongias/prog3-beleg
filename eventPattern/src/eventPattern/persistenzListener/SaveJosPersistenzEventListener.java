package eventPattern.persistenzListener;

import automat.Automat;
import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.persistentEvent.SaveJosPersistenzEvent;
import impl.KuchenImpl;
import impl.Parser;
import io.JOS;

public class SaveJosPersistenzEventListener {
    private Automat automat;
    JOS jos = new JOS();

    public SaveJosPersistenzEventListener(Automat automat) {

        this.automat = automat;
    }


    public void onEvent(SaveJosPersistenzEvent event) {

        if (jos.saveDL(automat)) {
            System.out.println("Automat erfolgreich gespeichert.");
        } else {
            System.out.println("Fehler beim Speichern des Automaten.");
        }
        System.out.println(automat.getKuchenHashMap());

    }
}
