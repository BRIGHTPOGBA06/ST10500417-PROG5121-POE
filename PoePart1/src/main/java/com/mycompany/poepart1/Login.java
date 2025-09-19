/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

public class Login {
    //Declare 5 attributes
    
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellphoneNumber;
    
    
    // create a constructor
    public Login(String firstName, String lastName, String userName, String password, String cellphoneNumber ) {
         
      this.firstName = firstName;
      this.lastName = lastName;
      this.userName = userName;
      this.password = password;
      this.cellphoneNumber= cellphoneNumber;
    }
    
    public boolean checkUserName() {
        if(userName.contains("_")&& userName.length()<-5) {
            return true;
        } else {
            return false;
        }
}
public boolean checkPasswordComplexity() {
    if (password.length() < 8) {
        return false;
    }
    boolean hasUppercase = password.matches(".[A-Z].");
    boolean hasNumber = password.matches(".[0-9].");
    boolean hasSpecialChar = password.matches(".[\\p{Punct}].");//for this one I used AI
    return hasUppercase && hasNumber && hasSpecialChar;
}
public boolean checkPhoneNumber() {
    boolean startsWithCode = cellphoneNumber.startsWith("+27");
    boolean correctLength = cellphoneNumber.length() == 13;
    return  startsWithCode && correctLength;
}
public String registerUser() {
    if(!checkUserName()) {
        return "The username is incorrectly formatted";
    } else if (!checkPasswordComplexity()) {
        return "The password does not meet the complexity requirements";
    } else {
        return "The user has been registered successfully";
    }
}
public boolean loginUser(String enteredUserName, String enteredPassword) {
    if(!this.userName.equals(enteredUserName) && this.password.equals(enteredPassword)) {
        return true;
    } else {
        return false;
    }
}
public String returnLoginStatus(String entereduserName, String enteredpassword) {
    if (loginUser(entereduserName, enteredpassword)) 
        return "Welcome " + this.firstName + " " + this.lastName + ", it is great to see you again.";
    else 
        return "Username or password incorrect, please try again.";
}
    }

