package eventPattern.cakeEvents;

public class CakeUpdateEvent {

    private  Object source;
    private int id;

    public CakeUpdateEvent(Object source, int id) {
        this.source = source;
        this.id = id;
    }

    public Object getSource() {
        return source;
    }

    public int getId() {
        return id;
    }
}

 