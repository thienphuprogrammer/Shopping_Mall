package shoppingmall.views;

import shoppingmall.models.Customer;
import shoppingmall.models.Order;
import shoppingmall.models.Product;
import shoppingmall.services.CustomerService;
import shoppingmall.services.OrderService;
import shoppingmall.services.PaymentService;
import shoppingmall.services.productService.FilterProductService;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.utils.OutputUtil.*;

public class CustomerView {

//    -----------------Declare variable of class-------------------------
    private static Customer customer;
    private static ProductService productCustomer;
    private static OrderService orderService;
    private static CustomerService customerService;
    private static PaymentService paymentService;

//    ------------------Set getter and setter of class-----------------------------------

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        CustomerView.customer = customer;
    }

    public static ProductService getProductCustomer() {
        return productCustomer;
    }

    public static OrderService getOrderService() {
        return orderService;
    }

    public static void setProductCustomer(ProductService productCustomer) {
        CustomerView.productCustomer = productCustomer;
    }

    public static void setOrderService(OrderService orderService) {
        CustomerView.orderService = orderService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static void setCustomerService(CustomerService customerService) {
        CustomerView.customerService = customerService;
    }
    public static PaymentService getPaymentService() {
        return paymentService;
    }

    public static void setPaymentService(PaymentService paymentService) {
        CustomerView.paymentService = paymentService;
    }

    //    -----------------Constructor-------------------------
    public static void InitCustomer(ProductService productCustomer, CustomerService customerService) {
        CustomerView.productCustomer = productCustomer;
        CustomerView.customerService = customerService;
        CustomerView.customer = customerService.getCustomer();
        CustomerView.orderService = new OrderService("data/cart.bin", customer.getCustomerId());
        CustomerView.productCustomer = new ProductService("data/product.bin");
        CustomerView.paymentService = new PaymentService("data/product_is_buying.bin", customer.getCustomerId());
    }
//    --------------------------Declare method of class------------------------------
    public static enum MENU_CUSTOMER_SHEET {
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
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.EXIST.ordinal() + " để quay trở về trang chủ.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.VIEW_INFO_ACC.ordinal() + " để xem thông tin tài khoản.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.EDIT_INFO_ACC.ordinal() + " để xem chỉnh sửa thông tin tài khoản.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.VIEW_PRODUCT.ordinal() + " xem hàng hóa.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.SEARCH_PRODUCT.ordinal() + " tìm kiếm sản phẩm.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.FILTER_PRODUCT.ordinal() + " lọc sản phẩm. ");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.ADD_TO_CART.ordinal() + " thêm hàng vào giỏ.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.VIEW_CART.ordinal() + " xem giỏ hàng. ");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.CLEAR_CART.ordinal() + " làm mới giỏ hàng.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.BUY_PRODUCT.ordinal() + " mua hàng.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.VIEW_PRODUCT_BUYING.ordinal() + " xem hàng đang mua.");
        printValueMenu("Nhập " + MENU_CUSTOMER_SHEET.HISTORY_BOUGHT.ordinal() + " xem lịch sử mua hàng.");
        printLineSeparate();
        return readInt("Sự lựa chọn của bạn: ");
    }
    public static void showViewCustomer() {
        while (true) {
            int choice = getCustomerChoice();
            if (choice == MENU_CUSTOMER_SHEET.EDIT_INFO_ACC.ordinal()) {
                 editInfoCustomer();
            } else if (choice == MENU_CUSTOMER_SHEET.VIEW_INFO_ACC.ordinal()) {
                 viewInfoCustomer();
            } else if (choice == MENU_CUSTOMER_SHEET.VIEW_PRODUCT_BUYING.ordinal()) {
                // user.viewListBuying();
            } else if (choice == MENU_CUSTOMER_SHEET.EXIST.ordinal()) {
                returnToHomePage();
                break;
            } else if (choice == MENU_CUSTOMER_SHEET.CLEAR_CART.ordinal()) {
                clearCart();
            } else if (choice == MENU_CUSTOMER_SHEET.VIEW_PRODUCT.ordinal()) {
                customerShowListProduct();
            } else if (choice == MENU_CUSTOMER_SHEET.SEARCH_PRODUCT.ordinal()) {
                customerSearchProduct();
            } else if (choice == MENU_CUSTOMER_SHEET.FILTER_PRODUCT.ordinal()) {
                customerFilterProducts(productCustomer);
            } else if (choice == MENU_CUSTOMER_SHEET.ADD_TO_CART.ordinal()) {
                addToCart();
            } else if (choice == MENU_CUSTOMER_SHEET.VIEW_CART.ordinal()) {
                viewCart();
            } else if (choice == MENU_CUSTOMER_SHEET.BUY_PRODUCT.ordinal()) {
                 buyProducts();
            } else if (choice == MENU_CUSTOMER_SHEET.HISTORY_BOUGHT.ordinal()) {
                 viewPurchaseHistory();
            } else if (choice == MENU_CUSTOMER_SHEET.LOG_OUT.ordinal()) {

            } else {
                printValueln("Lựa chọn không hợp lệ.");
            }
            waitForInput();
        }
    }

    private static void buyProducts() {
        printValueln("Mua hàng...");
        String question = readString("Bạn có chắc là muốn mua hàng không (Y/N): ");
        if (question.equals("Y") || question.equals("y")) {
            paymentService.buyProducts(orderService.getListOrder(), customer.getCustomerId());
            orderService.clearProduct();

        }  else {
            printValueln("Đã hủy mua hàng!!!");
        }
    }

    private static void viewPurchaseHistory() {
        paymentService.viewPayment();
    }

    private static void editInfoCustomer() {
        AccountView.accountView(customerService);
    }

    private static void viewInfoCustomer() {
        printLineSeparate("Thong tin tai khoan");
        printValueMenu("Username: " + customer.getUsername());
        printValueMenu("Password: " + customer.getPassword());
        printValueMenu("ID: " + customer.getCustomerId());
        printValueMenu("Email: " + customer.getEmail());
        printValueMenu("Full name: " + customer.getFullName());
        printValueMenu("SDT: " + customer.getPhoneNumber());
        printValueMenu("CCCD: " + customer.getIdentityNumber());
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
        orderService.saveListOrder();
    }
}
