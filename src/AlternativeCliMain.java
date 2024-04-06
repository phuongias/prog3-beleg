import cli.Cli;
import eventPattern.cakeHandler.CakeAddEventHandler;
import eventPattern.cakeHandler.CakeDeleteEventHandler;
import eventPattern.cakeHandler.CakeReadEventHandler;
import eventPattern.cakeHandler.CakeUpdateEventHandler;
import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.cakeListener.CakeDeleteEventListener;
import eventPattern.cakeListener.CakeReadEventListener;
import eventPattern.cakeListener.CakeUpdateEventListener;
import eventPattern.herstellerHandler.HerstellerAddEventHandler;
import eventPattern.herstellerHandler.HerstellerReadEventHandler;
import eventPattern.herstellerListener.HerstellerAddEventListener;
import eventPattern.herstellerListener.HerstellerReadEventListener;
import impl.Automat;
import observerPattern.CapacityObserver;

public class AlternativeCliMain {

    public static void main(String[] args) {

        int maxKapazitaet = 1;
        for (String arg : args) {
            try {
                maxKapazitaet = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return;
            }

        }

        Automat automat = new Automat(maxKapazitaet);
        Cli cliConsole = new Cli(automat);
        CapacityObserver capacityObserver = new CapacityObserver(automat);
        System.out.println("Löschen von Hersteller und auflisten von Allergene nicht vorhanden.");

        //hersteller  handler erstellen
        HerstellerAddEventHandler herstellerAddEventHandler = new HerstellerAddEventHandler();
        HerstellerReadEventHandler herstellerReadEventHandler = new HerstellerReadEventHandler();

        //hersteller listener hinzufügen
        HerstellerAddEventListener herstellerAddEventListener = new HerstellerAddEventListener(automat);
        HerstellerReadEventListener herstellerReadEventListener = new HerstellerReadEventListener(automat);

        //hersteller listener handlern hinzufügen
        herstellerAddEventHandler.addListener(herstellerAddEventListener);
        herstellerReadEventHandler.addListener(herstellerReadEventListener);


        //handler setten
        cliConsole.setHerstellerAddEventHandler(herstellerAddEventHandler);
        cliConsole.setHerstellerReadEventHandler(herstellerReadEventHandler);


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
        cliConsole.setCakeAddEventHandler(cakeAddEventHandler);
        cliConsole.setCakeDeleteEventHandler(cakeDeleteEventHandler);
        cliConsole.setCakeReadEventHandler(cakeReadEventHandler);
        cliConsole.setCakeUpdateEventHandler(cakeUpdateEventHandler);

        cliConsole.execute();



    }
}
