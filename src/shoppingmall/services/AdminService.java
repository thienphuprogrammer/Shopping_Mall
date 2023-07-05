package shoppingmall.services;

import shoppingmall.models.Admin;
import shoppingmall.models.Customer;

import java.util.ArrayList;

import static shoppingmall.utils.FileUtil.loadFileObject;
import static shoppingmall.utils.FileUtil.saveFileObject;

public class AdminService {
//    -------------------Property------------------------
    private Admin admin;
    private String filename;
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
    }
    public AdminService(String filename, Admin admin) {
        this.admin = admin;
        this.filename = filename;
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