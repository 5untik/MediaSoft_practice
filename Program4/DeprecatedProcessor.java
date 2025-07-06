import java.lang.reflect.Method;

public class DeprecatedProcessor {
    
    public static void processClass(Class<?> clazz) {
        System.out.println("Анализ класса: " + clazz.getSimpleName());
        System.out.println("─".repeat(50));
        
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.println("Внимание: класс '" + clazz.getSimpleName() + 
                             "' устарел. Альтернатива: '" + annotation.message() + "'");
        }
        
        Method[] methods = clazz.getDeclaredMethods();
        boolean hasDeprecatedMethods = false;
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.println("Внимание: метод '" + method.getName() + 
                                 "' устарел. Альтернатива: '" + annotation.message() + "'");
                hasDeprecatedMethods = true;
            }
        }
        
        if (!clazz.isAnnotationPresent(DeprecatedEx.class) && !hasDeprecatedMethods) {
            System.out.println("В классе нет устаревших элементов");
        }
        
        System.out.println();
    }
}
