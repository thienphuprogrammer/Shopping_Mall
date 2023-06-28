package shoppingmall.views;
import shoppingmall.models.Customer;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.views.StandardView.*;

public class MenuCustomerView {
    private Customer customer;
    private ProductService productService;
    private int idUser;
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public static enum MENU_SHEET {
        EXIST,
        VIEW_INFO_ACC,
        EDIT_INFO_ACC,
        VIEW_PRODUCT,
        SEARCH_PRODUCT,
        FILTER_PRODUCT,
        ADD_TO_CART,
        VIEW_CART,
        CLEAR_CART,
        BUY_PRODUCT,
        VIEW_PRODUCT_BUYING,
        HISTORY_BOUGHT,
        LOG_OUT()
    }
    public static int getCustomerChoice() {
        System.out.println("+------------------------MENU--------------------------+");
        System.out.println("|    Nhập " + MENU_SHEET.EXIST.ordinal() +               " để quay trở về trang chủ.                  |");
        System.out.println("|    Nhập " + MENU_SHEET.VIEW_INFO_ACC.ordinal() +       " để xem thông tin tài khoản.                |");
        System.out.println("|    Nhập " + MENU_SHEET.EDIT_INFO_ACC.ordinal() +       " để xem chỉnh sửa thông tin tài khoản.      |");
        System.out.println("|    Nhập " + MENU_SHEET.VIEW_PRODUCT.ordinal() +        " xem hàng hóa.                              |");
        System.out.println("|    Nhập " + MENU_SHEET.SEARCH_PRODUCT.ordinal() +      " tìm kiếm sản phẩm.                         |");
        System.out.println("|    Nhập " + MENU_SHEET.FILTER_PRODUCT.ordinal() +      " lọc sản phẩm.                              |");
        System.out.println("|    Nhập " + MENU_SHEET.ADD_TO_CART.ordinal() +         " thêm hàng vào giỏ.                         |");
        System.out.println("|    Nhập " + MENU_SHEET.VIEW_CART.ordinal() +           " xem giỏ hàng.                              |");
        System.out.println("|    Nhập " + MENU_SHEET.CLEAR_CART.ordinal() +          " làm mới giỏ hàng.                          |");
        System.out.println("|    Nhập " + MENU_SHEET.BUY_PRODUCT.ordinal() +         " mua hàng.                                  |");
        System.out.println("|    Nhập " + MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal() + " xem hàng đang mua.                        |");
        System.out.println("|    Nhập " + MENU_SHEET.HISTORY_BOUGHT.ordinal() +      " xem lịch sử mua hàng.                     |");
        System.out.println("+------------------------------------------------------+");
        return readInt("Sự lựa chọn của bạn: ");
    }
    public void handleCustomerChoice() {
        while(true) {
            int choice = user.getUserChoice();
            if (choice == MENU_SHEET.EDIT_INFO_ACC.ordinal()) {
//                user.editInfoUser();
            } else if(choice == MENU_SHEET.VIEW_INFO_ACC.ordinal()) {
//                user.viewInfoAcc();
            } else if(choice == MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal()) {
//                user.viewListBuying();
            } else if (choice == MENU_SHEET.EXIST.ordinal()) {
                returnToHomePage();
                break;
            } else if (choice == MENU_SHEET.CLEAR_CART.ordinal()) {
//                user.clearCart();
            } else if (choice == MENU_SHEET.VIEW_PRODUCT.ordinal()) {
                customerShowListProduct();
            } else if (choice == MENU_SHEET.SEARCH_PRODUCT.ordinal()) {
                customerSearchProduct();
            } else if (choice == MENU_SHEET.FILTER_PRODUCT.ordinal()) {
                customerFilterProducts();
            } else if (choice == MENU_SHEET.ADD_TO_CART.ordinal()) {
//                user.addToCart();
            } else if (choice == MENU_SHEET.VIEW_CART.ordinal()) {
//                user.viewCart();
            } else if (choice == MENU_SHEET.BUY_PRODUCT.ordinal()) {
//                user.buyProducts();
            } else if (choice == MENU_SHEET.HISTORY_BOUGHT.ordinal()) {
//                user.viewPurchaseHistory();
            } else if (choice == MENU_SHEET.LOG_OUT.ordinal()) {

            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
            waitForInput();
        }
    }
    private void customerShowListProduct() {
        productService.showListProduct();
    }
    private void  customerSearchProduct() {
        String str = readString("Nhập vào id hoặc là tên của sản phẩm");
        productService.searchProducts(str);
    }
    private void customerFilterProducts() {

    }

    private static void returnToHomePage() {
        System.out.println("Quay trở về trang chủ...");
        // Code for returning to the home page
    }
    private void editInfoUser() {
        customer.showInfo(customer.getCustomerId());
        System.out.println("+----------------------------------------+");
    }
}
