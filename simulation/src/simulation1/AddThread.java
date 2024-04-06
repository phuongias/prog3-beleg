package simulation1;

import automat.Automat;
import impl.KuchenImpl;

import java.util.List;


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class AddThread implements Runnable {
    private Automat automat;

    List<String> kuchenList;
    private Lock lock = new ReentrantLock();

    public AddThread(Automat automat, List kuchenList) {
        this.automat = automat;
        this.kuchenList = kuchenList;
    }

    //ein Kuchen von der randomKuchenliste wird zum Automaten hinzugefügt
    private void randomKuchenEinfuegen() {
        synchronized (automat) { //Quelle: https://stackoverflow.com/questions/1085709/what-does-synchronized-mean
            Random randomGenerator = new Random(); // Quelle: https://stackoverflow.com/questions/5034370/retrieving-a-random-item-from-arraylist
            int index = randomGenerator.nextInt(kuchenList.size());
            String kuchenInfo = kuchenList.get(index);

            KuchenImpl addedKuchen = automat.addKuchen(kuchenInfo);
            if (addedKuchen != null) {
                System.out.println(addedKuchen.getKuchensorte() + " wurde hinzugefügt");
            }
        }
    }


    public void run() {
        while (true) {
            this.lock.lock(); ////von StorageImpl -> und:
            // Quelle: https://stackoverflow.com/questions/11821801/why-use-a-reentrantlock-if-one-can-use-synchronizedthis
            //https://stackoverflow.com/questions/74150735/run-multiple-threads-in-sequence-using-locks

            //synchronized (automat) {
            try {
                /*while (automat.isFull()) { //wenn Automat voll ist, dann soll gewartet werden
                    Thread.sleep(0);
                }*/
                randomKuchenEinfuegen();
           /* } catch (InterruptedException e) {
                e.printStackTrace()*/
                ;
            } finally {
                lock.unlock();
            }


           /* try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


        }
    }

}


