package eventPattern.herstellerEvents;

import impl.HerstellerImpl;

public class HerstellerDeleteEvent {
    private Object source;
    private String herstellerName;



    public HerstellerDeleteEvent(Object source, String herstellerName) {
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
