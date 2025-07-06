import java.util.function.*;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressionDemo {
    
    public static void main(String[] args) {
        System.out.println("ДЕМОНСТРАЦИЯ ЛЯМБДА-ВЫРАЖЕНИЙ");
        System.out.println("═".repeat(60));
        
        task1_Printable();
        
        task2_StringValidation();
        
        task3_StringPattern();
        
        task4_HeavyBoxConsumer();
        
        task5_NumberFunction();
        
        task6_RandomSupplier();
        
        demonstrateAnnotations();
    }
    
    private static void task1_Printable() {
        System.out.println("\nЗАДАНИЕ 1: Лямбда для интерфейса Printable");
        System.out.println("─".repeat(50));
        
        Printable printHello = () -> System.out.println("Привет из лямбда-выражения!");
        Printable printTime = () -> System.out.println("Текущее время: " + 
                                                      java.time.LocalTime.now());
        Printable printSeparator = () -> System.out.println("─".repeat(30));
        
        System.out.println("Выполняем различные Printable лямбды:");
        printHello.print();
        printTime.print();
        printSeparator.print();
    }
    
    private static void task2_StringValidation() {
        System.out.println("\nЗАДАНИЕ 2: Проверка пустой строки");
        System.out.println("─".repeat(50));
        
        Predicate<String> notNull = str -> str != null;
        
        Predicate<String> notEmpty = str -> !str.isEmpty();
        
        Predicate<String> validString = notNull.and(notEmpty);
        
        String[] testStrings = {null, "", "   ", "Hello", "Java"};
        
        System.out.println("Тестирование строк:");
        for (String str : testStrings) {
            String displayStr = str == null ? "null" : "\"" + str + "\"";
            System.out.printf("%-10s | notNull: %-5s | notEmpty: %-5s | valid: %-5s%n",
                displayStr,
                str != null ? notNull.test(str) : false,
                str != null ? notEmpty.test(str) : "N/A",
                validString.test(str)
            );
        }
    }
    
    private static void task3_StringPattern() {
        System.out.println("\nЗАДАНИЕ 3: Проверка строки на паттерн");
        System.out.println("─".repeat(50));
        
        Predicate<String> startsWithJOrN = str -> str.startsWith("J") || str.startsWith("N");
        Predicate<String> endsWithA = str -> str.endsWith("A");
        Predicate<String> matchesPattern = startsWithJOrN.and(endsWithA);
        
        String[] testStrings = {"JAVA", "NASA", "NINJA", "HELLO", "JULIA", "NOVA", "ZEBRA"};
        
        System.out.println("Проверка паттерна (начинается с J/N и заканчивается на A):");
        for (String str : testStrings) {
            boolean matches = matchesPattern.test(str);
            System.out.printf("%-8s → %s %s%n", str, matches ? "да" : "нет", 
                            matches ? "соответствует" : "не соответствует");
        }
    }
    
    private static void task4_HeavyBoxConsumer() {
        System.out.println("\nЗАДАНИЕ 4: HeavyBox с Consumer");
        System.out.println("─".repeat(50));
        
        Consumer<HeavyBox> shipBox = box -> 
            System.out.println("Отгрузили ящик с весом " + box.getWeight() + " кг");
        
        Consumer<HeavyBox> sendBox = box -> 
            System.out.println("Отправляем ящик с весом " + box.getWeight() + " кг");
        
        Consumer<HeavyBox> processBox = shipBox.andThen(sendBox);
        
        List<HeavyBox> boxes = Arrays.asList(
            new HeavyBox(15.5, "Книги"),
            new HeavyBox(23.0, "Электроника"),
            new HeavyBox(8.2, "Одежда")
        );
        
        System.out.println("Обработка ящиков:");
        for (HeavyBox box : boxes) {
            System.out.println("\nОбрабатываем: " + box);
            processBox.accept(box);
        }
    }
    
    private static void task5_NumberFunction() {
        System.out.println("\nЗАДАНИЕ 5: Function для анализа чисел");
        System.out.println("─".repeat(50));
        
        Function<Integer, String> analyzeNumber = num -> {
            if (num > 0) return "Положительное число";
            else if (num < 0) return "Отрицательное число";
            else return "Ноль";
        };
        
        int[] testNumbers = {-5, 0, 10, -100, 42, -1, 1};
        
        System.out.println("Анализ чисел:");
        for (int num : testNumbers) {
            String result = analyzeNumber.apply(num);
            System.out.printf("%4d → %s%n", num, result);
        }
    }
    
    private static void task6_RandomSupplier() {
        System.out.println("\nЗАДАНИЕ 6: Supplier для случайных чисел");
        System.out.println("─".repeat(50));
        
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);
        
        System.out.println("Генерация 10 случайных чисел от 0 до 10:");
        for (int i = 1; i <= 10; i++) {
            int randomNum = randomSupplier.get();
            System.out.printf("Число %2d: %d%n", i, randomNum);
        }
        
        Supplier<Double> randomDouble = () -> Math.random() * 100;
        System.out.println("\nБонус - случайные дробные числа от 0 до 100:");
        for (int i = 1; i <= 5; i++) {
            double randomNum = randomDouble.get();
            System.out.printf("Число %d: %.2f%n", i, randomNum);
        }
    }
    
    private static void demonstrateAnnotations() {
        System.out.println("\nДЕМОНСТРАЦИЯ РАБОТЫ С АННОТАЦИЯМИ");
        System.out.println("═".repeat(60));
        
        System.out.println("ЗАДАНИЕ 1: Обработка @DeprecatedEx");
        DeprecatedProcessor.processClass(TestUser.class);
        DeprecatedProcessor.processClass(Product.class);
        
        System.out.println("ЗАДАНИЕ 2: JSON сериализация с @JsonField");
        System.out.println("─".repeat(50));
        
        TestUser user = new TestUser(1, "Иван Петров", "ivan@example.com", "secret123", true);
        Product product = new Product(101, "Ноутбук", 75000.0, true, "Электроника");
        
        JsonSerializer.demonstrateSerialization(user);
        JsonSerializer.demonstrateSerialization(product);
        
        SimpleObject simple = new SimpleObject();
        System.out.println("Объект без @JsonField аннотаций:");
        System.out.println("JSON результат: " + JsonSerializer.toJson(simple));
    }
    
    static class SimpleObject {
        private String name = "Test";
        private int value = 42;
        
        @Override
        public String toString() {
            return "SimpleObject{name='" + name + "', value=" + value + "}";
        }
    }
}
