import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Welcome to Hazbin Hotel! We're delighted to have you here. Sit back, relax, and enjoy your stay!");
        System.out.println();
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        RoomManagement roomManagement = new RoomManagement(); // RoomManagement object
        char choice;
        do {
            // Display menu
            System.out.println("Main Menu:");
            System.out.println("a. Show All Rooms");
            System.out.println("b. Show Available Rooms");
            System.out.println("c. Change Room Details");
            System.out.println("d. Search by Room Type");
            System.out.println("e. Search by Capacity");
            System.out.println("f. Sort and Display Rooms by Price");
            System.out.println("g. Reserve a Room");
            System.out.println("h. Read Room Details from File");
            System.out.println("i. Save Rooms Data to File");
            System.out.println("j. Quit");

            // Get user choice
            System.out.print("Enter your choice: ");
            choice = scanner.next().toLowerCase().charAt(0);

            // Perform action based on user choice
            switch (choice) {
                case 'a':
                    roomManagement.showAllRooms();
                    break;
                case 'b':
                    roomManagement.showAvailableRooms();
                    break;
                case 'c':
                    System.out.print("Enter Room Number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter Room Type: ");
                    String roomType = scanner.next();
                    System.out.print("Is Occupied (true/false): ");
                    boolean isOccupied = scanner.nextBoolean();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter Price Per Night: ");
                    double pricePerNight = scanner.nextDouble();
                    roomManagement.changeRoomDetails(roomNumber, roomType, isOccupied, capacity, pricePerNight, scanner);
                    break;
                case 'd':
                    System.out.print("Enter Room Type: ");
                    roomType = scanner.next();
                    roomManagement.searchByRoomType(roomType);
                    break;
                case 'e':
                    System.out.print("Enter Capacity: ");
                    capacity = scanner.nextInt();
                    roomManagement.searchByCapacity(capacity);
                    break;
                case 'f':
                    roomManagement.sortRoomsByPrice();
                    break;
                case 'g':
                    System.out.print("Enter Room Number: ");
                    roomNumber = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Customer First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Customer Last Name: ");
                    String lastName = scanner.nextLine();
                    roomManagement.reserveRoom(roomNumber, firstName, lastName);
                    break;
                case 'h':
                    System.out.print("Enter Filename to Read: ");
                    String filename = scanner.nextLine();
                    roomManagement.readRoomsFromFile(filename);
                    break;
                case 'i':
                    System.out.print("Enter Filename to Save: ");
                    filename = scanner.nextLine();
                    roomManagement.saveRoomsToFile(filename);
                    break;
                case 'j':
                    System.out.println("Thank you for choosing Hazbin Hotel. We hope you enjoyed your stay!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 'j');
    }
}
