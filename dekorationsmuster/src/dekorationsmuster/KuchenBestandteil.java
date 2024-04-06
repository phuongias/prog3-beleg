package dekorationsmuster;

import kuchen.Allergen;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public abstract class KuchenBestandteil {
    protected String name;
    protected java.time.Duration haltbarkeit;
    protected List<Allergen> allergene;
    protected BigDecimal naehrwert;
    protected BigDecimal preis;

    // Konstruktor
    public KuchenBestandteil(String name, Duration haltbarkeit, List<Allergen> allergene, BigDecimal naehrwert, BigDecimal preis) {
        this.name = name;
        this.haltbarkeit = haltbarkeit;
        this.allergene = allergene;
        this.naehrwert = naehrwert;
        this.preis = preis;
    }

    // Getter-Methoden
    public String getName() {
        return name;
    }

    public java.time.Duration getHaltbarkeit() {
        return haltbarkeit;
    }

    public List<Allergen> getAllergene() {
        return allergene;
    }

    public BigDecimal getNaehrwert() {
        return naehrwert;
    }

    public BigDecimal getPreis() {
        return preis;
    }
    }
