package cli;

import eventPattern.allergenEvent.AllergenNichtVorhandenListEvent;
import eventPattern.allergenEvent.AllergenVorhandenListEvent;
import eventPattern.allergenHandler.AllergenNichtVorhandenListEventHandler;
import eventPattern.allergenHandler.AllergenVorhandenListEventHandler;
import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.cakeEvents.CakeDeleteEvent;
import eventPattern.cakeEvents.CakeReadEvent;
import eventPattern.cakeEvents.CakeUpdateEvent;
import eventPattern.cakeHandler.CakeAddEventHandler;
import eventPattern.cakeHandler.CakeDeleteEventHandler;
import eventPattern.cakeHandler.CakeReadEventHandler;
import eventPattern.cakeHandler.CakeUpdateEventHandler;
import eventPattern.herstellerEvents.HerstellerAddEvent;
import eventPattern.herstellerEvents.HerstellerDeleteEvent;
import eventPattern.herstellerEvents.HerstellerReadEvent;
import eventPattern.herstellerHandler.HerstellerAddEventHandler;
import eventPattern.herstellerHandler.HerstellerDeleteEventHandler;
import eventPattern.herstellerHandler.HerstellerReadEventHandler;
import automat.Automat;
import eventPattern.persistentEvent.LoadJbpPersistenzEvent;
import eventPattern.persistentEvent.LoadJosPersistenzEvent;
import eventPattern.persistentEvent.SaveJbpPersistenzEvent;
import eventPattern.persistentEvent.SaveJosPersistenzEvent;
import eventPattern.persistenzHandler.LoadJbpPersistenzEventHandler;
import eventPattern.persistenzHandler.LoadJosPersistenzEventHandler;
import eventPattern.persistenzHandler.SaveJbpPersistenzEventHandler;
import eventPattern.persistenzHandler.SaveJosPersistenzEventHandler;
import eventPattern.persistenzListener.LoadJbpPersistenzEventListener;
import impl.HerstellerImpl;
import impl.KuchenImpl;
import io.JOS;


