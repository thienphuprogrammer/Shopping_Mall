import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;
import Shopping_Mall.UserObject.User;

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

            }
            else if(choice == 2) {
                new User();
            }

        }
    }
}