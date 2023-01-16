package entities;

public enum OrderStatus {
    PENDING_PAYMENT(1),
    PROCESSING(2),
    SHIPPED(3),
    DELIVERED(4);

    private final int status;

    private OrderStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
