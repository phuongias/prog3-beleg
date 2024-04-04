package eventPattern.herstellerEvents;

public class HerstellerAddEvent {

    private Object source;
    private String herstellerName;

    public HerstellerAddEvent(Object source, String herstellerName) {
        this.source = source;
        this.herstellerName = herstellerName;
    }

    public Object getSource() {
        return source;
    }

    public String getHerstellerName() {

        return herstellerName;
    }

}
