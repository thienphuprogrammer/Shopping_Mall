package Shopping_Mall.CommonFunction;

import java.io.*;
import java.util.ArrayList;

public class ListProduct {
    protected ArrayList<Product> listProduct = new ArrayList<Product>();

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public int getSize() {
        return listProduct.size();
    }
    public void addProduct(Product product) {
        this.listProduct.add(product);
    }

    public void showListProduct() {
        for(Product product: listProduct) {
            product.showProduct();
        }
    }

    public void loadListProduct(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listProduct = (ArrayList<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc danh sách sản phẩm từ file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveListProduct(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listProduct);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách sản phẩm vào file.");
            e.printStackTrace();
        }
    }
}