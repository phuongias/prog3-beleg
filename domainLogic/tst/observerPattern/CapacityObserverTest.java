package observerPattern;

import impl.Automat;
import impl.KuchenImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;





class CapacityObserverTest {

    @Test
    void testUpdate_() {
        Automat automat = new Automat(1);
        CapacityObserver capacityObserver = new CapacityObserver(automat);

        String kuchen = "Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel";
        KuchenImpl result = automat.addKuchen(kuchen);







    }
}