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
    void testIsFull_shouldThrowError_whenCapacityIsFull() {
        Automat automat = new Automat(1); //Maxkapazität auf 1 gesetzt

        automat.addHersteller(new HerstellerImpl("hi"));
        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";
        String kuchen2 = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Birne";

        KuchenImpl result = automat.addKuchen(kuchen);
        KuchenImpl result2 = automat.addKuchen(kuchen2);


        assertEquals(1, automat.getBelegteFaecher());
        assertFalse(automat.getKuchenHashMap().containsValue(result2));

    }

    @Test
    void getMaxkapazitaet() {
        Automat automat = new Automat(1);

        assertEquals(1, automat.getMaxkapazitaet());
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

        //assertNotNull(result);
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
        Automat kuchenautomat = new Automat(1);

        String kuchen1 = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";

        KuchenImpl result1 = kuchenautomat.addKuchen(kuchen1);

        assertEquals(0, kuchenautomat.getBelegteFaecher());
        assertFalse(kuchenautomat.getKuchenHashMap().containsValue(result1));

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
        Automat automat = new Automat(2);
        KuchenImpl kuchen = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        boolean result = automat.updateInspektiosdatum(kuchen.getFachnummer());

        //assertTrue(result);
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
        assertEquals(2, result.get(hersteller));
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


}