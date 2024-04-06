package eventPattern.cakeEvents;

import impl.KuchenImpl;

public class CakeAddEvent {
    private Object source;
    private String kuchenInfo;

    public CakeAddEvent(Object source, String kuchenInfo) {
        this.source = source;
        this.kuchenInfo = kuchenInfo;
    }

    public Object getSource() {
        return source;
    }

    public String getKuchenInfo() {
        return kuchenInfo;
    }
}
