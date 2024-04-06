package eventPattern.persistentEvent;

public class SaveJosPersistenzEvent {

    private Object source;

    public SaveJosPersistenzEvent(Object source) {
        this.source = source;

    }

    public Object getSource() {
        return source;
    }


}
