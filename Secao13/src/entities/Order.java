package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    LocalDateTime moment;
    OrderStatus status;
    ArrayList<OrderItem> items = new ArrayList<>();
    Client client;

    public Order(OrderStatus status, Client client) {
        this.moment = LocalDateTime.now();
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double sum = 0.0;
        for (OrderItem i : items) {
            sum += i.subTotal();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");
        sb.append("Order moment: ");
        sb.append(moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
        sb.append("Order status: ");
        sb.append(status.name() + "\n");
        sb.append("Client: ");
        sb.append(client.getName() + " (" + client.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ") - " + client.getEmail() + "\n");
        sb.append("Order items:\n");
        for (OrderItem i : items) {
            sb.append(i.product.getName() + ", $" + i.getPrice() + ", Quantity: " + i.getQuantity() + ", Subtotal: $" + i.subTotal() + "\n");
        }
        sb.append("Total price: " + total());
        return sb.toString();
    }
}
