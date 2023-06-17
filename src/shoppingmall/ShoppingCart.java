package shoppingmall;

import shoppingmall.services.ProductService;
import shoppingmall.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart extends ProductService {
    private int idUser = -1;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void addItem(Product product) {
        boolean isFind = false;
        for (int i = 0; i < listProduct.size(); i++) {
            if (product.getId() == listProduct.get(i).getId()) {
                this.listProduct.get(i).setCount(listProduct.get(i).getCount() + 1);
                isFind = true;
            }
        }

        if(!isFind) {
            listProduct.add(product);
        }
    }
    public boolean updateItemQuantity(int quantity, int idProduct) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (idProduct == listProduct.get(i).getId()) {
                this.listProduct.get(i).setCount(quantity);
                return true;
            }
        }
        return false;
    }

    public void clearCart() {
        listProduct.clear();
    }

    public void loadListProduct(String filename) {
        try {
            HashMap<Integer, ArrayList<Product>> hashMap = new HashMap<>();
            FileInputStream fis = new FileInputStream(filename);
            if(fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                hashMap = (HashMap<Integer, ArrayList<Product>>) ois.readObject();
                this.listProduct = hashMap.get(idUser);
                ois.close();
            }
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
            HashMap<Integer, ArrayList<Product>> hashMap = new HashMap<>();
            FileInputStream fis = new FileInputStream(filename);
            if(fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                hashMap = (HashMap<Integer, ArrayList<Product>>) ois.readObject();
                ois.close();
            }
            fis.close();
            if(listProduct.size() > 0) {
                hashMap.put(idUser, listProduct);
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(hashMap);
                fos.close();
                oos.close();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách sản phẩm vào file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}