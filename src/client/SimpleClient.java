package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class SimpleClient {

    private Socket socket;
    private PrintWriter outStream;
    private BufferedReader inStream;

    public void connect(String targetIp,int port) throws IOException {
        socket = new Socket(targetIp,port);
        outStream = new PrintWriter(socket.getOutputStream(), true);
        inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Connected sucesffully to server");
    }

    public void sendMessage(String message) throws IOException {
        outStream.println(message);
        String response = inStream.readLine();
        System.out.println("\n[RESPONSE]Server response: ");
        System.out.println(response);
        System.out.println("---end of request --- \n\n");
    }

    public static void main(String[] args) throws IOException {
        SimpleClient client = new SimpleClient();
        client.connect("127.0.0.1", 3021);
        client.sendMessage("loginfo");
        //client.sendMessage("datenow");


    }
}
