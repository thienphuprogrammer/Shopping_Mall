package shoppingmall.views.admin;

import shoppingmall.models.product.Product;
import shoppingmall.services.admin.AdminService;
import shoppingmall.services.admin.BrowseProductService;
import shoppingmall.services.customer.PaymentService;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.utils.OutputUtil.*;
import static shoppingmall.utils.OutputUtil.waitForInput;
import static shoppingmall.views.LogInView.loginAdminView;
import static shoppingmall.views.LogInView.loginCustomerView;
import static shoppingmall.views.SignUpView.signUpCustomerView;

public class AdminView {
    // ------------------Property--------------------------
    private static final ProductService productService = new ProductService("data/product.bin");
    private static final BrowseProductService browseProductService = new BrowseProductService("data/product_is_buying.bin", "data/product_bought.bin");
    private static AdminService adminService = new AdminService();

    // -------------------Init---------------------------

    public static void initProperty() {
        productService.loadListProduct();
    }
    public enum MENU_ADMIN_SHEET {
        EXIT,
        ADD_PRODUCT,
        EDIT_PRODUCT,
        VIEW_PRODUCT,
        VIEW_LIST_PRODUCT_BUYING,
        VIEW_LIST_PRODUCT_BOUGHT,
        SELL_PRODUCT,
        VIEW_ACCOUNT_ADMIN
    }

