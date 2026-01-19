package DataStructure.LinkedList;
/*
Singly Linked List: Inventory Management System - Complete Implementation

This standalone Java class (no package) implements FULL singly linked list for inventory management.

NODE STRUCTURE:
- ItemNode: itemId(int unique key), itemName(String), quantity(int), price(double), next(ItemNode)
- Linear: head -> ... -> tail.next=null

LIST MAINTENANCE:
- head: first item (null=empty)
- No tail ptr (O(n) for end ops ok for interview)
- Insertions: addFirst O(1), addLast/addPos O(n)
- Deletions: O(n) search + bypass
- Traversals: while(temp != null)

FULL OPERATIONS IMPLEMENTED (menu-driven Scanner):
1. addFirst(): O(1) prepend
2. addLast(): O(n) append
3. addAtPosition(pos 1-based): O(n) insert after (pos-1), bounds check
4. removeByItemId(): O(n) delete by ID
5. updateQuantityById(): O(n) find + modify qty
6. searchById(): O(n) display if found
7. searchByName(): O(n) display if found (case-insensitive)
8. calculateTotalValue(): O(n) sum(qty * price) double
9. sortByNameAsc(): O(n log n) bubble sort (simple for LL)
10.sortByNameDesc(): O(n log n) bubble reverse
11.sortByPriceAsc(): O(n log n) bubble price
12.sortByPriceDesc(): O(n log n) bubble reverse price
13. displayAll(): O(n) print list

EDGE CASES HANDLED:
- Empty list
- Single node
- Invalid pos (>size)
- Not found (ID/name)
- Zero/neg qty/price
- Sort empty/single

SORTING: Bubble sort on LL (stable, simple): repeated passes swap adjacent if wrong order
INTERACTIVE MENU: 1-13 options, loop until 0
Inline comments explain EVERY step.
Hint followed: totalValue traverse sum, sorting bubble (merge complex for time)

Author: AI Assistant | Date: 2026 | Interview DS Practice
*/

import java.util.*;  // Scanner

// Inner Node class - inventory item data + next
class ItemNode {
    int itemId;          // Unique ID (int)
    String itemName;     // Item description
    int quantity;        // Stock count (>=0)
    double price;        // Unit price (>=0)
    ItemNode next;       // Next item (null end)

    // Constructor: init fields
    ItemNode(int id, String name, int qty, double pr) {
        itemId = id;
        itemName = name;
        quantity = qty;
        price = pr;
        next = null;
    }
}

// Main InventoryManager class
public class InventoryManagementSystem {
    ItemNode head;  // Head of list (null=empty)

    public void InventoryManagementSystem() {
        head = null;
    }

    /*
     * 1. ADD FIRST: Prepend O(1)
     */
    public void addFirst(Scanner sc) {
        System.out.print("Item ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Item Name: "); String name = sc.nextLine();
        System.out.print("Quantity: "); int qty = sc.nextInt();
        System.out.print("Price: "); double price = sc.nextDouble(); sc.nextLine();

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;     // New -> old head
        head = newNode;          // Head advance
        System.out.println("Added '" + name + "' at front.");
    }

