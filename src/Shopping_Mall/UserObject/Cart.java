package Shopping_Mall.UserObject;

import Shopping_Mall.CommonFunction.Product;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
    private ArrayList<Product> listCart = new ArrayList<>();

    public ArrayList<Product> getListCart() {
        return listCart;
    }

    public void setListCart(ArrayList<Product> listCart) {
        this.listCart = listCart;
    }

    void addToCart(int idProduct) {
        for(Product product : listCart) {
            if(idProduct == product.getId()) {
                product.setCount(product.getCount() + 1);
            }
        }
    }
}