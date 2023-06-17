package shoppingmall.utils;

import java.io.*;

public class FileUtil {
    public static Object loadFileObject(String filename) {
        try {
            Object object;
            FileInputStream fis = new FileInputStream(filename);
            if (fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                object = ois.readObject();
                ois.close();
                return object;
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc danh sách sản phẩm từ file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void saveFileObject(String filename, Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách sản phẩm vào file.");
            e.printStackTrace();
        }
    }
}
