import java.util.*;

public class HotelManagementSystem {
    
    public static void main(String[] args) {
        System.out.println("СИСТЕМА УПРАВЛЕНИЯ ОТЕЛЕМ");
        System.out.println("═".repeat(50));
        
        testRoomCreation();
        
        testBasicRoomService();
        
        testLuxuryRoomService();
        
        testExceptionHandling();
        
        demonstratePolymorphism();
    }
    
    private static void testRoomCreation() {
        System.out.println("\nТЕСТИРОВАНИЕ СОЗДАНИЯ КОМНАТ");
        System.out.println("─".repeat(40));
        
        EconomyRoom economy = new EconomyRoom(101);
        StandardRoom standard = new StandardRoom(201);
        LuxRoom lux = new LuxRoom(301);
        UltraLuxRoom ultraLux = new UltraLuxRoom(401);
        
        List<Room> rooms = Arrays.asList(economy, standard, lux, ultraLux);
        
        System.out.println("Созданные комнаты:");
        rooms.forEach(System.out::println);
        
        System.out.println("\n💰 Доступные категории цен:");
        for (Prices price : Prices.values()) {
            System.out.println("   " + price);
        }
    }
    
    private static void testBasicRoomService() {
        System.out.println("\n🛎️  ТЕСТИРОВАНИЕ БАЗОВОГО СЕРВИСА");
        System.out.println("─".repeat(40));
        
        HotelRoomService<Room> service = new HotelRoomService<>();
        EconomyRoom economy = new EconomyRoom(102);
        StandardRoom standard = new StandardRoom(202);
        
        try {
            System.out.println("Работа с эконом комнатой:");
            service.clean(economy);
            service.reserve(economy);
            System.out.println();
            
            System.out.println("Работа со стандартной комнатой:");
            service.clean(standard);
            service.reserve(standard);
            service.free(standard);
            
        } catch (RoomAlreadyBookedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testLuxuryRoomService() {
        System.out.println("\nТЕСТИРОВАНИЕ ЛЮКС СЕРВИСА");
        System.out.println("─".repeat(40));
        
        LuxuryHotelService<LuxRoom> luxService = new LuxuryHotelService<>();
        LuxRoom lux = new LuxRoom(302);
        UltraLuxRoom ultraLux = new UltraLuxRoom(402);
        
        try {
            System.out.println("Работа с люкс комнатой:");
            luxService.clean(lux);
            luxService.reserve(lux);
            luxService.foodDelivery(lux, "Стейк Веллингтон с трюфелями");
            System.out.println();
            
            System.out.println("Работа с ультра люкс комнатой:");
            luxService.clean(ultraLux);
            luxService.reserve(ultraLux);
            luxService.foodDelivery(ultraLux, "Икра белуги с шампанским Dom Pérignon");
            
        } catch (RoomAlreadyBookedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
    
    private static void testExceptionHandling() {
        System.out.println("\nТЕСТИРОВАНИЕ ОБРАБОТКИ ОШИБОК");
        System.out.println("─".repeat(40));
        
        HotelRoomService<Room> service = new HotelRoomService<>();
        EconomyRoom room = new EconomyRoom(103);
        
        try {
            service.reserve(room);
            System.out.println();
            
            System.out.println("Попытка повторного бронирования:");
            service.reserve(room);
            
        } catch (RoomAlreadyBookedException e) {
            System.err.println("Перехвачена ошибка: " + e.getMessage());
            System.err.println("Номер комнаты из исключения: " + e.getRoomNumber());
        }
    }
    
    private static void demonstratePolymorphism() {
        System.out.println("\nДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА");
        System.out.println("─".repeat(40));
        
        List<Room> rooms = Arrays.asList(
            new EconomyRoom(104),
            new StandardRoom(204),
            new LuxRoom(304),
            new UltraLuxRoom(404)
        );
        
        HotelRoomService<Room> service = new HotelRoomService<>();
        
        System.out.println("Обработка комнат разных типов одним сервисом:");
        for (Room room : rooms) {
            System.out.println("\n" + room);
            service.clean(room);
            
            try {
                service.reserve(room);
            } catch (RoomAlreadyBookedException e) {
                System.err.println(e.getMessage());
            }
        }
        
        System.out.println("\nДЕМОНСТРАЦИЯ ОГРАНИЧЕНИЙ ТИПОВ:");
        
        LuxuryHotelService<LuxRoom> luxService = new LuxuryHotelService<>();
        LuxRoom luxRoom = new LuxRoom(305);
        EconomyRoom economyRoom = new EconomyRoom(105);
        
        try {
            luxService.reserve(luxRoom);
            luxService.foodDelivery(luxRoom, "Суши от шеф-повара");
            
            
        } catch (RoomAlreadyBookedException e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("\nСистема безопасности типов работает корректно!");
        System.out.println("Нельзя заказать доставку еды в не-люкс комнаты");
    }
}
