package DataStructure.LinkedList;
/*
StudentRecordManager
This class implements a singly linked list for student records with Roll Number (int unique key), Name (String), Age (int), Grade (char).
Core Node: inner StudentNode class holds data fields + next pointer (null terminated).
Operations fully implemented:
1. addFirst(): Prepends new node, O(1) head update.
2. addLast(): Appends to tail, O(n) traverse.
3. addAtPosition(pos 1-based): Inserts after pos-1, handles bounds/empty.
4. deleteByRoll(): Removes first match, updates prev.next, O(n).
5. searchByRoll(): Linear scan prints full record if found.
6. displayAll(): Traverses/prints all nodes formatted.
7. updateGradeByRoll(): Finds/updates grade field in-place.
Interactive menu-driven (Scanner), persistent head ref, edge cases: empty list, invalid pos/roll/not found, pos=1/end.
No duplicates check (allows dup rolls), no memory alloc explicit (GC handles).
Usage Example:
- 1 -> Roll1 Alice 20 A -> Added beginning
- 6 -> Display: Roll1 Alice 20 A
- 7 Roll1 B -> Updated to B
- 0 Exit
*/

import java.util.Scanner;  // For all user inputs

public class StudentRecordManagement {
    // Inner static Node class - encapsulates student data + link
    static class StudentNode {
        int rollNo;      // Unique identifier (int)
        String name;     // Student full name
        int age;         // Age in years
        char grade;      // Academic grade A-F
        StudentNode next; // Pointer to next student (null = end)

        // Constructor initializes all fields
        StudentNode(int rollNo, String name, int age, char grade) {
            this.rollNo = rollNo;    // Copy roll
            this.name = name;        // Copy name
            this.age = age;          // Copy age
            this.grade = grade;      // Copy grade
            this.next = null;        // Initially no next
        }
    }

    static StudentNode head;  // Global head pointer (null = empty list)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Single scanner instance
        head = null;  // Initialize empty list

        // Welcome + menu display
        System.out.println("Student Record Manager using Singly Linked List");
        System.out.println("1. Add at beginning\t2. Add at end\t\t3. Add at position");
        System.out.println("4. Delete by Roll No\t5. Search by Roll No\t6. Display All");
        System.out.println("7. Update Grade by Roll No\t0. Exit");

        int choice;  // Menu choice holder
        do {
            System.out.print("\nEnter choice: ");  // Prompt each iteration
            choice = sc.nextInt();                 // Read int choice
            sc.nextLine();                         // Clear buffer newline

            // Switch handles all operations
            switch (choice) {
                case 1:
                    addFirst(sc);      // O(1) prepend
                    break;
                case 2:
                    addLast(sc);       // O(n) append
                    break;
                case 3:
                    addAtPosition(sc); // O(n) insert
                    break;
                case 4:
                    deleteByRoll(sc);  // O(n) remove
                    break;
                case 5:
                    searchByRoll(sc);  // O(n) find/print
                    break;
                case 6:
                    displayAll();      // O(n) list all
                    break;
                case 7:
                    updateGradeByRoll(sc); // O(n) modify
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Enter 0-7.");
            }
        } while (choice != 0);  // Loop until exit

