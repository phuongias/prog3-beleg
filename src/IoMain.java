
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

        if(args.length > 0){
            int maxkapaziaet = Integer.parseInt(args[0]);
            Automat automat = new Automat(maxkapaziaet);

            automat.addKuchen("Obstkuchen hi 10.99 3294 PT12H Erdnuss Apfel");

            JOS.saveDL(automat);
            Automat loadedAutomat = JOS.loadDL();
            System.out.println(loadedAutomat.getKuchenHashMap());
        }
    }

    }

