package Shopping_Mall.CommonFunction.Account;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    private InfoUser info = new InfoUser();
    public InfoUser LogIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên người dùng: ");
        info.setUsername(scanner.nextLine());
        System.out.print("Nhập mật khẩu: ");
        info.setPassword(scanner.nextLine());

        int status = logIn("src/Data/user.bin");
        if (status == -2){
            return null;
        }
        else if (status == -1) {
            System.out.println("Đăng nhập thất bại!!!");
        }
        else {
            return info;
        }
        return null;
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
                    if(infoUser.getUsername().equals(info.getUsername())
                            && infoUser.getPassword().equals(info.getPassword())){
                        System.out.println("Đăng nhập thành công!!!");
                        this.info = infoUser;
                        return infoUser.getCustomerId();
                    }
                }
            }
            else {
                System.out.println("Lỗi, không có user nào tồn tại trong hệ thống!!!");
                return -2;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
