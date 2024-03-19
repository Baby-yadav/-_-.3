package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ATM {
    private final Scanner scanner;
    private final List<String> transactionHistory;
    private final ATMOperation[] operations;
    private double accountBalance;

    ATM(double initialBalance) {
        scanner = new Scanner(System.in);
        transactionHistory = new ArrayList<>();
        operations = new ATMOperation[]{
                new ViewTransactionHistory(transactionHistory),
                new Withdraw(scanner, transactionHistory, initialBalance),
                new Deposit(scanner, transactionHistory, initialBalance),
                new Transfer(scanner, transactionHistory, initialBalance)
        };
        this.accountBalance = initialBalance;
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter User ID: ");
        int inputId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int inputPin = scanner.nextInt();

        if (authenticate(inputId, inputPin)) {
            System.out.println("Authentication successful. Welcome, User!");
            showOptions();
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private boolean authenticate(int inputId, int inputPin) {
       
        return inputId == 12345 && inputPin == 6789;
    }

    private void showOptions() {
        while (true) {
            System.out.println("\nATM Options:");
            System.out.println("1. View Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                operations[choice - 1].execute();
            } else if (choice == 5) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}