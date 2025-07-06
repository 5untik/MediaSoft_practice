import java.util.Random;

public abstract class Room {
    protected int roomNumber;
    protected int maxCapacity;
    protected int pricePerNight;
    protected boolean isBooked;
    
    public Room(int roomNumber, int maxCapacity, int pricePerNight, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
    }
    
    public Room(int roomNumber, int pricePerNight) {
        this(roomNumber, generateRandomCapacity(), pricePerNight, false);
    }
    
    public Room(int roomNumber, Prices priceCategory) {
        this(roomNumber, generateRandomCapacity(), priceCategory.getPricePerNight(), false);
    }
    
    private static int generateRandomCapacity() {
        Random random = new Random();
        return 1 + random.nextInt(4);
    }
    
    public int getRoomNumber() { return roomNumber; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getPricePerNight() { return pricePerNight; }
    public boolean isBooked() { return isBooked; }
    
    public void setBooked(boolean booked) { this.isBooked = booked; }
    public void setPricePerNight(int pricePerNight) { this.pricePerNight = pricePerNight; }
    
    @Override
    public String toString() {
        return String.format("%s №%d (вместимость: %d чел., цена: %d руб/ночь, %s)",
                getClass().getSimpleName(), roomNumber, maxCapacity, pricePerNight,
                isBooked ? "ЗАБРОНИРОВАНА" : "СВОБОДНА");
    }
    
    public abstract String getRoomType();
}
