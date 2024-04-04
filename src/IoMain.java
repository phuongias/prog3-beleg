
import impl.*;
import io.JOS;
import kuchen.Allergen;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IoMain implements Serializable {
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


