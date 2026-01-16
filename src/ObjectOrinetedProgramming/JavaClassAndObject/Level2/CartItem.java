package ObjectOrientedProgramming.JavaClassAndObject.Level2;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level2 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class CartItem {
// Class declaration for CartItem to model shopping cart operations and item data.

    String itemName;
// Instance variable to store the cart item's name as a string.

    double price;
// Instance variable to store the price per item as a double for decimal precision.

    int quantity;
// Instance variable to store the quantity of the item in cart as an integer.

    void addItem(String name, double p, int q) {
// Method declaration to add an item to the cart by setting its details.

        itemName = name;
// Assigning the provided name to the instance itemName field.

        price = p;
// Assigning the provided price to the instance price field.

        quantity = q;
// Assigning the provided quantity to the instance quantity field.

        System.out.println("Item added to cart.");
// Confirming item addition by printing success message.

    } // End of addItem method.

    void removeItem(int removeQty) {
// Method declaration to remove a specified quantity from the cart.

        if (removeQty <= quantity) {
// Checking if requested removal quantity does not exceed current quantity.

            quantity = quantity - removeQty;
// Subtracting the removal quantity from current quantity.

            System.out.println(removeQty + " item(s) removed from cart.");
// Confirming removal by printing the quantity removed.

        } else {
// Handling case where removal quantity exceeds available quantity.

            System.out.println("Cannot remove more items than available.");
// Printing error message for excessive removal request.

        } // End of if-else block for removal validation.

    } // End of removeItem method.

    void displayTotalCost() {
// Method declaration to calculate and display the total cost of remaining items.

        double total = price * quantity;
// Calculating total cost by multiplying price by current quantity.

        System.out.println("Remaining Quantity: " + quantity);
// Printing the current remaining quantity.

        System.out.println("Total Cost: " + total);
// Printing the calculated total cost.

    } // End of displayTotalCost method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        CartItem cart = new CartItem();
// Creating a new CartItem object instance named 'cart' using default constructor.

        System.out.print("Enter item name: ");
// Prompting the user to enter the item name.

        String name = sc.nextLine();
// Reading a line of input (name) and storing in local variable.

        System.out.print("Enter price: ");
// Prompting the user to enter the item price.

        double price = sc.nextDouble();
// Reading a double input (price) and storing in local variable.

        System.out.print("Enter quantity: ");
// Prompting the user to enter the initial quantity.

        int quantity = sc.nextInt();
// Reading an integer input (quantity) and storing in local variable.

        cart.addItem(name, price, quantity);
// Calling addItem method on 'cart' object with input parameters.

        cart.displayTotalCost();
// Calling displayTotalCost method to show initial total.

        System.out.print("Do you want to remove the item? (yes/no): ");
// Prompting user for decision to remove items.

        sc.nextLine(); // Consuming newline left in buffer after nextInt() call.

        String choice = sc.nextLine();
// Reading user's choice as a string.

        if (choice.equalsIgnoreCase("yes")) {
// Checking if user chose to remove items (case-insensitive comparison).

            System.out.print("How many items do you want to remove?: ");
// Prompting for removal quantity.

            int removeQty = sc.nextInt();
// Reading integer input for removal quantity.

            cart.removeItem(removeQty);
// Calling removeItem method with removal quantity.

            cart.displayTotalCost();
// Displaying updated total cost after removal.

        } else {
// Handling case where user chooses not to remove items.

            System.out.println("No items removed.");
// Printing confirmation of no removal.

        } // End of if-else block for removal decision.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of CartItem class.
