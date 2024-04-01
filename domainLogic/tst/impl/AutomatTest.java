package impl;

import kuchen.Kuchen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomatTest {
    @Test
    void getBelegteFaecher() {
        
    }

    @Test
    void isFull() {
    }

    @Test
    void addHersteller() {
    }

    @Test
    void deleteHersteller() {
    }

    @Test
    void addKuchen() {
    }

    @Test
    void getKuchenHashMap() {
    }

    @Test
    void getHerstellerListe() {
    }

    @Test
    void deleteKuchenById() {
    }

    @Test
    void updateInspektiosdatum() {
    }

    @Test
    void getHerstellerUndKuchenanzahl() {
    }

    @Test
    void setKuchenHashMap() {
    }

    @Test
    void setHerstellerListe() {
    }

    @Test
    void showAllergenList() {
    }

   /* void testAddKuchenWhenCapacityIsFull() {
        Automat kuchenautomat = new Automat(1); //Maxkapazität selber auf 1 gesetzt
        KuchenImpl erdbeerkuchen = new KuchenImpl("Erdbeerkuchen");
        KuchenImpl bananenkuchen = new KuchenImpl("Bananenkuchen");
        HerstellerImpl obstHersteller = new HerstellerImpl("Obsthersteller");

        erdbeerkuchen.setHersteller(obstHersteller);
        bananenkuchen.setHersteller(obstHersteller);
        kuchenautomat.addHersteller(obstHersteller);

        kuchenautomat.addKuchen(bananenkuchen);

        boolean hinzugefuegt = kuchenautomat.addKuchen(erdbeerkuchen);
        assertFalse(hinzugefuegt, "Das Einfügen ist fehlschlagen, weil die Kapazitaet zu voll ist!");
    }*/

    /*void testAddKuchenIfHerstellerIsNotOnTheList() {
        Automat kuchenautomat = new Automat(2);
        KuchenImpl erdbeerkuchen = new KuchenImpl("Erdbeerkuchen");
        HerstellerImpl obstHersteller = new HerstellerImpl("Obsthersteller");
        erdbeerkuchen.setHersteller(obstHersteller);

        boolean hinzugefuegt = kuchenautomat.addKuchen(erdbeerkuchen);
        assertFalse(hinzugefuegt, "Das Einfügen hat nicht geklappt, weil Hersteller nicht auf der Liste ist.");
    }*/

    /* void testKuchen() {
        Automat kuchenautomat = new Automat(1); //Maxkapazität selber gesetzt auf 1
        KuchenImpl erdbeerkuchen = new KuchenImpl("Erdbeerkuchen");
        HerstellerImpl obstHersteller = new HerstellerImpl("Obsthersteller");
        erdbeerkuchen.setHersteller(obstHersteller);

        kuchenautomat.addHersteller(obstHersteller);

        boolean hinzugefuegt = kuchenautomat.addKuchen(erdbeerkuchen);
        assertTrue(hinzugefuegt);
        assertEquals(1, 1);
    }*/





}