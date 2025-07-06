public class EconomyRoom extends Room {
    
    public EconomyRoom(int roomNumber) {
        super(roomNumber, Prices.ECONOMY);
    }
    
    public EconomyRoom(int roomNumber, int maxCapacity) {
        super(roomNumber, maxCapacity, Prices.ECONOMY.getPricePerNight(), false);
    }
    
    @Override
    public String getRoomType() {
        return "Эконом класс";
    }
}
