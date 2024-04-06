package simulation2;

import automat.Automat;
import simulation1.AddThread;
import simulation1.DeleteThread;

import java.util.List;

public class Simulation2 {

    public static void start(int n, Automat automat, List<String> kuchenList) {
        for (int i = 0; i < n; i++) {
            Thread addThread = new Thread(new AddThread(automat, kuchenList));
            Thread deleteThread = new Thread(new DeleteThread(automat));
            addThread.start();
            deleteThread.start();
        }

    }
}
