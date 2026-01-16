package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays.
Add constructors to initialize the rental details and calculate total cost.
*/
// Block comment describing the car rental system problem.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class CarRental {
    // Class representing a car rental with customer and rental details.

    String customerName;
    // Instance variable to store the customer's name.

    String carModel;
    // Instance variable to store the car model being rented.

    int rentalDays;
    // Instance variable to store how many days the car is rented for.

    double totalCost;
    // Instance variable to store the total rental cost.

    CarRental() {
        // Default constructor that initializes a basic rental with default values.

        customerName = "Customer";
        // Setting a default customer name.

        carModel = "Basic";
        // Setting a default car model.

        rentalDays = 1;
        // Setting a default rental duration of 1 day.

        totalCost = rentalDays * 1000;
        // Calculating total cost using a default cost of 1000 per day.
    }

    CarRental(String c, String m, int d) {
        // Parameterized constructor to initialize rental details with user-provided values.

        customerName = c;
        // Assigning the constructor parameter 'c' to the instance variable 'customerName'.

        carModel = m;
        // Assigning the constructor parameter 'm' to the instance variable 'carModel'.

        rentalDays = d;
        // Assigning the constructor parameter 'd' to the instance variable 'rentalDays'.

        totalCost = rentalDays * 1000;
        // Calculating total cost based on the number of days and fixed cost per day.
    }

    void display() {
        // Instance method to display car rental details.

        System.out.println("\nCar Rental Details:");
        // Printing a header for the car rental details.

        System.out.println("Customer Name : " + customerName);
        // Printing the customer's name.

        System.out.println("Car Model : " + carModel);
        // Printing the car model.

        System.out.println("Rental Days : " + rentalDays);
        // Printing how many days the car has been rented for.

        System.out.println("Total Cost : ₹" + totalCost);
        // Printing the total rental cost with a rupee symbol.
    }

    public static void main(String[] args) {
        // Main method: entry point of the car rental application.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        System.out.print("Enter customer name: ");
        // Prompting the user to enter the customer's name.

        String name = sc.nextLine();
        // Reading the full line as the customer's name.

        System.out.print("Enter car model: ");
        // Prompting the user to enter the car model.

        String model = sc.nextLine();
        // Reading the full line as the car model.

        System.out.print("Enter rental days: ");
        // Prompting the user to enter the number of days for the rental.

        int days = sc.nextInt();
        // Reading the number of days as an integer.

        CarRental rent = new CarRental(name, model, days);
        // Creating a CarRental object with the entered details.

        rent.display();
        // Displaying the rental details for the created CarRental object.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of CarRental class.
