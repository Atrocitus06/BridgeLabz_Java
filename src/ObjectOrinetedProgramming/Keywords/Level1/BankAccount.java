package Object_Oriented_Programming.Keywords.Level1;
// Package declaration that places this class in the Keywords.Level1 namespace within Object_Oriented_Programming.

import java.util.Scanner;
// Importing the Scanner class to allow reading user input from the console.

class BankAccount {
    // Class representing a bank account with static and instance members.

    static String bankName = "ABC Bank";
    // Static variable shared by all BankAccount objects, storing the common bank name.

    static int totalAccounts = 0;
    // Static variable to keep track of how many BankAccount instances have been created.

    final int accountNumber;
    // Instance variable for the unique account number; marked final so it cannot be changed after initialization.

    String accountHolderName;
    // Instance variable storing the name of the account holder; can be modified after object creation.

    BankAccount(int accountNumber, String accountHolderName) {
        // Constructor to initialize a new BankAccount with an account number and holder name.

        this.accountNumber = accountNumber;
        // Using 'this' to assign the constructor parameter to the instance variable 'accountNumber'.

        this.accountHolderName = accountHolderName;
        // Using 'this' to assign the constructor parameter to the instance variable 'accountHolderName'.

        totalAccounts++;
        // Incrementing the static counter each time a new BankAccount object is created.
    }

    static void getTotalAccounts() {
        // Static method to display the total number of BankAccount objects created so far.

        System.out.println("Total Accounts: " + totalAccounts);
        // Printing the value of the static variable 'totalAccounts' to the console.
    }

    void displayDetails(Object obj) {
        // Instance method that displays account details if the passed object is a BankAccount.

        if (obj instanceof BankAccount) {
            // Checking if the provided object is an instance of BankAccount before accessing its fields.

            System.out.println("Bank Name: " + bankName);
            // Printing the shared bank name from the static variable.

            System.out.println("Account Number: " + accountNumber);
            // Printing this account's unique account number.

            System.out.println("Account Holder Name: " + accountHolderName);
            // Printing the name of the person who owns this account.
        }
        // End of instanceof check.
    }
    // End of displayDetails method.
}
// End of BankAccount class.

class Main {
    // Class containing the main method which serves as the entry point of the program.

    public static void main(String[] args) {
        // Main method where the program starts executing.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the keyboard.

        System.out.print("Enter Account Number: ");
        // Prompting the user to enter an integer account number.

        int accNo = sc.nextInt();
        // Reading the entered account number as an integer.

        sc.nextLine();
        // Consuming the leftover newline character in the input buffer after nextInt().

        System.out.print("Enter Account Holder Name: ");
        // Prompting the user to enter the account holder's name.

        String name = sc.nextLine();
        // Reading the full line of text as the account holder's name.

        BankAccount acc = new BankAccount(accNo, name);
        // Creating a new BankAccount object using the entered account number and name.

        System.out.println("\n--- Account Details ---\n");
        // Printing a formatted header to visually separate the account details section.

        acc.displayDetails(acc);
        // Calling the instance method to display the details of the created BankAccount object.

        System.out.println();
        // Printing a blank line for better spacing in the console output.

        BankAccount.getTotalAccounts();
        // Calling the static method via the class name to show how many accounts have been created.

        sc.close();
        // Closing the Scanner to free the associated system resources.
    }
    // End of main method.
}
// End of Main class.
