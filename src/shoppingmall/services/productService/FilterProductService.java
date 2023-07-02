package shoppingmall.services.productService;

import shoppingmall.models.Product;

import java.util.ArrayList;

import static shoppingmall.utils.InputUtil.*;
import static shoppingmall.views.StandardView.*;

public class FilterProductService {
    private ProductService newList = new ProductService();
    private ArrayList<Product> listProduct;

    public ProductService getNewList() {
        return newList;
    }

    public void setNewList(ProductService newList) {
        this.newList = newList;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public FilterProductService(ProductService listProduct1) {
        this.listProduct = listProduct1.getListProduct();
    }

    public void filterCount() {
        int count = readInt("Nhập số lượng tối thiểu bạn muốn: ");
        for (Product product : listProduct) {
            if (product.getCount() >= count) {
                newList.addProduct(product);
            }
        }
    }

    public void filterPrice() {
        float minPrice = readFloat("Nhập giá thấp bạn muốn: ");
        float maxPrice = readFloat("Nhập giá cao nhất bạn muốn: ");
        for (Product product : listProduct) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                newList.addProduct(product);
            }
        }
    }

    public void filterType() {
        String type = readString("Nhập loại hàng bạn muốn: ");
        for (Product product : listProduct) {
            if (product.getType().equals(type)) {
                newList.addProduct(product);
            }
        }
    }
}
