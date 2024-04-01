package eventPattern.allergenListener;


import eventPattern.allergenEvent.AllergenVorhandenListEvent;
import impl.Automat;
import kuchen.Allergen;

import java.util.Collection;
import java.util.HashSet;

public class AllergenVorhandenListEventListener {

    Automat automat;

    public AllergenVorhandenListEventListener(Automat automat) {
        this.automat = automat;
    }

    public void onEvent(AllergenVorhandenListEvent event) {

        Collection<Allergen> allergensInKuchen = automat.showAllergenList(event.getKuchenHashMap());

        System.out.println("Vorhandene Allergene:");
        for (Allergen allergen : Allergen.values()) {
            if (allergensInKuchen.contains(allergen)) {
                System.out.println(allergen);
            }
        }
    }

}

