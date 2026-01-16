package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Problem 3: Bank Account Management

Create a BankAccount class with:
accountNumber (public).
accountHolder (protected).
balance (private).

Write methods to:
Access and modify balance using public methods.
Create a subclass SavingsAccount to demonstrate access to accountNumber and accountHolder.
*/
// Block comment describing the problem statement and requirements.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class BankAccount {
    // Class representing a bank account with different access modifiers.

    public int accountNumber;
    // Public instance variable to store the account number, accessible from anywhere.

    protected String accountHolder;
    // Protected instance variable to store the account holder's name, accessible in the same package and subclasses.

    private double balance;
    // Private instance variable to store the balance, accessible only within this class.

    BankAccount(int accNo, String holder, double bal) {
        // Constructor to initialize a BankAccount object with account number, holder name, and balance.

        accountNumber = accNo;
        // Assigning the constructor parameter 'accNo' to the instance variable 'accountNumber'.

        accountHolder = holder;
        // Assigning the constructor parameter 'holder' to the instance variable 'accountHolder'.

        balance = bal;
        // Assigning the constructor parameter 'bal' to the private instance variable 'balance'.
    }

    // Getter
    public double getBalance() {
        // Public getter method to return the current balance.

        return balance;
        // Returning the value of the private variable 'balance'.
    }

    // Setter
    public void setBalance(double bal) {
        // Public setter method to update the balance.

        balance = bal;
        // Assigning the parameter 'bal' to the private instance variable 'balance'.
    }

    // Subclass
    class SavingsAccount extends BankAccount {
        // Inner subclass representing a specific type of BankAccount: SavingsAccount.

        SavingsAccount(int accNo, String holder, double bal) {
            // Constructor for SavingsAccount that passes arguments to the superclass constructor.

            super(accNo, holder, bal);
            // Calling the parent class (BankAccount) constructor using super().
        }

        void displayDetails() {
            // Instance method to display account details from within the subclass.

            System.out.println("Account Number : " + accountNumber);
            // Printing the public account number accessed directly in the subclass.

            System.out.println("Account Holder : " + accountHolder);
            // Printing the protected account holder name accessed directly in the subclass.

            System.out.println("Balance : " + getBalance());
            // Printing the private balance accessed via the public getter method.
        }
        // End of displayDetails method.
    }
    // End of SavingsAccount subclass.
}

// Separate test class to run the bank account example.
class TestBank {
    // Class containing the main method to test BankAccount and SavingsAccount.

    public static void main(String[] args) {
        // Main method: entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        System.out.print("Enter Account Number: ");
        // Prompting the user to enter the account number.

        int accNo = sc.nextInt();
        // Reading the account number as an integer.

        sc.nextLine();
        // Clearing the newline character left in the buffer after nextInt().

        System.out.print("Enter Account Holder Name: ");
        // Prompting the user to enter the account holder's name.

        String holder = sc.nextLine();
        // Reading the full line as the account holder's name.

        System.out.print("Enter Balance: ");
        // Prompting the user to enter the initial balance.

        double bal = sc.nextDouble();
        // Reading the balance as a double.

        BankAccount outer = new BankAccount(accNo, holder, bal);
        // Creating an outer BankAccount object to initialize the inner SavingsAccount.

        BankAccount.SavingsAccount sa = outer.new SavingsAccount(accNo, holder, bal);
        // Creating an instance of the inner SavingsAccount class associated with the outer BankAccount.

        System.out.println("\nAccount Details:");
        // Printing a header to indicate the beginning of account details.

        sa.displayDetails();
        // Displaying the details of the savings account using the subclass method.

        System.out.print("\nEnter new Balance: ");
        // Prompting the user to enter a new balance.

        double newBal = sc.nextDouble();
        // Reading the new balance as a double.

        sa.setBalance(newBal);
        // Updating the balance using the public setter method.

        System.out.println("Updated Balance: " + sa.getBalance());
        // Printing the updated balance using the public getter method.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of TestBank class and bank account example.
