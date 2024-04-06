package eventPattern.persistenzListener;

import automat.Automat;
import eventPattern.persistentEvent.LoadJosPersistenzEvent;
import io.JOS;

public class LoadJosPersistenzEventListener {

    private Automat automat;
    JOS jos = new JOS();

    public LoadJosPersistenzEventListener(Automat automat) {
        this.automat = automat;
    }


    public void onEvent(LoadJosPersistenzEvent event) {

        Automat loadedAutomat = null;
        try {
            loadedAutomat = jos.loadDL();
        } catch (ClassNotFoundException e) {
            System.out.println("Automat konnte nicht geladen werden.");
            throw new RuntimeException(e);
        }

        System.out.println(loadedAutomat.getKuchenHashMap());

    }
}
