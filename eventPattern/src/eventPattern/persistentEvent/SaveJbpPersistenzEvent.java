package eventPattern.persistentEvent;

public class SaveJbpPersistenzEvent {
    private Object source;

    public SaveJbpPersistenzEvent(Object source) {
        this.source = source;

    }

    public Object getSource() {
        return source;
    }
}
