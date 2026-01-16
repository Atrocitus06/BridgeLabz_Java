// ===== BankingSystemDemo =====
package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package declaration for advanced OOP banking system demonstration.

import java.util.ArrayList;
// Importing ArrayList for managing accounts dynamically.

import java.util.Scanner;
// Importing Scanner for user console interactions.

public class BankingSystemDemo {
    // Main demo class showcasing banking operations with OOP principles.

    public static void main(String[] args) {
        // Entry point method for the banking system simulation.

        Scanner sc = new Scanner(System.in);
        // Initializing console input reader.

        ArrayList<Account> accounts = new ArrayList<>();
        // Polymorphic ArrayList holding Account references.

        System.out.print("Enter number of accounts: ");
        // User prompt for account count.

        int numAccounts = sc.nextInt();
        // Capturing number of accounts.

        sc.nextLine();
        // Clearing input newline residue.

        for (int i = 0; i < numAccounts; i++) {
            // Iterating to create each account.

            System.out.println((i + 1) + ".");
            // Displaying current account index (1-indexed).

            System.out.print("Account Type (1-Savings, 2-Current): ");
            // Prompting account type selection.

            int type = sc.nextInt();
            // Reading type (1 or 2).

            sc.nextLine();
            // Buffer flush.

            System.out.print("Enter Account Number: ");
            // Requesting account number.

            String accNo = sc.nextLine();
            // Reading account number as string.

            System.out.print("Enter Account Holder Name: ");
            // Name input prompt.

            String holderName = sc.nextLine();
            // Capturing holder name.

            System.out.print("Enter Initial Balance: ");
            // Initial deposit prompt.

            double initialBalance = sc.nextDouble();
            // Reading opening balance.

            Account acc;
            // Polymorphic account reference.

            if (type == 1) {
                // Savings account branch.

                System.out.print("Enter Interest Rate (%): ");
                // Specific savings interest prompt.

                double interestRate = sc.nextDouble();
                // Reading interest rate.

                acc = new SavingsAccount(accNo, holderName, initialBalance, interestRate);
                // Instantiating SavingsAccount.

            } else {
                // Current account branch.

                System.out.print("Enter Overdraft Limit: ");
                // Overdraft facility prompt.

                double overdraftLimit = sc.nextDouble();
                // Reading overdraft amount.

                acc = new CurrentAccount(accNo, holderName, initialBalance, overdraftLimit);
                // Creating CurrentAccount.

            }

            sc.nextLine();
            // Post-numeric buffer clear.

            accounts.add(acc);
            // Adding to collection.

        }

        // ===== Demo Transactions =====
        System.out.println("\n=== BANKING OPERATIONS ===");
        // Section header for transactions.

        for (Account a : accounts) {
            // Polymorphic transaction loop.

            System.out.println("\nAccount: " + a.getAccountNumber());
            // Showing current account.

            System.out.print("Enter Deposit Amount: ");
            // Deposit prompt.

            double deposit = sc.nextDouble();
            // Reading deposit.

            a.deposit(deposit);
            // Polymorphic deposit call.

            System.out.print("Enter Withdrawal Amount: ");
            // Withdrawal prompt.

            double withdraw = sc.nextDouble();
            // Reading withdrawal amount.

            a.withdraw(withdraw);
            // Polymorphic withdrawal.

            System.out.println("Final Balance: " + a.getBalance());
            // Displaying updated balance.

            if (a instanceof SavingsAccount) {
                // Type check for interest.

                System.out.println("Interest Earned: " + ((SavingsAccount) a).calculateInterest());
            }
        }

        sc.close();
        // Resource cleanup.

    }
}
// End BankingSystemDemo.

// ===== Abstract Account Superclass =====
abstract class Account {
    // Abstract base for all accounts with common operations.

    private String accountNumber;
    // Encapsulated account identifier.

    private String holderName;
    // Encapsulated owner name.

    private double balance;
    // Encapsulated current balance.

    Account(String accountNumber, String holderName, double balance) {
        // Constructor for base account properties.

        this.accountNumber = accountNumber;
        // Initializing account number.

        this.holderName = holderName;
        // Setting holder.

        this.balance = balance;
        // Starting balance.

    }

    // Getters
    public String getAccountNumber() {
        // Account number accessor.

        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        // Common deposit logic.

        if (amount > 0) {
            // Valid amount check.

            balance += amount;
            // Adding to balance.

            System.out.println("Deposited: " + amount);
        }
    }

    public abstract boolean withdraw(double amount);
    // Abstract withdrawal (subclass specific).

    protected void setBalance(double balance) {
        // Protected setter for internal use.

        this.balance = balance;
    }
}
// End abstract Account.

// ===== SavingsAccount Subclass =====
class SavingsAccount extends Account {
    // Savings subclass with interest.

    private double interestRate;
    // Annual interest percentage.

    SavingsAccount(String accNo, String name, double balance, double interestRate) {
        // Constructor.

        super(accNo, name, balance);
        // Super initialization.

        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        // Overridden withdrawal with min balance check.

        if (amount > 0 && (getBalance() - amount) >= 1000) {
            // Sufficient balance after withdrawal (min 1000 reserve).

            setBalance(getBalance() - amount);
            // Updating balance.

            System.out.println("Withdrawn: " + amount);
            // Confirmation.

            return true;
        }
        System.out.println("Insufficient balance or minimum required.");
        return false;
    }

    public double calculateInterest() {
        // Interest computation.

        return getBalance() * (interestRate / 100);
    }
}
// End SavingsAccount.

// ===== CurrentAccount Subclass =====
class CurrentAccount extends Account {
    // Current account with overdraft.

    private double overdraftLimit;
    // Allowed overdraft amount.

    CurrentAccount(String accNo, String name, double balance, double overdraftLimit) {
        super(accNo, name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        // Withdrawal allowing overdraft.

        if (amount > 0 && (getBalance() - amount) >= -overdraftLimit) {
            // Check against overdraft limit.

            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount + " (Overdraft used if negative)");
            return true;
        }
        System.out.println("Exceeds overdraft limit.");
        return false;
    }
}
// End CurrentAccount.
