package dekorationsmuster;

import impl.HerstellerImpl;
import kuchen.Allergen;
import kuchen.Kuchen;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;

public class DekorationsKuchen {
    private KuchenBoden kuchenBoden;
    private Set<Belag> belaege;

    private List<Allergen> allergenList;

    private HerstellerImpl hersteller;
    private Integer fachnummer;
    private Integer naehrwert;
    private Date inspektionsdatum;
    private Duration haltbarkeit;


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
            for (Allergen allergen : belag.getAllergene()) {
                if (!allergene.contains(allergen)) {
                    allergene.add(allergen);
                }
            }
        }

        return allergene;
    }

    public Integer gesamtNaehrwert() {
        return naehrwert;
    }


    public HerstellerImpl getHersteller() {
        return hersteller;
    }


    public Duration getHaltbarkeit() {
        return haltbarkeit;
    }

    public void setFachnummer(int fachnummer) {
        this.fachnummer = fachnummer;
    }

    public void setInspektionsdatum(Date newInspektionsdatum) {
        this.inspektionsdatum = newInspektionsdatum;
    }


    public int getFachnummer() {
        return fachnummer;
    }

    public Date getInspektionsdatum() {
        return inspektionsdatum;
    }
}