package Shopping_Mall.CommonFunction;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void removeProduct(int idProduct) {
        Iterator<Product> iterator = listProduct.iterator();

        while(iterator.hasNext()) {
            Product product = iterator.next();

            if(product.getId() == idProduct) {
                iterator.remove();
                break;
            }
        }
    }

    public void searchProduct(String str) {
        ListProduct newList = new ListProduct();

        for (Product product : listProduct) {
            if (str.equals(String.valueOf(product.getId()))
                    || product.getName().equals(str)) {
                newList.addProduct(product);
            }
        }
        if (newList.getSize() == 0) {
            System.out.println("Không tìm thấy sản phẩm mà bạn đã cung cấp thông tin");
        }
        else {
            System.out.println("Có " + newList.getSize() + " sản phẩm có thông tin giống trên: ");
            for(Product product : newList.getListProduct()){
                product.showProduct();
            }
        }
    }
    public void showListProduct() {
        for(Product product: listProduct) {
            product.showProduct();
        }
    }

    public void loadListProduct(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            if(fis.available() != 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                listProduct = (ArrayList<Product>) ois.readObject();
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