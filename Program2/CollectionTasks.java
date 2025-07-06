import java.util.*;

public class CollectionTasks {
    
    public static void task2_Collections() {
        System.out.println("=== ЗАДАНИЕ 2: Коллекции (Управление моделями) ===\n");
        
        List<String> models = new ArrayList<>(Arrays.asList(
            "Toyota Camry", "BMW X5", "Mercedes C-Class", "Toyota Camry",
            "Tesla Model S", "BMW X5", "Audi A4", "Tesla Model 3",
            "Honda Civic", "Tesla Roadster", "Mercedes C-Class", "Volkswagen Golf",
            "Toyota Prius", "BMW 3 Series", "Tesla Model Y"
        ));
        
        System.out.println("Исходный список моделей (с дубликатами):");
        models.forEach(System.out::println);
        System.out.println("Всего моделей: " + models.size() + "\n");
        
        Set<String> uniqueModels = new LinkedHashSet<>(models);
        List<String> uniqueList = new ArrayList<>(uniqueModels);
        
        System.out.println("После удаления дубликатов:");
        uniqueList.forEach(System.out::println);
        System.out.println("Уникальных моделей: " + uniqueList.size() + "\n");
        
        uniqueList.sort(Collections.reverseOrder());
        
        System.out.println("После сортировки в обратном алфавитном порядке:");
        uniqueList.forEach(System.out::println);
        
        uniqueList.replaceAll(model -> 
            model.contains("Tesla") ? "ELECTRO_CAR" : model
        );
        
        System.out.println("\nПосле замены Tesla на ELECTRO_CAR:");
        uniqueList.forEach(System.out::println);
        
        Set<String> finalSet = new TreeSet<>(uniqueList);
        System.out.println("\nФинальный Set (автоматически отсортирован):");
        finalSet.forEach(System.out::println);
        System.out.println();
    }
}
