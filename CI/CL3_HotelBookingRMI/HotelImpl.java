import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

public class HotelImpl extends UnicastRemoteObject implements Hotel {

    private Set<String> bookings;

    protected HotelImpl() throws RemoteException {
        bookings = new HashSet<>();
    }

    public synchronized String bookRoom(String guestName) throws RemoteException {
        if (bookings.contains(guestName)) {
            return "Room already booked for " + guestName;
        }
        bookings.add(guestName);
        return "Room successfully booked for " + guestName;
    }

    public synchronized String cancelBooking(String guestName) throws RemoteException {
        if (bookings.remove(guestName)) {
            return "Booking cancelled for " + guestName;
        }
        return "No booking found for " + guestName;
    }
}
