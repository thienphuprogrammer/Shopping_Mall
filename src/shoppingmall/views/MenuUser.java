package shoppingmall.views;

import shoppingmall.models.Product;
import shoppingmall.services.EditInfo;
import shoppingmall.services.FilterProduct;
import shoppingmall.services.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUser {
    private static Scanner scanner = new Scanner(System.in);
    private InfoUser accUser;
    private int idUser;
    private ArrayList<ProductService> listProduct = new ArrayList<>();
    public InfoUser getAccUser() {
        return accUser;
    }

    public void setAccUser(InfoUser accUser) {
        this.accUser = accUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    public enum MENU_SHEET {
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
    public static int getUserChoice() {
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
        System.out.print("Sự lựa chọn của bạn: ");
        int choice = Integer.parseInt(scanner.nextLine());

        return choice;
    }
    public static void waitForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+------------------------------------------------------+");
        System.out.println("Nhấn phím bất kỳ để trở về menu.");
        scanner.nextLine(); // Wait for user to press Enter
        for(int i = 0; i < 100; i++) System.out.println("");

    }

    public static void returnToHomePage() {
        System.out.println("Quay trở về trang chủ...");
        // Code for returning to the home page
    }

    public void editInfoUser() {
        accUser.showInfo(accUser.getCustomerId());
        System.out.println("+----------------------------------------+");
        new EditInfo(accUser, "src/Data/user.bin");
    }

    public void viewProducts() {
        System.out.println("Xem hàng hóa...");
        // Code for viewing products
        listProduct.showListProduct();
    }

    public void searchProducts() {
        System.out.println("Tìm kiếm sản phẩm...");
        // Code for searching products
        System.out.print("Tên hoặc id sản phẩm muốn tiềm kiếm: ");
        String str = scanner.nextLine();
        listProduct.searchProduct(str);
    }

    public void viewInfoAcc() {
        accUser.showInfo(accUser.getCustomerId());
    }

    public void filterProducts() {
        System.out.println("Lọc sản phẩm...");
        // Code for filtering products
        new FilterProduct(listProduct);
    }

    public void addToCart() {
        System.out.println("Thêm hàng vào giỏ...");
        // Code for adding items to cart
        System.out.print("Nhập vào id của sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product product: listProduct.getListProduct()) {
            if (product.getCount() > 0) {
                if(product.getId() == id) {
                    product.setCount(1);
                    listCart.addItem(product);
                    System.out.println("Đã thêm vào giỏ hàng. ");
                    break;
                }
            }
            else {
                System.out.println("Sản phẩm đã hết hàng!!!");
                break;
            }

        }
    }

    public void viewCart() {
        System.out.println("Xem giỏ hàng...");
        // Code for viewing the cart
        listCart.showListProduct();
        float sumPrice = 0;
        for(Product product : listCart.getListProduct()) {
            sumPrice += product.getPrice() * product.getCount();
        }
        System.out.println("Tổng giá tiền của hóa đơn là: " + sumPrice);
    }

    public void clearCart() {
        System.out.println("Xóa giỏ hàng...");
        listCart.clearCart();
        System.out.println("Giỏ hàng đã được làm mới!!");
    }

    public void viewListBuying() {
        System.out.println("Xem danh sách hàng đang mua...");
        listProductBuying.showListProduct();
    }

    public void buyProducts() {
        System.out.println("Mua hàng...");
        System.out.print("Bạn có chắc là muốn mua hàng không (Y/N): ");
        String question = scanner.nextLine();
        if (question.equals("Y") || question.equals("y")) {
            // Code for buying products
            for(Product product: listCart.getListProduct()) {
                this.listProductBuying.addProduct(product);
            }
            this.listCart.clearCart();
            System.out.println("Đã mua hàng thành công!!!");
        } else {
            System.out.println("Đã hủy mua hàng!!!");
        }
    }

    public void viewPurchaseHistory() {
        System.out.println("Xem lịch sử mua hàng...");
        listBoughtHistory.showListProduct();
    }
}
