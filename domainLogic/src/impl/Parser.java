package impl;

//Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel

import impl.*;
import kuchen.Allergen;
import kuchen.Kuchen;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Parser {


    //Hilfsmethod, um String-Eingabe in ein Kuchenobjekt umzuwandeln
    public static KuchenImpl parseKuchenInfo(String kuchen) throws IllegalArgumentException {

        String[] kucheninformationen = kuchen.split(" ");

        if (kucheninformationen.length < 5) {
            throw new IllegalArgumentException("Fehlende Kucheninformationen!");

        }

        String kuchensorte = kucheninformationen[0];
        String herstellerName = kucheninformationen[1];
        HerstellerImpl hersteller = new HerstellerImpl(herstellerName);

        BigDecimal preis;
        try {
            preis = new BigDecimal(kucheninformationen[2]);
        } catch (NumberFormatException e) {
            System.out.println("Preis fehlerhaft. Korrektes Beispiel: '9.99'. Input war: " + kucheninformationen[2]);
            preis = BigDecimal.ZERO;
        }

        int naehrwert;
        try {
            naehrwert = Integer.parseInt(kucheninformationen[3]);
        } catch (NumberFormatException e) {
            System.out.println("Nährwert fehlerhaft. Integer erwartet. Input war: " + kucheninformationen[3]);
            naehrwert = 0;
        }

        Duration haltbarkeit;
        try {
            haltbarkeit = Duration.parse(kucheninformationen[4]);
        } catch (DateTimeParseException e) {
            System.out.println("Haltbarkeit fehlerhaft! Input war: " + kucheninformationen[4]);
            haltbarkeit = null;
        }

        List<Allergen> allergene = new ArrayList<>();
        if (kucheninformationen.length > 5) {
            String[] allergeneText = kucheninformationen[5].split(",");
            for (String allergenText : allergeneText) {
                try {
                    Allergen allergen = Allergen.valueOf(allergenText);
                    allergene.add(allergen);
                } catch (IllegalArgumentException e) {
                    System.out.println("Unbekanntes Allergen. Input war: " + allergenText);
                }
            }
        }

        switch (kuchensorte) {
            case "Obstkuchen":
                if (kucheninformationen.length < 7) {
                    throw new IllegalArgumentException("Fehlende Kucheninformationen!");
                }
                String obstsorte = kucheninformationen[6];
                return new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene, obstsorte);
            case "Kremkuchen":
                if (kucheninformationen.length < 7) {
                    throw new IllegalArgumentException("Fehlende Kucheninformationen!");
                }
                String kremsorte = kucheninformationen[6];
                return new KremkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene, kremsorte);
            case "Obsttorte":
                if (kucheninformationen.length < 8) {
                    throw new IllegalArgumentException("Fehlende Kucheninformationen!");
                }
                String obstsorteTorte = kucheninformationen[6];
                String kremsorteTorte = kucheninformationen[7];
                return new ObsttorteImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene, obstsorteTorte, kremsorteTorte);
            default:
                throw new IllegalArgumentException("Ungültige Kucheninformationen!");

        }
    }
}


        /*String[] kucheninformationen = kuchen.split(" ");

        if (kucheninformationen.length < 7 || (!kucheninformationen[0].equals("Obstkuchen") && !kucheninformationen[0].equals("Kremkuchen") && !kucheninformationen[0].equals("Obsttorte"))) {
            throw new IllegalArgumentException("Ungültige Kucheninformationen: " + kuchen);
        }

        String kuchensorte = kucheninformationen[0];
        String herstellerName = kucheninformationen[1];
        HerstellerImpl hersteller = new HerstellerImpl(herstellerName);

        BigDecimal preis;
        try {
            preis = new BigDecimal(kucheninformationen[2]);
        } catch (NumberFormatException e) {
            System.out.println("Preis fehlerhaft. Korrektes Beispiel: '9.99'. Input war: " + kucheninformationen[2]);
            preis = BigDecimal.ZERO;
        }

        int naehrwert;
        try {
            naehrwert = Integer.parseInt(kucheninformationen[3]);
        } catch (NumberFormatException e) {
            System.out.println("Nährwert fehlerhaft. Integer erwartet. Input war: " + kucheninformationen[3]);
            naehrwert = 0;
        }

        Duration haltbarkeit;
        try {
            haltbarkeit = Duration.parse(kucheninformationen[4]);
        } catch (DateTimeParseException e) {
            System.out.println("Haltbarkeit fehlerhaft! Input war: " + kucheninformationen[4]);
            haltbarkeit = null;
        }

        Allergen allergen1;
        try {
            allergen1 = Allergen.valueOf(kucheninformationen[5]);
        } catch (IllegalArgumentException e) {
            System.out.println("Unbekanntes Allergen. Input war: " + kucheninformationen[5]);
            allergen1 = null;
        }

        if (kuchensorte.equals("Obstkuchen")) {
            String obstsorte = kucheninformationen[6];
            return new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, List.of(allergen1), obstsorte);
        } else if (kuchensorte.equals("Kremkuchen")) {
            String kremsorte = kucheninformationen[6];
            return new KremkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, List.of(allergen1), kremsorte);
        } else { // für Obsttorte
            String obstsorte = kucheninformationen[6];
            String kremsorte = kucheninformationen[7];
            return new ObsttorteImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, List.of(allergen1), obstsorte, kremsorte);
        }
    }*/


