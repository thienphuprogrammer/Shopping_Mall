package Shopping_Mall.UserObject;

import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;

import java.util.Scanner;

class FilterProduct extends ListProduct{
    private Scanner scanner = new Scanner(System.in);
    private ListProduct newList = new ListProduct();
    FilterProduct(ListProduct listProduct1) {
        this.listProduct = listProduct1.getListProduct();
        System.out.println("----------------------------------------");
        System.out.println("Nhập 0 để trở về menu.");
        System.out.println("Nhập 1 để lọc sản phẩm theo số lượng.");
        System.out.println("Nhập 2 để lọc sản phẩm theo giá.");
        System.out.println("Nhập 3 để lọc sản phẩm theo loại.");
        System.out.println("----------------------------------------");
        System.out.print("Sự lựa chọn của bạn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        
        if(choice == 0) {
            return;
        }
        else if(choice == 1) {
            filterCount();
        }
        else if(choice == 2) {
            filterPrice();
        }
        else {
            filterType();
        }
        newList.showListProduct();
        new FilterProduct(newList);
    }

    private void filterCount() {
        System.out.print("Nhập số lượng tối thiểu bạn muốn: ");
        int count = Integer.parseInt(scanner.nextLine());
        for(Product product : listProduct) {
            if(product.getCount() >= count) {
                newList.addProduct(product);
            }
        }
    }
    private void filterPrice() {
        System.out.print("Nhập giá thấp bạn muốn: ");
        float minPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá cao nhất bạn muốn: ");
        float maxPrice = Float.parseFloat(scanner.nextLine());
        for(Product product : listProduct) {
            if(product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                newList.addProduct(product);
            }
        }
    }
    private void filterType() {
        System.out.print("Nhập loại hàng bạn muốn: ");
        String type = scanner.nextLine();
        for(Product product : listProduct) {
            if(product.getType().equals(type)) {
                newList.addProduct(product);
            }
        }
    }
    
}

public class MenuUser {
    private Scanner scanner = new Scanner(System.in);

    private ListProduct listProduct = new ListProduct();
    private ShoppingCart listCart = new ShoppingCart();
    private ShoppingCart listBoughtHistory = new ShoppingCart();
    private ShoppingCart listProductBuying = new ShoppingCart();
    private enum MENU_SHEET {
        EXIST,
        VIEW_PRODUCT,
        SEARCH_PRODUCT,
        FILTER_PRODUCT,
        ADD_TO_CART,
        VIEW_CART,
        CLEAR_CART,
        BUY_PRODUCT,
        VIEW_PRODUCT_BUYING,
        HISTORY_BOUGHT
    }

