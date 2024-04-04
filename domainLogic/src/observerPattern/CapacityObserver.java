package observerPattern;

import impl.Automat;

import java.io.Serializable;

public class CapacityObserver implements Observer, Serializable {


    private Automat automat;
    private int kuchenHashMapSize;

    public CapacityObserver(Automat automat){
        this.automat = automat;
        this.kuchenHashMapSize = automat.getKuchenHashMap().size();
        this.automat.register(this);
    }

    @Override
    public void update() {
        if(automat.getKuchenHashMap().size() >= (automat.getMaxkapazitaet()*0.9)){
            System.out.println("The data base has reached 90% of its capacity!");
        }
        kuchenHashMapSize = automat.getKuchenHashMap().size();
    }
}
