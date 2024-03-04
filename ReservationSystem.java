import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystem {
    private static Map<String, String> users = new HashMap<>();
    private static Map<String, String> reservations = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Reserve");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    reserve();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void register() {
        System.out.print("Enter new username: ");
        String username = scanner.next();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try a different one.");
        } else {
            System.out.print("Enter password: ");
            String password = scanner.next();
            users.put(username, password);
            System.out.println("Registration successful.");
        }
    }

    private static void reserve() {
        if (isLoggedIn()) {
            System.out.print("Enter reservation details: ");
            String reservationDetails = scanner.next();
            reservations.put(getLoggedInUser(), reservationDetails);
            System.out.println("Reservation successful.");
        } else {
            System.out.println("You need to log in first.");
        }
    }

    private static void cancelReservation() {
        if (isLoggedIn()) {
            if (reservations.containsKey(getLoggedInUser())) {
                reservations.remove(getLoggedInUser());
                System.out.println("Reservation canceled.");
            } else {
                System.out.println("No reservation found for the logged-in user.");
            }
        } else {
            System.out.println("You need to log in first.");
        }
    }

    private static boolean isLoggedIn() {
        return getLoggedInUser() != null;
    }

    private static String getLoggedInUser() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        if (users.containsKey(username)) {
            System.out.print("Enter password: ");
            String password = scanner.next();
            if (users.get(username).equals(password)) {
                return username;
            }
        }
        return null;
    }
}