    private int idUser;
    MenuUser(int id) {
        initData();
        this.idUser = id;
        while(true) {
            int choice = getUserChoice();
            if(choice == MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal()) {
                viewListBuying();
            } else if (choice == MENU_SHEET.EXIST.ordinal()) {
                returnToHomePage();
                break;
            } else if (choice == MENU_SHEET.CLEAR_CART.ordinal()) {
                clearCart();
            } else if (choice == MENU_SHEET.VIEW_PRODUCT.ordinal()) {
                viewProducts();
            } else if (choice == MENU_SHEET.SEARCH_PRODUCT.ordinal()) {
                searchProducts();
            } else if (choice == MENU_SHEET.FILTER_PRODUCT.ordinal()) {
                filterProducts();
            } else if (choice == MENU_SHEET.ADD_TO_CART.ordinal()) {
                addToCart();
            } else if (choice == MENU_SHEET.VIEW_CART.ordinal()) {
                viewCart();
            } else if (choice == MENU_SHEET.BUY_PRODUCT.ordinal()) {
                buyProducts();
            } else if (choice == MENU_SHEET.HISTORY_BOUGHT.ordinal()) {
                viewPurchaseHistory();
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
            waitForInput();
        }
        saveData();
    }

    void initData() {
        this.listProduct.loadListProduct("src/Data/product.bin");
        this.listCart.setIdUser(idUser);
        this.listCart.loadListProduct("src/Data/cart.bin");
        this.listProductBuying.setIdUser(idUser);
        this.listProductBuying.loadListProduct("src/Data/product_is_buying.bin");
        this.listBoughtHistory.setIdUser(idUser);
        this.listBoughtHistory.loadListProduct("src/Data/product_bought.bin");
    }

    void saveData() {
        this.listProduct.saveListProduct("src/Data/product.bin");
        this.listCart.saveListProduct("src/Data/cart.bin");
        this.listProductBuying.saveListProduct("src/Data/product_is_buying.bin");
        this.listBoughtHistory.saveListProduct("src/Data/product_bought.bin");
    }

    public int getUserChoice() {
        System.out.println("Nhập " + MENU_SHEET.EXIST.ordinal() + " để quay trở về trang chủ.");
        System.out.println("Nhập " + MENU_SHEET.VIEW_PRODUCT.ordinal() + " xem hàng hóa.");
        System.out.println("Nhập " + MENU_SHEET.SEARCH_PRODUCT.ordinal() + " tìm kiếm sản phẩm.");
        System.out.println("Nhập " + MENU_SHEET.FILTER_PRODUCT.ordinal() + " lọc sản phẩm.");
        System.out.println("Nhập " + MENU_SHEET.ADD_TO_CART.ordinal() + " thêm hàng vào giỏ.");
        System.out.println("Nhập " + MENU_SHEET.VIEW_CART.ordinal() + " xem giỏ hàng.");
        System.out.println("Nhập " + MENU_SHEET.CLEAR_CART.ordinal() + " làm mới giỏ hàng.");
        System.out.println("Nhập " + MENU_SHEET.BUY_PRODUCT.ordinal() + " mua hàng.");
        System.out.println("Nhập " + MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal() + " xem hàng đang mua.");
        System.out.println("Nhập " + MENU_SHEET.HISTORY_BOUGHT.ordinal() + " xem lịch sử mua hàng.");
        System.out.println("----------------------------------------");
        System.out.print("Sự lựa chọn của bạn: ");
        int choice = Integer.parseInt(scanner.nextLine());

        return choice;
    }

    private void waitForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("Nhấn phím bất kỳ để trở về menu.");
        scanner.nextLine(); // Wait for user to press Enter
        for(int i = 0; i < 100; i++) System.out.println("");

    }

    private void returnToHomePage() {
        System.out.println("Quay trở về trang chủ...");
        // Code for returning to the home page
    }

    private void viewProducts() {
        System.out.println("Xem hàng hóa...");
        // Code for viewing products
        listProduct.showListProduct();
    }

    private void searchProducts() {
        System.out.println("Tìm kiếm sản phẩm...");
        // Code for searching products
        System.out.print("Tên hoặc id sản phẩm muốn tiềm kiếm: ");
        String str = scanner.nextLine();
        listProduct.searchProduct(str);
    }

    private void filterProducts() {
        System.out.println("Lọc sản phẩm...");
        // Code for filtering products
        new FilterProduct(listProduct);
    }

    private void addToCart() {
        System.out.println("Thêm hàng vào giỏ...");
        // Code for adding items to cart
        System.out.print("Nhập vào id của sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product product: listProduct.getListProduct()) {
            if(product.getId() == id) {
                product.setCount(1);
                listCart.addItem(product);
                break;
            }
        }
        System.out.println("Đã thêm vào giỏ hàng. ");
    }

    private void viewCart() {
        System.out.println("Xem giỏ hàng...");
        // Code for viewing the cart
        listCart.showListProduct();
        float sumPrice = 0;
        for(Product product : listCart.getListProduct()) {
            sumPrice += product.getPrice();
        }
        System.out.println("Tổng giá tiền của hóa đơn là: " + sumPrice);
    }

    private void clearCart() {
        System.out.println("Xóa giỏ hàng...");
        listCart.clearCart();
        System.out.println("Giỏ hàng đã được làm mới!!");
    }

    private void viewListBuying() {
        System.out.println("Xem danh sách hàng đang mua...");
        listProductBuying.showListProduct();
    }

    private void buyProducts() {
        System.out.println("Mua hàng...");
        // Code for buying products
        for(Product product: listCart.getListProduct()) {
            this.listProductBuying.addProduct(product);
        }
        System.out.println("Đã mua hàng thành công!!!");
    }

    private void viewPurchaseHistory() {
        System.out.println("Xem lịch sử mua hàng...");
        listBoughtHistory.showListProduct();
    }
}
