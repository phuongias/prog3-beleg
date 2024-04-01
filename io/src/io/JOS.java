package io;

import impl.Automat;

import java.io.*;

//Geschäftslogik abespeichern/serilisieren

public class JOS {

    public JOS(){
    }

    //Quellen: https://www.youtube.com/watch?v=DfbFTVNfkeI
    public static void saveDL(Automat automat){
        try{
            FileOutputStream fileOutput = new FileOutputStream("Automat.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutput);
            out.writeObject(automat);
            out.close();
            fileOutput.close();
        }catch (IOException e){
            throw new RuntimeException(e);
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
            return automat;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
