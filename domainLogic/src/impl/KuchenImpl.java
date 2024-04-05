package impl;

import kuchen.*;
import verwaltung.Verkaufsobjekt;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public abstract class KuchenImpl implements Kuchen, Verkaufsobjekt, Serializable {
    private String kuchensorte;
    private HerstellerImpl hersteller;
    private List<Allergen> allergene;
    private int naehrwert;
    private Duration haltbarkeit;
    private BigDecimal preis;
    private int fachnummer;
    private Date inspektionsdatum;
    private Date einfuegedatum;


    public KuchenImpl(String kuchensorte, HerstellerImpl hersteller, BigDecimal preis, int naehrwert, Duration haltbarkeit, List<Allergen> allergene) {
        this.kuchensorte = kuchensorte;
        this.hersteller = hersteller;
        this.preis = preis;
        this.naehrwert = naehrwert;
        this.haltbarkeit = haltbarkeit;
        this.allergene = allergene;
        this.einfuegedatum = new Date();
    }


    public String getKuchensorte() {
        return kuchensorte;
    }



    public void setInspektionsdatum(Date inspektionsdatum) {
        this.inspektionsdatum = inspektionsdatum;
    }


    public void setFachnummer(int fachnummer) {
        this.fachnummer = fachnummer;
    }

    public HerstellerImpl getHersteller() {
        return hersteller;
    }


    @Override 
    public List<Allergen> getAllergene() {
        return allergene;
    }


    @Override
    public int getNaehrwert() {
        return naehrwert;
    }


    @Override
    public Duration getHaltbarkeit() {
        return haltbarkeit;
    }


    @Override
    public BigDecimal getPreis() {
        return preis;
    }

    @Override
    public Date getInspektionsdatum() {
        return inspektionsdatum;
    }

    @Override
    public int getFachnummer() {
        return fachnummer;
    }
}
