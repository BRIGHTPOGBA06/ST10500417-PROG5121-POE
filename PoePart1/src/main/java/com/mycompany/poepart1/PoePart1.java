


package com.mycompany.poepart1;
import java.util.Scanner;
public class PoePart1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("User Registration");
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone number (+27XXXXXXXXX): ");
        String cellphone = input.nextLine();

        Login user = new Login(username, password, cellphone, "registeredDate: ", "loginDate: ");

        String registerResult = user.registerUser();
        System.out.println(registerResult);

        if (registerResult.equals("The user has been registered successfully")) {
            System.out.println("User Login");
            System.out.print("Enter username to login: ");
            String loginUsername = input.nextLine();
            
            System.out.print("Enter password to login: ");
            String loginPassword = input.nextLine();
            
            boolean loginSuccess = (username.equals(loginUsername) && password.equals(loginPassword));
            String  loginStatus = loginSuccess
                    ?"Welcome " + username + ", it is good to see you again."
                    :"Username or password is incorrect, please try again.";

            System.out.println(loginStatus);

 
        }   
     
        input.close();
            
    }
}
