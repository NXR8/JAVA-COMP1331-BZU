import java.io.*;
import java.util.Scanner;


public class RoomManagement {
    private Room[] rooms; // Array of Room objects

    public RoomManagement() {
        rooms = new Room[50]; // Initialize the rooms array with 50 rooms
        initializeRooms();
    }

    private void initializeRooms() {
        int roomNumber = 101;
        int floorNumber = 1;
        for (int i = 0; i < 50; i++) {
            String roomType;
            if (i < 20) {
                roomType = "Standard";
            } else if (i < 40) {
                roomType = "Family";
            } else {
                roomType = "Suite";
            }
    
            double pricePerNight = Math.random() * 200;
    
            rooms[i] = new Room(roomNumber, floorNumber, roomType, false, 2, pricePerNight);
    
            roomNumber++;
    
            if (roomNumber % 100 == 11) {
                roomNumber = (floorNumber + 1) * 100 + 1;
                floorNumber++;
            }
        }
    }
    

    public void showAllRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void showAvailableRooms() {
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println(room);
            }
        }
    }

    public void changeRoomDetails(int roomNumber, String roomType, boolean isOccupied, int capacity, double pricePerNight, Scanner scanner) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            room.setRoomType(roomType);
            room.setOccupied(isOccupied);
            room.setCapacity(capacity);
            room.setPricePerNight(pricePerNight);
            if (isOccupied) {
                System.out.print("Enter Customer First Name: ");
                String firstName = scanner.next();
                System.out.print("Enter Customer Last Name: ");
                String lastName = scanner.next();
                room.setCustomerName(firstName, lastName);
            } else {
                room.setCustomerName("", ""); // Clear customer name if not occupied
            }
            System.out.println("Room details updated successfully.");
        } else {
            System.out.println("Room not found.");
        }
    }

    public void searchByRoomType(String roomType) {
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType)) {
                System.out.println(room);
            }
        }
    }

    public void searchByCapacity(int capacity) {
        for (Room room : rooms) {
            if (room.getCapacity() == capacity) {
                System.out.println(room);
            }
        }
    }
    public void sortRoomsByPrice() {
        for (int i = 0; i < rooms.length - 1; i++) {
            for (int j = 0; j < rooms.length - i - 1; j++) {
                if (rooms[j].getPricePerNight() > rooms[j + 1].getPricePerNight()) {
                    Room temp = rooms[j];
                    rooms[j] = rooms[j + 1];
                    rooms[j + 1] = temp;
                }
            }
        }
        showAllRooms(); // Display sorted rooms
    }

    public void reserveRoom(int roomNumber, String firstName, String lastName) {
        Room room = findRoom(roomNumber);
        if (room != null && !room.isOccupied()) {
            room.setOccupied(true);
            room.setCustomerName(firstName, lastName);
            System.out.println("Room reserved successfully.");
        } else {
            System.out.println("Room not available or already occupied.");
        }
    }

    public void readRoomsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(" ");
                int roomNumber = Integer.parseInt(details[0]);
                String roomType = details[1];
                boolean isOccupied = Boolean.parseBoolean(details[2]);
                int capacity = Integer.parseInt(details[3]);
                double pricePerNight = Double.parseDouble(details[4]);
                Room room = findRoom(roomNumber);
                if (room != null) {
                    room.setRoomType(roomType);
                    room.setOccupied(isOccupied);
                    room.setCapacity(capacity);
                    room.setPricePerNight(pricePerNight);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public void saveRoomsToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Room room : rooms) {
                bw.write(room.getRoomNumber() + " " + room.getRoomType() + " " +
                         room.isOccupied() + " " + room.getCapacity() + " " +
                         room.getPricePerNight());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
