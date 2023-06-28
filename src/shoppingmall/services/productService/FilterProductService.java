package shoppingmall.services.productService;

import shoppingmall.models.Product;

import java.util.ArrayList;

import static shoppingmall.utils.InputUtil.*;

public class FilterProductService {
    private ProductService newList = new ProductService();
    private ArrayList<Product> listProduct;

    FilterProductService(ProductService listProduct1) {
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

        if (choice == 0) {
            return;
        } else if (choice == 1) {
            filterCount();
        } else if (choice == 2) {
            filterPrice();
        } else {
            filterType();
        }
        newList.showListProduct();
        new FilterProductService(newList);
    }

    private void filterCount() {
        int count = readInt("Nhập số lượng tối thiểu bạn muốn: ");
        for (Product product : listProduct) {
            if (product.getCount() >= count) {
                newList.addProduct(product);
            }
        }
    }

    private void filterPrice() {
        float minPrice = readFloat("Nhập giá thấp bạn muốn: ");
        float maxPrice = readFloat("Nhập giá cao nhất bạn muốn: ");
        for (Product product : listProduct) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                newList.addProduct(product);
            }
        }
    }

    private void filterType() {
        String type = readString("Nhập loại hàng bạn muốn: ");
        for (Product product : listProduct) {
            if (product.getType().equals(type)) {
                newList.addProduct(product);
            }
        }
    }
}
