package shoppingmall.models;

public class Order {
    private int orderId;
    private int customerId;
    private String orderDate;
    private Product product;
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
        System.out.print("| Name : " + product.name + " ".repeat(25 - String.valueOf(product.name).length()) + "|");
        System.out.print(" id : " + product.id + " ".repeat(25 - String.valueOf(product.id).length()) + "|");
        System.out.print(" Type : " + product.type + " ".repeat(25 - product.type.length()) + "|");
        System.out.print(" Price : " + product.price + " ".repeat(25 - String.valueOf(product.price).length()) + "|");
        System.out.print(" Count : " + totalAmount + " ".repeat(25 - String.valueOf(totalAmount).length()) + "|");

        // Xử lý mô tả nếu vượt quá kích thước cột
        if (product.description.length() > 25) {
            String truncatedDescription = product.description.substring(0, 22) + "...";
            System.out.println(
                    " Description : " + truncatedDescription + " ".repeat(25 - truncatedDescription.length()) + "|");
        } else {
            System.out.println(
                    " Description : " + product.description + " ".repeat(25 - product.description.length()) + "|");
        }
    }
}
