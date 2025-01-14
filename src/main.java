
import cli.Cli;

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
import automat.Automat;
import eventPattern.persistentEvent.SaveJosPersistenzEvent;
import eventPattern.persistenzHandler.LoadJbpPersistenzEventHandler;
import eventPattern.persistenzHandler.LoadJosPersistenzEventHandler;
import eventPattern.persistenzHandler.SaveJbpPersistenzEventHandler;
import eventPattern.persistenzHandler.SaveJosPersistenzEventHandler;
import eventPattern.persistenzListener.LoadJbpPersistenzEventListener;
import eventPattern.persistenzListener.LoadJosPersistenzEventListener;
import eventPattern.persistenzListener.SaveJbpPersistenzEventListener;
import eventPattern.persistenzListener.SaveJosPersistenzEventListener;
import io.JOS;
/*import observerPattern.AllergenObserver;*/
import observerPattern.CapacityObserver;


public class main {

    public static void main(String[] args) {

        // Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel

        Automat automat = new Automat(10);
        CapacityObserver c1 = new CapacityObserver(automat);
        //AllergenObserver a1 = new AllergenObserver(automat);

        //automat.addHersteller(new HerstellerImpl("hi"));

        automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");
        automat.addKuchen("Obsttorte hi 10.99 3294 PT12H Erdnuss Apfel Sahne");

        /*HashMap<Integer,KuchenImpl> test =  automat.getKuchenHashMap();
        test.clear();
        System.out.println(test.size());*/


        Cli console = new Cli(automat);
        JOS jos = new JOS();



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

        //JOS / JOS
        //JOS
        SaveJosPersistenzEventHandler saveJosPersistenzEventHandler = new SaveJosPersistenzEventHandler();
        SaveJosPersistenzEventListener saveJosPersistenzEventListener = new SaveJosPersistenzEventListener(automat);
        saveJosPersistenzEventHandler.addListener(saveJosPersistenzEventListener);
        console.setSaveJosPersistenzEventHandler(saveJosPersistenzEventHandler);

        LoadJosPersistenzEventHandler loadJosPersistenzEventHandler = new LoadJosPersistenzEventHandler();
        LoadJosPersistenzEventListener loadJosPersistenzEventListener = new LoadJosPersistenzEventListener(automat);
        loadJosPersistenzEventHandler.addListener(loadJosPersistenzEventListener);
        console.setLoadJosPersistenzEventHandler(loadJosPersistenzEventHandler);

        SaveJbpPersistenzEventHandler saveJbpPersistenzEventHandler = new SaveJbpPersistenzEventHandler();
        SaveJbpPersistenzEventListener saveJbpPersistenzEventListener = new SaveJbpPersistenzEventListener(automat);
        saveJbpPersistenzEventHandler.addListener(saveJbpPersistenzEventListener);
        console.setSaveJbpPersistenzEventHandler(saveJbpPersistenzEventHandler);

        LoadJbpPersistenzEventHandler loadJbpPersistenzEventHandler = new LoadJbpPersistenzEventHandler();
        LoadJbpPersistenzEventListener loadJbpPersistenzEventListener = new LoadJbpPersistenzEventListener(automat);
        loadJbpPersistenzEventHandler.addListener(loadJbpPersistenzEventListener);
        console.setLoadJbpPersistenzEventHandler(loadJbpPersistenzEventHandler);




        console.execute();

    }
}