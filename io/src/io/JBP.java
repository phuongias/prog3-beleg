package io;

import automat.Automat;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class JBP implements Serializable{


    //Serialisierung mit JBP
    //Quellen: https://openbook.rheinwerk-verlag.de/java8/07_010.html
    public static boolean saveJBP( Automat automat) throws IOException {

        try (FileOutputStream fileOutput = new FileOutputStream("Automat.jbp");
             XMLEncoder encoder = new XMLEncoder(fileOutput)) {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(automat);
            oos.flush();
            oos.close();
            encoder.writeObject(baos.toByteArray());

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Automat loadJBP() throws IOException {
        try (FileInputStream fileInput = new FileInputStream("Automat.jbp");
             XMLDecoder customerDecoder = new XMLDecoder(fileInput)) {

            byte[] serializedData = (byte[]) customerDecoder.readObject();
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
            ObjectInputStream ois = new ObjectInputStream(bais);

            try {
                return (Automat) ois.readObject(); // Erfolgreich geladen
            } catch (ClassNotFoundException e) {
                throw new IOException("Automat konnte nicht deserialisiert werden: " + e.getMessage());
            }
        } catch (IOException e) {
            throw new IOException("Fehler beim Laden des Automaten: " + e.getMessage());
        }
    }

}
