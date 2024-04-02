package impl;

import kuchen.Kuchen;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AutomatTest {
    @Test
    void getBelegteFaecher() {
    }

    @Test
    void isFull() {
    }

    @Test
    void getMaxkapazitaet() {
    }

    @Test
    void getKuchenHashMap() {
    }

    @Test
    void getHerstellerListe() {
    }


    //test hersteller

    @Test
    void testAddHersteller() {
        Automat automat = new Automat(10);
        HerstellerImpl hersteller = new HerstellerImpl("hi");

        boolean result = automat.addHersteller(hersteller);

        assertTrue(result);
        assertEquals(1, automat.getHerstellerListe().size());
        assertTrue(automat.getHerstellerListe().contains(hersteller));
    }

    @Test
    void testDeleteHersteller() {
        Automat automat = new Automat(10);
        HerstellerImpl hersteller = new HerstellerImpl("hi");
        automat.addHersteller(hersteller);

        HerstellerImpl result = automat.deleteHersteller(hersteller);

        assertNotNull(result);
        assertEquals(0, automat.getHerstellerListe().size());
        assertFalse(automat.getHerstellerListe().contains(hersteller));
    }

    //test addkuchen

    @Test
    void addKuchen_shouldSuccessfully_Add_whenValidKuchen() {
        Automat automat = new Automat(10);
        automat.addHersteller(new HerstellerImpl("hi"));
        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";

        KuchenImpl result = automat.addKuchen(kuchen);

        assertNotNull(result);
        assertEquals(1, automat.getBelegteFaecher());
        assertTrue(automat.getKuchenHashMap().containsValue(result));
    }

    @Test
    void addKuchen_shouldThrowError_whenInvalidKuchen() {
        Automat automat = new Automat(10);
        automat.addHersteller(new HerstellerImpl("hi"));
        String kuchen = "jaja hi 10.99 3294 PT12H Erdnuss Apfel";
        KuchenImpl result = automat.addKuchen(kuchen);

        assertNotNull(result);
        assertEquals(0, automat.getBelegteFaecher());
        assertFalse(automat.getKuchenHashMap().containsValue(result));

    }

    @Test
    void addKuchen_shouldNotAdd_whenAutomatIsFull() {
        Automat automat = new Automat(1);
        automat.addHersteller(new HerstellerImpl("hi"));
        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";
        String kuchen2 = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Birne";

        KuchenImpl result = automat.addKuchen(kuchen);
        KuchenImpl result2 = automat.addKuchen(kuchen2);

        assertNotNull(result);
        assertEquals(1, automat.getBelegteFaecher());
        assertFalse(automat.getKuchenHashMap().containsValue(result2));

    }

    @Test
    void addKuchen_shouldThrowError_whenNoHersteller() {

    }

    //test delete kuchen
    @Test
    void deleteKuchenById() {
        Automat automat = new Automat(10);

        KuchenImpl kuchen = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");


        boolean result = automat.deleteKuchenById(kuchen.getFachnummer());

        assertTrue(result);
        assertEquals(0, automat.getBelegteFaecher());
        assertFalse(automat.getKuchenHashMap().containsValue(kuchen));
    }

    //test update inspektionsdatum
    @Test
    void updateInspektiosdatum() {
        Automat automat = new Automat(10);
        KuchenImpl kuchen = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        boolean result = automat.updateInspektiosdatum(kuchen.getFachnummer());

        assertTrue(result);
        assertNotNull(kuchen.getInspektionsdatum());
        assertNotEquals(new Date(), kuchen.getInspektionsdatum());
    }

    @Test
    void getHerstellerUndKuchenanzahl() {

        Automat automat = new Automat(10);
        HerstellerImpl hersteller = new HerstellerImpl("hi");
        automat.addHersteller(hersteller);

        KuchenImpl kuchen1 = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");
        KuchenImpl kuchen2 = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Birne");

        HashMap<HerstellerImpl, Integer> result = automat.getHerstellerUndKuchenanzahl();

        assertTrue(result.containsKey(hersteller));
        assertEquals(2, (int) result.get(hersteller));
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


    @Test
    void getAllergenListe() {
    }


    @Test
    void register() {
    }

    @Test
    void unregister() {
    }

    @Test
    void notifyObserver() {
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