package shoppingmall.models;

import java.io.Serializable;

import static shoppingmall.Account.AccountUser.AccountUser;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L; // added serialVersionUID field
    protected String username;
    protected String password;
    protected String phoneNumber;
    protected String email;
    protected String fullName;
    protected String identityNumber;
    protected int customerId;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer() {
        this("", "", "", "", "", "", 0);
    }

    public Customer(String username, String password, String phoneNumber, String email, String fullName, String identityNumber, int customerId) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fullName = fullName;
        this.identityNumber = identityNumber;
        this.customerId = customerId;
    }

    public void showInfo(int userID) {
        System.out.println("+---------------------------------------------------+");
        System.out.println("| Username: " + username + " ".repeat(40 - String.valueOf(username).length()) + "|");
        System.out.println("| Password: " + password + " ".repeat(40 - String.valueOf(password).length()) + "|");
        System.out.println("| Phone Number: " + phoneNumber + " ".repeat(36 - String.valueOf(phoneNumber).length()) + "|");
        System.out.println("| Email: " + email + " ".repeat(43 - String.valueOf(email).length()) + "|");
        System.out.println("| Full Name: " + fullName + " ".repeat(39 - String.valueOf(fullName).length()) + "|");
        System.out.println("| Identity Number: " + identityNumber + " ".repeat(33 - String.valueOf(identityNumber).length()) + "|");
        System.out.println("| customerId: " + customerId + " ".repeat(38 - String.valueOf(customerId).length()) + "|");
        System.out.println("+---------------------------------------------------+\n\n");
    }
}
