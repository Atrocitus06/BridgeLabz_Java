package ObjectOrientedProgramming.JavaClassAndObject.Level2;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level2 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class BankAccount {
// Class declaration for BankAccount to encapsulate banking operations and account data.

    String accountHolder;
// Instance variable to store the account holder's name as a string.

    int accountNumber;
// Instance variable to store the unique account number as an integer.

    double balance;
// Instance variable to store the current account balance as a double for decimal precision.

    void deposit(double amount) {
// Method declaration to deposit a specified amount into the account.

        balance = balance + amount;
// Adding the deposit amount to the current balance.

        System.out.println("Amount deposited: " + amount);
// Confirming the deposit by printing the amount deposited.

    } // End of deposit method.

    void withdraw(double amount) {
// Method declaration to withdraw a specified amount from the account if sufficient funds exist.

        if (amount <= balance) {
// Checking if the withdrawal amount does not exceed current balance.

            balance = balance - amount;
// Subtracting the withdrawal amount from the current balance.

            System.out.println("Amount withdrawn: " + amount);
// Confirming the withdrawal by printing the amount withdrawn.

        } else {
// Handling case where insufficient funds are available.

            System.out.println("Insufficient balance!");
// Printing error message for insufficient balance.

        } // End of if-else block for withdrawal validation.

    } // End of withdraw method.

    void displayBalance() {
// Method declaration to display the current account balance.

        System.out.println("Current Balance: " + balance);
// Printing the current balance prefixed with descriptive label.

    } // End of displayBalance method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        BankAccount acc = new BankAccount();
// Creating a new BankAccount object instance named 'acc' using default constructor.

        System.out.print("Enter account holder name: ");
// Prompting the user to enter the account holder name.

        acc.accountHolder = sc.nextLine();
// Reading a line of input (name) and assigning it to the object's accountHolder field.

        System.out.print("Enter account number: ");
// Prompting the user to enter the account number.

        acc.accountNumber = sc.nextInt();
// Reading an integer input (account number) and assigning it to the object's accountNumber field.

        System.out.print("Enter initial balance: ");
// Prompting the user to enter the initial balance.

        acc.balance = sc.nextDouble();
// Reading a double input (balance) and assigning it to the object's balance field.

        System.out.print("\nEnter amount to deposit: ");
// Prompting the user to enter deposit amount with newline for separation.

        double depositAmount = sc.nextDouble();
// Reading a double input (deposit amount) and storing in local variable.

        acc.deposit(depositAmount);
// Calling the deposit method on 'acc' object with depositAmount parameter.

        System.out.print("Enter amount to withdraw: ");
// Prompting the user to enter withdrawal amount.

        double withdrawAmount = sc.nextDouble();
// Reading a double input (withdraw amount) and storing in local variable.

        acc.withdraw(withdrawAmount);
// Calling the withdraw method on 'acc' object with withdrawAmount parameter.

        acc.displayBalance();
// Calling the displayBalance method on 'acc' object to show final balance.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of BankAccount class.
