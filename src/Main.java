import shoppingmall.models.admin.AdminObject;
import shoppingmall.Account.AccountUser;
import shoppingmall.MenuProductUSer;
import shoppingmall.MenuUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("+-------------------------------------------+");
            System.out.println("|   Nhập 0 để thoát khoải chương trình      |");
            System.out.println("|   Nhập 1 để đăng nhập vào tài khoản Admin |");
            System.out.println("|   Nhập 2 để đăng nhập vào tài khoản User  |");
            System.out.println("+-------------------------------------------+");

            int choice = readInt("Sự lựa chọn của bạn: ");
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
}