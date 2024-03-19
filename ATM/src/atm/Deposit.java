package atm;

import java.util.List;
import java.util.Scanner;

class Deposit implements ATMOperation {
    private final Scanner scanner;
    private final List<String> transactionHistory;
    private double accountBalance;

    Deposit(Scanner scanner, List<String> transactionHistory, double accountBalance) {
        this.scanner = scanner;
        this.transactionHistory = transactionHistory;
        this.accountBalance = accountBalance;
    }

    @Override
    public void execute() {
        System.out.println("Deposit operation selected.");
        System.out.println("Your current balance: Rupee" + accountBalance);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful. Amount: Rupee" + amount);
            transactionHistory.add("Deposit: Rupee" + amount);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }
}
