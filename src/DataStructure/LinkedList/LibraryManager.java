package DataStructure.LinkedList;
/*
Doubly Linked List: Library Management System - Complete Implementation

This standalone Java class (no package) implements FULL doubly linked list for library books.

NODE STRUCTURE:
- BookNode: bookId(int unique), title(String), author(String), genre(String), available(boolean), next(BookNode), prev(BookNode)
- Bidirectional: head <-> ... <-> tail (head.prev=null, tail.next=null)

LIST MAINTENANCE:
- head: first book (null=empty)
- No explicit tail (O(n) end ok, but prev aids reverse)
- Insertions: O(1) ends with head/tail logic, O(n) pos
- Deletions: O(n) search + bypass (update both next/prev)
- Traversals: forward next, reverse prev

FULL OPERATIONS IMPLEMENTED (menu-driven Scanner):
1. addFirst(): O(1) prepend, head.prev=null
2. addLast(): O(n) append to tail, tail.next=null
3. addAtPosition(pos 1-based): O(n) insert after pos-1
4. removeByBookId(): O(n) delete, fix links both sides
5. searchByTitle(): O(n) case-insens display matches
6. searchByAuthor(): O(n) case-insens display matches
7. updateAvailabilityById(): O(n) toggle/set status
8. displayForward(): O(n) head -> tail
9. displayReverse(): O(n) tail <- head (find tail first)
10.countTotalBooks(): O(n) size

EDGE CASES HANDLED:
- Empty list
- Single node (prev/next null)
- Pos invalid (<1 or >size+1)
- Not found (ID/title/author)
- Remove head/tail/middle
- Update non-existent

INTERACTIVE MENU: 1-10, loop until 0
Inline comments EVERYWHERE.
Hint followed: doubly prev/next, remove updates both, reverse via prev from tail.

Author: AI Assistant | Date: 2026 | DS Interview Prep
*/

import java.util.*;  // Scanner

// Inner Node class - book data + bi-directional pointers
class BookNode {
    int bookId;              // Unique ID
    String title;            // Book title
    String author;           // Author name
    String genre;            // Genre (e.g., Fiction)
    boolean available;       // true=available
    BookNode next;           // Forward
    BookNode prev;           // Backward

    // Constructor
    BookNode(int id, String t, String a, String g, boolean avail) {
        bookId = id; title = t; author = a; genre = g; available = avail;
        next = null; prev = null;
    }
}

// Main LibraryManager class
public class LibraryManager {
    BookNode head;  // Head (first book)

    public LibraryManager() {
        head = null;
    }

    /*
     * HELPER: Find tail O(n)
     */
    private BookNode getTail() {
        if (head == null) return null;
        BookNode temp = head;
        while (temp.next != null) temp = temp.next;
        return temp;
    }

