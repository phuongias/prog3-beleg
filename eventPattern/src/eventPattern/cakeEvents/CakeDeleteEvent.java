package eventPattern.cakeEvents;

public class CakeDeleteEvent {
    private  Object source;
    private int id;

    public CakeDeleteEvent(Object source, int id) {
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
  