import shoppingmall.models.Product;
import shoppingmall.services.productService.ProductService;

import static shoppingmall.views.MenuCustomerView.*;
import static shoppingmall.views.StandardView.waitForInput;

public class Main {
    public static void main(String[] args) {
        ProductService productCustomer = new ProductService("data/product.bin");
        setProductCustomer(productCustomer);
        handleCustomerChoice();
        productCustomer.saveListProduct();
    }
}