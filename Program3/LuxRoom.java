public class LuxRoom extends ProRoom {
    
    public LuxRoom(int roomNumber) {
        super(roomNumber, Prices.LUX);
    }
    
    public LuxRoom(int roomNumber, int maxCapacity) {
        super(roomNumber, maxCapacity, Prices.LUX.getPricePerNight(), false);
    }
    
    @Override
    public String getRoomType() {
        return "Люкс";
    }
    
    public void provideButlerService() {
        System.out.println("Предоставляем услуги дворецкого для комнаты №" + roomNumber);
    }
}
