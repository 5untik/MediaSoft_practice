public class Product {
    
    @JsonField(name = "product_id")
    private int id;
    
    @JsonField(name = "product_name")
    private String name;
    
    @JsonField(name = "price_rub")
    private double price;
    
    @JsonField(name = "in_stock")
    private boolean available;
    
    private String internalCode;
    
    @JsonField(name = "category")
    private String category;
    
    public Product(int id, String name, double price, boolean available, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
        this.category = category;
        this.internalCode = "INTERNAL_" + id;
    }
    
    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f, available=%s, category='%s'}", 
                           id, name, price, available, category);
    }
}
