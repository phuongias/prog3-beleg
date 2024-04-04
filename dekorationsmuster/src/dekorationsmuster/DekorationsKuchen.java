package dekorationsmuster;

import impl.HerstellerImpl;
import kuchen.Allergen;
import kuchen.Kuchen;
import verwaltung.Hersteller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;

public class DekorationsKuchen implements Kuchen {
    private KuchenBoden kuchenBoden;
    private Set<Belag> belaege;

    private List<Allergen> allergenList;

    private HerstellerImpl hersteller;
    private Integer fachnummer;



    private double gesamtPreis;

    public DekorationsKuchen(KuchenBoden kuchenBoden, HerstellerImpl hersteller, Set<Belag> belaege) {
        this.kuchenBoden = kuchenBoden;
        this.hersteller = hersteller;
        this.belaege = belaege;
    }

    public KuchenBoden getKuchenBoden() {
        return kuchenBoden;
    }

    public Set<Belag> getBelaege() {
        return belaege;
    }

    public BigDecimal gesamtpreisBerechnen() {
        BigDecimal gesamtpreis = kuchenBoden.getPreis();
        for (Belag belag : belaege) {
            gesamtpreis = gesamtpreis.add(belag.getPreis());
        }
        return gesamtpreis;
    }

    public Duration minimaleHaltbarkeitBerechnen() {
        Duration minHaltbarkeit = kuchenBoden.getHaltbarkeit();
        for (Belag belag : belaege) {
            if (belag.getHaltbarkeit().compareTo(minHaltbarkeit) < 0) {
                minHaltbarkeit = belag.getHaltbarkeit();
            }
        }
        return minHaltbarkeit;
    }

    public List<Allergen> gesamtAllergene() {
        List<Allergen> allergene = new ArrayList<>(kuchenBoden.getAllergene());
        for (Belag belag : belaege) {
            allergene.addAll(belag.getAllergene());
        }
        return allergene;
    }

    @Override
    public HerstellerImpl getHersteller() {
        return hersteller;
    }

    @Override
    public Collection<Allergen> getAllergene() {
        return null;
    }

    @Override
    public int getNaehrwert() {
        return 0;
    }

    @Override
    public Duration getHaltbarkeit() {
        return null;
    }

    public void setFachnummer(int fachnummer) {
        this.fachnummer = fachnummer;
    }

    public void setInspektionsdatum(Date newInspektionsdatum) {
    }

    public double getGesamtPreis() {
        return gesamtPreis;
    }

    public int getFachnummer(){
        return fachnummer;
    }

}

