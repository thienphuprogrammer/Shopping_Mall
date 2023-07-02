package shoppingmall.services.productService;

import shoppingmall.models.Product;

import java.util.ArrayList;
import java.util.Iterator;

import static shoppingmall.utils.FileUtil.*;

public class ProductService {
    protected ArrayList<Product> listProduct = new ArrayList<>();
    protected String filename;

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

    public void clear() {
        this.listProduct.clear();
    }

    public void searchProducts(String str) {
        ArrayList<Product> newList = new ArrayList<>();

        for (Product product : listProduct) {
            if (str.equals(String.valueOf(product.getId()))
                    || product.getName().equals(str)) {
                newList.add(product);
            }
        }
        if (newList.size() == 0) {
            System.out.println("Không tìm thấy sản phẩm mà bạn đã cung cấp thông tin");
        }
        else {
            System.out.println("Có " + newList.size() + " sản phẩm có thông tin giống trên: ");
            for(Product product : newList){
                product.showProduct();
            }
        }
    }

    public void showListProduct() {
        for (Product product : listProduct) {
            product.showProduct();
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