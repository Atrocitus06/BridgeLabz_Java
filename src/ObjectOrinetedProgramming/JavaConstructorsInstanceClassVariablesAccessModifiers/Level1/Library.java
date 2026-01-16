package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Library Book System: Create a Book class with attributes title, author, price, and availability.
Implement a method to borrow a book.
*/
// Block comment describing the simple library book system.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Library {
    // Class representing a single book in a library system.

    String title;
    // Instance variable to store the title of the book.

    String author;
    // Instance variable to store the author's name.

    double price;
    // Instance variable to store the price of the book.

    boolean available;
    // Instance variable to indicate whether the book is currently available.

    Library(String t, String a, double p) {
        // Constructor to initialize a Library object with title, author, and price.

        title = t;
        // Assigning the constructor parameter 't' to the instance variable 'title'.

        author = a;
        // Assigning the constructor parameter 'a' to the instance variable 'author'.

        price = p;
        // Assigning the constructor parameter 'p' to the instance variable 'price'.

        available = true;
        // Initializing availability to true, meaning the book is available by default.
    }

    void borrowBook() {
        // Instance method to borrow a book if it is available.

        if (available) {
            // Checking if the book is currently available.

            available = false;
            // Marking the book as not available because it has been borrowed.

            System.out.println("Book borrowed successfully!");
            // Informing the user that the borrowing operation was successful.

        } else {
            // Executed if the book is already borrowed.

            System.out.println("Sorry, book is already borrowed.");
            // Informing the user that the book cannot be borrowed again.
        }
        // End of availability check.
    }

    void display() {
        // Instance method to display the book's details.

        System.out.println("\nBook Details:");
        // Printing a header to indicate the start of the book details.

        System.out.println("Title : " + title);
        // Printing the title of the book.

        System.out.println("Author : " + author);
        // Printing the name of the author.

        System.out.println("Price : " + price);
        // Printing the price of the book.

        System.out.println("Available : " + available);
        // Printing the current availability status of the book.
    }

    public static void main(String[] args) {
        // Main method: entry point of the library book example.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        System.out.print("Enter book title: ");
        // Prompting the user to enter the book's title.

        String title = sc.nextLine();
        // Reading the full line as the book title.

        System.out.print("Enter author name: ");
        // Prompting the user to enter the author's name.

        String author = sc.nextLine();
        // Reading the full line as the author's name.

        System.out.print("Enter book price: ");
        // Prompting the user to enter the book's price.

        double price = sc.nextDouble();
        // Reading the price as a double value.

        Library book = new Library(title, author, price);
        // Creating a Library object (representing a book) with the entered details.

        book.display();
        // Displaying the initial details of the book, including its availability.

        System.out.println("\nTrying to borrow the book...");
        // Informing the user that a borrow attempt is about to occur.

        book.borrowBook();
        // Attempting to borrow the book using the borrowBook method.

        book.display();
        // Displaying the details again to show the updated availability status.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Library class.
