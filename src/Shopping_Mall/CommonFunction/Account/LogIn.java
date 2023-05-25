package Shopping_Mall.CommonFunction.Account;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    private InfoUser info = new InfoUser();

    public boolean LogIn() {
        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập tên người dùng: ");
            info.username = scanner.nextLine();
            System.out.print("Nhập mật khẩu: ");
            info.password = scanner.nextLine();

            int status = logIn("src/Data/user.bin");
            if(status == 1) {
                return true;
            }
            else if (status == -1){
                return false;
            }
            System.out.println("Đăng nhập thất bại");
        }
    }
    private int logIn(String filename) {
        try {
            ArrayList<InfoUser> listInfo;
            FileInputStream fis = new FileInputStream(filename);

            if (fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                listInfo = (ArrayList<InfoUser>) ois.readObject();

                fis.close();
                ois.close();

                for (InfoUser infoUser : listInfo) {
                    if(infoUser.username.equals(info.username)
                            && infoUser.password.equals(info.password)){
                        System.out.println("Đăng nhập thành công");
                        return 1;
                    }
                }
            }
            else {
                System.out.println("Lỗi, không có user nào tồn tại trong hệ thống");
                return -1;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
