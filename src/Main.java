import shoppingmall.services.CustomerService;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.InputUtil.readInt;
import static shoppingmall.views.LogInView.*;
import static shoppingmall.views.CustomerView.*;
import static shoppingmall.views.SignUpView.signUpCustomerView;
import static shoppingmall.utils.OutputUtil.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
//            -------------------Start Program------------------
            ProductService productCustomer = new ProductService("data/product.bin");


//            ----------------------Shop-------------------------


//           -------------------- Customer--------------------------
//            Account
            CustomerService customerService = new CustomerService();
            boolean statusLogin = false;
            printLineSeparate("Menu");
            printValueMenu("0 de tro ve trang chu");
            printValueMenu("1 Dang nhap vao tai khoan customer");
            printValueMenu("2 Dang ky vao tai khoan customer");
            printLineSeparate();

            int choice = readInt("Sự lựa chọn của bạn: ");
            if (choice == 1) {
                customerService = loginCustomerView("data/customer.bin");
                if (customerService != null) {
                    statusLogin = true;
                } else {
                    continue;
                }
            } else if (choice == 2) {
                signUpCustomerView("data/customer.bin");
            } else {
                break;
            }

//            Product
            if (statusLogin) {
                InitCustomer(productCustomer, customerService);
                showViewCustomer();
                productCustomer.saveListProduct();
                break;
            }

        }
    }
}