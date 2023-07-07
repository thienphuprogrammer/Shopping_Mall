package shoppingmall.models.admin;

import shoppingmall.models.customer.Order;
import shoppingmall.models.customer.Payment;
import shoppingmall.models.product.Product;

public class BrowseProduct extends Payment {
    public BrowseProduct(int paymentId, Product product, String paymentDate, int customerId) {
        super(paymentId, product, paymentDate, customerId);
    }
}
