package NullObjectDesignPattern;

public class RealUser implements User{


    private final String email;
    private final String role;


    public RealUser(String email, String role) {
        this.email = email;
        this.role = role;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getRole() {
        return role;
    }


    @Override
    public boolean isAuthenticated() {
        return true;
    }
}
