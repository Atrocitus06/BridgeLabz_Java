package ObjectOrientedProgramming.JavaClassAndObject.Level1;
// Package declaration that organizes this class within the Java_Class_And_Object Level1 module.

/*
Program to Handle Book Details

Problem Statement: Write a program to create a Book class with attributes title, author, and price.
Add a method to display the book details.
*/
// Block comment describing the book handling program.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Book {
    // Class representing a book with title, author, and price attributes.

    String title;
    // Instance variable to store the title of the book.

    String author;
    // Instance variable to store the name of the book's author.

    double price;
    // Instance variable to store the price of the book.

    void displayDetails() {
        // Instance method to display all details of the book.

        System.out.println("\nBook Details:");
        // Printing a header to indicate the start of book details.

        System.out.println("Title: " + title);
        // Printing the book's title.

        System.out.println("Author: " + author);
        // Printing the book's author.

        System.out.println("Price: " + price);
        // Printing the book's price.
    }

    public static void main(String[] args) {
        // Main method: entry point of the book details program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read input from the console.

        Book b = new Book();
        // Creating a new Book object using the default constructor.

        System.out.print("Enter book title: ");
        // Prompting the user to enter the book's title.

        b.title = sc.nextLine();
        // Directly assigning the read title to the object's instance variable.

        System.out.print("Enter author name: ");
        // Prompting the user to enter the author's name.

        b.author = sc.nextLine();
        // Directly assigning the read author name to the object's instance variable.

        System.out.print("Enter book price: ");
        // Prompting the user to enter the book's price.

        b.price = sc.nextDouble();
        // Directly assigning the read price to the object's instance variable.

        b.displayDetails();
        // Calling the instance method to display the book's details.

        sc.close();
        // Closing the Scanner to release system resources (added for good practice).
    }
    // End of main method.
}
// End of Book class.
