public class RoomAlreadyBookedException extends RuntimeException {
    private final int roomNumber;
    
    public RoomAlreadyBookedException(int roomNumber) {
        super("Комната №" + roomNumber + " уже забронирована!");
        this.roomNumber = roomNumber;
    }
    
    public RoomAlreadyBookedException(int roomNumber, String message) {
        super(message);
        this.roomNumber = roomNumber;
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }
}
