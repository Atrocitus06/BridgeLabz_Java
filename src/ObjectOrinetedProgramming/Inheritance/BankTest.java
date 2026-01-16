package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console (though unused in main logic).

public class BankTest {
// Public class declaration for BankTest as the main demonstration class for inheritance hierarchy.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins and bank accounts are demonstrated.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input (though not used; kept for potential expansion).

        SavingsAccount sa = new SavingsAccount(1001, 5000, 4.5);
// Creating a SavingsAccount object with accountNumber=1001, balance=5000, interestRate=4.5.

        sa.displayAccountType();
// Calling displayAccountType() on sa object to print specific account subtype.

        sa.displayDetails();
// Calling inherited displayDetails() on sa object to print common account details.

        System.out.println();
// Printing a blank line for separation between account demonstrations.

        CheckingAccount ca = new CheckingAccount(1002, 8000, 3);
// Creating a CheckingAccount object with accountNumber=1002, balance=8000, withdrawalLimit=3.

        ca.displayAccountType();
// Calling displayAccountType() on ca object to print specific account subtype.

        ca.displayDetails();
// Calling inherited displayDetails() on ca object to print common account details.

        System.out.println();
// Printing a blank line for separation between account demonstrations.

        FixedDepositAccount fda = new FixedDepositAccount(1003, 20000, 12);
// Creating a FixedDepositAccount object with accountNumber=1003, balance=20000, tenure=12.

        fda.displayAccountType();
// Calling displayAccountType() on fda object to print specific account subtype.

        fda.displayDetails();
// Calling inherited displayDetails() on fda object to print common account details.

        sc.close();
// Closing the Scanner to prevent resource leak (good practice).

    } // End of main method.

    // Superclass
    class BankAccount {
// Inner class declaration for BankAccount as the superclass/base class for all account types.

        int accountNumber;
// Instance variable to store the unique account number.

        double balance;
// Instance variable to store the current account balance as double for decimal precision.

        BankAccount(int accountNumber, double balance) {
// Constructor declaration that initializes common account fields.

            this.accountNumber = accountNumber;
// Assigning parameter to instance variable (distinguished by 'this').

            this.balance = balance;
// Assigning parameter to instance variable (distinguished by 'this').

        } // End of BankAccount constructor.

        void displayDetails() {
// Method declaration providing common display behavior for all BankAccount subtypes.

            System.out.println("Account Number: " + accountNumber);
// Printing the account number with descriptive label.

            System.out.println("Balance: ₹" + balance);
// Printing the balance prefixed with currency symbol and label.

        } // End of displayDetails method in superclass.

    } // End of BankAccount superclass.

    //subclass
    class SavingsAccount extends BankAccount {
// Inner class declaration for SavingsAccount subclass that inherits from BankAccount superclass.

        double interestRate;
// Subclass-specific instance variable for interest rate.

        SavingsAccount(int accountNumber, double balance, double interestRate) {
// Constructor declaration that chains to superclass and initializes subclass field.

            super(accountNumber, balance);
// Calling superclass BankAccount constructor with common parameters.

            this.interestRate = interestRate;
// Assigning parameter to subclass instance variable.

        } // End of SavingsAccount constructor.

        void displayAccountType() {
// Subclass method declaration to identify specific account type.

            System.out.println("Account Type: Savings Account");
// Printing SavingsAccount-specific type message.

        } // End of displayAccountType method in SavingsAccount.

    } // End of SavingsAccount subclass.

    // subclass
    class CheckingAccount extends BankAccount {
// Inner class declaration for CheckingAccount subclass that inherits from BankAccount superclass.

        int withdrawalLimit;
// Subclass-specific instance variable for daily withdrawal limit.

        CheckingAccount(int accountNumber, double balance, int withdrawalLimit) {
// Constructor declaration that chains to superclass and initializes subclass field.

            super(accountNumber, balance);
// Calling superclass BankAccount constructor with common parameters.

            this.withdrawalLimit = withdrawalLimit;
// Assigning parameter to subclass instance variable.

        } // End of CheckingAccount constructor.

        void displayAccountType() {
// Subclass method declaration to identify specific account type.

            System.out.println("Account Type: Checking Account");
// Printing CheckingAccount-specific type message.

        } // End of displayAccountType method in CheckingAccount.

    } // End of CheckingAccount subclass.

    //subclass
    class FixedDepositAccount extends BankAccount {
// Inner class declaration for FixedDepositAccount subclass that inherits from BankAccount superclass.

        int tenure;
// Subclass-specific instance variable for deposit tenure in months.

        FixedDepositAccount(int accountNumber, double balance, int tenure) {
// Constructor declaration that chains to superclass and initializes subclass field.

            super(accountNumber, balance);
// Calling superclass BankAccount constructor with common parameters.

            this.tenure = tenure;
// Assigning parameter to subclass instance variable.

        } // End of FixedDepositAccount constructor.

        void displayAccountType() {
// Subclass method declaration to identify specific account type.

            System.out.println("Account Type: Fixed Deposit Account");
// Printing FixedDepositAccount-specific type message.

        } // End of displayAccountType method in FixedDepositAccount.

    } // End of FixedDepositAccount subclass.

} // End of BankTest class.
