package shoppingmall.models.customer;

import shoppingmall.models.product.Product;

import java.io.Serializable;

public class Order implements Serializable {
    protected static final long serialVersionUID = 1L; // added serialVersionUID field
    protected int orderId;
    protected int customerId;
    protected String orderDate;
    protected Product product;
    protected int totalAmount;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order(int orderId, int customerId, Product product, String orderDate, int totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.product = product;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public void showOrder() {
        System.out.print("| Name : " + product.getName() + " ".repeat(25 - String.valueOf(product.getName()).length()) + "|");
        System.out.print(" id : " + product.getId() + " ".repeat(25 - String.valueOf(product.getId()).length()) + "|");
        System.out.print(" Type : " + product.getType() + " ".repeat(25 - product.getType().length()) + "|");
        System.out.print(" Price : " + product.getPrice() + " ".repeat(25 - String.valueOf(product.getPrice()).length()) + "|");
        System.out.print(" Count : " + totalAmount + " ".repeat(25 - String.valueOf(totalAmount).length()) + "|");

        // Xử lý mô tả nếu vượt quá kích thước cột
        if (product.getDescription().length() > 25) {
            String truncatedDescription = product.getDescription().substring(0, 22) + "...";
            System.out.println(
                    " Description : " + truncatedDescription + " ".repeat(25 - truncatedDescription.length()) + "|");
        } else {
            System.out.println(
                    " Description : " + product.getDescription() + " ".repeat(25 - product.getDescription().length()) + "|");
        }
    }
}
