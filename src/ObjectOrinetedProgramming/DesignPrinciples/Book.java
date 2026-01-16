package Object_Oriented_Programming.Aggregation;

import java.util.ArrayList;

/* ---------- BOOK CLASS (Independent) ---------- */
class Book {

    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayBookDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

/* ---------- LIBRARY CLASS (Aggregates Books) ---------- */
class Library {

    String libraryName;
    ArrayList<Book> books = new ArrayList<>();   // Aggregation

    Library(String libraryName) {
        this.libraryName = libraryName;
    }

    void addBook(Book book) {
        books.add(book);
    }

    void displayLibraryDetails() {
        System.out.println("\nLibrary: " + libraryName);
        for (Book book : books) {
            book.displayBookDetails();
        }
    }
}

/* ---------- MAIN CLASS (SAME FILE) ---------- */
class LibraryAggregation {

    public static void main(String[] args) {

        // Books exist independently
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("Wings of Fire", "A. P. J. Abdul Kalam");
        Book book3 = new Book("Clean Code", "Robert C. Martin");

        // Libraries
        Library cityLibrary = new Library("City Library");
        Library collegeLibrary = new Library("College Library");

        // Aggregation: libraries use existing books
        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);

        collegeLibrary.addBook(book2);
        collegeLibrary.addBook(book3);

        // Display libraries
        cityLibrary.displayLibraryDetails();
        collegeLibrary.displayLibraryDetails();

        // Book still exists independently
        System.out.println("\nIndependent Book:");
        book1.displayBookDetails();
    }
}
