package tst;

import cli.Cli;
import eventPattern.herstellerHandler.HerstellerAddEventHandler;
import eventPattern.herstellerListener.HerstellerAddEventListener;
import automat.Automat;
import impl.HerstellerImpl;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

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
        

       