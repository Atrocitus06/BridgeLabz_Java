package Object_Oriented_Programming.Association;

import java.util.ArrayList;

/* ---------- BANK CLASS ---------- */
class Bank {

    String bankName;
    ArrayList<Customer> customers = new ArrayList<>();

    Bank(String bankName) {
        this.bankName = bankName;
    }

    // Association: Bank ↔ Customer
    void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println(customer.name + " opened an account in " + bankName);
    }
}

/* ---------- CUSTOMER CLASS ---------- */
class Customer {

    String name;
    double balance;
    Bank bank;   // Association with Bank

    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void assignBank(Bank bank) {
        this.bank = bank;
    }

    void viewBalance() {
        System.out.println(name + "'s balance in " + bank.bankName + ": " + balance);
    }
}

/* ---------- MAIN CLASS (SAME FILE) ---------- */
class BankAssociation {

    public static void main(String[] args) {

        // Bank
        Bank sbi = new Bank("State Bank of India");

        // Customers
        Customer c1 = new Customer("Rahul", 5000);
        Customer c2 = new Customer("Anita", 12000);

        // Association
        c1.assignBank(sbi);
        c2.assignBank(sbi);

        sbi.openAccount(c1);
        sbi.openAccount(c2);

        // Communication
        c1.viewBalance();
        c2.viewBalance();
    }
}
