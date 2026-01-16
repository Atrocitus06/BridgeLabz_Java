package ObjectOrientedProgramming.JavaClassAndObject.Level1;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level1 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class MobilePhone {
// Class declaration for MobilePhone to encapsulate mobile phone-related data and behavior.

    String brand;
// Instance variable to store the phone's brand name as a string.

    String model;
// Instance variable to store the phone's model name as a string.

    double price;
// Instance variable to store the phone's price as a double for decimal precision.

    void displayDetails() {
// Method declaration to display all mobile phone details in a formatted manner.

        System.out.println("\nMobile Phone Details:");
// Printing a header line with newline for better readability.

        System.out.println("Brand: " + brand);
// Printing the brand prefixed with "Brand: " label.

        System.out.println("Model: " + model);
// Printing the model prefixed with "Model: " label.

        System.out.println("Price: " + price);
// Printing the price prefixed with "Price: " label.

    } // End of displayDetails method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        MobilePhone phone = new MobilePhone();
// Creating a new MobilePhone object instance named 'phone' using default constructor.

        System.out.print("Enter mobile brand: ");
// Prompting the user to enter the mobile brand.

        phone.brand = sc.nextLine();
// Reading a line of input (brand) and assigning it to the object's brand field.

        System.out.print("Enter mobile model: ");
// Prompting the user to enter the mobile model.

        phone.model = sc.nextLine();
// Reading a line of input (model) and assigning it to the object's model field.

        System.out.print("Enter mobile price: ");
// Prompting the user to enter the mobile price.

        phone.price = sc.nextDouble();
// Reading a double input (price) and assigning it to the object's price field.

        phone.displayDetails();
// Calling the displayDetails method on the phone object to print all details.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of MobilePhone class.
