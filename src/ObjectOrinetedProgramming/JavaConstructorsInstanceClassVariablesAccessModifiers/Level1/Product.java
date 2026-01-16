package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the specified OOP module and level.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Product {
    // Class declaration representing a product in an inventory system.

    // Instance variables
    String productName;
    // Instance variable to store the name of the product.

    double price;
    // Instance variable to store the price of a single unit of the product.

    // Class variable
    static int totalProducts = 0;
    // Static variable shared across all Product objects to count how many products have been created.

    // Constructor
    Product(String name, double p) {
        // Constructor used to initialize a Product object with a name and price.

        productName = name;
        // Assigning the constructor parameter 'name' to the instance variable 'productName'.

        price = p;
        // Assigning the constructor parameter 'p' to the instance variable 'price'.

        totalProducts++;
        // Incrementing the static counter each time a new Product object is created.
    }

    // Instance method
    void displayProductDetails() {
        // Instance method to display details of the current Product object.

        System.out.println("Product Name : " + productName);
        // Printing the product's name.

        System.out.println("Price : " + price);
        // Printing the product's price.

        System.out.println();
        // Printing a blank line for better readability.
    }

    // Class method
    static void displayTotalProducts() {
        // Static method to display the total number of Product objects created.

        System.out.println("Total Products Created: " + totalProducts);
        // Printing the total number of products created so far.
    }

    public static void main(String[] args) {
        // Main method: entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read input from System.in.

        System.out.print("Enter number of products: ");
        // Prompting the user to enter how many products will be created.

        int n = sc.nextInt();
        // Reading the number of products as an integer.

        sc.nextLine();
        // Clearing the newline character left in the buffer after nextInt().

        Product[] products = new Product[n];
        // Creating an array of Product references to store multiple Product objects.

        // Taking input from user
        for (int i = 0; i < n; i++) {
            // Looping 'n' times to read details for each product.

            System.out.println("\nEnter details for product " + (i + 1));
            // Printing which product's details are being entered (1-based index).

            System.out.print("Product Name: ");
            // Prompting the user to enter the product's name.

            String name = sc.nextLine();
            // Reading the product name as a full line of text.

            System.out.print("Price: ");
            // Prompting the user to enter the product's price.

            double price = sc.nextDouble();
            // Reading the product price as a double value.

            sc.nextLine();
            // Clearing the newline character left in the buffer after nextDouble().

            products[i] = new Product(name, price);
            // Creating a new Product object with the given name and price, and storing it in the array.
        }

        // Display product details
        System.out.println("\n--- Product Details ---");
        // Printing a header to indicate the start of product details.

        for (int i = 0; i < n; i++) {
            // Iterating over all Product objects in the array.

            products[i].displayProductDetails();
            // Calling the instance method to display the details of each product.
        }

        // Display total products
        Product.displayTotalProducts();
        // Calling the static method to print how many Product objects were created in total.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Product class.
