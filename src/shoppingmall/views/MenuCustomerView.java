package shoppingmall.views;
import shoppingmall.models.Customer;
import shoppingmall.services.productService.FilterProductService;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.views.StandardView.*;

public class MenuCustomerView {
    private static Customer customer;
    private static ProductService productCustomer = new ProductService();
    private static int idUser;
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        MenuCustomerView.customer = customer;
    }

    public static ProductService getProductCustomer() {
        return productCustomer;
    }

    public static void setProductCustomer(ProductService productCustomer) {
        MenuCustomerView.productCustomer = productCustomer;
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
        printLineSeparate();
        printValueMenu("Nhập " + MENU_SHEET.EXIST.ordinal() + " để quay trở về trang chủ.");
        printValueMenu("Nhập " + MENU_SHEET.VIEW_INFO_ACC.ordinal() + " để xem thông tin tài khoản.");
        printValueMenu("Nhập " + MENU_SHEET.EDIT_INFO_ACC.ordinal() + " để xem chỉnh sửa thông tin tài khoản.");
        printValueMenu("Nhập " + MENU_SHEET.VIEW_PRODUCT.ordinal() + " xem hàng hóa.");
        printValueMenu("Nhập " + MENU_SHEET.SEARCH_PRODUCT.ordinal() + " tìm kiếm sản phẩm.");
        printValueMenu("Nhập " + MENU_SHEET.FILTER_PRODUCT.ordinal() + " lọc sản phẩm. ");
        printValueMenu("Nhập " + MENU_SHEET.ADD_TO_CART.ordinal() + " thêm hàng vào giỏ.");
        printValueMenu("Nhập " + MENU_SHEET.VIEW_CART.ordinal() + " xem giỏ hàng. ");
        printValueMenu("Nhập " + MENU_SHEET.CLEAR_CART.ordinal() + " làm mới giỏ hàng.");
        printValueMenu("Nhập " + MENU_SHEET.BUY_PRODUCT.ordinal() + " mua hàng.");
        printValueMenu("Nhập " + MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal() + " xem hàng đang mua.");
        printValueMenu("Nhập " + MENU_SHEET.HISTORY_BOUGHT.ordinal() + " xem lịch sử mua hàng.");
        printLineSeparate();
        return readInt("Sự lựa chọn của bạn: ");
    }
    public static void handleCustomerChoice() {

        int choice = getCustomerChoice();
        if (choice == MENU_SHEET.EDIT_INFO_ACC.ordinal()) {
//                user.editInfoUser();
            continue;
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
            printValueln("Lựa chọn không hợp lệ.");
        }
    }
    private static void customerShowListProduct() {
        productCustomer.showListProduct();
    }
    private static void  customerSearchProduct() {
        String str = readString("Nhập vào id hoặc là tên của sản phẩm");
        productCustomer.searchProducts(str);
    }
    private static void customerFilterProducts() {
        FilterProductService value = new FilterProductService(productCustomer);
        printLineSeparate();
        printValueMenu("Nhập 0 để trở về menu.");
        printValueMenu("Nhập 1 để lọc sản phẩm theo số lượng.");
        printValueMenu("Nhập 2 để lọc sản phẩm theo giá.");
        printValueMenu("Nhập 3 để lọc sản phẩm theo loại.");
        printLineSeparate();
        
        int choice = readInt("Sự lựa chọn của bạn: ");
        if (choice == 0) {
            return;
        } else if (choice == 1) {
            value.filterCount();
        } else if (choice == 2) {
            value.filterPrice();
        } else {
            value.filterType();
        }
        value.getNewList().showListProduct();
        new FilterProductService(value.getNewList());

    }
    private static void returnToHomePage() {
        printValueln("Quay trở về trang chủ...");
        // Code for returning to the home page
    }
    private static void editInfoUser() {
        customer.showInfo(customer.getCustomerId());
        printLineSeparate();
    }
}
