import dekorationsmuster.Belag;
import dekorationsmuster.DekorationsKuchen;
import dekorationsmuster.DekorationsKuchenAutomat;
import dekorationsmuster.KuchenBoden;
import impl.Automat;
import impl.HerstellerImpl;

public class dekorotionskuchenMain {

    public static void main(String[] args) {


        DekorationsKuchenAutomat dekorationsKuchenAutomat = new DekorationsKuchenAutomat(10);

        dekorationsKuchenAutomat.addHersteller(new HerstellerImpl("hi"));
        String dekoKuchenString = "Muerteig hi Apfel Sahne";

        dekorationsKuchenAutomat.addDekoKuchen(dekoKuchenString);

        System.out.println(dekorationsKuchenAutomat.getKuchenHashMap().size());


    }
}

