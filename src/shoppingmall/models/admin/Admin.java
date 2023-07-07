package shoppingmall.models.admin;

import java.io.Serial;
import java.io.Serializable;

public class Admin implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // added serialVersionUID field
//    ---------------------Property----------------------
    protected String username;
    protected String password;
    protected String email;
    protected String fullName;
    protected String identityNumber;
    protected int adminID;

//    ---------------------Constructor------------------

    public Admin(String username, String password, String email, String fullName, String identityNumber, int adminID) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.identityNumber = identityNumber;
        this.adminID = adminID;
    }

//    --------------------Getter and Setter----------------------


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

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
}