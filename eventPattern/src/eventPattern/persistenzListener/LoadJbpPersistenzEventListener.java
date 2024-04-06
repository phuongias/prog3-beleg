package eventPattern.persistenzListener;

import automat.Automat;
import eventPattern.persistentEvent.LoadJbpPersistenzEvent;
import eventPattern.persistentEvent.LoadJosPersistenzEvent;
import io.JBP;
import io.JOS;

import java.io.IOException;

public class LoadJbpPersistenzEventListener {
    private Automat automat;
    JBP jbp = new JBP();

    public LoadJbpPersistenzEventListener(Automat automat) {
        this.automat = automat;
    }

    public void onEvent(LoadJbpPersistenzEvent event) throws IOException {

        // Automaten laden
        Automat geladenerAutomat = JBP.loadJBP();
        if (geladenerAutomat != null) {
            System.out.println("Automat erfolgreich geladen.");
        } else {
            System.out.println("Fehler beim Laden des Automaten.");
        }
    }
}
