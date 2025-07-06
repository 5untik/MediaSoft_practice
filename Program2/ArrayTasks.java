import java.util.Random;

public class ArrayTasks {
    
    public static void task1_Arrays() {
        System.out.println("=== ЗАДАНИЕ 1: Массивы (Работа с парком машин) ===\n");
        
        int[] years = new int[50];
        Random random = new Random();
        
        System.out.println("Генерируем 50 случайных годов выпуска машин (2000-2025):");
        for (int i = 0; i < years.length; i++) {
            years[i] = 2000 + random.nextInt(26);
        }
        
        System.out.print("Все годы: ");
        for (int year : years) {
            System.out.print(year + " ");
        }
        System.out.println("\n");
        
        System.out.println("Машины, выпущенные после 2015 года:");
        int countAfter2015 = 0;
        for (int year : years) {
            if (year > 2015) {
                System.out.print(year + " ");
                countAfter2015++;
            }
        }
        System.out.println("\nКоличество машин после 2015 года: " + countAfter2015);
        
        int currentYear = 2024;
        int totalAge = 0;
        for (int year : years) {
            totalAge += (currentYear - year);
        }
        double averageAge = (double) totalAge / years.length;
        System.out.printf("Средний возраст автомобилей: %.1f лет\n\n", averageAge);
    }
}
