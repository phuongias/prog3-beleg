package impl;

import kuchen.Allergen;
import kuchen.Kuchen;
import kuchen.Obstkuchen;
import verwaltung.Hersteller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ObstkuchenImpl extends KuchenImpl implements Obstkuchen, Serializable {
    private String obstsorte;

    public ObstkuchenImpl(String kuchensorte, HerstellerImpl hersteller, BigDecimal preis, int naehrwert, Duration haltbarkeit, List<Allergen> allergen1, String obstsorte) {
        super(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergen1);
        this.obstsorte = obstsorte;
    }

    public String getObstsorte() {
        return obstsorte;
    }

}
