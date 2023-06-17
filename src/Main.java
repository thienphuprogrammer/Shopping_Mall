import shoppingmall.models.admin.AdminObject;
import shoppingmall.Account.AccountUser;
import shoppingmall.MenuProductUSer;
import shoppingmall.MenuUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while(true) {
            System.out.println("+-------------------------------------------+");
            System.out.println("|   Nhập 0 để thoát khoải chương trình      |");
            System.out.println("|   Nhập 1 để đăng nhập vào tài khoản Admin |");
            System.out.println("|   Nhập 2 để đăng nhập vào tài khoản User  |");
            System.out.println("+-------------------------------------------+");
            System.out.print("Sự lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            if(choice == 0) {
                System.out.println("Đã thoát khỏi chương trinhg");
                break;
            }
            else if (choice == 1) {
                for(int i = 0; i < 100; i++) System.out.println("");
                new AdminObject();
            }
            else if(choice == 2) {
                for(int i = 0; i < 100; i++) System.out.println("");
                MenuProductUSer listProduct = new MenuProductUSer();
                listProduct.loadListProduct("src/Data/product.bin");

                InfoUser statusLogIn = AccountUser.AccountUser();
//        int statusLogIn = 0;
                if (statusLogIn != null) {
                    new MenuUser(statusLogIn);
                }
            }
            for(int i = 0; i < 100; i++) System.out.println("");

        }
    }


    public static void menuUser(MenuUser user, InfoUser accuser) {
        user.setAccUser(accuser);
        this.idUser = accuser.getCustomerId();
        while(true) {
            int choice = user.getUserChoice();
            if (choice == MenuUser.MENU_SHEET.EDIT_INFO_ACC.ordinal()) {
                user.editInfoUser();
            } else if(choice == MenuUser.MENU_SHEET.VIEW_INFO_ACC.ordinal()) {
                user.viewInfoAcc();
            } else if(choice == MenuUser.MENU_SHEET.VIEW_PRODUCT_BUYING.ordinal()) {
                user.viewListBuying();
            } else if (choice == MenuUser.MENU_SHEET.EXIST.ordinal()) {
                user.returnToHomePage();
                break;
            } else if (choice == MenuUser.MENU_SHEET.CLEAR_CART.ordinal()) {
                user.clearCart();
            } else if (choice == MenuUser.MENU_SHEET.VIEW_PRODUCT.ordinal()) {
                user.viewProducts();
            } else if (choice == MenuUser.MENU_SHEET.SEARCH_PRODUCT.ordinal()) {
                user.searchProducts();
            } else if (choice == MenuUser.MENU_SHEET.FILTER_PRODUCT.ordinal()) {
                user.filterProducts();
            } else if (choice == MenuUser.MENU_SHEET.ADD_TO_CART.ordinal()) {
                user.addToCart();
            } else if (choice == MenuUser.MENU_SHEET.VIEW_CART.ordinal()) {
                user.viewCart();
            } else if (choice == MenuUser.MENU_SHEET.BUY_PRODUCT.ordinal()) {
                user.buyProducts();
            } else if (choice == MenuUser.MENU_SHEET.HISTORY_BOUGHT.ordinal()) {
                user.viewPurchaseHistory();
            } else if (choice == MenuUser.MENU_SHEET.LOG_OUT.ordinal()) {

            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
            user.waitForInput();
        }
    }

}