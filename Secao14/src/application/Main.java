package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> productsList = new ArrayList<>();

        String productName;
        Double productPrice;
        Product novoProduto = null;

        System.out.print("Enter the number of products: ");
        Integer productsQuantity = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= productsQuantity; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            String tipoProduto = sc.nextLine();

            System.out.print("Name: ");
            productName = sc.nextLine();

            System.out.print("Price: ");
            productPrice = Double.parseDouble(sc.nextLine());

            switch (tipoProduto.charAt(0)) {
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate manufactureDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    novoProduto = new UsedProduct(productName, productPrice, manufactureDate);
                    break;
                case 'i':
                    System.out.print("Customs fee: ");
                    Double productCustomFee = Double.parseDouble(sc.nextLine());
                    novoProduto = new ImportedProduct(productName, productPrice, productCustomFee);
                    break;
                default:
                    novoProduto = new Product(productName, productPrice);
                    break;
            }
            productsList.add(novoProduto);
        }

        System.out.println("PRICE TAGS:");
        for (Product p : productsList) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
