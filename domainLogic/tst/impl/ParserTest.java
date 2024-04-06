package impl;

import kuchen.Allergen;
import observerPattern.Observable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    //Parser klasse wird getestet

    @Test
    public void testParseKuchenInfo_Obstkuchen() {
        String input = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";
        KuchenImpl kuchen = Parser.parseKuchenInfo(input);

        assertTrue(kuchen instanceof ObstkuchenImpl);

        assertEquals("Obstkuchen", kuchen.getKuchensorte());
        assertEquals("hi", kuchen.getHersteller().getName());
        assertEquals(10.99, kuchen.getPreis().doubleValue());
        assertEquals(3294, kuchen.getNaehrwert());
        assertEquals("PT12H", kuchen.getHaltbarkeit().toString());
        assertTrue(kuchen.getAllergene().contains(Allergen.Erdnuss));

        //assertTrue(kuchen.getObstsorte().contains("Apfel"));
    }

    @Test
    public void testParseKuchenInfo_Kremkuchen() {
        String kuchenInfo = "Kremkuchen hi 8.50 2700 PT10H Erdnuss Sahne";
        KuchenImpl kuchen = Parser.parseKuchenInfo(kuchenInfo);

        assertTrue(kuchen instanceof KremkuchenImpl);
        assertEquals("Kremkuchen", kuchen.getKuchensorte());
        assertEquals("hi", kuchen.getHersteller().getName());
        assertEquals(8.50, kuchen.getPreis().doubleValue());
        assertEquals(2700, kuchen.getNaehrwert());
        assertEquals("PT10H", kuchen.getHaltbarkeit().toString());
        assertTrue(kuchen.getAllergene().contains(Allergen.Erdnuss));
    }

    @Test
    public void testParseKuchenInfo_Obsttorte() {
        String input = "Obsttorte BaeckereiKruste 15.99 2500 PT15H Erdnuss Himbeere Sahne";
        KuchenImpl kuchen = Parser.parseKuchenInfo(input);
        assertTrue(kuchen instanceof ObsttorteImpl);
        assertEquals("Obsttorte", kuchen.getKuchensorte());
        assertEquals("BaeckereiKruste", kuchen.getHersteller().getName());
        assertEquals(15.99, kuchen.getPreis().doubleValue());
        assertEquals(2500, kuchen.getNaehrwert());
        assertEquals("PT15H", kuchen.getHaltbarkeit().toString());
        assertTrue(kuchen.getAllergene().contains(Allergen.Erdnuss));
    }

    @Test
    public void testParseKuchenInfo_InvalidInput() {
        String input = "InvalidInput"; //Ungültige Eingabe
        assertThrows(IllegalArgumentException.class, () -> {
            Parser.parseKuchenInfo(input);
        });
    }
}