        sc.close();  // Cleanup scanner
    }

    // 1. Add new student at list beginning (head insert)
    static void addFirst(Scanner sc) {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();  // Read roll key
        sc.nextLine();            // Buffer clear
        System.out.print("Enter Name: ");
        String name = sc.nextLine();  // Read full name
        System.out.print("Enter Age: ");
        int age = sc.nextInt();       // Read age
        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);  // Read single char

        StudentNode newNode = new StudentNode(roll, name, age, grade);  // Create node
        newNode.next = head;      // Link new to current head
        head = newNode;           // Repoint head to new
        System.out.println("Student added at beginning successfully.");
    }

    // 2. Add new student at list end (tail append)
    static void addLast(Scanner sc) {
        // Input same as addFirst
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        StudentNode newNode = new StudentNode(roll, name, age, grade);  // New tail node
        if (head == null) {
            head = newNode;  // First node case
            System.out.println("Student added (list was empty).");
            return;
        }

        StudentNode temp = head;  // Start from head
        while (temp.next != null) {  // Traverse to last node
            temp = temp.next;
        }
        temp.next = newNode;      // Link last to new tail
        System.out.println("Student added at end successfully.");
    }

    // 3. Add at specific 1-based position
    static void addAtPosition(Scanner sc) {
        System.out.print("Enter position (1-based): ");
        int pos = sc.nextInt();  // Position input
        if (pos < 1) {           // Invalid <1
            System.out.println("Position must be >=1!");
            return;
        }

        // Read student data
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (pos == 1) {          // Special head insert
            newNode.next = head;
            head = newNode;
            System.out.println("Student added at position 1.");
            return;
        }

        StudentNode temp = head;  // Traverse helper
        for (int i = 1; i < pos - 1 && temp != null; i++) {  // Reach prev node
            temp = temp.next;
        }
        if (temp == null) {      // Pos too large
            System.out.println("Position exceeds current list size!");
            return;
        }
        newNode.next = temp.next;  // Insert between temp and temp.next
        temp.next = newNode;
        System.out.println("Student added at position " + pos + ".");
    }

    // 4. Delete node by roll number (first match)
    static void deleteByRoll(Scanner sc) {
        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();  // Target roll

        if (head == null) {       // Empty check
            System.out.println("List is empty! Nothing to delete.");
            return;
        }

        if (head.rollNo == roll) {  // Head is target
            head = head.next;     // Bypass head
            System.out.println("Student (head) deleted successfully.");
            return;
        }

        StudentNode temp = head;  // Prev pointer
        while (temp.next != null && temp.next.rollNo != roll) {  // Find prev of target
            temp = temp.next;
        }
        if (temp.next == null) {  // Not found
            System.out.println("Student with Roll No " + roll + " not found!");
            return;
        }
        temp.next = temp.next.next;  // Unlink target node
        System.out.println("Student deleted successfully.");
    }

    // 5. Search and display by roll number
    static void searchByRoll(Scanner sc) {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();  // Query roll

        StudentNode temp = head;  // Traverse start
        while (temp != null) {    // Linear search
            if (temp.rollNo == roll) {
                // Found - print full details
                System.out.println("Student Found:");
                System.out.println("Roll No: " + temp.rollNo +
                        ", Name: " + temp.name +
                        ", Age: " + temp.age +
                        ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;     // Next candidate
        }
        System.out.println("Student with Roll No " + roll + " not found!");
    }

    // 6. Display complete list
    static void displayAll() {
        if (head == null) {       // Empty list
            System.out.println("No student records! List is empty.");
            return;
        }

        System.out.println("\n=== All Student Records ===");
        StudentNode temp = head;  // Copy head
        while (temp != null) {    // Full traversal
            System.out.println("Roll No: " + temp.rollNo +
                    ", Name: " + temp.name +
                    ", Age: " + temp.age +
                    ", Grade: " + temp.grade);
            temp = temp.next;     // Advance
        }
        System.out.println("==========================");
    }

    // 7. Update grade field by roll number
    static void updateGradeByRoll(Scanner sc) {
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt();  // Target roll
        System.out.print("Enter new Grade (A-F): ");
        char newGrade = sc.next().charAt(0);  // New grade value

        StudentNode temp = head;  // Search start
        while (temp != null) {    // Find node
            if (temp.rollNo == roll) {
                temp.grade = newGrade;  // In-place update
                System.out.println("Grade updated to '" + newGrade + "' for Roll No " + roll + ".");
                return;
            }
            temp = temp.next;       // Continue search
        }
        System.out.println("Student with Roll No " + roll + " not found!");
    }
}
// Main - Complete student linked list manager.
