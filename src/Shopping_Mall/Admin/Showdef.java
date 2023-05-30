package CommonFunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Shopping_Mall.CommonFunction.Account.InfoUser;

public class Showdef {
    public static ArrayList<InfoUser> getUserData() {
        ArrayList<InfoUser> userList = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream("C:/codeN/Github/Shopping_Mall/src/Data/user.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Đọc đối tượng từ tệp tin bin
            userList = (ArrayList<InfoUser>) objectIn.readObject();
            System.out.println(userList);
            System.out.println();

            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
