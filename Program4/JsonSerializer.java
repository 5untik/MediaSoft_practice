import java.lang.reflect.Field;

public class JsonSerializer {
    
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }
        
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        StringBuilder json = new StringBuilder("{");
        boolean first = true;
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonName = annotation.name();
                
                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    
                    if (!first) {
                        json.append(", ");
                    }
                    
                    json.append("\"").append(jsonName).append("\": ");
                    
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else if (value == null) {
                        json.append("null");
                    } else {
                        json.append(value);
                    }
                    
                    first = false;
                    
                } catch (IllegalAccessException e) {
                    System.err.println("Ошибка доступа к полю: " + field.getName());
                }
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    public static void demonstrateSerialization(Object obj) {
        System.out.println("Сериализация объекта: " + obj.getClass().getSimpleName());
        System.out.println("Исходный объект: " + obj);
        
        Field[] fields = obj.getClass().getDeclaredFields();
        System.out.println("Поля с @JsonField:");
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                System.out.println("  - " + field.getName() + " → \"" + annotation.name() + "\"");
            }
        }
        
        String json = toJson(obj);
        System.out.println("JSON результат: " + json);
        System.out.println();
    }
}
