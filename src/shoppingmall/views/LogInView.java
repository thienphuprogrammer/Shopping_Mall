package shoppingmall.views;

import shoppingmall.services.admin.AdminService;
import shoppingmall.services.admin.LogInAdminService;
import shoppingmall.services.customer.CustomerService;
import shoppingmall.services.customer.LogInCustomerService;

import static shoppingmall.utils.InputUtil.readString;

public class LogInView {
    public static CustomerService loginCustomerView(String filename) {
        String str = readString("Ten dang nhap hoac la email: ");
        String password = readString("Mat khau: ");
        LogInCustomerService log = new LogInCustomerService(filename);
        return log.logIn(str, password);
    }

    public static AdminService loginAdminView(String filename) {
        String str = readString("Ten dang nhap hoac la email: ");
        String password = readString("Mat khau: ");
        LogInAdminService log = new LogInAdminService(filename);
        return log.logIn(str, password);
    }
}
