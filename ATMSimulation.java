import java.util.Scanner;

public class ATMSimulation {
    private static double balance = 1000.0; // Initial balance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("\nYour current balance is: $" + balance);
    }

    private static void depositMoney() {
        System.out.print("\nEnter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            balance += amount;
            System.out.println("Successfully deposited $" + amount + ". Your new balance is: $" + balance);
        }
    }

    private static void withdrawMoney() {
        System.out.print("\nEnter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Your current balance is: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount + ". Your new balance is: $" + balance);
        }
    }
}
