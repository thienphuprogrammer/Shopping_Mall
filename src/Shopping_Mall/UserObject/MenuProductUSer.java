package Shopping_Mall.UserObject;

import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;

public class MenuProductUSer extends ListProduct {
    //function is used to filter product that base on type of product
    public void filterProducṭ(String type) {
        ListProduct newList = this;

        for (Product product : listProduct) {
            if (product.getType().equals(type)) {
                newList.addProduct(product);
            }
        }
        if (newList.getSize() == 0) {
            System.out.println("Không tìm thấy sản phảm mà bạn đã cung cấp thông tin");
        }
        else {
            System.out.println("Có " + newList.getSize() + " saản phẩm có thông tin giống trên: ");
            for(Product product : newList.getListProduct()){
                product.showProduct();
            }
        }
    }
}
