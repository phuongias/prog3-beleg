package impl;

import verwaltung.Verkaufsobjekt;

import java.math.BigDecimal;
import java.util.Date;

public class VerkaufsobjektImpl implements Verkaufsobjekt {
    private BigDecimal preis;
    private Date inspektionsdatum;
    private int fachnummer;

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


    public void setPreis(BigDecimal newPreis) {
        this.preis = newPreis;
    }

    public void setInspektionsdatum(Date newDatum) {
        this.inspektionsdatum = newDatum;
    }

    public void setFachnummer(int newFachnummer) {
        this.fachnummer = newFachnummer;
    }
}
