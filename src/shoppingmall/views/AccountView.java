package shoppingmall.views;

import shoppingmall.services.customer.CustomerService;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.utils.OutputUtil.*;
import static shoppingmall.utils.ValidationUtil.*;

public class AccountView {
    private static CustomerService customerService = new CustomerService("data/customer.bin");

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static void setCustomerService(CustomerService customerService) {
        AccountView.customerService = customerService;
    }

    public static void accountView(CustomerService customerService) {
        setCustomerService(customerService);
        while (true) {
            printLineSeparate();
            printValueMenu("Nhập 0 để trở về menu.");
            printValueMenu("Nhập 1 để thay đổi tên đăng nhập.");
            printValueMenu("Nhập 2 để thay đổi password.");
            printValueMenu("Nhập 3 để thay đổi số điện thoại.");
            printValueMenu("Nhập 4 để thay đổi email.");
            printValueMenu("Nhập 5 để thay dồi họ và tên.");
            printValueMenu("Nhập 6 để thay đổi CMND.");
            printLineSeparate();
            int choice = readInt("Sự lựa chọn của bạn: ");
            boolean status = false;

            if (choice == 0) {
                return;
            } else if(choice == 1) {
                //Function to edit user name
                status = editUserName();
            } else if(choice == 2) {
                //Function to edit password
                status =editPassword();
            } else if (choice == 3) {
                //Function to edit phone number
                status =editPhoneNumber();
            } else if (choice == 4) {
                //Function to edit email
                status =editEmail();
            } else if (choice == 5) {
                //Function to edit full name
                status =editFullName();
            } else if (choice == 6) {
                //Function to edit identity Number
                status =editIdentityNumber();
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }

            if (status) {
                customerService.saveListCustomer();
            }
        }
    }
    public static boolean editUserName() {
        String username = readString("Tên đăng nhập: ");
        if(!isValidUserName(username)) {
            printValueln("Tên đăng nhập phải có chiều dài lớn hơn 5 và ít hơn 20 kí tự");
        } else if (customerService.editUserName(username)) {
            printValueln("Thay dổi thành công!!");
        }  else {
            printValueln("Ten dang nhap da ton tai!!!");
            return false;
        }
        return true;
    }
    public static boolean editPassword() {
        String password = readString("Mật khẩu: ");
        if (customerService.editPassword(password)) {
            printValueln("Thay dổi thành công!!");

        } else {
            System.out.println("Mật khẩu phải có ít nhất 8 kí tự.");
            return false;
        }
        return true;
    }
    public static boolean editPhoneNumber() {
        String phoneNumber = readString("Số điện thoại: ");

        if (customerService.editPhoneNumber(phoneNumber)) {
            printValueln("Thay dổi thành công!!");

        } else {
            System.out.println("Số điện thoại không hợp lệ.");
            return false;
        }
        return true;
    }
    public static boolean editEmail() {
        String email = readString("Email: ");
        if(isValidEmail(email)) {
            System.out.println("Email không hợp lệ.");
            return false;
        }
        else if (customerService.editEmail(email)) {
            printValueln("Thay dổi thành công!!");

        } else {
            printValueln("Email da ton tai!!");
            return false;
        }
        return true;
    }
    public static boolean editFullName() {
        String fullName = readString("Họ và tên: ");
        if (customerService.editFullName(fullName)) {
            printValueln("Thay dổi thành công!!");

        } else {
            System.out.println("Họ và tên không hợp lệ.");
            return false;
        }
        return true;
    }
    public static boolean editIdentityNumber() {
        String identityNumber = readString("Số CMND: ");
        if (customerService.editIdentityNumber(identityNumber)) {
            printValueln("Thay dổi thành công!!");

        } else {
            System.out.println("CMND không hợp lệ.");
            return false;
        }
        return true;
    }
}