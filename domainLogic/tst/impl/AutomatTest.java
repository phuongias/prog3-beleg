package impl;

import kuchen.Allergen;
import kuchen.Kuchen;
import observerPattern.CapacityObserver;
import observerPattern.Observable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AutomatTest {

    //Automaten Klasse wird getestet


    @Test
    void getBelegteFaecher() {

        Automat automat = new Automat(10); // Beispiel: Automat mit Kapazität 10
        HashMap<Integer, KuchenImpl> kuchenHashMap = automat.getKuchenHashMap();
        automat.addHersteller(new HerstellerImpl("hi"));

        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";
        String kuchen2 = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Birne";


        KuchenImpl result = automat.addKuchen(kuchen);
        KuchenImpl result2 = automat.addKuchen(kuchen2);

        assertEquals(2, automat.getBelegteFaecher());

    }

    @Test
    void getNaechstFreieFachnummer() {

        Automat automat = new Automat(10); // Beispiel: Automat mit Kapazität 10
        HashMap<Integer, KuchenImpl> kuchenHashMap = automat.getKuchenHashMap();
        automat.addHersteller(new HerstellerImpl("hi"));

        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";
        String kuchen2 = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Birne";


        KuchenImpl result = automat.addKuchen(kuchen);
        KuchenImpl result2 = automat.addKuchen(kuchen2);

        assertEquals(2, automat.getNaechstFreieFachnummer());
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

        Automat automat = new Automat(10);

        HerstellerImpl hersteller1 = new HerstellerImpl("Hersteller1");
        HerstellerImpl hersteller2 = new HerstellerImpl("Hersteller2");

        automat.addHersteller(hersteller1);
        automat.addHersteller(hersteller2);

        assertTrue(automat.checkHerstellerVorhanden(hersteller1));
        assertTrue(automat.checkHerstellerVorhanden(hersteller2));


        HerstellerImpl nichtVorhandenerHersteller = new HerstellerImpl("Nicht vorhandener Hersteller");
        assertFalse(automat.checkHerstellerVorhanden(nichtVorhandenerHersteller));


    }

    @Test
    void getHerstellerListe() {

        Automat automat = new Automat(10);

        HerstellerImpl hersteller1 = new HerstellerImpl("Hersteller1");
        HerstellerImpl hersteller2 = new HerstellerImpl("Hersteller2");

        automat.addHersteller(hersteller1);
        automat.addHersteller(hersteller2);

        ArrayList<HerstellerImpl> herstellerListe = automat.getHerstellerListe();

        assertEquals(2, herstellerListe.size());
        assertTrue(herstellerListe.contains(hersteller1));
        assertTrue(herstellerListe.contains(hersteller2));
        assertEquals(2, herstellerListe.size());


    }

    @Test
    void addHersteller_shouldSucessful_whenHerstellerNochNichtVorhanden() {
        Automat automat = new Automat(10);
        HerstellerImpl hersteller = new HerstellerImpl("hi");

        boolean result = automat.addHersteller(hersteller);

        assertTrue(result);
        assertEquals(1, automat.getHerstellerListe().size());
        assertTrue(automat.getHerstellerListe().contains(hersteller));
    }

    @Test
    void addHersteller_shouldSucessfull_whenHerstellerNochNichtVorhanden_withMockito() {

        Automat automat = new Automat(10);
        HerstellerImpl herstellerMock = Mockito.mock(HerstellerImpl.class);
        assertTrue(automat.addHersteller(herstellerMock));
    }


    @Test
    void deleteHersteller_shouldSucessful_whenHerstellerIsThere() {
        Automat automat = new Automat(10);
        HerstellerImpl hersteller = new HerstellerImpl("hi");
        automat.addHersteller(hersteller);

        HerstellerImpl result = automat.deleteHersteller(hersteller);

        assertNotNull(result);
        assertEquals(0, automat.getHerstellerListe().size());
        assertFalse(automat.getHerstellerListe().contains(hersteller));
    }

    @Test
    void deleteHersteller_shouldSuccessful_whenHerstellerIsThere_withMockito() {
        Automat automat = new Automat(10);
        HerstellerImpl herstellerMock = Mockito.mock(HerstellerImpl.class);
        HerstellerImpl herstellerMock2 = Mockito.mock(HerstellerImpl.class);

        HerstellerImpl hersteller = automat.deleteHersteller(herstellerMock);

        assertFalse(automat.getHerstellerListe().contains(herstellerMock2));

    }

    @Test
    void deleteHersteller_shouldThrowError_whenThereIsNoHersteller_withMockito() {
        Automat automat = new Automat(10);
        HerstellerImpl herstellerMock = Mockito.mock(HerstellerImpl.class);
        HerstellerImpl hersteller = automat.deleteHersteller(herstellerMock);
        assertFalse(automat.getHerstellerListe().contains(hersteller));
    }


    @Test
    void deleteHersteller_withSpy() {

        HerstellerImpl herstellerSpy = spy(new HerstellerImpl("herstellerSpy"));

        Automat spyAutomat = spy(new Automat(10));
        spyAutomat.addHersteller(herstellerSpy);

        // Verify that the Hersteller is no longer in the vending machine
        assertFalse(spyAutomat.getHerstellerListe().contains(spyAutomat));
    }

//test addkuchen

    @Test
    void addKuchen_shouldSuccessfully_whenValidKuchen() {
        Automat automat = new Automat(10);
        automat.addHersteller(new HerstellerImpl("hi"));
        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";

        KuchenImpl result = automat.addKuchen(kuchen);

        assertNotNull(result);
        assertEquals(1, automat.getBelegteFaecher());
        assertTrue(automat.getKuchenHashMap().containsValue(result));
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

        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(5);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String add = "Apfel";

        KuchenImpl kuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene, add);
        kuchen.setFachnummer(1);
        boolean result = automat.deleteKuchenById(kuchen.getFachnummer());

        assertFalse(result);
        assertEquals(0, automat.getBelegteFaecher());
        assertFalse(automat.getKuchenHashMap().containsValue(kuchen));
    }


    @Test
    void deleteKuchenById_shouldSuccessful_whenKuchenInAutomat() {

        Automat automat = new Automat(10);
        automat.addHersteller(new HerstellerImpl("hi"));

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
        HerstellerImpl hersteller = new HerstellerImpl("hi");
        automat.addHersteller(hersteller);
        KuchenImpl kuchen = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        boolean result = automat.updateInspektiosdatum(kuchen.getFachnummer());

        assertTrue(result);
        assertNotEquals(new Date(), kuchen.getInspektionsdatum());
    }


    @Test
    void getHerstellerUndKuchenanzahl_shouldSuccessful() {

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
    void getHerstellerUndKuchenanzahl_withMockito() {
        Automat automat = new Automat(10);
        HerstellerImpl herstellerMock = new HerstellerImpl("herstellerMock");
        automat.addHersteller(herstellerMock);

        KuchenImpl kuchenMock = Mockito.mock(KuchenImpl.class);

        when(kuchenMock.getHersteller()).thenReturn(herstellerMock);

        automat.getKuchenHashMap().put(0, kuchenMock);

        HashMap<HerstellerImpl, Integer> herstellerUndKuchenanzahl = automat.getHerstellerUndKuchenanzahl();


        assertEquals(1, herstellerUndKuchenanzahl.get(herstellerMock));
    }


    @Test
    void getAllergenList() {

        Automat automat = new Automat(10);
        HerstellerImpl hersteller = new HerstellerImpl("hi");
        automat.addHersteller(hersteller);

        KuchenImpl kuchen1 = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Gluten Apfel");
        KuchenImpl kuchen2 = automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Birne");

        Collection<Allergen> result = automat.getAllergenList(automat.getKuchenHashMap());

        assertEquals(Set.of(Allergen.Gluten, Allergen.Erdnuss), result);
        assertEquals(2, 2);

    }


    @Test
    void register() {
        Automat observable = new Automat(10);
        CapacityObserver observer = new CapacityObserver(observable);
        assertTrue(observable.register(observer));


    }

    @Test
    void unregister() {
        Automat observable = new Automat(10);
        CapacityObserver observer = new CapacityObserver(observable);

        assertTrue(observable.unregister(observer));


    }

    @Test
    void notifyObserver() {
        Automat observable = new Automat(10);
        CapacityObserver mockObserver = mock(CapacityObserver.class);

        assertTrue(observable.register(mockObserver));
        observable.notifyObserver();
        verify(mockObserver, times(1)).update();

    }


}