package shoppingmall.services.productService;

import shoppingmall.models.Product;

import java.util.ArrayList;
import java.util.Iterator;

import static shoppingmall.utils.FileUtil.*;

public class ProductService {
    protected ArrayList<Product> listProduct = new ArrayList<>();
    protected String filename = "../data/product.txt";

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

    public ProductService() {
        ;
    }

    public ProductService(String filename) {
        this.filename = filename;
        loadListProduct();
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

    public void searchProducts(String str) {
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