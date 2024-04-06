import automat.Automat;
import io.JBP;

import java.io.IOException;

public class JBPIoMain {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Mit JBP: ");

        Automat automat = new Automat(10);


        try {
            // Automaten speichern
            if (JBP.saveJBP(automat)) {
                System.out.println("Automat erfolgreich gespeichert.");
            }

            // Automaten laden
            Automat geladenerAutomat = JBP.loadJBP();
            if (geladenerAutomat != null) {
                System.out.println("Automat erfolgreich geladen.");
            } else {
                System.out.println("Fehler beim Laden des Automaten.");
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern oder Laden des Automaten: " + e.getMessage());
        }
    }
}


