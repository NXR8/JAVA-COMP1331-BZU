public class Room {
    // Room properties
    private int roomNumber; // The room number
    private int floorNumber; // The floor number
    private String roomType; // The type of room (Standard, Family, Suite)
    private boolean isOccupied; // Indicates whether the room is occupied or not
    private int capacity; // The maximum capacity of the room (number of people)
    private double pricePerNight; // The price per night for the room
    private String[] customerName; // Array to store customer first and last name

    public Room(int roomNumber, int floorNumber, String roomType, boolean isOccupied, int capacity, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.roomType = roomType;
        this.isOccupied = isOccupied;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.customerName = new String[2]; // Initialize the customer name array
    }

    // Getter and setter methods for room properties

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String[] getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String firstName, String lastName) {
        this.customerName[0] = firstName;
        this.customerName[1] = lastName;
    }

    public String toString() {
        if (isOccupied){
            return "Room Number: " + roomNumber + ", Floor Number: " + floorNumber + ", Room Type: " + roomType + ", Is Occupied: " + isOccupied + ", Capacity: " + capacity + ", Price Per Night: $" + pricePerNight + ", Customer Name: " + customerName[0] + " " + customerName[1];
        }
        else{
            return "Room Number: " + roomNumber + ", Floor Number: " + floorNumber + ", Room Type: " + roomType + ", Is Occupied: " + isOccupied + ", Capacity: " + capacity + ", Price Per Night: $" + pricePerNight;
        }
    }
}
