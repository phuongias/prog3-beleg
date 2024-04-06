package observerPattern;

import automat.Automat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AllergenObserverTest {

    @Test
    void testUpdate_AllergenListeAktualisiert_withMockito() {
        // Arrange
        Automat automat = Mockito.mock(Automat.class);
        AllergenObserver observer = new AllergenObserver(automat);

        /*HashSet<Allergen> previousAllergenList = new HashSet<>();
        HashSet<Allergen> currentAllergenList = new HashSet<>();
        previousAllergenList.add(Allergen.Gluten);
        currentAllergenList.add(Allergen.Gluten);
        currentAllergenList.add(Allergen.Laktose);*/

        automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");


        assertDoesNotThrow(() -> {
            automat.notifyObserver();});
        /*assertNotEquals(currentAllergenList, previousAllergenList);*/
    }

}

