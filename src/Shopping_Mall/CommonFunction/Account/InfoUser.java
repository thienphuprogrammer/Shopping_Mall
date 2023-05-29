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

    public void showInfo(int userID) {
        System.out.println("+---------------------------------------------------+");
        System.out.println("| Username: " + username + " ".repeat(40 - String.valueOf(username).length()) + "|");
        System.out.println("| Password: " + password + " ".repeat(40 - String.valueOf(password).length()) + "|");
        System.out.println("| Phone Number: " + phoneNumber + " ".repeat(36 - String.valueOf(phoneNumber).length()) + "|");
        System.out.println("| Email: " + email + " ".repeat(43 - String.valueOf(email).length()) + "|");
        System.out.println("| Full Name: " + fullName + " ".repeat(39 - String.valueOf(fullName).length()) + "|");
        System.out.println("| Identity Number: " + identityNumber + " ".repeat(32 - String.valueOf(identityNumber).length()) + "|");
        System.out.println("| customerId: " + customerId + " ".repeat(38 - String.valueOf(customerId).length()) + "|");
        System.out.println("+---------------------------------------------------+\n\n");
    }
}
