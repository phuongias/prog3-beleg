package simulation1;

import impl.Automat;
import impl.KuchenImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeleteThread implements Runnable {
    private Automat automat;
    private Lock lock = new ReentrantLock();

    public DeleteThread(Automat automat) { //Konstrukor
        this.automat = automat;
    }

    //löscht random Kuchen aus dem Automaten
    private void randomKuchenLoeschen() {
        synchronized (automat) { //um den Automaten zu synchronisieren
            List<Integer> keys = new ArrayList<>(automat.getKuchenHashMap().keySet()); //nur die keys von der hashmap -> müssen immer synchronisiert werden durch stetigen die Veränderungen

            if (!keys.isEmpty()) { //nur wenn Automat nicht leer ist, ist das entfernen möglich
                Random randomGenerator = new Random(); // Quelle: https://stackoverflow.com/questions/5034370/retrieving-a-random-item-from-arraylist
                int keyToRemove = keys.get(randomGenerator.nextInt(keys.size())); //wählt random Index von der keys-Liste

                if (automat.getKuchenHashMap().containsKey(keyToRemove)) { //nur wenn der key in der Hashmap vorhanden ist, kann an dieser Stelle gelöscht werden
                    KuchenImpl kuchen = automat.getKuchenHashMap().get(keyToRemove);
                    boolean deletedKuchen = automat.deleteKuchenById(keyToRemove);
                    if (deletedKuchen) {
                        System.out.println(kuchen.getKuchensorte() + " wurde entfernt.");
                    }
                }
            }
        }
    }


    public void run() {
        while (true) { //Schleife soll unendlich lang laufen
            this.lock.lock(); //von StorageImpl -> und Quelle: https://stackoverflow.com/questions/11821801/why-use-a-reentrantlock-if-one-can-use-synchronizedthis
            //wird gelockt, damit der bereich geschützt wird -> kritischer Abschnitt

            try {
                /*while (automat.getKuchenHashMap().isEmpty()) { //wenn der Automat leer ist, soll gewartet werden
                    Thread.sleep(0);
                }*/
                //synchronized (automat) {

                randomKuchenLoeschen();

            } finally {
                lock.unlock();
            }


            /*try { //pausiert den Thread, um 1s
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        }
    }
}





