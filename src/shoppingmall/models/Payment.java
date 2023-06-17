package shoppingmall.models;

public class Payment {
    private int paymentId;
    private int order;
    private int paymentDate;
    private float paymentAmount;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(int paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Payment(int paymentId, int order, int paymentDate, float paymentAmount) {
        this.paymentId = paymentId;
        this.order = order;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }
}
