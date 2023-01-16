package app;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nameClient = sc.nextLine();
        System.out.print("Email: ");
        String emailClient = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDateClient = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
        System.out.print("How many items to this order? ");
        Integer quantityItems = Integer.valueOf(sc.nextLine());

        Client client = new Client(nameClient, emailClient, birthDateClient);
        Order newOrder = new Order(orderStatus, client);

        for (int i = 1; i <= quantityItems; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            Double priceProduct = Double.valueOf(sc.nextLine());
            System.out.print("Quantity: ");
            Integer quantityProduct = Integer.valueOf(sc.nextLine());

            OrderItem orderItem = new OrderItem(nameProduct, quantityProduct, priceProduct);
            newOrder.addItem(orderItem);
        }

        System.out.println(newOrder.toString());
        sc.close();
    }
}
