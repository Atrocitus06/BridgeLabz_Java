package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Problem 3: Vehicle Registration

Create a Vehicle class to manage the details of vehicles:
Instance Variables: ownerName, vehicleType.
Class Variable: registrationFee (fixed for all vehicles).

Methods:
An instance method displayVehicleDetails() to display owner and vehicle details.
A class method updateRegistrationFee() to change the registration fee.
*/
// Block comment describing the exercise and requirements.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Vehicle {
    // Class representing a vehicle with owner and registration information.

    String ownerName;
    // Instance variable to store the name of the vehicle owner.

    String vehicleType;
    // Instance variable to store the type of vehicle (for example, "Car" or "Bike").

    static double registrationFee = 1000;
    // Static variable storing the registration fee common to all vehicles.

    Vehicle(String o, String v) {
        // Constructor to initialize a Vehicle object with owner name and vehicle type.

        ownerName = o;
        // Assigning the constructor parameter 'o' to the instance variable 'ownerName'.

        vehicleType = v;
        // Assigning the constructor parameter 'v' to the instance variable 'vehicleType'.
    }

    void displayVehicleDetails() {
        // Instance method to display the vehicle's owner, type, and current registration fee.

        System.out.println(
            ownerName + " - " + vehicleType + " - Fee: " + registrationFee
        );
        // Printing owner name, vehicle type, and static registration fee in a single formatted line.
    }

    static void updateRegistrationFee(double fee) {
        // Static method to update the registration fee for all Vehicle objects.

        registrationFee = fee;
        // Assigning the new fee value to the static variable 'registrationFee'.
    }

    public static void main(String[] args) {
        // Main method: entry point of the vehicle registration program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        System.out.print("Enter registration fee: ");
        // Prompting the user to input a new registration fee.

        double fee = sc.nextDouble();
        // Reading the registration fee as a double.

        sc.nextLine();
        // Clearing the newline character left in the buffer after nextDouble().

        Vehicle.updateRegistrationFee(fee);
        // Calling the static method to update the common registration fee.

        System.out.println("\nEnter details for Vehicle 1:");
        // Indicating that details for the first vehicle are being entered.

        String owner1 = sc.nextLine();
        // Reading the owner name for the first vehicle.

        String type1 = sc.nextLine();
        // Reading the vehicle type for the first vehicle.

        System.out.println("Enter details for Vehicle 2:");
        // Indicating that details for the second vehicle are being entered.

        String owner2 = sc.nextLine();
        // Reading the owner name for the second vehicle.

        String type2 = sc.nextLine();
        // Reading the vehicle type for the second vehicle.

        Vehicle v1 = new Vehicle(owner1, type1);
        // Creating the first Vehicle object with the entered owner and type.

        Vehicle v2 = new Vehicle(owner2, type2);
        // Creating the second Vehicle object with the entered owner and type.

        System.out.println("\nVehicle Details:");
        // Printing a header to indicate the start of vehicle details output.

        v1.displayVehicleDetails();
        // Displaying the details of the first vehicle.

        v2.displayVehicleDetails();
        // Displaying the details of the second vehicle.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Vehicle class.
