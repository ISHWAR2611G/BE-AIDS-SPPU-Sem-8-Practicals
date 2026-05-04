import java.rmi.Naming;
import java.util.Scanner;

public class HotelClient {
    public static void main(String[] args) {
        try {
            Hotel hotel = (Hotel) Naming.lookup("rmi://localhost:1099/HotelService");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Hotel Booking System ---");
                System.out.println("1. Book Room");
                System.out.println("2. Cancel Booking");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 3) break;

                System.out.print("Enter Guest Name: ");
                String name = sc.nextLine();

                String result;

                if (choice == 1) {
                    result = hotel.bookRoom(name);
                } else if (choice == 2) {
                    result = hotel.cancelBooking(name);
                } else {
                    System.out.println("Invalid choice");
                    continue;
                }

                System.out.println("Response: " + result);
            }

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
