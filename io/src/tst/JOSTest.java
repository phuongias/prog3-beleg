package tst;

import impl.Automat;
import impl.HerstellerImpl;
import io.JOS;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class JOSTest {

    //JOS Klasse wird getestet
    //getestete Methoden : saveDL und loadDL


    //1 hier wird getestet ob die Kapazitaeten vom Automaten und der gespeicherten Datei gleich groß sind
    @Test
    void serilizationJosCapacity(){
        Automat automat = new Automat(10);
        automat.addHersteller(new HerstellerImpl("hi"));
        automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        JOS jos = new JOS();
        jos.saveDL(automat);


        try (FileInputStream input = new FileInputStream("Automat.ser");
             ObjectInputStream objectInput = new ObjectInputStream(input)) {
            Automat savedAutomat = (Automat) objectInput.readObject();

            assertEquals(automat.getMaxkapazitaet(), savedAutomat.getMaxkapazitaet());

        } catch (FileNotFoundException e) { //von intellij
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //2 getestet ob das serilisierte Objekt auch eine Instanz vom Automaten ist
    @Test
    void serilizationAutomat() throws FileNotFoundException {
        Automat automat = new Automat(10);
        automat.addHersteller(new HerstellerImpl("hi"));
        automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        JOS jos = new JOS();
        jos.saveDL(automat);


        File file = new File("Automat.ser");
        try (FileInputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Automat savedAutomat = (Automat) objectInputStream.readObject();

            assertNotNull(savedAutomat);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //3 Kapaziät ist gleich der geladeten Automaten
    @Test
    void deserializedAutomatCapacity() throws ClassNotFoundException {
        Automat automat = new Automat(10);
        automat.addHersteller(new HerstellerImpl("hi"));
        automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

        JOS jos = new JOS();
        jos.saveDL(automat);

        Automat deserializedAutomat = jos.loadDL();

        assertEquals(automat.getMaxkapazitaet(), deserializedAutomat.getMaxkapazitaet());


    }

}