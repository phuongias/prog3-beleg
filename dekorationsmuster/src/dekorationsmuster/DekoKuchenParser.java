package dekorationsmuster;

import impl.HerstellerImpl;
import kuchen.Allergen;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DekoKuchenParser {

    public static DekorationsKuchen parseDekoKuchenInfo(String kuchen) throws IllegalArgumentException {

        String[] kucheninformationen = kuchen.split(" ");
        KuchenBoden muerteig = new KuchenBoden("Muerteig", Duration.parse("PT12H"), List.of(Allergen.Gluten), BigDecimal.valueOf(3849), BigDecimal.valueOf(10));
        KuchenBoden hefeteig = new KuchenBoden("Hefeteig", Duration.parse("PT12H"), List.of(Allergen.Gluten), BigDecimal.valueOf(2445), BigDecimal.valueOf(12));

        Belag apfelBelag = new Belag("Apfel", Duration.ofDays(7), List.of(Allergen.Fructose), BigDecimal.valueOf(50), BigDecimal.valueOf(2.5));
        Belag birnenBelag = new Belag("Birne", Duration.ofDays(5), List.of(Allergen.Fructose), BigDecimal.valueOf(40), BigDecimal.valueOf(2));
        Belag kirschBelag = new Belag("Kirsche", Duration.ofDays(6), List.of(Allergen.Fructose), BigDecimal.valueOf(45), BigDecimal.valueOf(3));
        Belag sahneBelag = new Belag("Sahne", Duration.ofDays(3), List.of(Allergen.Laktose), BigDecimal.valueOf(30), BigDecimal.valueOf(1.5));
        Belag puddingBelag = new Belag("Pudding", Duration.ofDays(4), List.of(Allergen.Laktose, Allergen.Gluten), BigDecimal.valueOf(60), BigDecimal.valueOf(2));


        if (kucheninformationen.length < 2) {
            throw new IllegalArgumentException("Fehlende Kucheninformationen!");
        }

        String kuchenBoden = kucheninformationen[0];
        String herstellerName = kucheninformationen[1];
        HerstellerImpl hersteller = new HerstellerImpl(herstellerName);


        Set<Belag> belaege = new HashSet<>();

        if (kucheninformationen.length > 2 && kucheninformationen.length < 8) {
            for (int i = 2; i < kucheninformationen.length; i++) {
                if (kucheninformationen[i].equals("Apfel")) {
                    belaege.add(apfelBelag);
                }
                if(kucheninformationen[i].equals("Kirsche")){
                    belaege.add(kirschBelag);
                }
                if(kucheninformationen[i].equals("Birne")){
                    belaege.add(birnenBelag);
                }
                if(kucheninformationen[i].equals("Sahne")){
                    belaege.add(sahneBelag);
                }
                if(kucheninformationen[i].equals("Pudding")){
                    belaege.add(puddingBelag);
                }
            }
        }


        switch (kuchenBoden) {
            case "Muerteig":
                return new DekorationsKuchen(muerteig, hersteller, belaege);
            case "Hefeteig":
                return new DekorationsKuchen(hefeteig, hersteller, belaege);
            default:
                throw new IllegalArgumentException("Ungültiger Kuchenboden: " + kuchenBoden);
        }
    }
}
