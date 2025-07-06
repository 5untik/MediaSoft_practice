public class HeavyBox {
    private double weight;
    private String contents;
    
    public HeavyBox(double weight, String contents) {
        this.weight = weight;
        this.contents = contents;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getContents() {
        return contents;
    }
    
    @Override
    public String toString() {
        return String.format("HeavyBox{вес=%.1f кг, содержимое='%s'}", weight, contents);
    }
}
