package eventPattern.allergenListener;

import eventPattern.allergenEvent.AllergenNichtVorhandenListEvent;
import impl.Automat;
import kuchen.Allergen;

import java.util.Collection;

public class AllergenNichtVorhandenListEventListener {

    Automat automat;

    public AllergenNichtVorhandenListEventListener(Automat automat) {
        this.automat = automat;
    }

    public void onEvent(AllergenNichtVorhandenListEvent event) {

        Collection<Allergen> allergensInKuchen = automat.getAllergenList(event.getKuchenHashMap());

        if (allergensInKuchen.isEmpty()) {
            System.out.println("Keine Allergene vorhanden.");
        }

        System.out.println("Nicht enthaltene Allergene:");
        for (Allergen allergen : Allergen.values()) {
            if (!allergensInKuchen.contains(allergen)) {
                System.out.println(allergen);
            }
        }

    }


}
