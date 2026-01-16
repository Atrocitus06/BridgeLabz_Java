package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package for OOP library management demo.

import java.util.ArrayList;
// ArrayList import for item collection.

import java.util.Scanner;
// Scanner for input.

public class LibraryManagementDemo {
    // Demo class for library OOP patterns.

    public static void main(String[] args) {
        // Program starting point.

        Scanner sc = new Scanner(System.in);
        // Input scanner.

        ArrayList<LibraryItem> items = new ArrayList<>();
        // List of library items.

        System.out.print("Enter number of library items: ");
        // Items count prompt.

        int n = sc.nextInt();
        // Reading count.

        sc.nextLine();
        // Buffer clear.

        for (int i = 0; i < n; i++) {
            // Per-item loop.

            System.out.println("\nItem " + (i + 1));
            // Item number.

            System.out.print("Choose Type (1-Book, 2-Magazine, 3-DVD): ");
            // Type choice.

            int type = sc.nextInt();
            // Type input.

            sc.nextLine();

            System.out.print("Enter Item ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            LibraryItem item;
            // Polymorphic reference.

            if (type == 1) {
                item = new Book(id, title, author);
            } else if (type == 2) {
                item = new Magazine(id, title, author);
            } else {
                item = new DVD(id, title, author);
            }

            items.add(item);
            // Add to list.

        }  // End loop.

        System.out.println("\n===== LIBRARY ITEM DETAILS =====");
        // Details header.

        for (LibraryItem item : items) {
            // Process each.

            item.getItemDetails();
            // Details call.

            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            // Polymorphic duration.

            if (item instanceof Reservable) {
                // Reservable check.

                Reservable r = (Reservable) item;
                // Downcast.

                r.reserveItem();
                // Reserve action.

                System.out.println("Available: " + r.checkAvailability());
                // Status check.
            }

            System.out.println("--------------------------------");
            // Separator.
        }

        sc.close();
        // Close scanner.

    }  // End main.

}  // End demo class.

// Abstract library item base.
abstract class LibraryItem {
    // Encapsulation fields.
    private int itemId;
    private String title;
    private String author;

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Abstract method
    public abstract int getLoanDuration();
}

// Reservable interface.
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    // Availability tracker.
    private boolean available = true;

    Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14; // 14 days
    }

    public void reserveItem() {
        available = false;
        System.out.println("Book reserved successfully.");
    }

    public boolean checkAvailability() {
        return available;
    }
}

class Magazine extends LibraryItem {
    Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7; // 7 days
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean available = true;

    DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3; // 3 days
    }

    public void reserveItem() {
        available = false;
        System.out.println("DVD reserved successfully.");
    }

    public boolean checkAvailability() {
        return available;
    }
}
