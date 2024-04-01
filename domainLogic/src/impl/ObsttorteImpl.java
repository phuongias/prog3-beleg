package impl;

import kuchen.Allergen;
import kuchen.Obsttorte;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ObsttorteImpl extends KuchenImpl implements Obsttorte, Serializable {

    private String obstsorte;
    private String kremsorte;


    public ObsttorteImpl(String kuchensorte, HerstellerImpl hersteller, BigDecimal preis, int naehrwert, Duration haltbarkeit, List<Allergen> allergen1, String obstsorte, String kremsorte) {
        super(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergen1);
        this.obstsorte = obstsorte;
        this.kremsorte = kremsorte;

    }

    public String getKremsorte() {
        return kremsorte;
    }

    public String getObstsorte() {
        return obstsorte;
    }
}

