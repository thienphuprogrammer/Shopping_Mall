package shoppingmall.services;
import shoppingmall.models.Customer;

import java.util.ArrayList;

import static shoppingmall.utils.FileUtil.*;
import static shoppingmall.utils.ValidationUtil.*;

public class CustomerService {
//--------------------------properties------------------------
    protected Customer customer;
    protected ArrayList<Customer> listCustomer = new ArrayList<>();

    protected String filename;
//    --------------------------Getter and setter -----------------------

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(ArrayList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

//    ----------------------Constructor-------------------------

    public CustomerService() {
        this.filename = "data/customer.bin";
        loadListCustomer();
    }

    public CustomerService(String file) {
        this.filename = file;
        loadListCustomer();
    }
    public CustomerService(Customer customer) {
        this.filename = "data/customer.bin";
        this.customer = customer;
    }

    public CustomerService(Customer customer, String filename) {
        this.filename = filename;
        this.customer = customer;
    }

//    ----------------------------Method------------------------
    public boolean editUserName(String username) {
        if(isValidUserName(username) && findAccount(username) == null) {
            this.customer.setUsername(username);
            return true;
        }
        return false;
    }
    public boolean editPassword(String password) {
        if(isValidPassword(password)) {
            this.customer.setPassword(password);
            return true;
        }
        return false;
    }
    public boolean editPhoneNumber(String phoneNumber) {
            if (isValidPhoneNumber(phoneNumber)) {
                this.customer.setPhoneNumber(phoneNumber);
                return true;
            }
            return false;
    }
    public boolean editEmail(String email) {
        if(isValidEmail(email)  && findAccount(email) == null) {
            this.customer.setEmail(email);
            return true;
        }

        return false;
    }
    public boolean editFullName(String fullName) {
        if (isValidFullName(fullName)) {
            this.customer.setFullName(fullName);
            return true;
        }
        return false;
    }
    public boolean editIdentityNumber(String identityNumber) {
        if(isValidIdentityNumber(identityNumber)) {
            this.customer.setIdentityNumber(identityNumber);
            return true;
        }

        return false;
    }
    public Customer findAccount(String str ) { //str is user name or email
        for (Customer customer1: listCustomer) {
            if(str.equals(customer1.getUsername())
                    ||  str.equals(customer1.getEmail())) {
                return customer1;
            }
        }
        return null;
    }
    public Customer findAccount(int ID) {
        for (Customer customer1: listCustomer) {
            if(ID == customer1.getCustomerId()) {
                return customer1;
            }
        }
        return null;
    }
    public Customer checkAccount(String str, String pass) {
        for (Customer customer1: listCustomer) {
            if((str.equals(customer1.getUsername())
                    ||  str.equals(customer1.getEmail()))
                    && pass.equals(customer1.getPassword())) {
                return customer1;
            }
        }
        return null;
    }

    public void loadListCustomer() {
        Object object = loadFileObject(filename);
        if (object != null) {
            this.listCustomer = (ArrayList<Customer>) object;
        }
    }

    public void saveListCustomer() {
        if (listCustomer == null || listCustomer.isEmpty()) {
            return; // Nothing to save
        }

        if (filename != null) {
            saveFileObject(filename, listCustomer);
        }
    }
}