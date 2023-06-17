package shoppingmall.services;

import shoppingmall.models.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static shoppingmall.utils.FileUtil.*;
import static shoppingmall.utils.InputUtil.*;

class FilterProduct extends ProductService {
    private Scanner scanner = new Scanner(System.in);
    private ProductService newList = new ProductService();
    FilterProduct(ProductService listProduct1) {
        this.listProduct = listProduct1.getListProduct();
    }
    void menuFilter() {
        System.out.println("+----------------------------------------+");
        System.out.println("|   Nhập 0 để trở về menu.               |");
        System.out.println("|   Nhập 1 để lọc sản phẩm theo số lượng.|");
        System.out.println("|   Nhập 2 để lọc sản phẩm theo giá.     |");
        System.out.println("|   Nhập 3 để lọc sản phẩm theo loại.    |");
        System.out.println("+----------------------------------------+");
        int choice = readInt("Sự lựa chọn của bạn: ");

        if(choice == 0) {
            return;
        }
        else if(choice == 1) {
            filterCount();
        }
        else if(choice == 2) {
            filterPrice();
        }
        else {
            filterType();
        }
        newList.showListProduct();
        new FilterProduct(newList);
    }
    private void filterCount() {
        int count = readInt("Nhập số lượng tối thiểu bạn muốn: ");
        for(Product product : listProduct) {
            if(product.getCount() >= count) {
                newList.addProduct(product);
            }
        }
    }
    private void filterPrice() {
        float minPrice = readFloat("Nhập giá thấp bạn muốn: ");
        System.out.print("Nhập giá cao nhất bạn muốn: ");
        float maxPrice = Float.parseFloat(scanner.nextLine());
        for(Product product : listProduct) {
            if(product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                newList.addProduct(product);
            }
        }
    }
    private void filterType() {
        String type = readString("Nhập loại hàng bạn muốn: ");
        for(Product product : listProduct) {
            if(product.getType().equals(type)) {
                newList.addProduct(product);
            }
        }
    }

}

public class ProductService {
    protected ArrayList<Product> listProduct = new ArrayList<Product>();
    protected String filename = new String();

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
                System.out.println("Sản phẩm có ID " + idProduct + " đã được xóa.\n");
                break;
            } else {
                System.out.println("Xóa thất bại\n");
            }
        }
    }

    public void searchProduct(String str) {
        ProductService newList = this;

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
        boolean found = false;
        for (Product product : listProduct) {
            product.showProduct();
            found = true;
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với ID đã nhập.\n");
        }
    }

    public void loadListProduct() {
        Object object = loadFileObject(filename);
        if (object != null) {
            this.listProduct = (ArrayList<Product>) object;
        }
    }

    public void saveListProduct() {
        saveFileObject(filename, listProduct);
    }
}