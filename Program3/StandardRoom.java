public class StandardRoom extends ProRoom {
    
    public StandardRoom(int roomNumber) {
        super(roomNumber, Prices.STANDARD);
    }
    
    public StandardRoom(int roomNumber, int maxCapacity) {
        super(roomNumber, maxCapacity, Prices.STANDARD.getPricePerNight(), false);
    }
    
    @Override
    public String getRoomType() {
        return "Стандарт";
    }
}
