import java.util.Objects;

public class Car implements Comparable<Car> {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    private CarType type;
    
    public Car(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Objects.equals(vin, car.vin);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }
    
    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year);
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %d г. (VIN: %s, пробег: %,d км, цена: %,.0f руб., тип: %s)",
                manufacturer, model, year, vin, mileage, price, type);
    }
    
    public String getVin() { return vin; }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }
    public CarType getType() { return type; }
    
    public void setPrice(double price) { this.price = price; }
    public void setMileage(int mileage) { this.mileage = mileage; }
}
