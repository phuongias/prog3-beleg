package eventPattern.allergenListener;


import eventPattern.allergenEvent.AllergenVorhandenListEvent;
import automat.Automat;
import kuchen.Allergen;

import java.util.Collection;

public class AllergenVorhandenListEventListener {

    Automat automat;

    public AllergenVorhandenListEventListener(Automat automat) {
        this.automat = automat;
    }

    public void onEvent(AllergenVorhandenListEvent event) {

        Collection<Allergen> allergensInKuchen = automat.getAllergenList(event.getKuchenHashMap());

        System.out.println("Vorhandene Allergene:");
        for (Allergen allergen : Allergen.values()) {
            if (allergensInKuchen.contains(allergen)) {
                System.out.println(allergen);
            }
        }
    }

}

