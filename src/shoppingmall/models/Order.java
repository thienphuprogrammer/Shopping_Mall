package shoppingmall.models;

public class Order {
    private int orderId;
    private int customerId;
    private int productsId;
    private int orderDate;
    private int totalAmount;

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

    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(int orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order(int orderId, int customerId, int productsId, int orderDate, int totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productsId = productsId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
}
