package console;

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
import impl.Automat;
import impl.HerstellerImpl;
import impl.KuchenImpl;
import io.JOS;


import java.util.HashMap;
import java.util.Scanner;

public class Console {

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

    private Scanner scanner;

    public Console(Automat automat) {
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
        System.out.println(":h - Hersteller hinzufügen");
        System.out.println(":k - Kuchen hinzufügen");

        String choice = scanner.nextLine();

        switch (choice) {
            case ":h":
                handleHerstellerHinzufuegen();
                break;
            case ":k":
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
        System.out.println(":h - Hersteller löschen:");
        System.out.println(":k - Kuchen löschen: ");

        String innerChoice2 = scanner.nextLine();
        switch (innerChoice2) {
            case ":h":
                handleHerstellerLoeschen();
            case "k":
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
        System.out.println(":k - Kuchenliste anzeigen: ");
        System.out.println(":h - Hersteller + Anzahl der Kuchen anzeigen lassen: ");
        System.out.println(":a - Allergenliste anzeigen: ");
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

    private void handlePersistenzmodus() {
        System.out.println("Persistenzmodus ");
        System.out.println(":saveJOS");
        System.out.println("loadJOS");
        String innerChoice4 = scanner.nextLine();
        switch (innerChoice4) {
            case "saveJOS":
                handleSaveJos();
                break;

            case "loadJOS":
                handleLoadJos();
                break;
        }
    }



    private void handleSaveJos() {
        if (jos.saveDL(automat)) {
            System.out.println("Automat erfolgreich gespeichert.");
        } else {
            System.out.println("Fehler beim Speichern des Automaten.");
        }
        System.out.println(automat.getKuchenHashMap());
    }

    private void handleLoadJos() {
        Automat loadedAutomat = null;
        try {
            loadedAutomat = jos.loadDL();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(loadedAutomat.getKuchenHashMap());
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
}


