package Object_Oriented_Programming.Keywords.Level1;
// Package declaration that places this class under the Keywords.Level1 package.

import java.util.Scanner;
// Importing the Scanner class to allow reading input from the console.

public class Product {
    // Public class representing a product with pricing and discount details.

    /* ---------- STATIC ---------- */

    static double discount = 10.0;
    // Static variable storing a shared discount percentage applied to all products.

    static void updateDiscount(double newDiscount) {
        // Static method to update the discount percentage for all products.

        discount = newDiscount;
        // Assigning the new discount percentage to the static variable 'discount'.

        System.out.println("Updated Discount: " + discount + "%");
        // Printing the updated discount value along with a percentage sign.
    }

    /* ---------- INSTANCE VARIABLES ---------- */

    String productName;
    // Instance variable storing the name of the product.

    final int productID;
    // Final instance variable storing a unique product ID that cannot be changed after initialization.

    double price;
    // Instance variable storing the price of a single unit of the product.

    int quantity;
    // Instance variable storing the quantity of the product being purchased.

    /* ---------- CONSTRUCTOR (THIS) ---------- */

    Product(String productName, int productID, double price, int quantity) {
        // Constructor used to initialize a Product object with name, ID, price, and quantity.

        this.productName = productName;
        // Using 'this' to assign the constructor parameter to the instance variable 'productName'.

        this.productID = productID;
        // Using 'this' to assign the constructor parameter to the final instance variable 'productID'.

        this.price = price;
        // Using 'this' to assign the constructor parameter to the instance variable 'price'.

        this.quantity = quantity;
        // Using 'this' to assign the constructor parameter to the instance variable 'quantity'.
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */

    void processProduct(Object obj) {
        // Instance method that calculates and displays billing details if the object is a Product.

        if (obj instanceof Product) {
            // Checking whether the provided object is actually an instance of Product.

            double total = price * quantity;
            // Calculating the total price before discount as price multiplied by quantity.

            double discountAmount = total * (discount / 100);
            // Calculating the discount amount using the static discount percentage.

            double finalPrice = total - discountAmount;
            // Calculating the final price after subtracting the discount amount.

            System.out.println("\n--- Product Details ---");
            // Printing a header to indicate the start of product billing details.

            System.out.println("Product ID : " + productID);
            // Printing the unique product ID.

            System.out.println("Product Name : " + productName);
            // Printing the name of the product.

            System.out.println("Price : " + price);
            // Printing the price per unit of the product.

            System.out.println("Quantity : " + quantity);
            // Printing the quantity of the product.

            System.out.println("Discount : " + discount + "%");
            // Printing the discount percentage applied.

            System.out.println("Final Price : " + finalPrice);
            // Printing the final price to be paid after applying the discount.

        } else {
            // Executed if the given object is not an instance of Product.

            System.out.println("Object is not a Product");
            // Informing that the provided object is not of type Product.
        }
        // End of instanceof check and billing logic.
    }
    // End of processProduct method.

    /* ---------- MAIN METHOD (SAME FILE) ---------- */

    public static void main(String[] args) {
        // Main method serving as the entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read input from the user.

        System.out.print("Enter Product Name: ");
        // Prompting the user to enter the product's name.

        String name = sc.nextLine();
        // Reading the full line as the product name.

        System.out.print("Enter Product ID: ");
        // Prompting the user to enter the product's ID.

        int id = sc.nextInt();
        // Reading the product ID as an integer.

        System.out.print("Enter Price: ");
        // Prompting the user to enter the unit price of the product.

        double price = sc.nextDouble();
        // Reading the product's price as a double.

        System.out.print("Enter Quantity: ");
        // Prompting the user to enter the quantity of the product.

        int qty = sc.nextInt();
        // Reading the quantity as an integer.

        // Update discount (static method)
        Product.updateDiscount(15.0);
        // Calling the static method to update the shared discount percentage.

        // Create Product object
        Product product = new Product(name, id, price, qty);
        // Creating a new Product object using the values entered by the user.

        // Validate using instanceof and process product
        product.processProduct(product);
        // Passing the same Product object to processProduct to verify instanceof and calculate billing details.

        sc.close();
        // Closing the Scanner to free its resources.
    }
    // End of main method.
}
// End of Product class.
