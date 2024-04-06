
import automat.Automat;
import io.JOS;

import java.io.*;

public class JOSIoMain implements Serializable {
    public static void main(String[] args) throws ClassNotFoundException {

            int maxkapaziaet = 5;
            Automat automat = new Automat(maxkapaziaet);

            automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

            System.out.println("Before: ");
            JOS.saveDL(automat);
            System.out.println(automat.getKuchenHashMap());

            System.out.println("After: ");
            Automat loadedAutomat = JOS.loadDL();
            System.out.println(loadedAutomat.getKuchenHashMap());
        }
    }