    /*
     * 1. ADD FIRST: O(1) prepend
     */
    public void addFirst(Scanner sc) {
        System.out.print("Book ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Author: "); String author = sc.nextLine();
        System.out.print("Genre: "); String genre = sc.nextLine();
        System.out.print("Available (1=yes/0=no): "); boolean avail = sc.nextInt() == 1; sc.nextLine();

        BookNode newNode = new BookNode(id, title, author, genre, avail);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;     // Old head <- new
            head = newNode;          // New head.prev=null implicit
        }
        System.out.println("Added '" + title + "' at front.");
    }

    /*
     * 2. ADD LAST: O(n) append
     */
    public void addLast(Scanner sc) {
        System.out.print("Book ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Author: "); String author = sc.nextLine();
        System.out.print("Genre: "); String genre = sc.nextLine();
        System.out.print("Available (1/0): "); boolean avail = sc.nextInt() == 1; sc.nextLine();

        BookNode newNode = new BookNode(id, title, author, genre, avail);
        if (head == null) {
            head = newNode;
        } else {
            BookNode tail = getTail();
            tail.next = newNode;
            newNode.prev = tail;     // Tail <-> new
        }
        System.out.println("Added '" + title + "' at end.");
    }

    /*
     * 3. ADD AT POSITION: O(n)
     */
    public void addAtPosition(Scanner sc) {
        System.out.print("Position (1-based): "); int pos = sc.nextInt();
        if (pos < 1) {
            System.out.println("Pos >=1!"); sc.nextLine(); return;
        }
        sc.nextLine();

        System.out.print("Book ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Author: "); String author = sc.nextLine();
        System.out.print("Genre: "); String genre = sc.nextLine();
        System.out.print("Available (1/0): "); boolean avail = sc.nextInt() == 1; sc.nextLine();

        BookNode newNode = new BookNode(id, title, author, genre, avail);
        if (pos == 1) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
        } else {
            BookNode temp = head;
            int i = 1;
            while (temp != null && i < pos - 1) {
                temp = temp.next; i++;
            }
            if (temp == null) {
                System.out.println("Pos > size!"); return;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) temp.next.prev = newNode;
            temp.next = newNode;
        }
        System.out.println("Added '" + title + "' at pos " + pos + ".");
    }

    /*
     * 4. REMOVE BY BOOK ID: O(n) + link fixes
     */
    public void removeByBookId(Scanner sc) {
        System.out.print("Book ID: "); int id = sc.nextInt(); sc.nextLine();
        if (head == null) {
            System.out.println("Empty!"); return;
        }
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp.prev == null) {  // Head
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp.next == null) {  // Tail
                    temp.prev.next = null;
                } else {  // Middle
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Removed ID " + id + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("ID " + id + " not found!");
    }

    /*
     * 5. SEARCH BY TITLE: Case-insens O(n)
     */
    public void searchByTitle(Scanner sc) {
        System.out.print("Title: "); String title = sc.nextLine();
        BookNode temp = head;
        boolean found = false;
        System.out.println("Title '" + title + "' matches:");
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matches!");
    }

    /*
     * 6. SEARCH BY AUTHOR: Case-insens O(n)
     */
    public void searchByAuthor(Scanner sc) {
        System.out.print("Author: "); String author = sc.nextLine();
        BookNode temp = head;
        boolean found = false;
        System.out.println("Author '" + author + "' books:");
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matches!");
    }

    /*
     * 7. UPDATE AVAILABILITY BY ID: O(n)
     */
    public void updateAvailabilityById(Scanner sc) {
        System.out.print("Book ID: "); int id = sc.nextInt();
        System.out.print("Available (1/0): "); boolean newAvail = sc.nextInt() == 1; sc.nextLine();
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                boolean old = temp.available;
                temp.available = newAvail;
                System.out.println("ID " + id + " avail: " + old + " -> " + newAvail);
                return;
            }
            temp = temp.next;
        }
        System.out.println("ID " + id + " not found!");
    }

    /*
     * HELPER: Display book
     */
    private void displayBook(BookNode node) {
        System.out.printf("ID:%d | %s | %s | %s | %s%n",
                node.bookId, node.title, node.author, node.genre,
                node.available ? "Available" : "Issued");
    }

    /*
     * 8. DISPLAY FORWARD: Head -> tail O(n)
     */
    public void displayForward() {
        if (head == null) {
            System.out.println("Empty library!");
            return;
        }
        System.out.println("\n=== FORWARD (Head to Tail) ===");
        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
        System.out.println("=============================");
    }

    /*
     * 9. DISPLAY REVERSE: Tail <- head O(n)
     */
    public void displayReverse() {
        if (head == null) {
            System.out.println("Empty!");
            return;
        }
        BookNode tail = getTail();
        System.out.println("\n=== REVERSE (Tail to Head) ===");
        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
        System.out.println("=============================");
    }

    /*
     * 10. COUNT TOTAL BOOKS: O(n)
     */
    public void countTotalBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    // MAIN: Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager lib = new LibraryManager();

        System.out.println("=== LIBRARY MANAGEMENT SYSTEM (Doubly LL) ===");

        int choice;
        do {
            System.out.println("\n1.AddFirst 2.AddLast 3.AddPos");
            System.out.println("4.RemoveID 5.SearchTitle 6.SearchAuthor");
            System.out.println("7.UpdateAvail 8.Forward 9.Reverse 10.Count");
            System.out.print("0.Exit | Choice: "); choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:  lib.addFirst(sc);        break;
                case 2:  lib.addLast(sc);         break;
                case 3:  lib.addAtPosition(sc);   break;
                case 4:  lib.removeByBookId(sc);  break;
                case 5:  lib.searchByTitle(sc);   break;
                case 6:  lib.searchByAuthor(sc);  break;
                case 7:  lib.updateAvailabilityById(sc); break;
                case 8:  lib.displayForward();    break;
                case 9:  lib.displayReverse();    break;
                case 10: lib.countTotalBooks();   break;
                case 0:  System.out.println("Checkout complete!"); break;
                default: System.out.println("Invalid 0-10!");
            }
        } while (choice != 0);

        sc.close();
    }
}
/* END - Complete doubly linked library system with bi-dir display/remove. */

