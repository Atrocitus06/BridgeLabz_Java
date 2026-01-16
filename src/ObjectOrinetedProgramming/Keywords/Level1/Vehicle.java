package Object_Oriented_Programming.Keywords.Level1;
// Package declaration that places this class under the Keywords.Level1 package.

import java.util.Scanner;
// Importing the Scanner class to enable reading input from the console.

public class Vehicle {
    // Public class representing a vehicle with registration-related information.

    /* ---------- STATIC ---------- */

    static double registrationFee = 1500.0;
    // Static variable storing a common registration fee applicable to all vehicles.

    static void updateRegistrationFee(double newFee) {
        // Static method to update the registration fee for all vehicles.

        registrationFee = newFee;
        // Assigning the new fee value to the static variable 'registrationFee'.

        System.out.println("Updated Registration Fee: " + registrationFee);
        // Printing the updated registration fee to confirm the change.
    }

    /* ---------- INSTANCE VARIABLES ---------- */

    String ownerName;
    // Instance variable storing the name of the vehicle's owner.

    String vehicleType;
    // Instance variable storing the type of vehicle, such as "Car" or "Bike".

    final String registrationNumber;
    // Final instance variable storing the unique registration number, which cannot be changed after initialization.

    /* ---------- CONSTRUCTOR (THIS) ---------- */

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        // Constructor used to create a Vehicle object with owner name, vehicle type, and registration number.

        this.ownerName = ownerName;
        // Using 'this' to assign the constructor parameter to the instance variable 'ownerName'.

        this.vehicleType = vehicleType;
        // Using 'this' to assign the constructor parameter to the instance variable 'vehicleType'.

        this.registrationNumber = registrationNumber;
        // Using 'this' to assign the constructor parameter to the final instance variable 'registrationNumber'.
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */

    void displayRegistrationDetails(Object obj) {
        // Instance method that displays registration details if the passed object is a Vehicle.

        if (obj instanceof Vehicle) {
            // Checking whether the provided object is actually an instance of Vehicle.

            System.out.println("\n--- Vehicle Registration Details ---");
            // Printing a header to indicate the start of registration details.

            System.out.println("Owner Name : " + ownerName);
            // Printing the name of the vehicle owner.

            System.out.println("Vehicle Type : " + vehicleType);
            // Printing the type of the vehicle.

            System.out.println("Registration Number : " + registrationNumber);
            // Printing the unique registration number of this vehicle.

            System.out.println("Registration Fee : " + registrationFee);
            // Printing the static registration fee applicable to all vehicles.

        } else {
            // Executed if the given object is not an instance of Vehicle.

            System.out.println("Object is not a Vehicle");
            // Informing that the provided object is not of type Vehicle.
        }
        // End of instanceof check and details display.
    }
    // End of displayRegistrationDetails method.

    /* ---------- MAIN METHOD (SAME FILE) ---------- */

    public static void main(String[] args) {
        // Main method serving as the entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        System.out.print("Enter Owner Name: ");
        // Prompting the user to enter the vehicle owner's name.

        String owner = sc.nextLine();
        // Reading the full line as the owner's name.

        System.out.print("Enter Vehicle Type: ");
        // Prompting the user to enter the type of vehicle.

        String type = sc.nextLine();
        // Reading the full line as the vehicle type.

        System.out.print("Enter Registration Number: ");
        // Prompting the user to enter the vehicle's registration number.

        String regNo = sc.nextLine();
        // Reading the full line as the registration number.

        // Update registration fee (static method)
        Vehicle.updateRegistrationFee(2000.0);
        // Calling the static method to update the registration fee for all vehicles.

        // Create Vehicle object
        Vehicle vehicle = new Vehicle(owner, type, regNo);
        // Creating a new Vehicle object using the data entered by the user.

        // Validate using instanceof and display details
        vehicle.displayRegistrationDetails(vehicle);
        // Passing the same Vehicle object to displayRegistrationDetails to verify instanceof and print details.

        sc.close();
        // Closing the Scanner to release its system resources.
    }
    // End of main method.
}
// End of Vehicle class.
