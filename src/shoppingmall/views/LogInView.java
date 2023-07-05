package shoppingmall.views;

import shoppingmall.services.CustomerService;
import shoppingmall.services.LogInService;

import static shoppingmall.utils.InputUtil.readString;

public class LogInView {
    public static CustomerService loginCustomerView(String filename) {
        String str = readString("Ten dang nhap hoac la email: ");
        String password = readString("Mat khau: ");
        LogInService log = new LogInService(filename);
        return log.logInCustomer(str, password);
    }
}
