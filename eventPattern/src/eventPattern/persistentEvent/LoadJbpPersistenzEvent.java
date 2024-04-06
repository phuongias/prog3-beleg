package eventPattern.persistentEvent;

public class LoadJbpPersistenzEvent {
    private Object source;

    public LoadJbpPersistenzEvent(Object source) {
        this.source = source;

    }

    public Object getSource() {
        return source;
    }
}
