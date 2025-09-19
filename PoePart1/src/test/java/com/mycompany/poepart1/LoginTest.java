/*brigh
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void testValidUsername() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+27830551961");
        assertTrue(login.checkUserName(), "Username should be valid");
    }

    @Test
    void testInvalidUsernameTooShort() {
        Login login = new Login("Brigh", "Moyo", "BM", "Cy@abcde0987", "+27830551961");
        assertFalse(login.checkUserName(), "Username should be invalid due to length");
    }

    @Test
    void testInvalidUsernameNoUnderscore() {
        Login login = new Login("Brigh", "Moyo", "BrighM", "Cy@abcde0987", "+27830551961");
        assertFalse(login.checkUserName(), "Username should be invalid due to missing underscore");
    }

    
    @Test
    void testValidPassword() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+27830551961");
        assertTrue(login.checkPasswordComplexity(), "Password should meet complexity requirements");
    }

    @Test
    void testInvalidPasswordTooShort() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abc", "+27830551961");
        assertFalse(login.checkPasswordComplexity(), "Password should be invalid due to length");
    }

    @Test
    void testInvalidPasswordMissingSpecialChar() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cyabcde0987", "+27830551961");
        assertFalse(login.checkPasswordComplexity(), "Password should be invalid due to missing special character");
    }

    
    @Test
    void testValidPhoneNumber() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+27830551961");
        assertTrue(login.checkPhoneNumber(), "Phone number should be valid");
    }

    @Test
    void testInvalidPhoneNumberWrongPrefix() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "07230551961");
        assertFalse(login.checkPhoneNumber(), "Phone number should be invalid due to missing +27");
    }

    @Test
    void testInvalidPhoneNumberWrongLength() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+2783055196");
        assertFalse(login.checkPhoneNumber(), "Phone number should be invalid due to incorrect length");
    }

    @Test
    void testSuccessfulLogin() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+27830551961");
        assertTrue(login.loginUser("Brigh_M", "Cy@abcde0987"), "Login should succeed");
    }

    @Test
    void testFailedLoginWrongUsername() {
        Login login = new Login("Bright", "Moyo", "Bright_M", "Cy@abcde0987", "+27830551961");
        assertFalse(login.loginUser("WrongUser", "Cy@abcde0987"), "Login should fail due to wrong username");
    }

    @Test
    void testFailedLoginWrongPassword() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+27830551961");
        assertFalse(login.loginUser("Brigh_M", "WrongPass"), "Login should fail due to wrong password");
    }

    @Test
    void testLoginStatusSuccessMessage() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+27830551961");
        String expected = "Welcome Brigh Moyo, it is great to see you again.";
        assertEquals(expected, login.returnLoginStatus("Brigh_M", "Cy@abcde0987"), "Login message should match");
    }

    @Test
    void testLoginStatusFailureMessage() {
        Login login = new Login("Brigh", "Moyo", "Brigh_M", "Cy@abcde0987", "+27830551961");
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, login.returnLoginStatus("WrongUser", "WrongPass"), "Failure message should match");
    }
}
    

    
            
