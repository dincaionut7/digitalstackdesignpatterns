package network.server;

public class ServerFactorySingelton extends SimpleServerFactory {

    public static ServerFactorySingelton instance = null;

    private ServerFactorySingelton()
    {//hide constructor
    };

    public static synchronized ServerFactorySingelton getInstance()
    {
        if (instance == null)
            instance = new ServerFactorySingelton();
        return instance;
    }
}
