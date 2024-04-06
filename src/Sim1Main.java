import automat.Automat;
import simulation1.AddThread;
import simulation1.DeleteThread;
import impl.*;
import kuchen.Allergen;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Sim1Main {
    public static void main(String[] args) {
        //EventHandler handler = new EventHandler();
        Automat simulationsAutomat = new Automat(10);
        HerstellerImpl apfel = new HerstellerImpl("Apfel");
        HerstellerImpl hi = new HerstellerImpl("hi");
        simulationsAutomat.addHersteller(apfel);
        simulationsAutomat.addHersteller(hi);
        List<KuchenImpl> randomKuchenliste = new ArrayList<>();
        List<String> randomStringKuchenListe = new ArrayList<>();


        randomKuchenliste.add(new ObstkuchenImpl("Obstkuchen", apfel, new BigDecimal(10), 8923, null, List.of(Allergen.Erdnuss), "Apfel"));
        randomKuchenliste.add(new ObstkuchenImpl("Obstkuchen", apfel, new BigDecimal(10), 8923, null, List.of(Allergen.Erdnuss), "Apfel"));
        randomKuchenliste.add(new KremkuchenImpl("Kremkuchen", apfel, new BigDecimal(10), 8923, null, List.of(Allergen.Erdnuss), "Sahne"));
        randomKuchenliste.add(new ObsttorteImpl("Obsttorte", apfel, new BigDecimal(10), 8923, null, List.of(Allergen.Erdnuss), "Apfel", "Sahne"));
        randomKuchenliste.add(new ObsttorteImpl("Obsttorte", apfel, new BigDecimal(10), 8923, null, List.of(Allergen.Erdnuss), "Apfel", "Sahne"));

        randomStringKuchenListe.add("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");
        randomStringKuchenListe.add("Obsttorte hi 10.99 3294 PT12H Gluten Apfel, Sahne");
        randomStringKuchenListe.add("Kremkuchen hi 10.99 3294 PT12H Erdnuss Sahne");

        AddThread addThread = new AddThread(simulationsAutomat, randomStringKuchenListe);
        DeleteThread deleteThread = new DeleteThread(simulationsAutomat);

        Thread aThread = new Thread(addThread);
        Thread dThread = new Thread(deleteThread);

        dThread.start();
        aThread.start();


    }


}
