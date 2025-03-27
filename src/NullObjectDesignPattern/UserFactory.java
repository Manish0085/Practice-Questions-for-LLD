package NullObjectDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class UserFactory{

    private static final Map<String, UserCredential> userDatabase = new HashMap<>();

    static {
        userDatabase.put("xyz1@gmail.com", new UserCredential("xyz1@gmail.com", "USER", "123456789"));
        userDatabase.put("xyz2@gmail.com", new UserCredential("xyz2@gmail.com", "USER", "987654321"));
        userDatabase.put("xyz3@gmail.com", new UserCredential("xyz3@gmail.com", "ADMIN", "147852369"));
        userDatabase.put("xyz4@gmail.com", new UserCredential("xyz4@gmail.com", "USER", "963258741"));
    }

    public static User authenticateUser(String email, String password){
        UserCredential userCredential = userDatabase.get(email);
        if (userCredential != null && userCredential.getPassword().equals(password)){
            return new RealUser(userCredential.getUsername(), userCredential.getRole());
        }
        return new NullUserObject();
    }
}
