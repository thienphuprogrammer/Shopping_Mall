import shoppingmall.services.productService.ProductService;

import static shoppingmall.views.MenuCustomerView.*;
import static shoppingmall.views.StandardView.waitForInput;

public class Main {
    public static void main(String[] args) {

        ProductService productCustomer = new ProductService("data/product.txt");
        setProductCustomer(productCustomer);
        getProductCustomer().loadListProduct();
        while(true) {
            handleCustomerChoice();
            waitForInput();
        }

    }
}