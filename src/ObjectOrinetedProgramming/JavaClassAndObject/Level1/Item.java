package ObjectOrientedProgramming.JavaClassAndObject.Level1;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level1 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class Item {
// Class declaration for Item to encapsulate inventory item-related data and behavior.

    int itemCode;
// Instance variable to store the unique item code as an integer.

    String itemName;
// Instance variable to store the item's name as a string.

    double price;
// Instance variable to store the price per item as a double for decimal precision.

    void displayDetails(int quantity) {
// Method declaration that takes quantity parameter and displays item details plus total cost.

        double totalCost = price * quantity;
// Calculating the total cost by multiplying price by quantity and storing in local variable.

        System.out.println("\nItem Details:");
// Printing a header line with newline for better readability.

        System.out.println("Item Code: " + itemCode);
// Printing the item code prefixed with "Item Code: " label.

        System.out.println("Item Name: " + itemName);
// Printing the item name prefixed with "Item Name: " label.

        System.out.println("Price per item: " + price);
// Printing the price per item prefixed with descriptive label.

        System.out.println("Quantity: " + quantity);
// Printing the quantity prefixed with "Quantity: " label.

        System.out.println("Total Cost: " + totalCost);
// Printing the calculated total cost prefixed with "Total Cost: " label.

    } // End of displayDetails method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        Item item = new Item();
// Creating a new Item object instance named 'item' using default constructor.

        System.out.print("Enter item code: ");
// Prompting the user to enter the item code.

        item.itemCode = sc.nextInt();
// Reading an integer input (item code) and assigning it to the object's itemCode field.

        sc.nextLine();
// Consuming the newline character left in the input buffer after nextInt() call.

        System.out.print("Enter item name: ");
// Prompting the user to enter the item name.

        item.itemName = sc.nextLine();
// Reading a line of input (name) and assigning it to the object's itemName field.

        System.out.print("Enter price of item: ");
// Prompting the user to enter the price per item.

        item.price = sc.nextDouble();
// Reading a double input (price) and assigning it to the object's price field.

        System.out.print("Enter quantity: ");
// Prompting the user to enter the quantity.

        int quantity = sc.nextInt();
// Reading an integer input (quantity) and storing it in local variable.

        item.displayDetails(quantity);
// Calling the displayDetails method on the item object, passing quantity parameter.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of Item class.
