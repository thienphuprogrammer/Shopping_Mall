package Shopping_Mall.UserObject;

import Shopping_Mall.CommonFunction.ListProduct;
import Shopping_Mall.CommonFunction.Product;

public class ShoppingCart extends ListProduct {
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
}