    // -------------------Method-------------------------
    public static int getAdMinChoice() {
        printLineSeparate();
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.EXIT.ordinal() + " để quay trở về trang chủ.");
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.ADD_PRODUCT.ordinal() + " để them san pham.");
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.EDIT_PRODUCT.ordinal() + " để chinh sua thong tin san pham.");
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.VIEW_PRODUCT.ordinal() + " để xem danh sach san pham.");
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.VIEW_LIST_PRODUCT_BUYING.ordinal() + " để xem danh sach hang dang cho duyet.");
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.VIEW_LIST_PRODUCT_BOUGHT.ordinal() + " de xem danh sach hang da duyet.");
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.SELL_PRODUCT.ordinal() + " de ban san pham.");
        printValueMenu("Nhập " + MENU_ADMIN_SHEET.VIEW_ACCOUNT_ADMIN.ordinal() + " xem thong tin tai khoan. ");
        printLineSeparate();
        return readInt("Sự lựa chọn của bạn: ");
    }

    public static void showViewAdmin() {
        while(true) {
            boolean statusLogin = false;
            printLineSeparate("Menu");
            printValueMenu("0 de tro ve trang chu");
            printValueMenu("1 Dang nhap vao tai khoan Amin");
//            printValueMenu("2 Dang ky vao tai khoan Admin");
            printLineSeparate();

            int choice = readInt("Sự lựa chọn của bạn: ");
            if (choice == 1) {
                adminService = loginAdminView("data/admin.bin");
                if (adminService != null) {
                    statusLogin = true;
                } else {
                    continue;
                }
            } else {
                break;
            }

//            Product
            if (statusLogin) {
                handleChoiceAdmin();
                productService.saveListProduct();
                browseProductService.saveListBrowseProduct();
            }
        }
    }

    private static void handleChoiceAdmin() {
        initProperty();
        while (true) {
            int choice = getAdMinChoice();
            if (choice == MENU_ADMIN_SHEET.ADD_PRODUCT.ordinal()) {
                addProduct();
            } else if (choice == MENU_ADMIN_SHEET.EDIT_PRODUCT.ordinal()) {
                editInfoProduct();
            } else if (choice == MENU_ADMIN_SHEET.VIEW_LIST_PRODUCT_BUYING.ordinal()) {
                viewListProductBuying();
            } else if (choice == MENU_ADMIN_SHEET.VIEW_LIST_PRODUCT_BOUGHT.ordinal()) {
                viewListProductBought();
            } else if (choice == MENU_ADMIN_SHEET.SELL_PRODUCT.ordinal()) {
                sellProduct();
            } else if (choice == MENU_ADMIN_SHEET.VIEW_ACCOUNT_ADMIN.ordinal()) {
                showInfoAdmin();
            } else if (choice == MENU_ADMIN_SHEET.EXIT.ordinal()) {
                break;
            } else if(choice == MENU_ADMIN_SHEET.VIEW_PRODUCT.ordinal()) {
                viewProduct();
            }
            else {
                printValueln("Lựa chọn không hợp lệ.");
            }
            waitForInput();
        }
    }

    private static void viewProduct() {
        productService.showListProduct();
    }
    private static void addProduct() {
        String nameProduct = readString("Nhập tên sản phẩm: ");
        if (nameProduct.length() == 0 || nameProduct.length() >= 80) {
            printValueln("Loi nhap san pham");
            return;
        }
        String typeProduct = readString("Nhập loại sản phẩm: ");
        if (typeProduct.length() == 0 || typeProduct.length() >= 80) {
            printValueln("Loi nhap san pham");
            return;
        }
        String descriptionProduct =  readString("Nhập mê tả sản phẩm: ");
        if (descriptionProduct.length() == 0 || descriptionProduct.length() >= 80) {
            printValueln("Loi nhap san pham");
            return;
        }
        float priceProduct = readFloat("Nhập giá của sản phẩm: ");
        int countProduct = readInt("Nhập số lượng sản phẩm: ");
        productService.addProduct(new Product(nameProduct, typeProduct, descriptionProduct, productService.getSize(), priceProduct,countProduct,5));
        printLineSeparate();
        printValueln("Đã cập nhật sản phẩm thành công!!!");
        productService.saveListProduct();
    }

    private static void editInfoProduct() {
        int idProduct = readInt("Nhập vào id sản phẩm mủa chỉnh sửa: ");
        Product newProduct = new Product();
        for (Product product : productService.getListProduct()) {
            if(product.getId() == idProduct) {
                newProduct = product;
            }
        }
        if (newProduct != null) {
            String nameProduct = readString("Nhập tên sản phẩm: ");
            if (nameProduct.length() == 0 || nameProduct.length() >= 80) {
                printValueln("Loi nhap san pham");
                return;
            }
            String typeProduct = readString("Nhập loại sản phẩm: ");
            if (typeProduct.length() == 0 || typeProduct.length() >= 80) {
                printValueln("Loi nhap san pham");
                return;
            }
            String descriptionProduct =  readString("Nhập mê tả sản phẩm: ");
            if (descriptionProduct.length() == 0 || descriptionProduct.length() >= 80) {
                printValueln("Loi nhap san pham");
                return;
            }
            float priceProduct = readFloat("Nhập giá của sản phẩm: ");
            int countProduct = readInt("Nhập số lượng sản phẩm: ");
            newProduct.setName(nameProduct);
            newProduct.setType(typeProduct);
            newProduct.setDescription(descriptionProduct);
            newProduct.setPrice(priceProduct);
            newProduct.setCount(countProduct);
            productService.editInfo(idProduct, newProduct);
        } else {
            printValueln("ID sản phẩm không tồn tai trong của hàng!!");
        }
        productService.saveListProduct();
    }

    private static void viewListProductBuying() {
        browseProductService.viewPendingApprovalProduct();
    }

    private static void viewListProductBought() {
        browseProductService.viewApprovedProduct();
    }

    private static void sellProduct() {
        viewListProductBuying();
        if(browseProductService.getListUnapprovedProduct().size() == 0) {
            return;
        }
        String question = readString("Bạn có chắc là muốn mua hàng không (Y/N): ");
        if (question.equals("Y") || question.equals("y")) {
            browseProductService.browseProduct(productService);
            printValueln("Da ban hang thanh cong");

        }  else {
            printValueln("Đã hủy ban hàng!!!");
        }
    }

    private static void showInfoAdmin() {
        adminService.showInfo();
    }
}