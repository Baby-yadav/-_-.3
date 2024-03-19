package atm;

import java.util.List;
import java.util.Scanner;

class ViewTransactionHistory implements ATMOperation {
    private final List<String> transactionHistory;

    ViewTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @Override
    public void execute() {
        System.out.println("Viewing Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}



