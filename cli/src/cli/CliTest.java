package cli;

import eventPattern.allergenHandler.AllergenNichtVorhandenListEventHandler;
import eventPattern.allergenHandler.AllergenVorhandenListEventHandler;
import eventPattern.allergenListener.AllergenNichtVorhandenListEventListener;
import eventPattern.allergenListener.AllergenVorhandenListEventListener;
import eventPattern.cakeHandler.CakeAddEventHandler;
import eventPattern.cakeHandler.CakeDeleteEventHandler;
import eventPattern.cakeHandler.CakeReadEventHandler;
import eventPattern.cakeHandler.CakeUpdateEventHandler;
import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.cakeListener.CakeDeleteEventListener;
import eventPattern.cakeListener.CakeReadEventListener;
import eventPattern.cakeListener.CakeUpdateEventListener;
import eventPattern.herstellerHandler.HerstellerAddEventHandler;
import eventPattern.herstellerHandler.HerstellerDeleteEventHandler;
import eventPattern.herstellerHandler.HerstellerReadEventHandler;
import eventPattern.herstellerListener.HerstellerAddEventListener;
import eventPattern.herstellerListener.HerstellerDeleteEventListener;
import eventPattern.herstellerListener.HerstellerReadEventListener;
import impl.Automat;
import impl.HerstellerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import verwaltung.Hersteller;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CliTest {
    private Automat automat = new Automat(10);
    Cli console = new Cli(automat);

    @BeforeEach
    void setUp() {
        //hersteller  handler erstellen
        HerstellerAddEventHandler herstellerAddEventHandler = new HerstellerAddEventHandler();
        HerstellerDeleteEventHandler herstellerDeleteEventHandler = new HerstellerDeleteEventHandler();
        HerstellerReadEventHandler herstellerReadEventHandler = new HerstellerReadEventHandler();

        //hersteller listener hinzufügen
        HerstellerAddEventListener herstellerAddEventListener = new HerstellerAddEventListener(automat);
        HerstellerDeleteEventListener herstellerDeleteEventListener = new HerstellerDeleteEventListener(automat);
        HerstellerReadEventListener herstellerReadEventListener = new HerstellerReadEventListener(automat);

        //hersteller listener handlern hinzufügen
        herstellerAddEventHandler.addListener(herstellerAddEventListener);
        herstellerDeleteEventHandler.addListener(herstellerDeleteEventListener);
        herstellerReadEventHandler.addListener(herstellerReadEventListener);


        //handler setten
        console.setHerstellerAddEventHandler(herstellerAddEventHandler);
        console.setHerstellerDeleteEventHandler(herstellerDeleteEventHandler);
        console.setHerstellerReadEventHandler(herstellerReadEventHandler);


        //kuchen handler erstellen
        CakeAddEventHandler cakeAddEventHandler = new CakeAddEventHandler();
        CakeDeleteEventHandler cakeDeleteEventHandler = new CakeDeleteEventHandler();
        CakeReadEventHandler cakeReadEventHandler = new CakeReadEventHandler();
        CakeUpdateEventHandler cakeUpdateEventHandler = new CakeUpdateEventHandler();

        //kuchen listener erstellen
        CakeAddEventListener cakeAddEventListener = new CakeAddEventListener(automat);
        CakeDeleteEventListener cakeDeleteEventListener = new CakeDeleteEventListener(automat);
        CakeReadEventListener cakeReadEventListener = new CakeReadEventListener(automat);
        CakeUpdateEventListener cakeUpdateEventListener = new CakeUpdateEventListener(automat);

        //kuchen listener hinzufügen
        cakeAddEventHandler.addListener(cakeAddEventListener);
        cakeDeleteEventHandler.addListener(cakeDeleteEventListener);
        cakeReadEventHandler.addListener(cakeReadEventListener);
        cakeUpdateEventHandler.addListener(cakeUpdateEventListener);


        //handler setten
        console.setCakeAddEventHandler(cakeAddEventHandler);
        console.setCakeDeleteEventHandler(cakeDeleteEventHandler);
        console.setCakeReadEventHandler(cakeReadEventHandler);
        console.setCakeUpdateEventHandler(cakeUpdateEventHandler);

        //Allergen vorhanden
        AllergenVorhandenListEventHandler allergenVorhandenListEventHandler = new AllergenVorhandenListEventHandler();
        AllergenVorhandenListEventListener allergenVorhandenListEventListener = new AllergenVorhandenListEventListener(automat);
        allergenVorhandenListEventHandler.addListener(allergenVorhandenListEventListener);
        console.setAllergenVorhandenListEventHandler(allergenVorhandenListEventHandler);


        //Allergen nicht vorhanden
        AllergenNichtVorhandenListEventHandler allergenNichtVorhandenListEventHandler = new AllergenNichtVorhandenListEventHandler();
        AllergenNichtVorhandenListEventListener allergenNichtVorhandenListEventListener = new AllergenNichtVorhandenListEventListener(automat);
        allergenNichtVorhandenListEventHandler.addListener(allergenNichtVorhandenListEventListener);
        console.setAllergenNichtVorhandenListEventHandler(allergenNichtVorhandenListEventHandler);
    }


    @Test
    void addHerstellerInCli() {

        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(":c\n".getBytes());
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream("hersteller\n".getBytes());
        ByteArrayInputStream inputStream3 = new ByteArrayInputStream("Hersteller\n".getBytes());
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);
        SequenceInputStream finalSequenceInputStream = new SequenceInputStream(sequenceInputStream, inputStream3);

        System.setIn(finalSequenceInputStream);

        try {
            // Führe die CLI aus, um einen Hersteller hinzuzufügen
            console.execute();
        } catch (Exception e) {
            // Behandle mögliche Fehler
            fail("Fehler beim Ausführen der CLI: " + e.getMessage());
        }

        // Überprüfe, ob der Hersteller erfolgreich hinzugefügt wurde
        // Vergleiche die Anzahl der Hersteller vor und nach dem Hinzufügen
        assertEquals(1, automat.getHerstellerListe().size());

        // Überprüfe, ob der hinzugefügte Hersteller korrekt ist
        HerstellerImpl hersteller = automat.getHerstellerListe().get(0);
        assertEquals("Hersteller", hersteller.getName());

    }

}
        

       