package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Problem 2: Book Library System

Design a Book class with:
ISBN (public).
title (protected).
author (private).

Write methods to:
Set and get the author name.
Create a subclass EBook to access ISBN and title and demonstrate access modifiers.
*/
// Block comment describing the book library system problem.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class LibraryBook {
    // Class representing a library book with different access modifiers.

    public String ISBN;
    // Public instance variable to store the book's ISBN, accessible from anywhere.

    protected String title;
    // Protected instance variable to store the book's title, accessible in the same package and subclasses.

    private String author;
    // Private instance variable to store the author's name, accessible only within this class.

    LibraryBook(String i, String t, String a) {
        // Constructor to initialize a LibraryBook with ISBN, title, and author.

        ISBN = i;
        // Assigning the constructor parameter 'i' to the instance variable 'ISBN'.

        title = t;
        // Assigning the constructor parameter 't' to the instance variable 'title'.

        author = a;
        // Assigning the constructor parameter 'a' to the private instance variable 'author'.
    }

    // Setter
    public void setAuthor(String a) {
        // Public setter method to modify the author's name.

        author = a;
        // Assigning the parameter 'a' to the private variable 'author'.
    }

    // Getter
    public String getAuthor() {
        // Public getter method to access the author's name.

        return author;
        // Returning the value of the private variable 'author'.
    }

    // Subclass representing a digital version of the book.
    class DigitalBook extends LibraryBook {
        // Inner subclass extending LibraryBook to demonstrate access to protected and public fields.

        DigitalBook(String i, String t, String a) {
            // Constructor for DigitalBook that forwards its parameters to the LibraryBook constructor.

            super(i, t, a);
            // Calling the superclass constructor to initialize ISBN, title, and author.
        }

        void displayDetails() {
            // Instance method to display book details, demonstrating access control.

            System.out.println("ISBN : " + ISBN);
            // Accessing and printing the public ISBN directly.

            System.out.println("Title : " + title);
            // Accessing and printing the protected title directly.

            System.out.println("Author : " + getAuthor());
            // Accessing and printing the private author via the public getter.
        }
        // End of displayDetails method.
    }
    // End of DigitalBook inner subclass.
}

// Separate test class to demonstrate usage of LibraryBook and DigitalBook.
class TestLibrary {
    // Class containing the main method to test the library book system.

    public static void main(String[] args) {
        // Main method: entry point of the test program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        System.out.print("Enter ISBN: ");
        // Prompting the user to enter the book's ISBN.

        String isbn = sc.nextLine();
        // Reading the full line as the ISBN.

        System.out.print("Enter Title: ");
        // Prompting the user to enter the book's title.

        String title = sc.nextLine();
        // Reading the full line as the book's title.

        System.out.print("Enter Author: ");
        // Prompting the user to enter the author's name.

        String author = sc.nextLine();
        // Reading the full line as the author's name.

        LibraryBook outer = new LibraryBook(isbn, title, author);
        // Creating an outer LibraryBook object to associate with the inner DigitalBook.

        LibraryBook.DigitalBook db = outer.new DigitalBook(isbn, title, author);
        // Creating an instance of the inner DigitalBook class using the outer LibraryBook object.

        System.out.println("\nBook Details:");
        // Printing a header to indicate the start of book details.

        db.displayDetails();
        // Displaying the details of the digital book.

        System.out.print("\nEnter new Author name: ");
        // Prompting the user to enter a new author name.

        String newAuthor = sc.nextLine();
        // Reading the new author name as a full line.

        db.setAuthor(newAuthor);
        // Updating the author's name using the setter method.

        System.out.println("Updated Author: " + db.getAuthor());
        // Printing the updated author's name using the getter method.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of TestLibrary class and library book example.
