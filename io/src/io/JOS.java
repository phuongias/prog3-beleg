package io;

import automat.Automat;

import java.io.*;

//Geschäftslogik abespeichern/serilisieren

public class JOS {

    //private static final String FILE_PATH = "//Users/phuong/Documents/Programmierung3/belegProg3 (1)/networking";

    public JOS(){
    }

    //Quellen: https://www.youtube.com/watch?v=DfbFTVNfkeI
    public static boolean saveDL(Automat automat){
        /*File file = new File(FILE_PATH);*/
        try{
            FileOutputStream fileOutput = new FileOutputStream("Automat.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutput);
            out.writeObject(automat);
            out.close();
            fileOutput.close();
            System.out.println("Automat gespeichert.");
            return true;
        }catch (IOException e){
            System.err.println("Fehler beim Speichern des Automaten: " + e.getMessage());
            return false;
        }
    }

    public static Automat loadDL()throws ClassNotFoundException{
        try{
            Automat automat;
            FileInputStream fileInput = new FileInputStream("Automat.ser");
            ObjectInputStream in = new ObjectInputStream(fileInput);
            automat = (Automat) in.readObject();
            in.close();
            fileInput.close();
            System.out.println("Automat erfolgreich geladen.");
            return automat;
        }catch(IOException e){
            System.err.println("Fehler beim Laden des Automaten: " + e.getMessage());
            return null;
        }
    }
}
