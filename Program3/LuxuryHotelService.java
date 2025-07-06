public class LuxuryHotelService<T extends LuxRoom> implements LuxRoomService<T> {
    
    private final HotelRoomService<T> baseService;
    
    public LuxuryHotelService() {
        this.baseService = new HotelRoomService<>();
    }
    
    @Override
    public void clean(T room) {
        baseService.clean(room);
        System.out.println("Дополнительная премиум уборка для люкс комнаты");
        System.out.println("Свежие цветы и ароматизация помещения");
    }
    
    @Override
    public void reserve(T room) throws RoomAlreadyBookedException {
        baseService.reserve(room);
        System.out.println("Комплимент от отеля: шампанское и фрукты");
        
        if (room instanceof UltraLuxRoom) {
            System.out.println("VIP встреча и персональный консьерж");
        }
    }
    
    @Override
    public void free(T room) {
        baseService.free(room);
        System.out.println("Отчет о пребывании отправлен в VIP отдел");
    }
    
    @Override
    public void foodDelivery(T room, String menuItem) {
        if (!room.isBooked()) {
            System.out.println("Нельзя заказать доставку еды в незабронированную комнату №" + 
                             room.getRoomNumber());
            return;
        }
        
        System.out.println("Доставка еды в люкс комнату №" + room.getRoomNumber());
        System.out.println("Заказ: " + menuItem);
        System.out.println("Приготовление шеф-поваром");
        System.out.println("Доставка на серебряной посуде");
        
        if (room instanceof UltraLuxRoom) {
            System.out.println("Дополнительно: элитные напитки и десерт от шефа");
        }
    }
}
