import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nAccount Holder: " + accountHolderName + "\nBalance: $" + balance;
    }
}

public class BankingSystem {
    private static HashMap<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account with this number already exists.");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter Initial Deposit Amount: $");
        double initialBalance = scanner.nextDouble();

        Account account = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully!");
    }

    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();

        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Deposit Amount: $");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        account.deposit(amount);
        System.out.println("Deposit successful! Updated balance: $" + account.getBalance());
    }

    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();

        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Withdrawal Amount: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Updated balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();

        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("\n--- Account Details ---");
        System.out.println(account);
    }
}
