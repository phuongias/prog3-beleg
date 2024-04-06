package impl;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObsttorteImplTest {
    //ObsttorteImpl klasse  wird getestet

    @Test
    void getKremsorte() {

        String kuchensorte = "Obsttorte";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String obstsorte = "Apfel";
        String kremsorte = "Schokolade";

        ObsttorteImpl obsttorte = new ObsttorteImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,obstsorte,kremsorte);

        assertEquals(kremsorte, obsttorte.getKremsorte());
    }

    @Test
    void getObstsorte() {
        String kuchensorte = "Obsttorte";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String obstsorte = "Apfel";
        String kremsorte = "Schokolade";

        ObsttorteImpl obsttorte = new ObsttorteImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene,obstsorte,kremsorte);

        assertEquals(obstsorte, obsttorte.getObstsorte());
    }
}