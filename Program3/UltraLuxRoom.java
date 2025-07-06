public class UltraLuxRoom extends LuxRoom {
    
    public UltraLuxRoom(int roomNumber) {
        super(roomNumber, Prices.ULTRA_LUX.getPricePerNight());
        this.maxCapacity = 2 + (int)(Math.random() * 4);
    }
    
    public UltraLuxRoom(int roomNumber, int maxCapacity) {
        super(roomNumber, maxCapacity);
        this.pricePerNight = Prices.ULTRA_LUX.getPricePerNight();
    }
    
    @Override
    public String getRoomType() {
        return "Ультра люкс";
    }
    
    public void providePersonalChef() {
        System.out.println("Предоставляем персонального шеф-повара для комнаты №" + roomNumber);
    }
    
    public void provideLimousineService() {
        System.out.println("Предоставляем лимузин для комнаты №" + roomNumber);
    }
}
