package observerPattern;

import automat.Automat;
import impl.HerstellerImpl;
import impl.KuchenImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class CapacityObserverTest {
    //CapacityObserver Klasse wird getestet

    @Test
    void testUpdate_shouldSuccessFull_whenIts90Percent() {
        Automat automat = new Automat(1);
        CapacityObserver capacityObserver = new CapacityObserver(automat);
        automat.addHersteller(new HerstellerImpl("hi"));

        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";
        KuchenImpl result = automat.addKuchen(kuchen);

        assertDoesNotThrow(() -> {automat.notifyObserver();});


    }
}