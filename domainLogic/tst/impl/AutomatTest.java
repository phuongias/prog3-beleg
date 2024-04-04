package impl;

import kuchen.Kuchen;
import observerPattern.CapacityObserver;
import observerPattern.Observable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.HashMap;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;

class AutomatTest {
    @Test
    void getBelegteFaecher() {
    }

    @Test
    void getNaechstFreieFachnummer() {

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
        Automat automat = new Automat(1);

        HashMap<Integer, KuchenImpl> result = automat.getKuchenHashMap();
        HerstellerImpl hersteller = new HerstellerImpl("hi");
        automat.addHersteller(hersteller);

        automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        assertEquals(1, automat.getKuchenHashMap().size());
    }

    //test hersteller


    @Test
    void checkHerstellerVorhanden() {

    }

    @Test
    void getHerstellerListe() {
        Automat automat = new Automat(1);


    }

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
    void addKuchen_shouldSucessfully_whenHerstellerVorhanden_withMockito() {
        HerstellerImpl herstellerMock = Mockito.mock(HerstellerImpl.class);
        KuchenImpl kuchenMock = Mockito.mock(KuchenImpl.class);
        Mockito.when(kuchenMock.getHersteller()).thenReturn(herstellerMock);

        Automat automat = new Automat(2);
        KuchenImpl result = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        assertNull(result);

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

 /*   @Test
    void addKuchen_shouldNotAdd_whenAutomatFull_withMockito(){

        KuchenImpl kuchenMock = Mockito.mock(KuchenImpl.class);
        Automat automat = new Automat(1);
        automat.addHersteller(new HerstellerImpl("hi"));
        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";

        KuchenImpl result = automat.addKuchen(kuchenMock);

    }*/

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
    void deleteKuchenById_shouldThrowError_whenKuchenIsNotInAutomat() {
        Automat automat = new Automat(10);

        KuchenImpl kuchen = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");
        boolean result = automat.deleteKuchenById(kuchen.getFachnummer());

        assertFalse(result);
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

        CapacityObserver capacityObserver = new CapacityObserver(new Automat(1));



        
    }

    @Test
    void unregister() {
    }

    @Test
    void notifyObserver() {
    }


}