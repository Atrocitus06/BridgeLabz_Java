// ===== FoodDeliveryDemo =====
package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package declaration that organizes this class within the ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass namespace.

import java.util.ArrayList;
// Importing ArrayList to store multiple food items dynamically.

import java.util.Scanner;
// Importing Scanner to read user input from the console.

public class FoodDeliveryDemo {
// Public class declaration for the main demonstration of food delivery system using OOP principles.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object to read input from System.in (keyboard).

        ArrayList<FoodItem> order = new ArrayList<>();
// Creating an ArrayList to store food items for the order dynamically.

        System.out.print("Enter number of food items: ");
// Prompting the user to enter the total number of food items.

        int n = sc.nextInt();
// Reading the number of food items from user input.

        sc.nextLine();
// Consuming the newline character left in the input buffer after reading int.

        for (int i = 0; i < n; i++) {
// Looping 'n' times to collect details for each food item.

            System.out.println("\nFood Item " + (i + 1));
// Printing the current item number for user clarity.

            System.out.print("Choose Type (1-Veg, 2-Non-Veg): ");
// Prompting user to choose food type (vegetarian or non-vegetarian).

            int type = sc.nextInt();
// Reading the type choice (1 or 2) from user.

            sc.nextLine();
// Consuming the newline character after reading int.

            System.out.print("Enter Item Name: ");
// Prompting for the name of the food item.

            String name = sc.nextLine();
// Reading the food item name as a string.

            System.out.print("Enter Price: ");
// Prompting for the price of the food item.

            double price = sc.nextDouble();
// Reading the price as a double value.

            System.out.print("Enter Quantity: ");
// Prompting for the quantity of the food item.

            int qty = sc.nextInt();
// Reading the quantity as an integer.

            FoodItem item;
// Declaring a reference variable for FoodItem to hold the created object.

            if (type == 1) {
// Checking if user selected vegetarian option.

                item = new VegItem(name, price, qty);
// Creating a new VegItem object with provided details.

            } else {
// If not vegetarian, assuming non-vegetarian.

                item = new NonVegItem(name, price, qty);
// Creating a new NonVegItem object with provided details.
            }

            order.add(item);
// Adding the created food item to the order ArrayList.

        }

        System.out.println("\n===== ORDER SUMMARY =====");
// Printing a header for the order summary section.

        processOrder(order);
// Calling the processOrder method to display and calculate order details.

        sc.close();
// Closing the Scanner to prevent resource leak.

    }

    // Polymorphic order processing method that works with any FoodItem.
    static void processOrder(ArrayList<FoodItem> order) {
// Static method to process the entire order polymorphically.

        double grandTotal = 0;
// Initializing grand total to zero for accumulating costs.

        for (FoodItem item : order) {
// Looping through each food item in the order using enhanced for loop.

            item.getItemDetails();
// Calling getItemDetails() polymorphically on current item.

            double total = item.calculateTotalPrice();
// Calculating total price for current item using polymorphic method call.

            if (item instanceof Discountable) {
// Checking if current item implements Discountable interface using instanceof.

                Discountable d = (Discountable) item;
// Casting the FoodItem to Discountable interface reference.

                total = d.applyDiscount(total);
// Applying discount to the total price using interface method.

                System.out.println("Discount: " + d.getDiscountDetails());
// Printing discount details obtained from interface method.
            }

            System.out.println("Final Price: ₹" + total);
// Printing the final price after discount (if applicable).

            System.out.println("-------------------------");
// Printing separator line for readability.

            grandTotal += total;
// Adding current item's final price to grand total.
        }

        System.out.println("Grand Total: ₹" + grandTotal);
// Printing the overall grand total for the entire order.

    }
}

// Abstract base class for all food items demonstrating encapsulation.
abstract class FoodItem {
// Abstract class declaration to serve as base for concrete food item classes.

    // Encapsulation: private fields accessible only through methods.
    private String itemName;
// Private field to store the name of the food item.

    private double price;
// Private field to store the unit price of the food item.

    private int quantity;
// Private field to store the quantity ordered.

    FoodItem(String itemName, double price, int quantity) {
// Constructor to initialize all private fields with provided values.

        this.itemName = itemName;
// Assigning parameter to instance variable (this refers to current object).

        this.price = price;
// Assigning price parameter to instance variable.

        this.quantity = quantity;
// Assigning quantity parameter to instance variable.
    }

    // Getters only (no setters) to demonstrate read-only encapsulation.
    public String getItemName() {
// Public getter method to access item name.

        return itemName;
// Returning the private itemName field.
    }

    public double getPrice() {
// Public getter method to access unit price.

        return price;
// Returning the private price field.
    }

    public int getQuantity() {
// Public getter method to access quantity.

        return quantity;
// Returning the private quantity field.
    }

    // Concrete method available to all subclasses.
    public void getItemDetails() {
// Public method to display basic item information.

        System.out.println("Item: " + itemName);
// Printing the item name.

        System.out.println("Price: ₹" + price);
// Printing the unit price with currency symbol.

        System.out.println("Quantity: " + quantity);
// Printing the ordered quantity.
    }

    // Abstract method that must be implemented by subclasses.
    public abstract double calculateTotalPrice();
// Abstract method declaration for subclasses to provide specific total price logic.

}

// Interface for items that support discounts.
interface Discountable {
// Interface declaration defining discount-related contract.

    double applyDiscount(double amount);
// Abstract method to apply discount on given amount.

    String getDiscountDetails();
// Abstract method to get details about the discount applied.
}

// Concrete class for vegetarian food items implementing discount.
class VegItem extends FoodItem implements Discountable {
// VegItem class extending FoodItem and implementing Discountable.

    VegItem(String name, double price, int qty) {
// Constructor delegating to superclass constructor.

        super(name, price, qty);
// Calling parent class constructor with all parameters.
    }

    public double calculateTotalPrice() {
// Overriding abstract method from FoodItem.

        return getPrice() * getQuantity();
// Returning simple multiplication of price and quantity.
    }

    public double applyDiscount(double amount) {
// Implementing interface method for 10% discount on veg items.

        return amount - (amount * 0.10); // 10% discount
// Calculating and returning discounted amount (subtracting 10%).
    }

    public String getDiscountDetails() {
// Implementing interface method to describe discount.

        return "10% Veg Discount";
// Returning string describing the vegetarian discount.
    }
}

// Concrete class for non-vegetarian food items (no discount).
class NonVegItem extends FoodItem {
// NonVegItem class extending FoodItem (does not implement Discountable).

    NonVegItem(String name, double price, int qty) {
// Constructor delegating to superclass.

        super(name, price, qty);
// Calling parent FoodItem constructor.
    }

    public double calculateTotalPrice() {
// Overriding abstract method with extra charge logic.

        double base = getPrice() * getQuantity();
// Calculating base total price.

        return base + (base * 0.05); // 5% extra charge
// Returning base plus 5% extra charge for non-veg.
    }
}
