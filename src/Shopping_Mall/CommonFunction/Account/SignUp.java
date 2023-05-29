package Shopping_Mall.CommonFunction.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
    protected InfoUser info = new InfoUser();

    public InfoUser getInfo() {
        return info;
    }

    public void setInfo(InfoUser info) {
        this.info = info;
    }

    public boolean SignUp() {
        Scanner scanner = new Scanner(System.in);
        this.info = getUserInformation();
//            this.info = new InfoUser("ThienPhu1", "ThienPhu", "ThienPhu", "ThienPhu1", "ThienPhu", "ThienPhu", 0);
        if(!signUp("src/Data/user.bin")) {
            System.out.println("Username hay là email đã được đăng kí trước đó.");
        }
        else {
            System.out.println("Đăng kí thành công!!!");
            return true;
        }
        return false;
    }

    public boolean signUp(String filename) {
        try {
            ArrayList<InfoUser> listInfo = new ArrayList<InfoUser>();

            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                if(fis.available() != 0) {
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    listInfo = (ArrayList<InfoUser>) ois.readObject();
                    ois.close();
                }
            }

            for (InfoUser infoUser : listInfo) {
                if (infoUser.getUsername().equals(info.getUsername()) || infoUser.getEmail().equals(info.getEmail())) {
                    return false;
                }
            }
            info.setCustomerId(listInfo.size() - 1);
            listInfo.add(info);

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listInfo);
            oos.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public InfoUser getUserInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tên đăng nhập: ");
        String username = scanner.nextLine();

        String password = "";
        System.out.print("Mật khẩu: ");
        password = scanner.nextLine();

        if(!isValidPassword(password)) {
            System.out.println("Mật khẩu phải có ít nhất 8 kí tự.");
            return null;
        }

        String phoneNumber = "";
        while (true) {
            System.out.print("Số điện thoại: ");
            phoneNumber = scanner.nextLine();
            if (isValidPhoneNumber(phoneNumber)) {
                break;
            }
            System.out.println("Số điện thoại không hợp lệ.");
        }

        String email = "";
        while(true) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if(isValidEmail(email)) {
                break;
            }
            System.out.println("Email không hợp lệ.");
        }


        System.out.print("Họ và tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Số CMND: ");
        String identityNumber = scanner.nextLine();

        int customerId = 0;

        return new InfoUser(username, password, phoneNumber, email, fullName, identityNumber, customerId);
    }

    public boolean isValidEmail(String email) {
        // Biểu thức chính quy để kiểm tra cú pháp email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        // Biểu thức chính quy để kiểm tra cú pháp số điện thoại
        String phoneRegex = "^\\d{10}$"; // Định dạng 10 chữ số

        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}
