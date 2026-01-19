package DataStructure.LinkedList;
/*
MovieManagementSystem
This class implements a doubly linked list for movie records with Title (String unique key), Director (String), Year (int), Rating (double 0-10).
Core Node: inner MovieNode class holds data + next/prev pointers (null terminated both ends).
Operations fully implemented with O(1) ends via head/tail:
1. addFirst(): Prepends, updates head.prev=null/tail if needed.
2. addLast(): Appends, updates tail.next=null/head if needed.
3. addAtPosition(pos 1-based): Inserts after pos-1, bidirectional links.
4. removeByTitle(): Deletes first title match (head/tail/middle), O(n).
5. searchByDirector(): Prints all matching director (multi possible).
6. searchByRating(): Prints all >= rating threshold.
7. displayForward(): Head -> tail traversal.
8. displayReverse(): Tail -> head backward.
9. updateRatingByTitle(): Modifies rating in-place for title.
Interactive menu 1-9 +0 exit; Scanner inputs, edge: empty/invalid pos/not found/pos>size.
No dup title enforce; forward/reverse show bidirectional power.
Usage Example:
- 1 "Inception" Nolan 2010 8.8 -> Added beginning
- 7 -> Forward: Inception Nolan 2010 8.8
- 8 -> Reverse: same (single)
- 9 Inception 9.2 -> Updated
*/

import java.util.Scanner;  // Unified input handling

public class MovieManagementSystem {
    // Inner static Node class - bidirectional links
    static class MovieNode {
        String title;        // Movie title (search key)
        String director;     // Director name
        int year;            // Release year
        double rating;       // Rating 0-10
        MovieNode next;      // Forward pointer
        MovieNode prev;      // Backward pointer

        // Constructor sets all data, links null
        MovieNode(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;    // Initially no next
            this.prev = null;    // Initially no prev
        }
    }

    static MovieNode head;  // Front sentinel
    static MovieNode tail;  // End sentinel

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        head = null;  // Empty forward
        tail = null;  // Empty backward

        // Menu introduction
        System.out.println("Movie Management System using Doubly Linked List");
        System.out.println("1.Add First  2.Add Last  3.Add Position  4.Remove by Title");
        System.out.println("5.Search Director  6.Search Rating(>=)  7.Display Forward");
        System.out.println("8.Display Reverse  9.Update Rating by Title  0.Exit");

        int choice;
        do {
            System.out.print("\nEnter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Buffer flush

            switch (choice) {
                case 1:
                    addFirst(sc);
                    break;
                case 2:
                    addLast(sc);
                    break;
                case 3:
                    addAtPosition(sc);
                    break;
                case 4:
                    removeByTitle(sc);
                    break;
                case 5:
                    searchByDirector(sc);
                    break;
                case 6:
                    searchByRating(sc);
                    break;
                case 7:
                    displayForward();
                    break;
                case 8:
                    displayReverse();
                    break;
                case 9:
                    updateRatingByTitle(sc);
                    break;
                case 0:
                    System.out.println("Exiting Movie Manager...");
                    break;
                default:
                    System.out.println("Invalid! Choose 0-9.");
            }
        } while (choice != 0);

        sc.close();  // Resource cleanup
    }

    // 1. O(1) prepend - new head
    static void addFirst(Scanner sc) {
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Director: ");
        String director = sc.nextLine();
        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();

        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {  // First node
            head = tail = newNode;
        } else {
            newNode.next = head;     // New -> old head
            head.prev = newNode;     // Old head <- new
            head = newNode;          // Head shift
        }
        System.out.println("Movie '" + title + "' added at beginning.");
    }

    // 2. O(1) append - new tail
    static void addLast(Scanner sc) {
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        sc.nextLine();  // Extra for nextLine after double? Wait no, sequence
        System.out.print("Enter Director: ");
        String director = sc.nextLine();
        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();

        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {  // Empty
            head = tail = newNode;
        } else {
            tail.next = newNode;     // Old tail -> new
            newNode.prev = tail;     // New <- old tail
            tail = newNode;          // Tail advance
        }
        System.out.println("Movie '" + title + "' added at end.");
    }

    // 3. Insert at pos (1=first)
    static void addAtPosition(Scanner sc) {
        System.out.print("Enter position (1-based): ");
        int pos = sc.nextInt();
        if (pos < 1) {
            System.out.println("Position >=1 required!");
            return;
        }
        sc.nextLine();

        // Read movie data
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Director: ");
        String director = sc.nextLine();
        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();

        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (pos == 1) {  // Head insert
            newNode.next = head;
            if (head != null) head.prev = newNode;
            else tail = newNode;
            head = newNode;
            System.out.println("Added at position 1.");
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;  // Prev position
        }
        if (temp == null) {
            System.out.println("Position > list size!");
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;  // Next <- new
        } else {
            tail = newNode;  // New tail
        }
        temp.next = newNode;
        System.out.println("Movie '" + title + "' added at pos " + pos + ".");
    }

    // 4. Delete by title (first match)
    static void removeByTitle(Scanner sc) {
        System.out.print("Enter Title to remove: ");
        String title = sc.nextLine();

        if (head == null) {
            System.out.println("List empty!");
            return;
        }

        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;  // Find match
        }
        if (temp == null) {
            System.out.println("Movie '" + title + "' not found!");
            return;
        }

        // Unlink
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;  // Was head
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;  // Was tail
        }
        System.out.println("Movie '" + title + "' removed.");
    }

    // 5. Search all by director (case insensitive)
    static void searchByDirector(Scanner sc) {
        System.out.print("Enter Director name: ");
        String director = sc.nextLine();
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Found: " + temp.title + " (" + temp.year + ") Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies by '" + director + "' found!");
    }

    // 6. Search all with rating >= threshold
    static void searchByRating(Scanner sc) {
        System.out.print("Enter minimum Rating: ");
        double minRating = sc.nextDouble();
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating >= minRating) {
                System.out.println(temp.title + " - " + temp.director + " (" + temp.year + ") " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies with rating >= " + minRating + "!");
    }

    // 7. Forward traversal (head to tail)
    static void displayForward() {
        if (head == null) {
            System.out.println("No movies! List empty.");
            return;
        }
        System.out.println("\n=== Forward Order ===");
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
        System.out.println("====================");
    }

    // 8. Reverse traversal (tail to head)
    static void displayReverse() {
        if (tail == null) {
            System.out.println("No movies! List empty.");
            return;
        }
        System.out.println("\n=== Reverse Order ===");
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
        System.out.println("====================");
    }

    // 9. Update rating by title
    static void updateRatingByTitle(Scanner sc) {
        System.out.print("Enter Title to update: ");
        String title = sc.nextLine();
        System.out.print("Enter new Rating: ");
        double newRating = sc.nextDouble();

        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated to " + newRating + " for '" + title + "'.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie '" + title + "' not found!");
    }
}
// Main - Bidirectional movie list complete.
