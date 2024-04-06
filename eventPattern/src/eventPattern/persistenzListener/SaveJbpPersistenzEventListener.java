package eventPattern.persistenzListener;

import automat.Automat;
import eventPattern.persistentEvent.SaveJbpPersistenzEvent;
import eventPattern.persistentEvent.SaveJosPersistenzEvent;
import io.JBP;
import io.JOS;

import java.io.IOException;

public class SaveJbpPersistenzEventListener {
    private Automat automat;
    JBP jbp = new JBP();

    public SaveJbpPersistenzEventListener(Automat automat) {

        this.automat = automat;
    }


    public void onEvent(SaveJbpPersistenzEvent event) throws IOException {
        System.out.println("Mit JBP: ");


        try {
            // Automaten speichern
            if (JBP.saveJBP(automat)) {
                System.out.println("Automat erfolgreich gespeichert.");
            }

        } catch (IOException e) {
            System.err.println("Fehler beim Speichern oder Laden des Automaten: " + e.getMessage());
        }
    }


}
