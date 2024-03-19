package atm;

import java.util.List;
import java.util.Scanner;

class Transfer implements ATMOperation {
    private final Scanner scanner;
    private final List<String> transactionHistory;
    private double accountBalance;

    Transfer(Scanner scanner, List<String> transactionHistory, double accountBalance) {
        this.scanner = scanner;
        this.transactionHistory = transactionHistory;
        this.accountBalance = accountBalance;
    }

    @Override
    public void execute() {
        System.out.println("Transfer operation selected.");
        System.out.println("Your current balance: Rupee" + accountBalance);
        System.out.print("Enter recipient's account number: ");
        String recipientAccount = scanner.next();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Transfer successful. Amount: Rupee" + amount + " to Account: " + recipientAccount);
            transactionHistory.add("Transfer: Rupee" + amount + " to Account: " + recipientAccount);
        } else {
            System.out.println("Invalid amount or insufficient funds. Please try again.");
        }
    }
}