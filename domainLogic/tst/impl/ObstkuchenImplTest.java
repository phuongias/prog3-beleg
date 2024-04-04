package impl;

import kuchen.Allergen;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ObstkuchenImplTest {

    @Test
    void getObstsorte() {
        String kuchensorte = "Obstkuchen";
        HerstellerImpl hersteller = new HerstellerImpl("TestHersteller");
        BigDecimal preis = BigDecimal.valueOf(10);
        int naehrwert = 100;
        Duration haltbarkeit = Duration.ofDays(7);
        List<Allergen> allergene = Arrays.asList(Allergen.Gluten);
        String kremsorte = "Schokolade";

        ObstkuchenImpl kremkuchen = new ObstkuchenImpl(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene, kremsorte);

        assertEquals(kremsorte, kremkuchen.getObstsorte());
    }
}