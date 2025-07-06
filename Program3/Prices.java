public enum Prices {
    ECONOMY(2000, "Эконом класс"),
    STANDARD(4000, "Стандарт"),
    LUX(8000, "Люкс"),
    ULTRA_LUX(15000, "Ультра люкс");
    
    private final int pricePerNight;
    private final String description;
    
    Prices(int pricePerNight, String description) {
        this.pricePerNight = pricePerNight;
        this.description = description;
    }
    
    public int getPricePerNight() {
        return pricePerNight;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return description + " - " + pricePerNight + " руб/ночь";
    }
}
