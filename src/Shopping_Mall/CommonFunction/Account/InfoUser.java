package Shopping_Mall.CommonFunction.Account;

import java.io.Serializable;

public class InfoUser implements Serializable {
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

    public InfoUser() {
        this("", "", "", "", "", "", 0);
    }

    public InfoUser(String username, String password, String phoneNumber, String email, String fullName, String identityNumber, int customerId) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fullName = fullName;
        this.identityNumber = identityNumber;
        this.customerId = customerId;
    }

    public void showInfo() {
        System.out.print("Username: " + username);
        System.out.print(", Password: " + password);
        System.out.print(", Phone Number: " + phoneNumber);
        System.out.print(", Email: " + email);
        System.out.print(", Full Name: " + fullName);
        System.out.println(", Identity Number: " + identityNumber);
    }
}
