public enum CarType {
    SEDAN("Седан"),
    SUV("Внедорожник"),
    HATCHBACK("Хэтчбек"),
    COUPE("Купе"),
    ELECTRIC("Электромобиль"),
    TRUCK("Грузовик"),
    CONVERTIBLE("Кабриолет");
    
    private final String displayName;
    
    CarType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
