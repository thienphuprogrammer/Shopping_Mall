package Shopping_Mall.CommonFunction.Account;

import java.util.Scanner;

public class AccountUser {
    public static boolean AccountUser() {
        int choice = -1;

        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhập 0 để quay trở về trang chủ.");
            System.out.println("Nhập 1 để đăng kí tài khoản.");
            System.out.println("Nhập 2 để đăng nhập tài khoản.");
            System.out.println("----------------------------------------");
            System.out.print("Sự lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                new SignUp().SignUp();
            }
            else if (choice == 2){
                if(new LogIn().LogIn()) {
                    return true;
                }
            }
        }
    }
}