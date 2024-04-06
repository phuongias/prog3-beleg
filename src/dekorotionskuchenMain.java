import dekoKuchenCli.DekoKuchenCli;
import dekorationsmuster.DekorationsKuchen;
import dekorationsmuster.DekorationsKuchenAutomat;
import impl.HerstellerImpl;

public class dekorotionskuchenMain {

    public static void main(String[] args) {


        DekorationsKuchenAutomat dekorationsKuchenAutomat = new DekorationsKuchenAutomat(10);

        dekorationsKuchenAutomat.addHersteller(new HerstellerImpl("hi"));
        String dekoKuchenString = "Muerteig hi Apfel Sahne";
        String dekoKuchenString2 = "Muerteig hi Apfel Sahne";

        DekorationsKuchen dekoKuchen2 = dekorationsKuchenAutomat.addDekoKuchen(dekoKuchenString2);

        DekorationsKuchen dekorationsKuchen = dekorationsKuchenAutomat.addDekoKuchen(dekoKuchenString);

        System.out.println(dekorationsKuchenAutomat.getKuchenHashMap().size());
        System.out.println(dekorationsKuchenAutomat.getHerstellerListe());

        System.out.println("Allergenliste von Kuchen1: " +dekorationsKuchen.gesamtAllergene());
        System.out.println("Preis von Kuchen 1: "+ dekorationsKuchen.gesamtpreisBerechnen());

        DekoKuchenCli cli = new DekoKuchenCli(dekorationsKuchenAutomat);
        cli.execute();



    }
}

