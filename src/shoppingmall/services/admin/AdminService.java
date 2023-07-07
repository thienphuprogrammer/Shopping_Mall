package shoppingmall.services.admin;

import shoppingmall.models.admin.Admin;
import shoppingmall.models.customer.Customer;

import static shoppingmall.utils.OutputUtil.*;
import static shoppingmall.utils.FileUtil.*;

public class AdminService {
//    -------------------Property------------------------
    protected Admin admin;
    protected String filename;
//    ------------------------Getter and Setter------------------
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
//    ------------------------------Constructor-----------------------
    public AdminService() {
        this.filename = "data/admin.bin";
        loadListCustomer();
    }
    public AdminService(String filename, Admin admin) {
        this.admin = admin;
        this.filename = filename;
        loadListCustomer();
    }

    public void showInfo() {
        printLineSeparate("Information");
        printValueMenu("Username: " + admin.getUsername());
        printValueMenu("Password: " + admin.getPassword());
        printValueMenu("Email: " + admin.getEmail());
        printValueMenu("Full name: " + admin.getFullName());
        printValueMenu("Identity Number: " + admin.getIdentityNumber());
        printValueMenu("Admin ID: " + admin.getAdminID());
        printLineSeparate();
    }
    public Admin checkAccount(String str, String pass) {
        if((str.equals(admin.getUsername())
                ||  str.equals(admin.getEmail()))
                && pass.equals(admin.getPassword())) {
            return admin;
        }
        return null;
    }
    public void loadListCustomer() {
        Object object = loadFileObject(filename);
        if (object != null) {
            this.admin = (Admin) object;
        }
    }

    public void saveListCustomer() {
        if (admin == null) {
            return; // Nothing to save
        }
        if (filename != null) {
            saveFileObject(filename, admin);
        }
    }

}