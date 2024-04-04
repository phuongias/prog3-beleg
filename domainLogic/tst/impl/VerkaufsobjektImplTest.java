package impl;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VerkaufsobjektImplTest {

    @Test
    public void testGetPreis() {
        BigDecimal expectedPreis = BigDecimal.valueOf(10);
        VerkaufsobjektImpl verkaufsobjekt = new VerkaufsobjektImpl();
        verkaufsobjekt.setPreis(expectedPreis);
        assertEquals(expectedPreis, verkaufsobjekt.getPreis());
    }

    @Test
    public void testGetInspektionsdatum() {
        Date expectedInspektionsdatum = new Date();
        VerkaufsobjektImpl verkaufsobjekt = new VerkaufsobjektImpl();
        verkaufsobjekt.setInspektionsdatum(expectedInspektionsdatum);
        assertEquals(expectedInspektionsdatum, verkaufsobjekt.getInspektionsdatum());
    }

    @Test
    public void testGetFachnummer() {
        int expectedFachnummer = 1;
        VerkaufsobjektImpl verkaufsobjekt = new VerkaufsobjektImpl();

        verkaufsobjekt.setFachnummer(expectedFachnummer);
        assertEquals(expectedFachnummer, verkaufsobjekt.getFachnummer());
    }
}