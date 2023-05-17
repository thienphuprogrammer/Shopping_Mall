package Shopping_Mall.UserObject;

import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;

import java.util.ArrayList;

public class MenuProduct extends ListProduct {

    //function is used to search product that base on name or id of product
    public void searchProduct(String str) {
        ListProduct newList = new ListProduct();

        for (Product product : listProduct) {
            if (str.equals(String.valueOf(product.getId()))
                    || product.getName().equals(str)) {
                newList.addProduct(product);
            }
        }
        if (newList.getSize() == 0) {
            System.out.println("Không tìm thấy sinh viên mà bạn đã cung cấp thông tin");
        }
        else {
            System.out.println("Có " + newList.getSize() + " sinh viên có thông tin giống trên: ");
            for(Product product : newList.getListProduct()){
                product.showProduct();
            }
        }
    }

    //function is used to filter product that base on type of product
    public void filterProducṭ() {

    }
}