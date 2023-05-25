package Shopping_Mall.CommonFunction.Account;

import java.io.Serializable;

public class InfoUser implements Serializable {
    private static final long serialVersionUID = 1L; // added serialVersionUID field
    String username;
    String password;
    String phoneNumber;
    String email;
    String fullName;
    String identityNumber;
    int customerId;

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
