public class HotelRoomService<T extends Room> implements RoomService<T> {
    
    @Override
    public void clean(T room) {
        System.out.println("🧹 Убираем комнату №" + room.getRoomNumber() + 
                          " (" + room.getRoomType() + ")");
        System.out.println("Комната чистая и готова к заселению");
    }
    
    @Override
    public void reserve(T room) throws RoomAlreadyBookedException {
        if (room.isBooked()) {
            throw new RoomAlreadyBookedException(room.getRoomNumber());
        }
        
        room.setBooked(true);
        System.out.println("Комната №" + room.getRoomNumber() + 
                          " (" + room.getRoomType() + ") успешно забронирована");
        System.out.println("Стоимость: " + room.getPricePerNight() + " руб/ночь");
    }
    
    @Override
    public void free(T room) {
        if (!room.isBooked()) {
            System.out.println("Комната №" + room.getRoomNumber() + " уже свободна");
            return;
        }
        
        room.setBooked(false);
        System.out.println("Комната №" + room.getRoomNumber() + 
                          " (" + room.getRoomType() + ") освобождена");
        System.out.println("Комната доступна для бронирования");
    }
}
