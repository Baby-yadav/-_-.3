package atm;

import java.util.List;
import java.util.Scanner;

class Withdraw implements ATMOperation {
    private final Scanner scanner;
    private final List<String> transactionHistory;
    private double accountBalance;

    Withdraw(Scanner scanner, List<String> transactionHistory, double accountBalance) {
        this.scanner = scanner;
        this.transactionHistory = transactionHistory;
        this.accountBalance = accountBalance;
    }

    @Override
    public void execute() {
        System.out.println("Withdraw operation selected.");
        System.out.println("Your current balance: Rupee" + accountBalance);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. Amount: 	Rupee" + amount);
            transactionHistory.add("Withdrawal: Rupee" + amount);
        } else {
            System.out.println("Invalid amount or insufficient funds. Please try again.");
        }
    }
}