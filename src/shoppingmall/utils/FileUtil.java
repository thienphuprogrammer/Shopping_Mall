package shoppingmall.utils;

import java.io.*;

public class FileUtil {
    public static Object loadFileObject(String filename) {
        filename = "./src/" + filename;
        try {
            FileInputStream fis = new FileInputStream(filename);
            if (fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                return ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc danh sách sản phẩm từ file.");
            // Uncomment the appropriate line below based on your requirements
             e.printStackTrace();
        }
        return null;
    }

    public static void saveFileObject(String filename, Object object) {
        filename = "./src/" + filename;
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
