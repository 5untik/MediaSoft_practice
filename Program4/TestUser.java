@DeprecatedEx(message = "Используйте класс NewUser вместо TestUser")
public class TestUser {
    
    @JsonField(name = "user_id")
    private int id;
    
    @JsonField(name = "full_name")
    private String name;
    
    @JsonField(name = "user_email")
    private String email;
    
    private String password;
    
    @JsonField(name = "is_active")
    private boolean active;
    
    public TestUser(int id, String name, String email, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = active;
    }
    
    @DeprecatedEx(message = "Используйте метод getFullUserInfo()")
    public String getUserInfo() {
        return "User: " + name;
    }
    
    @DeprecatedEx(message = "Используйте метод updateUserData()")
    public void updateInfo(String newName) {
        this.name = newName;
    }
    
    public String getFullUserInfo() {
        return String.format("User{id=%d, name='%s', email='%s', active=%s}", 
                           id, name, email, active);
    }
    
    @Override
    public String toString() {
        return getFullUserInfo();
    }
}
