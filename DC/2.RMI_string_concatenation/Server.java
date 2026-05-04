import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.server.UnicastRemoteObject;


public class Server extends UnicastRemoteObject
        implements StringInterface
{

    protected Server()
            throws Exception
    {
        super();

        System.out.println(
                "Server Initialized..."
        );
    }


    @Override
    public String concatenate(
            String s1,
            String s2
    )
    {
        return s1 + s2;
    }


    public static void main(
            String args[]
    )
    {
        try
        {
            Server server =
                    new Server();

            Registry registry =
                    LocateRegistry.createRegistry(
                            1099
                    );

            registry.rebind(
                    "StringService",
                    server
            );

            System.out.println(
                    "RMI Server Ready..."
            );
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}