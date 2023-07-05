package shoppingmall.views;

import shoppingmall.models.Customer;
import shoppingmall.services.CustomerService;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.utils.OutputUtil.*;
import static shoppingmall.utils.ValidationUtil.*;

public class SignUpView {
    private static String fileName;
    private static CustomerService customerService;

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static void setCustomerService(CustomerService customerService) {
        SignUpView.customerService = customerService;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        SignUpView.fileName = fileName;
    }

    public static boolean signUpCustomerView(String filename) {
        SignUpView.fileName = filename;
        SignUpView.customerService = new CustomerService(filename);
        SignUpView.customerService.loadListCustomer();
        String username = readString("Tên đăng nhập: ");
        if(!isValidUserName(username)) {
            printValueln("Tên đăng nhập phải có chiều dài lớn hơn 5 và ít hơn 20 kí tự");
            return false;
        } else if (customerService.findAccount(username) != null) {
            printValueln("Ten dang nhap da ton tai!!!");
            return false;
        }
        String password = readString("Mật khẩu: ");
        if(!isValidPassword(password)) {
            System.out.println("Mật khẩu phải có ít nhất 8 kí tự.");
            return false;
        }
        String phoneNumber = readString("Số điện thoại: ");
        if(!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Số điện thoại không hợp lệ.");
            return false;
        }
        String email = readString("Email: ");
        if(!isValidEmail(email)) {
            System.out.println("Email không hợp lệ.");
            return false;
        } else if(customerService.findAccount(email) != null) {
            printValueln("Email da ton tai!!");
            return false;
        }
        String fullName = readString("Họ và tên: ");
        if(!isValidFullName(fullName)) {
            System.out.println("Họ và tên không hợp lệ.");
            return false;
        }
        String identityNumber = readString("Số CMND: ");
        if(!isValidIdentityNumber(identityNumber)) {
            System.out.println("CMND không hợp lệ.");
            return false;
        }

        printValueln("Dang ki thanh cong");
        customerService.getListCustomer().add(
                new Customer(username, password,phoneNumber,email,fullName,identityNumber,
                        customerService.getListCustomer().size())
        );
        customerService.saveListCustomer();
        return true;
    }
}
