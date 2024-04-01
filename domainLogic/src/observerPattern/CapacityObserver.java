package observerPattern;

import impl.Automat;

public class CapacityObserver implements Observer {


    private Automat automat;
    private int contentSize;

    public CapacityObserver(Automat automat){
        this.automat = automat;
        this.contentSize = automat.getKuchenHashMap().size();
        this.automat.register(this);
    }

    @Override
    public void update() {
        if(automat.getKuchenHashMap().size() >= (automat.getMaxkapazitaet()*0.9)){
            System.out.println("The data base has reached 90% of its capacity!");
        }
        contentSize = automat.getKuchenHashMap().size();
    }
}
