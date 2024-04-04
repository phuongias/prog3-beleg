package impl;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KuchenImplTest {

    @Test
    void getKuchensorte() {

        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String add = "Apfel";

        KuchenImpl kuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,add);

        assertEquals("Obstkuchen", kuchen.getKuchensorte());
    }


    @Test
    void setInspektionsdatum() {
    }

    @Test
    void setFachnummer() {
    }

    @Test
    void getHersteller() {
        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String add = "Apfel";

        KuchenImpl kuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,add);

        assertEquals(new HerstellerImpl("TestHersteller"), kuchen.getHersteller());
    }

    @Test
    void getAllergene() {
        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String add = "Apfel";

        KuchenImpl kuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,add);

        assertEquals(List.of(Allergen.Gluten), kuchen.getAllergene());
    }

    @Test
    void getNaehrwert() {
        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String add = "Apfel";

        KuchenImpl kuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,add);

        assertEquals(100, kuchen.getNaehrwert());
    }

    @Test
    void getHaltbarkeit() {
        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String add = "Apfel";

        KuchenImpl kuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,add);

        assertEquals(Duration.ofDays(7), kuchen.getHaltbarkeit());
    }

    @Test
    void getPreis() {
        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(5);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String add = "Apfel";

        KuchenImpl kuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,add);

        assertEquals(BigDecimal.valueOf(5), kuchen.getPreis());
    }

    @Test
    void getInspektionsdatum() {

        Automat automat = new Automat(10);
        HerstellerImpl herstellerName = new HerstellerImpl("TestHersteller");
        automat.addHersteller(herstellerName);

        String kuchenInfo = "Obstkuchen TestHersteller 10.99 100 PT12H Gluten Apfel";
        String kuchenInfo2 = "Obstkuchen TestHersteller 10.99 100 PT12H Gluten Apfel";

        KuchenImpl kuchen = automat.addKuchen(kuchenInfo);
        KuchenImpl kuchen2 = automat.addKuchen(kuchenInfo2);



        assertEquals(0, kuchen.getFachnummer());
        assertEquals(1,kuchen2.getFachnummer());



    }

    @Test
    void getFachnummer() {
        Automat automat = new Automat(10);
        HerstellerImpl herstellerName = new HerstellerImpl("TestHersteller");
        automat.addHersteller(herstellerName);

        String kuchenInfo = "Obstkuchen TestHersteller 10.99 100 PT12H Gluten Apfel";
        String kuchenInfo2 = "Obstkuchen TestHersteller 10.99 100 PT12H Gluten Apfel";

        KuchenImpl kuchen = automat.addKuchen(kuchenInfo);
        KuchenImpl kuchen2 = automat.addKuchen(kuchenInfo2);



        assertEquals(0, kuchen.getFachnummer());
        assertEquals(1,kuchen2.getFachnummer());
    }
}