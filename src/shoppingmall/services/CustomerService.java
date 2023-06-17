package shoppingmall.services;

import shoppingmall.Account.SignUp;
import shoppingmall.models.Customer;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static shoppingmall.utils.FileUtil.loadFileObject;
import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.utils.ValidationUtil.*;

public class CustomerService {
    Customer customer = new Customer();
    private String filename;
    private boolean isChangeUserName;
    private boolean isChangeEmail;
    private boolean isChangePassword;
    private boolean isChangePhoneNumber;
    private boolean isChangeFullName;
    private boolean isChangeIdentityNumber;

    CustomerService (Customer user, String file) {
        this.customer = user;
        this.filename = file;
    }

    void menu() {
        while (true) {
            System.out.println("+----------------------------------------+");
            System.out.println("|   Nhập 0 để trở về menu.               |");
            System.out.println("|   Nhập 1 để thay đổi tên đăng nhập.    |");
            System.out.println("|   Nhập 2 để thay đổi password.         |");
            System.out.println("|   Nhập 3 để thay đổi số điện thoại.    |");
            System.out.println("|   Nhập 4 để thay đổi email.            |");
            System.out.println("|   Nhập 5 để thay dồi họ và tên.        |");
            System.out.println("|   Nhập 6 để thay đổi CMND.             |");
            System.out.println("+----------------------------------------+");
            int choice = readInt("Sự lựa chọn của bạn: ");
            if (choice == 0) {
                return;
            } else if(choice == 1) {
                //Function to edit user name
                editUserName();
            } else if(choice == 2) {
                //Function to edit password
                editPassword();
            } else if (choice == 3) {
                //Function to edit phone number
                editPhoneNumber();
            } else if (choice == 4) {
                //Function to edit email
                editEmail();
            } else if (choice == 5) {
                //Function to edit full name
                editFullName();
            } else if (choice == 6) {
                //Function to edit identity Number
                editIdentityNumber();
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
            if (checkExistUser()) {
                System.out.println("Đổi thông tin tài khoảng thành công !!");
                return;
            }
            else {
                System.out.println("Thông tin không hợp lệ!!");
                isChangeUserName = false;
                isChangeEmail = false;
            }
        }
    }
    public boolean checkExistUser() {
        return false;
    }
    public void editUserName() {
        String username = readString("Tên đăng nhập: ");
        if(isValidUserName(username)) {
            this.customer.setUsername(username);
            isChangeUserName = true;
        }
        else {
            System.out.println("Tên đăng nhập phải có chiều dài lớn hơn 5 và ít hơn 20 kí tự");
        }
    }
    public void editPassword() {
        String password = "";
        password = readString("Mật khẩu: ");

        if(isValidPassword(password)) {
            this.customer.setPassword(password);
            isChangeUserName = true;
        }
        else {
            System.out.println("Mật khẩu phải có ít nhất 8 kí tự.");
        }

    }
    public void editPhoneNumber() {
        String phoneNumber = "";
            phoneNumber = readString("Số điện thoại: ");
            if (isValidPhoneNumber(phoneNumber)) {
                this.customer.setPhoneNumber(phoneNumber);
            }
            else{
                System.out.println("Số điện thoại không hợp lệ.");
            }
    }
    public void editEmail() {
        String email = readString("Email: ");
            if(isValidEmail(email)) {
                this.customer.setEmail(email);
                this.isChangeEmail = true;
            }
            else {
                System.out.println("Email không hợp lệ.");
            }
    }
    private void editFullName() {
        String fullName = readString("Họ và tên: ");
        if (isValidFullName(fullName)) {
            this.customer.setFullName(fullName);
            this.isChangeFullName = true;
        }
    }
    private void editIdentityNumber() {
        String identityNumber = readString("Số CMND: ");
        if(isValidIdentityNumber(identityNumber)) {
            this.customer.setIdentityNumber(identityNumber);
            this.isChangePhoneNumber = true;
        }
        else {
            System.out.println("SDT không hợp lệ.");
        }
    }

    public Customer findAccount(String str) {
        ArrayList<Customer> listCustomer;
        Object object = loadFileObject(filename);
        if (object != null) {
            listCustomer = (ArrayList<Customer>) object;
            for (Customer customer1: listCustomer) {
                if(str.equals(customer1.getUsername())
                        ||  str.equals(customer1.getEmail())) {
                    return customer1;
                }
            }
        }
        return null;
    }

    public Customer checkAccountExit(String str, String pass) {
        ArrayList<Customer> listCustomer;
        Object object = loadFileObject(filename);
        if (object != null) {
            listCustomer = (ArrayList<Customer>) object;
            for (Customer customer1: listCustomer) {
                if((str.equals(customer1.getUsername())
                        ||  str.equals(customer1.getEmail()))
                        && pass.equals(customer1.getPassword())) {
                    return customer1;
                }
            }
        }
        return null;
    }
    public boolean()
}