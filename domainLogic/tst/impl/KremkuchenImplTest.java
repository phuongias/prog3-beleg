package impl;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KremkuchenImplTest {

    @Test
    void getKremsorte() {

        String kuchensorte = "Kremkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String kremsorte = "Schokolade";

        KremkuchenImpl kremkuchen = new KremkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene, kremsorte);

        assertEquals(kremsorte, kremkuchen.getKremsorte());
    }
    }
