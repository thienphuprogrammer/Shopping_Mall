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

            if(logIn("src/Data/user.bin")) {
                return true;
            }
        }
    }
    private boolean logIn(String filename) {
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
                            && infoUser.email.equals(info.email)){
                        System.out.println("Đăng nhập thành công");
                        return true;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
