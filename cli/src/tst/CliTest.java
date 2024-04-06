package tst;

import cli.Cli;
import eventPattern.allergenHandler.AllergenNichtVorhandenListEventHandler;
import eventPattern.allergenHandler.AllergenVorhandenListEventHandler;
import eventPattern.allergenListener.AllergenNichtVorhandenListEventListener;
import eventPattern.allergenListener.AllergenVorhandenListEventListener;
import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.cakeHandler.CakeAddEventHandler;
import eventPattern.cakeHandler.CakeDeleteEventHandler;
import eventPattern.cakeHandler.CakeReadEventHandler;
import eventPattern.cakeHandler.CakeUpdateEventHandler;
import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.cakeListener.CakeDeleteEventListener;
import eventPattern.cakeListener.CakeReadEventListener;
import eventPattern.cakeListener.CakeUpdateEventListener;
import eventPattern.herstellerEvents.HerstellerAddEvent;
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

import org.mockito.Mockito;
import verwaltung.Hersteller;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class CliTest {
    //CLi Klasse wird getestet

    @Test
    void addHerstellerInCli() {

        Automat automat = new Automat(10);
        Cli console = new Cli(automat);


        HerstellerAddEventHandler herstellerAddEventHandler = Mockito.mock(HerstellerAddEventHandler.class);
        console.setHerstellerAddEventHandler(herstellerAddEventHandler);


        HerstellerAddEventListener herstellerAddEventListener = Mockito.mock(HerstellerAddEventListener.class);
        herstellerAddEventHandler.addListener(herstellerAddEventListener);

        //handler setten
        console.setHerstellerAddEventHandler(herstellerAddEventHandler);


        String simulatedInput = ":c\nhersteller\nHersteller\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());

        System.setIn(inputStream);

        try {
            console.execute();
        } catch (Exception e) {

        }

        assertEquals(1, automat.getHerstellerListe().size());
        HerstellerImpl hersteller = automat.getHerstellerListe().get(0);
        assertEquals("Hersteller", hersteller.getName());

    }






}
        

       