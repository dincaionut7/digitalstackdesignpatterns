package network.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class SimpleServerFactory extends javax.net.ServerSocketFactory {

    SimpleServerFactory()
    {
        System.out.println("Created SimpleServerFactory singelton object.");
    }

    public ServerSocket createServerSocket(int port) throws IOException {
        //simple socket
        System.out.println("Factory method called, args: port " + port);
        return new ServerSocket(port);
    }

    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        //some socket
        System.out.println("Factory method called, args: port, backlog");
        return new ServerSocket(port, backlog);
    }

    public ServerSocket createServerSocket(int port, int backlog, InetAddress ifAddress) throws IOException {
        //other kind of socket
        System.out.println("Factory method called, args : port, backlog, ifAddress");
        return new ServerSocket(port,backlog,ifAddress);
    }
}
