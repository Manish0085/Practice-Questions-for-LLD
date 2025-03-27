package NullObjectDesignPattern;

public class NullUserObject implements User{


    @Override
    public String getUsername() {
        return "Null User";
    }

    @Override
    public String getRole() {
        return "Undefined";
    }


    @Override
    public boolean isAuthenticated() {
        return false;
    }
}
