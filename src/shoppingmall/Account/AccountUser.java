//package shoppingmall.Account;
//
//import java.util.Scanner;
//
//public class AccountUser {
//    public static InfoUser AccountUser() {
//        int choice = -1;
//
//        while(true) {
//            Scanner scanner = new Scanner(System.in);
//
//            while(true) {
//                System.out.println("+----------------------------------------+");
//                System.out.println("|   Nhập 0 để quay trở về trang chủ.     |");
//                System.out.println("|   Nhập 1 để đăng kí tài khoản.         |");
//                System.out.println("|   Nhập 2 để đăng nhập tài khoản.       |");
//                System.out.println("+----------------------------------------+");
//                System.out.print("Sự lựa chọn của bạn: ");
//                choice = Integer.parseInt(scanner.nextLine());
//
//                if(choice == 0) {
//                    return null;
//                }
//                if (choice == 1) {
//                    new SignUp().SignUp();
//                }
//                else if (choice == 2){
//                    InfoUser status = new LogIn().LogIn();
//                    if(status != null) {
//                        try {
//                            Thread.sleep(2000); // Trễ 2 giây (2000 ms)
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        for (int i = 0; i < 30; i++) {
//                            System.out.println();
//                        }
//                        return status;
//                    }
//                }
//                try {
//                    Thread.sleep(2000); // Trễ 2 giây (2000 ms)
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                for (int i = 0; i < 30; i++) {
//                    System.out.println();
//                }
//            }
//        }
//    }
//}
