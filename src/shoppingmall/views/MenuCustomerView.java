package shoppingmall.views;

import shoppingmall.models.Customer;
import shoppingmall.models.Order;
import shoppingmall.models.Product;
import shoppingmall.services.OrderService;
import shoppingmall.services.productService.FilterProductService;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.InputUtil.readInt;
import static shoppingmall.utils.InputUtil.readString;
import static shoppingmall.views.StandardView.*;

public class MenuCustomerView {
    private static Customer customer;
    private static ProductService productCustomer = new ProductService();
    private static int idUser;
    private static String filename;
    private static OrderService orderService = new OrderService("data/cart.bin", idUser);

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

    public static OrderService getOrderService() {
        return orderService;
    }

    public static void setOrderService(OrderService orderService) {
        filename = "data/cart.bin";
        MenuCustomerView.orderService = orderService;
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
        while (true) {

            int choice = getCustomerChoice();
            if (choice == MENU_SHEET.EDIT_INFO_ACC.ordinal()) {
                // user.editInfoUser();
            } else if (choice == MENU_SHEET.VIEW_INFO_ACC.ordinal()) {
                // user.viewInfoAcc();
            } else if (choice == MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal()) {
                // user.viewListBuying();
            } else if (choice == MENU_SHEET.EXIST.ordinal()) {
                returnToHomePage();
                break;
            } else if (choice == MENU_SHEET.CLEAR_CART.ordinal()) {
                clearCart();
            } else if (choice == MENU_SHEET.VIEW_PRODUCT.ordinal()) {
                customerShowListProduct();
            } else if (choice == MENU_SHEET.SEARCH_PRODUCT.ordinal()) {
                customerSearchProduct();
            } else if (choice == MENU_SHEET.FILTER_PRODUCT.ordinal()) {
                customerFilterProducts(productCustomer);
            } else if (choice == MENU_SHEET.ADD_TO_CART.ordinal()) {
                addToCart();
            } else if (choice == MENU_SHEET.VIEW_CART.ordinal()) {
                viewCart();
            } else if (choice == MENU_SHEET.BUY_PRODUCT.ordinal()) {
                // user.buyProducts();
            } else if (choice == MENU_SHEET.HISTORY_BOUGHT.ordinal()) {
                // user.viewPurchaseHistory();
            } else if (choice == MENU_SHEET.LOG_OUT.ordinal()) {

            } else {
                printValueln("Lựa chọn không hợp lệ.");
            }
            waitForInput();

        }

    }

    private static void customerShowListProduct() {
        productCustomer.showListProduct();
    }

    private static void customerSearchProduct() {
        String str = readString("Nhập vào id hoặc là tên của sản phẩm: ");
        productCustomer.searchProducts(str);
    }

    private static void customerFilterProducts(ProductService listProduct) {
        FilterProductService value = new FilterProductService(listProduct);
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
        customerFilterProducts(value.getNewList());
    }

    private static void addToCart() {
        printValueln("Thêm hàng vào giỏ...");
        // Code for adding items to cart
        int id = readInt("Nhập vào id của sản phẩm: ");
        int count = readInt("Nhập so luong san pham can mua: ");
        for (Product product : productCustomer.getListProduct()) {
            if (product.getCount() > 0) {
                if (product.getId() == id) {
                    product.setCount(1);
                    orderService.addItem(product, count);
                    System.out.println("Đã thêm vào giỏ hàng. ");
                    break;
                }
            } else {
                System.out.println("Sản phẩm đã hết hàng!!!");
                break;
            }

        }
    }

    public static void viewCart() {
        System.out.println("Xem giỏ hàng...");
        // Code for viewing the cart
        orderService.viewOrder();

        float sumPrice = 0;
        for (Order order : orderService.getListOrder())
            sumPrice += order.getProduct().getPrice() * order.getTotalAmount();
        System.out.println("Tổng giá tiền của hóa đơn là: " + sumPrice);
    }

    public static void clearCart() {
        System.out.println("Xóa giỏ hàng...");
        orderService.clearProduct();
        System.out.println("Giỏ hàng đã được làm mới!!");
    }

    private static void returnToHomePage() {
        printValueln("Quay trở về trang chủ...");
        // Code for returning to the home page
    }
}
