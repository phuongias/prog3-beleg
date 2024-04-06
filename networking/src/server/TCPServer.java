package server;

import eventPattern.cakeEvents.CakeAddEvent;
import eventPattern.cakeEvents.CakeDeleteEvent;
import eventPattern.cakeEvents.CakeReadEvent;
import eventPattern.cakeEvents.CakeUpdateEvent;
import eventPattern.cakeHandler.CakeAddEventHandler;
import eventPattern.cakeHandler.CakeDeleteEventHandler;
import eventPattern.cakeHandler.CakeReadEventHandler;
import eventPattern.cakeHandler.CakeUpdateEventHandler;
import automat.Automat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private Automat automat;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    private CakeAddEventHandler cakeAddEventHandler;
    private CakeDeleteEventHandler cakeDeleteEventHandler;
    private CakeReadEventHandler cakeReadEventHandler;
    private CakeUpdateEventHandler cakeUpdateEventHandler;

    public TCPServer(int port, Automat automat) throws IOException {
        this.automat = automat;
        this.serverSocket = new ServerSocket(port);
        this.clientSocket = serverSocket.accept();
        System.out.println("Verbindung hergestellt!");

        in = new ObjectInputStream(clientSocket.getInputStream());
        out = new ObjectOutputStream(clientSocket.getOutputStream());
    }

    private void readSign() throws IOException, ClassNotFoundException {
        char sign = this.in.readChar();
        Object event = this.in.readObject();

        switch (sign) {
            case 'c':
                if (cakeAddEventHandler != null) {
                    cakeAddEventHandler.handle((CakeAddEvent) event);
                }
                break;
            case 'd':
                if (cakeDeleteEventHandler != null) {
                    cakeDeleteEventHandler.handle((CakeDeleteEvent) event);
                }
                break;
            case 'u':
                if (cakeUpdateEventHandler != null) {
                    cakeUpdateEventHandler.handle((CakeUpdateEvent) event);
                }
                break;
            case 'r':
                if (cakeReadEventHandler != null) {
                    cakeReadEventHandler.handle((CakeReadEvent) event);
                }
                break;
        }
    }

    public void run() {
        try {
            while (true) {
                readSign();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException ignored) {
            // Behandlung der IOException, falls erforderlich
        }
    }

    public void setCakeAddEventHandler(CakeAddEventHandler cakeAddEventHandler) {
        this.cakeAddEventHandler = cakeAddEventHandler;
    }

    public void setCakeDeleteEventHandler(CakeDeleteEventHandler cakeDeleteEventHandler) {
        this.cakeDeleteEventHandler = cakeDeleteEventHandler;
    }

    public void setCakeReadEventHandler(CakeReadEventHandler cakeReadEventHandler) {
        this.cakeReadEventHandler = cakeReadEventHandler;
    }

    public void setCakeUpdateEventHandler(CakeUpdateEventHandler cakeUpdateEventHandler) {
        this.cakeUpdateEventHandler = cakeUpdateEventHandler;
    }
}
