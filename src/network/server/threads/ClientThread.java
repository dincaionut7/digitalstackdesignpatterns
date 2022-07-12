package network.server.threads;

import network.commands.Command;
import network.commands.CommandsExecutor;
import network.commands.GetDateTimeCommand;
import network.commands.GetInfoCommand;

import javax.net.SocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;
    private BufferedReader inReader;
    private PrintWriter outWriter;

    public ClientThread(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            outWriter = new PrintWriter(socket.getOutputStream(), true);
            inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = inReader.readLine();
            switch (line) {
                case "datenow":
                    Command dateCMD = new GetDateTimeCommand();
                    outWriter.println(CommandsExecutor.executeCommand(dateCMD));
                    System.out.println("sent datenow response");

                case "loginfo":
                    Command infoCMD = new GetInfoCommand();
                    outWriter.println(CommandsExecutor.executeCommand(infoCMD));
                    System.out.println("sent loginfo response");
                }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
