package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

public class LibraryTest {
// Public class declaration for LibraryTest as the main demonstration class for book-author inheritance.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins and creates Author object.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        System.out.print("Enter Book Title: ");
// Prompting the user to enter the book title.

        String title = sc.nextLine();
// Reading a line of input (title) and storing in local variable.

        System.out.print("Enter Publication Year: ");
// Prompting the user to enter the publication year.

        int year = sc.nextInt();
// Reading an integer input (year) and storing in local variable.

        sc.nextLine();
// Consuming the newline character left in the input buffer after nextInt().

        System.out.print("Enter Author Name: ");
// Prompting the user to enter the author name.

        String name = sc.nextLine();
// Reading a line of input (author name) and storing in local variable.

        System.out.print("Enter Author Bio: ");
// Prompting the user to enter the author biography.

        String bio = sc.nextLine();
// Reading a line of input (bio) and storing in local variable.

        Author a1 = new Author(title, year, name, bio);
// Creating an Author object instance with all book and author details.

        System.out.println("\n--- Book & Author Details ---");
// Printing a formatted header for displaying combined information.

        a1.displayInfo();
// Calling overridden displayInfo() on a1 object; shows book details + author info.

        sc.close();
// Closing the Scanner to prevent resource leak (good practice).

    } // End of main method.

    // Superclass
    class Book {
// Inner class declaration for Book as the superclass/base class.

        String title;
// Instance variable to store the book title.

        int publicationYear;
// Instance variable to store the year of publication.

        Book(String title, int publicationYear) {
// Constructor declaration that initializes basic book fields.

            this.title = title;
// Assigning parameter to instance variable (distinguished by 'this').

            this.publicationYear = publicationYear;
// Assigning parameter to instance variable (distinguished by 'this').

        } // End of Book constructor.

        void displayInfo() {
// Method declaration providing basic book information display.

            System.out.println("Book Title: " + title);
// Printing the book title with descriptive label.

            System.out.println("Publication Year: " + publicationYear);
// Printing the publication year with descriptive label.

        } // End of displayInfo method in superclass.

    } // End of Book superclass.

    // Subclass
    class Author extends Book {
// Inner class declaration for Author subclass that inherits from Book superclass.

        String name;
// Subclass-specific instance variable for author name.

        String bio;
// Subclass-specific instance variable for author biography.

        Author(String title, int publicationYear, String name, String bio) {
// Constructor declaration that chains to superclass and sets subclass fields.

            super(title, publicationYear);
// Calling superclass Book constructor with book parameters.

            this.name = name;
// Assigning parameter to subclass instance variable.

            this.bio = bio;
// Assigning parameter to subclass instance variable.

        } // End of Author constructor.

        void displayInfo() {
// Overriding superclass displayInfo() to add author-specific details.

            super.displayInfo();
// Calling superclass Book's displayInfo() to print book details first.

            System.out.println("Author Name: " + name);
// Printing the author name with descriptive label.

            System.out.println("Author Bio: " + bio);
// Printing the author bio with descriptive label.

        } // End of overridden displayInfo method in Author subclass.

    } // End of Author subclass.

} // End of LibraryTest class.