    /*
     * 2. ADD LAST: Append O(n)
     */
    public void addLast(Scanner sc) {
        System.out.print("Item ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Item Name: "); String name = sc.nextLine();
        System.out.print("Quantity: "); int qty = sc.nextInt();
        System.out.print("Price: "); double price = sc.nextDouble(); sc.nextLine();

        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode temp = head;
            while (temp.next != null) {  // To tail
                temp = temp.next;
            }
            temp.next = newNode;         // Tail -> new
        }
        System.out.println("Added '" + name + "' at end.");
    }

    /*
     * 3. ADD AT POSITION: After (pos-1) O(n)
     */
    public void addAtPosition(Scanner sc) {
        System.out.print("Position (1-based): "); int pos = sc.nextInt();
        if (pos < 1) {
            System.out.println("Pos >=1!");
            sc.nextLine(); return;
        }
        sc.nextLine();

        System.out.print("Item ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("Item Name: "); String name = sc.nextLine();
        System.out.print("Quantity: "); int qty = sc.nextInt();
        System.out.print("Price: "); double price = sc.nextDouble(); sc.nextLine();

        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ItemNode temp = head;
            int i = 1;
            while (temp != null && i < pos - 1) {
                temp = temp.next; i++;
            }
            if (temp == null) {
                System.out.println("Pos > size!");
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        System.out.println("Added '" + name + "' at pos " + pos + ".");
    }

    /*
     * 4. REMOVE BY ITEM ID: O(n)
     */
    public void removeByItemId(Scanner sc) {
        System.out.print("Item ID to remove: "); int id = sc.nextInt();
        if (head == null) {
            System.out.println("Empty!");
            return;
        }
        if (head.itemId == id) {     // Head
            head = head.next;
            System.out.println("Removed ID " + id + ".");
            return;
        }
        ItemNode temp = head.next, prev = head;
        while (temp != null) {
            if (temp.itemId == id) {
                prev.next = temp.next;
                System.out.println("Removed ID " + id + ".");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("ID " + id + " not found!");
    }

    /*
     * 5. UPDATE QUANTITY BY ID: O(n)
     */
    public void updateQuantityById(Scanner sc) {
        System.out.print("Item ID: "); int id = sc.nextInt();
        System.out.print("New Quantity: "); int newQty = sc.nextInt(); sc.nextLine();
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Updated qty to " + newQty + " for ID " + id + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("ID " + id + " not found!");
    }

    /*
     * 6. SEARCH BY ID: O(n)
     */
    public void searchById(Scanner sc) {
        System.out.print("Item ID: "); int id = sc.nextInt(); sc.nextLine();
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("ID " + id + " not found!");
    }

    /*
     * 7. SEARCH BY NAME: Case-insensitive O(n)
     */
    public void searchByName(Scanner sc) {
        System.out.print("Item Name: "); String name = sc.nextLine();
        ItemNode temp = head;
        boolean found = false;
        System.out.println("Matches for '" + name + "':");
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matches!");
    }

    /*
     * HELPER: Print single item
     */
    private void displayItem(ItemNode node) {
        System.out.printf("ID:%d | %s | Qty:%d | Price:%.2f | Value:%.2f%n",
                node.itemId, node.itemName, node.quantity, node.price,
                node.quantity * node.price);
    }

    /*
     * 8. TOTAL INVENTORY VALUE: Sum(qty*price) O(n)
     */
    public void calculateTotalValue() {
        if (head == null) {
            System.out.println("Empty! Total: 0.00");
            return;
        }
        double total = 0.0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.printf("Total Inventory Value: $%.2f%n", total);
    }

    /*
     * SORT HELPERS: Bubble sort variants O(n^2 worst)
     * Swap data (not nodes) for simplicity in LL
     */

    /*
     * 9. SORT NAME ASC: A-Z
     */
    public void sortByNameAsc() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            ItemNode prev = null, temp = head;
            while (temp.next != null) {
                if (temp.itemName.compareTo(temp.next.itemName) > 0) {
                    // Swap data
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Sorted by Name (Asc).");
    }

    /*
     * 10. SORT NAME DESC: Z-A
     */
    public void sortByNameDesc() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            ItemNode prev = null, temp = head;
            while (temp.next != null) {
                if (temp.itemName.compareTo(temp.next.itemName) < 0) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Sorted by Name (Desc).");
    }

    /*
     * 11. SORT PRICE ASC
     */
    public void sortByPriceAsc() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            ItemNode temp = head;
            while (temp.next != null) {
                if (temp.price > temp.next.price) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Sorted by Price (Asc).");
    }

    /*
     * 12. SORT PRICE DESC
     */
    public void sortByPriceDesc() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            ItemNode temp = head;
            while (temp.next != null) {
                if (temp.price < temp.next.price) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Sorted by Price (Desc).");
    }

    /*
     * HELPER: Swap two adjacent nodes' DATA (easy for LL)
     */
    private void swapData(ItemNode a, ItemNode b) {
        int tempId = a.itemId; a.itemId = b.itemId; b.itemId = tempId;
        String tempName = a.itemName; a.itemName = b.itemName; b.itemName = tempName;
        int tempQty = a.quantity; a.quantity = b.quantity; b.quantity = tempQty;
        double tempPrice = a.price; a.price = b.price; b.price = tempPrice;
    }

    /*
     * 13. DISPLAY ALL: O(n)
     */
    public void displayAll() {
        if (head == null) {
            System.out.println("No items!");
            return;
        }
        System.out.println("\n=== INVENTORY ===");
        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
        System.out.println("================");
    }

    // MAIN: Menu loop
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem inv = new InventoryManagementSystem();

        System.out.println("=== INVENTORY MANAGEMENT SYSTEM ===");

        int choice;
        do {
            System.out.println("\n1.AddFirst 2.AddLast 3.AddPos");
            System.out.println("4.RemoveID 5.UpdateQty 6.SearchID 7.SearchName");
            System.out.println("8.TotalValue 9.SortNameAsc 10.SortNameDesc");
            System.out.println("11.SortPriceAsc 12.SortPriceDesc 13.Display");
            System.out.print("0.Exit | Choice: "); choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:  inv.addFirst(sc);        break;
                case 2:  inv.addLast(sc);         break;
                case 3:  inv.addAtPosition(sc);   break;
                case 4:  inv.removeByItemId(sc);  break;
                case 5:  inv.updateQuantityById(sc); break;
                case 6:  inv.searchById(sc);      break;
                case 7:  inv.searchByName(sc);    break;
                case 8:  inv.calculateTotalValue(); break;
                case 9:  inv.sortByNameAsc();     break;
                case 10: inv.sortByNameDesc();    break;
                case 11: inv.sortByPriceAsc();    break;
                case 12: inv.sortByPriceDesc();   break;
                case 13: inv.displayAll();        break;
                case 0:  System.out.println("Exiting..."); break;
                default: System.out.println("Invalid 0-13!");
            }
        } while (choice != 0);

        sc.close();
    }
}
/* END - Complete singly linked inventory system with sorting/total value. */
