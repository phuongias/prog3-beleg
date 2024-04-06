package client;

import eventPattern.cakeEvents.CakeReadEvent;
import eventPattern.cakeHandler.CakeReadEventHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.EventObject;

public class TCPClient {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket clientSocket;
    private CakeReadEventHandler cakeReadEventHandler;

    public TCPClient(int port) {
        try {
            this.clientSocket = new Socket(InetAddress.getLocalHost(), port);
            this.out = new ObjectOutputStream(clientSocket.getOutputStream());
            this.in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(char sign, EventObject event) {
        try {
            if (!clientSocket.isConnected()) {
                throw new RuntimeException("Keine Verbindung!");
            }
            this.out.writeChar(sign);
            this.out.writeObject(event);
            this.out.flush();
            this.out.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void receive() {
        try {
            char sign = this.in.readChar();
            Object event = this.in.readObject();

            if(cakeReadEventHandler != null){
                cakeReadEventHandler.handle((CakeReadEvent) event);

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
        }
    }
}
