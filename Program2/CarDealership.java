import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private Set<Car> cars;
    
    public CarDealership() {
        this.cars = new HashSet<>();
    }
    
    public boolean addCar(Car car) {
        boolean added = cars.add(car);
        if (added) {
            System.out.println("Машина добавлена: " + car);
        } else {
            System.out.println("Машина с VIN " + car.getVin() + " уже существует!");
        }
        return added;
    }
    
    public List<Car> findCarsByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }
    
    public OptionalDouble getAveragePriceByType(CarType type) {
        return cars.stream()
                .filter(car -> car.getType() == type)
                .mapToDouble(Car::getPrice)
                .average();
    }
    
    public List<Car> getCarsSortedByYear() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public Map<CarType, Long> getCarCountByType() {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
    }
    
    public Optional<Car> getOldestCar() {
        return cars.stream()
                .min(Comparator.comparing(Car::getYear));
    }
    
    public Optional<Car> getNewestCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::getYear));
    }
    
    public void streamApiTasks() {
        System.out.println("=== ЗАДАНИЕ 4: Stream API (Анализ автопарка) ===\n");
        
        List<Car> lowMileageCars = cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());
        
        System.out.println("Машины с пробегом менее 50,000 км (отсортированы по цене по убыванию):");
        lowMileageCars.forEach(System.out::println);
        
        System.out.println("\nТоп-3 самые дорогие машины:");
        lowMileageCars.stream()
                .limit(3)
                .forEach(System.out::println);
        
        OptionalDouble averageMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average();
        
        if (averageMileage.isPresent()) {
            System.out.printf("\nСредний пробег всех машин: %,.0f км\n", averageMileage.getAsDouble());
        }
        
        Map<String, List<Car>> carsByManufacturer = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));
        
        System.out.println("\nМашины, сгруппированные по производителю:");
        carsByManufacturer.forEach((manufacturer, carList) -> {
            System.out.println(manufacturer + " (" + carList.size() + " машин):");
            carList.forEach(car -> System.out.println("  - " + car));
        });
        System.out.println();
    }
    
    public Set<Car> getAllCars() {
        return new HashSet<>(cars);
    }
    
    public int getCarCount() {
        return cars.size();
    }
}
