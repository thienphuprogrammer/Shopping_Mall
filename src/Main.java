import shoppingmall.services.admin.AdminService;
import shoppingmall.services.productService.ProductService;
import shoppingmall.views.admin.AdminView;
import shoppingmall.views.customer.CustomerView;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.utils.OutputUtil.*;


public class Main {
    public static void main(String[] args) {
//        Admin admin = new Admin("admin123","123","admin@gmail.com","admin","1234567890",0);
//        AdminService adminService = new AdminService("data/admin.bin",admin);
//        adminService.saveListCustomer();
        while (true) {
            printLineSeparate("Menu");
            printValueMenu("0 de thoat khoai chuong trinh");
            printValueMenu("1 de dang nhap tai khoan admin");
            printValueMenu("2 de dang nhap tai khoan khach hang");
            printLineSeparate();
            int choice = readInt("Su lua chon cua ban: ");
            clearScreen();
//            -------------------Start Program------------------
            if(choice == 1) {
                AdminView.showViewAdmin();
            } else if(choice == 2) {
                CustomerView.showViewCustomer();
            } else if (choice == 0){
                break;
            }

        }
    }
}