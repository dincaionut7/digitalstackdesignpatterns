import network.commands.Command;
import network.commands.CommandsExecutor;
import network.commands.GetDateTimeCommand;
import network.server.ServerFactorySingelton;
import network.server.threads.ClientThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public final class SimpleServer{

    private ServerSocket serverSocket;
    private Map<Integer, Thread> activeConnections = new HashMap<>();
    public synchronized Map<Integer, Thread> getActiveConnections() {
        return activeConnections;
    }

    public SimpleServer(int port) throws IOException {
        System.out.println("Starting SimpleServer ServerSocket creation...");
        serverSocket = ServerFactorySingelton.getInstance().createServerSocket(port);
    }

    private void listen()
    {
        //log some info
        System.out.println("initalizing listen on ServerSocket: " + serverSocket.getLocalPort() + " / " + serverSocket.getInetAddress());

        Socket clientSocket = null;
        try {clientSocket = serverSocket.accept(); System.out.println("Connected client: " + clientSocket.getInetAddress());}
            catch (IOException ex) {System.out.println("Acception connection exception: " + ex.getMessage());}

        //create and store threads
        //TODO: remove clients from map in ClientThread.java
        Thread clientThread = new ClientThread(clientSocket);
        clientThread.start();
        activeConnections.put(activeConnections.size() + 1, clientThread);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Trying to start server...");
        SimpleServer server = new SimpleServer(3021);
        while (true)
        {
            System.out.println("Awaiting connection..");
            server.listen();
        }
    }

}
