package eventPattern.persistentEvent;

public class LoadJosPersistenzEvent {
    private Object source;

    public LoadJosPersistenzEvent(Object source) {
        this.source = source;

    }

    public Object getSource() {
        return source;
    }
}
