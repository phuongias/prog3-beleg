
import eventPattern.cakeHandler.CakeAddEventHandler;
import eventPattern.cakeHandler.CakeDeleteEventHandler;
import eventPattern.cakeHandler.CakeReadEventHandler;
import eventPattern.cakeHandler.CakeUpdateEventHandler;
import eventPattern.cakeListener.CakeAddEventListener;
import eventPattern.cakeListener.CakeDeleteEventListener;
import eventPattern.cakeListener.CakeReadEventListener;
import eventPattern.cakeListener.CakeUpdateEventListener;
import impl.Automat;
import server.TCPServer;

import java.io.IOException;
//import server.TCPServer;

public class TCPServerMain {
    public static void main(String[] args) throws Exception {


      /*  EventHandler handler = new EventHandler();
        Automat automat = new Automat(20);
        handler.addListener(new EventListener(automat));

        TCPServer server = new TCPServer(automat);
        server.start();*/

        /*EventHandler handler = new EventHandler();
        Automat automat = new Automat(20);
        handler.addListener(new EventListener(automat));

        Controller controller = new Controller();
        TCPServer server = new TCPServer(automat, controller);
        server.start();*/

        if (args.length > 0) {
            int maxkapzitaet = Integer.parseInt(args[0]);
            Automat automat = new Automat(maxkapzitaet);

            TCPServer server = new TCPServer(4177, automat);

            //Add
            CakeAddEventHandler cakeAddEventHandler = new CakeAddEventHandler();
            server.setCakeAddEventHandler(cakeAddEventHandler);
            CakeAddEventListener cakeAddEventListener = new CakeAddEventListener(automat);
            cakeAddEventHandler.addListener(cakeAddEventListener);

            //Read
            CakeReadEventHandler cakeReadEventHandler = new CakeReadEventHandler();
            server.setCakeReadEventHandler(cakeReadEventHandler);
            CakeReadEventListener cakeReadEventListener = new CakeReadEventListener(automat);
            cakeReadEventHandler.addListener(cakeReadEventListener);

            //Update
            CakeUpdateEventHandler cakeUpdateEventHandler = new CakeUpdateEventHandler();
            server.setCakeUpdateEventHandler(cakeUpdateEventHandler);
            CakeUpdateEventListener cakeUpdateEventListener = new CakeUpdateEventListener(automat);
            cakeUpdateEventHandler.addListener(cakeUpdateEventListener);

            //Delete
            CakeDeleteEventHandler cakeDeleteEventHandler = new CakeDeleteEventHandler();
            server.setCakeDeleteEventHandler(cakeDeleteEventHandler);
            CakeDeleteEventListener cakeDeleteEventListener = new CakeDeleteEventListener(automat);
            cakeDeleteEventHandler.addListener(cakeDeleteEventListener);

            server.run();

        }

    }
}

