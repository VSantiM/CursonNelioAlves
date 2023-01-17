package application;

import models.entities.Account;
import models.entities.OperationException;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        Integer accNumber = Integer.parseInt(sc.nextLine());

        System.out.print("Holder: ");
        String accHolder = sc.nextLine();

        System.out.print("Initial balance: ");
        Double accInitialBalance = Double.parseDouble(sc.nextLine());

        System.out.print("Withdraw limit: ");
        Double accWithdrawLimit = Double.parseDouble(sc.nextLine());

        Account acc = new Account(accNumber, accHolder, accInitialBalance, accWithdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        try {
            acc.withdraw(Double.parseDouble(sc.nextLine()));
            System.out.println("New balance: " + acc.getBalance());
        } catch (OperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
