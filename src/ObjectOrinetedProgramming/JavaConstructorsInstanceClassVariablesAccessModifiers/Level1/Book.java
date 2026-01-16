package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Book {
    // Class representing a book with title, author, and price.

    String title;
    // Instance variable to store the title of the book.

    String author;
    // Instance variable to store the author's name.

    double price;
    // Instance variable to store the price of the book.

    Book(String t, String a, double p) {
        // Parameterized constructor to initialize a Book object with title, author, and price.

        title = t;
        // Assigning the constructor parameter 't' to the instance variable 'title'.

        author = a;
        // Assigning the constructor parameter 'a' to the instance variable 'author'.

        price = p;
        // Assigning the constructor parameter 'p' to the instance variable 'price'.
    }

    void display() {
        // Instance method to display the details of the book.

        System.out.println("\nBook Details:");
        // Printing a header to indicate the start of book details.

        System.out.println("Title : " + title);
        // Printing the title of the book.

        System.out.println("Author : " + author);
        // Printing the author of the book.

        System.out.println("Price : " + price);
        // Printing the price of the book.
    }

    public static void main(String[] args) {
        // Main method: entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        System.out.print("Enter book title: ");
        // Prompting the user to enter the book title.

        String title = sc.nextLine();
        // Reading the full line as the book title.

        System.out.print("Enter author name: ");
        // Prompting the user to enter the author name.

        String author = sc.nextLine();
        // Reading the full line as the author name.

        System.out.print("Enter book price: ");
        // Prompting the user to enter the price of the book.

        double price = sc.nextDouble();
        // Reading the price as a double value.

        Book b = new Book(title, author, price);
        // Creating a new Book object using the provided title, author, and price.

        b.display();
        // Calling the display method to show the details of the created Book object.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Book class.
