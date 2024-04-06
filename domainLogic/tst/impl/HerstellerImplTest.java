package impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerstellerImplTest {

    //HerstellerImpl klasse wird getestet

    @Test
    public void testGetName() {
        String name = "Phuong";
        HerstellerImpl hersteller = new HerstellerImpl(name);
        assertEquals(name, hersteller.getName());
    }

    @Test
    public void testEquals() {
        HerstellerImpl hersteller1 = new HerstellerImpl("Hersteller1");
        HerstellerImpl hersteller2 = new HerstellerImpl("Hersteller1");
        HerstellerImpl hersteller3 = new HerstellerImpl("Hersteller2");

        assertTrue(hersteller1.equals(hersteller2));
        assertFalse(hersteller1.equals(hersteller3));
    }

    @Test
    public void testHashCode() {
        HerstellerImpl hersteller1 = new HerstellerImpl("Hersteller1");
        HerstellerImpl hersteller2 = new HerstellerImpl("Hersteller1");
        assertEquals(hersteller1.hashCode(), hersteller2.hashCode());
    }

    @Test
    public void testToString() {
        String name = "Hersteller";
        HerstellerImpl hersteller = new HerstellerImpl(name);
        assertEquals(name, hersteller.toString());
    }

    @Test
    public void testSetAnzahlKuchen() {
        HerstellerImpl hersteller = new HerstellerImpl("Hersteller");
        hersteller.setAnzahlKuchen(10);
        assertEquals(10, hersteller.getKuchenAnzahl());
    }

    @Test
    public void testGetKuchenAnzahl() {
        HerstellerImpl hersteller = new HerstellerImpl("Hersteller");
        hersteller.setAnzahlKuchen(10);
        assertEquals(10, hersteller.getKuchenAnzahl());
    }
}
