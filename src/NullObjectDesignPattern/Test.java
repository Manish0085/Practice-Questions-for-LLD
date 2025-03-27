package NullObjectDesignPattern;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the email ");
        String name = sc.nextLine();
        System.out.print("Enter the password ");
        String password = sc.nextLine();


        User user = UserFactory.authenticateUser("xyz4@gmail.com", "963258741");

        System.out.println(user.isAuthenticated()? "User logged in successfully with credentials" +
                "\n    Email:- "+user.getUsername()+"\n    Role:- "+user.getRole(): "User is not logged in");
    }
}
