import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HotelServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            HotelImpl hotel = new HotelImpl();
            Naming.rebind("rmi://localhost:1099/HotelService", hotel);
            System.out.println("Hotel Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
