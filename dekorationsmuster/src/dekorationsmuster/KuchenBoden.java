package dekorationsmuster;

import java.time.Duration;
import kuchen.Allergen;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class KuchenBoden extends KuchenBestandteil {
    public KuchenBoden(String name, Duration haltbarkeit, List<Allergen> allergene, BigDecimal naehrwert, BigDecimal preis) {
        super(name, haltbarkeit, allergene, naehrwert, preis);
    }
}
    