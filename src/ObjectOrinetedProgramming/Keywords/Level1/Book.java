package Object_Oriented_Programming.Keywords.Level1;
// Package declaration that places this Book class under the Keywords.Level1 package.

import java.util.Scanner;
// Importing the Scanner class to allow reading of user input from the console.

public class Book {
    // Public class representing a Book with static and instance members.

    /* ---------- STATIC ---------- */

    static String libraryName = "Central City Library";
    // Static variable holding the name of the library shared by all Book objects.

    static void displayLibraryName() {
        // Static method to display the name of the library.

        System.out.println("Library Name: " + libraryName);
        // Printing the static library name to the console.
    }

    /* ---------- INSTANCE VARIABLES ---------- */

    String title;
    // Instance variable storing the title of the book.

    String author;
    // Instance variable storing the name of the author.

    final String isbn;
    // Final instance variable storing the ISBN, which cannot be changed once assigned.

    /* ---------- CONSTRUCTOR (THIS) ---------- */

    Book(String title, String author, String isbn) {
        // Constructor used to initialize a Book object with title, author, and ISBN.

        this.title = title;
        // Using 'this' to assign the constructor parameter to the instance variable 'title'.

        this.author = author;
        // Using 'this' to assign the constructor parameter to the instance variable 'author'.

        this.isbn = isbn;
        // Using 'this' to assign the constructor parameter to the final instance variable 'isbn'.
    }

    /* ---------- METHOD ---------- */

    void displayDetails(Object obj) {
        // Instance method to display details of the book if the given object is a Book instance.

        /* ---------- INSTANCEOF ---------- */

        if (obj instanceof Book) {
            // Checking if the passed object is an instance of Book before accessing its fields.

            System.out.println("\n--- Book Details ---");
            // Printing a header to indicate the start of book details.

            System.out.println("Title : " + title);
            // Printing the title of this book.

            System.out.println("Author : " + author);
            // Printing the author of this book.

            System.out.println("ISBN : " + isbn);
            // Printing the ISBN of this book.

        } else {
            // Executed if the object is not an instance of Book.

            System.out.println("Object is not a Book");
            // Informing that the given object is not of type Book.
        }
        // End of instanceof check and display logic.
    }
    // End of displayDetails method.

    /* ---------- MAIN METHOD (SAME FILE, NO SEPARATE MAIN FILE) ---------- */

    public static void main(String[] args) {
        // Main method serving as the entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        System.out.print("Enter Book Title: ");
        // Asking the user to input the book title.

        String title = sc.nextLine();
        // Reading the entire line as the title of the book.

        System.out.print("Enter Author Name: ");
        // Asking the user to input the author's name.

        String author = sc.nextLine();
        // Reading the entire line as the author's name.

        System.out.print("Enter ISBN: ");
        // Asking the user to input the book's ISBN.

        String isbn = sc.nextLine();
        // Reading the entire line as the ISBN value.

        // Display static data
        Book.displayLibraryName();
        // Calling the static method to display the library name without needing a Book object.

        // Create Book object
        Book book = new Book(title, author, isbn);
        // Creating a new Book instance using the user-provided values.

        // Verify using instanceof and display details
        book.displayDetails(book);
        // Passing the same Book object to displayDetails to check instanceof and print details.

        sc.close();
        // Closing the Scanner to release its resources.
    }
    // End of main method.
}
// End of Book class.
