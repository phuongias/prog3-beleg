/*package observerPattern;*/

import automat.Automat;
import kuchen.Allergen;

import java.util.HashSet;


/*
public class AllergenObserver implements Observer {

    private Automat automat;
    private HashSet<Allergen> previousAllergenList;

    public AllergenObserver(Automat automat) {
        this.automat = automat;
        this.previousAllergenList = automat.getAllergenListe();
        this.automat.register(this);
    }


    @Override
    public void update() {
        HashSet<Allergen> currentAllergenList = new HashSet<>(automat.getAllergenListe());

        //gucken ob Allergenliste sich geändert hat
        if (!currentAllergenList.equals(previousAllergenList)) {
            System.out.println("Allergenliste wurde aktualisiert:");
            System.out.println("Vorherige Allergene: " + previousAllergenList);
            System.out.println("Aktuelle Allergene: " + currentAllergenList);
            System.out.println();

            //vorherige Allergenliste aktualisieren
            previousAllergenList = currentAllergenList;
        }
    }

}

*/
