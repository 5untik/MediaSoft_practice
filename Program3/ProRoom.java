public abstract class ProRoom extends Room {
    
    public ProRoom(int roomNumber, int maxCapacity, int pricePerNight, boolean isBooked) {
        super(roomNumber, maxCapacity, pricePerNight, isBooked);
    }
    
    public ProRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, pricePerNight);
    }
    
    public ProRoom(int roomNumber, Prices priceCategory) {
        super(roomNumber, priceCategory);
    }
    
    public void providePremiumService() {
        System.out.println("Предоставляем премиум сервис для комнаты №" + roomNumber);
    }
}
