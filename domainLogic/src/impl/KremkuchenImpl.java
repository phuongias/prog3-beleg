package impl;

import kuchen.Allergen;
import kuchen.Kremkuchen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class KremkuchenImpl extends KuchenImpl implements Kremkuchen, Serializable {

    String kremsorte;


    public KremkuchenImpl(String kuchensorte, HerstellerImpl hersteller, BigDecimal preis, int naehrwert, Duration haltbarkeit, List<Allergen> allergene, String kremsorte) {
        super(kuchensorte, hersteller, preis, naehrwert, haltbarkeit, allergene);
        this.kremsorte = kremsorte;
    }

    public String getKremsorte() {
        return kremsorte;
    }

}