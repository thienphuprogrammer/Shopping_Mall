package Shopping_Mall.CommonFunction.Account;

import java.util.Scanner;

public class AccountUser {
    public static int AccountUser() {
        int choice = -1;

        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhập 0 để quay trở về trang chủ.");
            System.out.println("Nhập 1 để đăng kí tài khoản.");
            System.out.println("Nhập 2 để đăng nhập tài khoản.");
            System.out.println("----------------------------------------");
            System.out.print("Sự lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            if(choice == 0) {
                return -1;
            }
            if (choice == 1) {
                new SignUp().SignUp();
            }
            else if (choice == 2){
                int status = new LogIn().LogIn();
                if(status != -1) {
                    return status;
                }
            }
        }
    }
}