import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Cli {

    private Automat automat;

    private JOS jos;


    private CakeAddEventHandler cakeAddEventHandler;
    private CakeDeleteEventHandler cakeDeleteEventHandler;
    private CakeReadEventHandler cakeReadEventHandler;
    private CakeUpdateEventHandler cakeUpdateEventHandler;

    private HerstellerAddEventHandler herstellerAddEventHandler;
    private HerstellerDeleteEventHandler herstellerDeleteEventHandler;
    private HerstellerReadEventHandler herstellerReadEventHandler;

    private AllergenVorhandenListEventHandler allergenVorhandenListEventHandler;
    private AllergenNichtVorhandenListEventHandler allergenNichtVorhandenListEventHandler;
    private SaveJosPersistenzEventHandler saveJosPersistenzEventHandler;
    private LoadJosPersistenzEventHandler loadJosPersistenzEventHandler;
    private SaveJbpPersistenzEventHandler saveJbpPersistenzEventHandler;
    private LoadJbpPersistenzEventHandler loadJbpPersistenzEventHandler;

    private Scanner scanner;

    public Cli(Automat automat) {
        this.automat = automat;
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        while (true) {
            try {
                System.out.println("Menü:");
                System.out.println(":c - Einfügemodus");
                System.out.println(":d - Löschmodus");
                System.out.println(":r - Anzeigemodus");
                System.out.println(":u - Änderungsmodus");
                System.out.println(":p - Persistenzmodus");

                String input = scanner.nextLine();

                switch (input) {
                    case ":c":
                        handleEinfuegemodus();
                        break;
                    case ":d":
                        handleLoeschmodus();
                        break;
                    case ":r":
                        handleAnzeigemodus();
                        break;
                    case ":u":
                        handleAenderungsmodus();
                        break;
                    case ":p":
                        handlePersistenzmodus();
                        break;
                    default:
                        System.out.println("Ungültige Eingabe!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }
    }

    private void handleEinfuegemodus() {
        System.out.println("Einfügemodus");
        System.out.println("Auswahl treffen:");
        System.out.println("hersteller - für hersteller hinzufügen");
        System.out.println("kuchen - für kuchen hinzuzufügen");

        String choice = scanner.nextLine();

        switch (choice) {
            case "hersteller":
                handleHerstellerHinzufuegen();
                break;
            case "kuchen":
                handleKuchenHinzufuegen();
                break;
            default:
                System.out.println("Ungültige Eingabe!");
                break;
        }
    }

    private void handleHerstellerHinzufuegen() {
        System.out.println("Geben Sie den Hersteller an den Sie hinzufügen möchten: ");
        String addedHersteller = scanner.nextLine();

        HerstellerAddEvent addHerstellerEvent = new HerstellerAddEvent(automat, addedHersteller);
        herstellerAddEventHandler.handle(addHerstellerEvent);
        System.out.println();

    }

    private void handleKuchenHinzufuegen() {
        System.out.println("Geben Sie die Kucheninformation in folgender Reihenfolge an: [Kuchenname] [Hersteller] [Preis] [Naehrwert] [Haltbarkeit] [Allergen] [Obstsorte] [Kremsorte]");
        String kuchenInfo = scanner.nextLine();
        /*KuchenImpl kuchen = Parser.addKuchen(addedKuchen);*/
        System.out.println();

        CakeAddEvent addCakeEvent = new CakeAddEvent(automat, kuchenInfo);
        cakeAddEventHandler.handle(addCakeEvent);
    }

    private void handleLoeschmodus() {
        System.out.println("Löschmodus ");
        System.out.println("hersteller");
        System.out.println("kuchen");

        String innerChoice2 = scanner.nextLine();
        switch (innerChoice2) {
            case "hersteller":
                handleHerstellerLoeschen();
            case "kuchen":
                handleKuchenLoeschen();
        }
    }

    private void handleHerstellerLoeschen() {
        System.out.println("Geben Sie den Hersteller an den Sie löschen wollen: ");
        String deletedHersteller = scanner.next();
        System.out.println();

        HerstellerDeleteEvent deleteEvent = new HerstellerDeleteEvent(automat, deletedHersteller);
        herstellerDeleteEventHandler.handle(deleteEvent);

    }


    private void handleKuchenLoeschen() {
        System.out.println("Bitte geben Sie die Fachnummer vom Kuchen ein, welches Sie löschen wollen: ");
        int deletedKuchenById = scanner.nextInt();

        CakeDeleteEvent deleteCakeEvent = new CakeDeleteEvent(automat, deletedKuchenById);
        cakeDeleteEventHandler.handle(deleteCakeEvent);

    }


    private void handleAnzeigemodus() {
        System.out.println("Anzeigemodus ");
        System.out.println("kuchen - Kuchenliste anzeigen: ");
        System.out.println("hersteller - Hersteller + Anzahl der Kuchen anzeigen lassen: ");
        System.out.println("allergene - Allergenliste anzeigen: ");
        String innerChoice3 = scanner.nextLine();
        switch (innerChoice3) {
            case ":k":
                handleKuchenAnzeigen();
                break;

            case ":h":
                handleHerstellerAnzeigen();
                break;


            case ":a":
                handleAllergenAnzeigen();
                break;

        }
    }

    private void handleHerstellerAnzeigen() {
        System.out.println("Herstellerliste (+Anzahl ihrer Kuchen): ");
        HashMap<HerstellerImpl, Integer> herstellerliste = automat.getHerstellerUndKuchenanzahl();

        HerstellerReadEvent herstellerReadEvent = new HerstellerReadEvent(automat, herstellerliste);
        herstellerReadEventHandler.handle(herstellerReadEvent);

    }


    private void handleKuchenAnzeigen() {
        System.out.println("Kuchenliste: ");
        HashMap<Integer, KuchenImpl> kuchenHashMap = automat.getKuchenHashMap();

        CakeReadEvent readEvent = new CakeReadEvent(automat, kuchenHashMap);
        cakeReadEventHandler.handle(readEvent);

    }

    private void handleAllergenAnzeigen() {
        System.out.println("Allergenliste: ");
        System.out.println(":e - nicht enthalten:");
        System.out.println(":i - enhalten: ");
        String innerChoice4 = scanner.nextLine();
        switch (innerChoice4) {
            case ":i":
                AllergenVorhandenListEvent allergenListEvent = new AllergenVorhandenListEvent(automat, automat.getKuchenHashMap());
                allergenVorhandenListEventHandler.handle(allergenListEvent);
                System.out.println();
                break;

            case ":e":
                AllergenNichtVorhandenListEvent allerergenListEvent = new AllergenNichtVorhandenListEvent(automat, automat.getKuchenHashMap());
                allergenNichtVorhandenListEventHandler.handle(allerergenListEvent);
                System.out.println();

        }
    }


    private void handleAenderungsmodus() {
        handleKuchenUpdaten();
    }

    private void handleKuchenUpdaten() {
        System.out.println("Geben Sie die Fachnummer vom dem Kuchen an von dem sie das Inspektionsdatum updaten möchten: ");
        int updatedKuchenById = scanner.nextInt();

        CakeUpdateEvent updateEvent = new CakeUpdateEvent(automat, updatedKuchenById);
        cakeUpdateEventHandler.handle(updateEvent);

    }

    private void handlePersistenzmodus() throws IOException {
        System.out.println("Persistenzmodus (nur JOS)");
        System.out.println("saveJOS");
        System.out.println("loadJOS");
        System.out.println("saveJBP");
        System.out.println("loadJBP");
        String innerChoice4 = scanner.nextLine();
        switch (innerChoice4) {
            case "saveJOS":
                handleSaveJos();
                break;

            case "loadJOS":
                handleLoadJos();
                break;

            case "saveJBP":
                handleSaveJbp();
                break;
            case "loadJBP":
                handleLoadJbp();
                break;
        }
    }




    private void handleSaveJos() {
        SaveJosPersistenzEvent saveJosPersistenzEvent = new SaveJosPersistenzEvent(automat);
        saveJosPersistenzEventHandler.handle(saveJosPersistenzEvent);
        System.out.println();
    }


    private void handleLoadJos() {
        LoadJosPersistenzEvent loadJosPersistenzEvent = new LoadJosPersistenzEvent(automat);
        loadJosPersistenzEventHandler.handle(loadJosPersistenzEvent);
        System.out.println();

    }
    private void handleSaveJbp() throws IOException {
        SaveJbpPersistenzEvent saveJbpPersistenzEvent = new SaveJbpPersistenzEvent(automat);
        saveJbpPersistenzEventHandler.handle(saveJbpPersistenzEvent);
        System.out.println();


    }
    private void handleLoadJbp() throws IOException {
        LoadJbpPersistenzEvent loadJbpPersistenzEvent = new LoadJbpPersistenzEvent(automat);
        loadJbpPersistenzEventHandler.handle(loadJbpPersistenzEvent);


    }



    public void setCakeAddEventHandler(CakeAddEventHandler cakeAddEventHandler) {
        this.cakeAddEventHandler = cakeAddEventHandler;
    }

    public void setCakeDeleteEventHandler(CakeDeleteEventHandler cakeDeleteEventHandler) {
        this.cakeDeleteEventHandler = cakeDeleteEventHandler;
    }

    public void setCakeReadEventHandler(CakeReadEventHandler cakeReadEventHandler) {
        this.cakeReadEventHandler = cakeReadEventHandler;
    }

    public void setCakeUpdateEventHandler(CakeUpdateEventHandler cakeUpdateEventHandler) {
        this.cakeUpdateEventHandler = cakeUpdateEventHandler;
    }

    public void setHerstellerAddEventHandler(HerstellerAddEventHandler herstellerAddEventHandler) {
        this.herstellerAddEventHandler = herstellerAddEventHandler;
    }

    public void setHerstellerDeleteEventHandler(HerstellerDeleteEventHandler herstellerDeleteEventHandler) {
        this.herstellerDeleteEventHandler = herstellerDeleteEventHandler;
    }

    public void setHerstellerReadEventHandler(HerstellerReadEventHandler herstellerReadEventHandler) {
        this.herstellerReadEventHandler = herstellerReadEventHandler;
    }

    public void setAllergenVorhandenListEventHandler(AllergenVorhandenListEventHandler allergenVorhandenListEventHandler) {
        this.allergenVorhandenListEventHandler = allergenVorhandenListEventHandler;
    }

    public void setAllergenNichtVorhandenListEventHandler(AllergenNichtVorhandenListEventHandler allergenNichtVorhandenListEventHandler) {
        this.allergenNichtVorhandenListEventHandler = allergenNichtVorhandenListEventHandler;
    }
    public void setSaveJosPersistenzEventHandler(SaveJosPersistenzEventHandler saveJosPersistenzEventHandler){
        this.saveJosPersistenzEventHandler = saveJosPersistenzEventHandler;
    }

    public void setLoadJosPersistenzEventHandler(LoadJosPersistenzEventHandler loadJosPersistenzEventHandler){
        this.loadJosPersistenzEventHandler = loadJosPersistenzEventHandler;
    }

    public void setSaveJbpPersistenzEventHandler(SaveJbpPersistenzEventHandler saveJbpPersistenzEventHandler){
        this.saveJbpPersistenzEventHandler = saveJbpPersistenzEventHandler;
    }

    public void setLoadJbpPersistenzEventHandler(LoadJbpPersistenzEventHandler loadJbpPersistenzEventHandler){
        this.loadJbpPersistenzEventHandler = loadJbpPersistenzEventHandler;
    }
}