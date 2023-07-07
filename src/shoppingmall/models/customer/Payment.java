package shoppingmall.models.customer;

import shoppingmall.models.product.Product;

import java.io.Serializable;

public class Payment implements Serializable {
    protected static final long serialVersionUID = 1L; // added serialVersionUID field

    private int paymentId;
    private Product product;
    private String paymentDate;
    private int customerId;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Payment(int paymentId, Product product, String paymentDate, int customerId) {
        this.paymentId = paymentId;
        this.product = product;
        this.paymentDate = paymentDate;
        this.customerId = customerId;
    }
}
