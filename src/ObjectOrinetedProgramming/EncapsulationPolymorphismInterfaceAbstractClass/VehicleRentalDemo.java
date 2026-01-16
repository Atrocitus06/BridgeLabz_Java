// ===== VehicleRentalDemo =====
package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package declaration organizing this class in OOP demonstrations.

import java.util.ArrayList;
// Importing ArrayList for dynamic storage of vehicle objects.

import java.util.Scanner;
// Importing Scanner class for console input handling.

public class VehicleRentalDemo {
    // Main demo class showcasing OOP principles in vehicle rental system.

    public static void main(String[] args) {
        // Entry point method where program execution starts.

        Scanner sc = new Scanner(System.in);
        // Instantiating Scanner for reading keyboard input.

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        // ArrayList to hold polymorphic Vehicle references.

        System.out.print("Enter number of vehicles: ");
        // User prompt for total vehicles to process.

        int n = sc.nextInt();
        // Capturing number of vehicles as integer.

        sc.nextLine();
        // Clearing input buffer newline after int read.

        for (int i = 0; i < n; i++) {
            // Loop iterating for each vehicle entry.

            System.out.println("\nVehicle " + (i + 1));
            // Displaying current vehicle index to user.

            System.out.print("Choose Type (1-Car, 2-Bike, 3-Truck): ");
            // Prompting for vehicle type selection.

            int type = sc.nextInt();
            // Reading type choice (1=Car, 2=Bike, 3=Truck).

            sc.nextLine();
            // Buffer clear after integer input.

            System.out.print("Enter Vehicle Number: ");
            // Requesting vehicle registration number.

            String number = sc.nextLine();
            // Reading vehicle number as string.

            System.out.print("Enter Rental Rate (per day): ");
            // Asking for daily rental rate.

            double rate = sc.nextDouble();
            // Storing rate as double.

            Vehicle v;
            // Polymorphic reference declaration.

            if (type == 1) {
                // Condition for Car selection.

                v = new Car(number, rate);
                // Instantiating Car object.

            } else if (type == 2) {
                // Condition for Bike selection.

                v = new Bike(number, rate);
                // Instantiating Bike object.

            } else {
                // Default for Truck.

                v = new Truck(number, rate);
                // Instantiating Truck object.
            }

            vehicles.add(v);
            // Adding vehicle to collection.

        }  // End vehicle input loop.

        System.out.print("\nEnter number of rental days: ");
        // Prompt for rental duration.

        int days = sc.nextInt();
        // Reading days as integer.

        System.out.println("\n===== RENTAL DETAILS =====");
        // Header for rental summary output.

        for (Vehicle v : vehicles) {
            // Enhanced for loop over all vehicles.

            printRentalDetails(v, days);
            // Polymorphic call to display details and costs.
        }

        sc.close();
        // Properly closing scanner resource.

    }  // End main method.

    // Polymorphic utility method for rental calculations.
    static void printRentalDetails(Vehicle v, int days) {
        // Static method handling any Vehicle type.

        double insurance = 0;
        // Variable for optional insurance cost (default 0).

        if (v instanceof Insurable) {
            // Runtime type check for Insurable implementation.

            insurance = ((Insurable) v).calculateInsurance();
            // Downcast and call insurance method.
        }

        double rentalCost = v.calculateRentalCost(days);
        // Polymorphic rental cost calculation.

        v.displayDetails();
        // Calling concrete display method.

        System.out.println("Rental Cost: ₹" + rentalCost);
        // Outputting computed rental amount.

        System.out.println("Insurance Cost: ₹" + insurance);
        // Showing insurance (0 if not applicable).

        System.out.println("Total Cost: ₹" + (rentalCost + insurance));
        // Total including insurance.

        System.out.println("--------------------------");
        // Separator between vehicle entries.
    }
    // End printRentalDetails method.

}  // End outer class.

// Abstract superclass for rental vehicles.
abstract class Vehicle {
    // Provides common fields and methods for subclasses.

    private String vehicleNumber;
    // Encapsulated vehicle registration number.

    private String type;
    // Encapsulated vehicle category string.

    private double rentalRate;
    // Encapsulated daily rental rate.

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        // Parameterized constructor.

        this.vehicleNumber = vehicleNumber;
        // Initializing registration field.

        this.type = type;
        // Setting vehicle type.

        this.rentalRate = rentalRate;
        // Setting daily rate.
    }

    // Encapsulation (getters only - no setters).
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Concrete implementation for all subclasses.
    public void displayDetails() {
        // Displays basic vehicle information.

        System.out.println("Vehicle Number: " + vehicleNumber);
        // Using direct private field access.

        System.out.println("Type: " + type);
        // Type field output.

        System.out.println("Rate per Day: ₹" + rentalRate);
        // Daily rate display.
    }

    // Abstract method requiring subclass implementation.
    public abstract double calculateRentalCost(int days);
    // Cost calculation varies by vehicle type.
}  // End Vehicle class.

// Interface for vehicles requiring insurance.
interface Insurable {
    // Contract for insurance-capable vehicles.

    double calculateInsurance();
    // Computes insurance premium.

    String getInsuranceDetails();
    // Returns insurance policy info.
}  // End Insurable interface.

class Car extends Vehicle implements Insurable {
    // Car rental subclass with insurance.

    private String insurancePolicyNumber = "CAR-INS-101"; // encapsulated
    // Private policy number field.

    Car(String number, double rate) {
        // Constructor delegating to super.

        super(number, "Car", rate);
        // Calling parent with type "Car".
    }

    public double calculateRentalCost(int days) {
        // Standard daily rate calculation.

        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        // Fixed insurance for cars.

        return 500; // fixed insurance
    }

    public String getInsuranceDetails() {
        // Policy description.

        return "Car Insurance";
    }
}  // End Car class.

class Bike extends Vehicle {
    // Bike without insurance interface.

    Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    // Simple rate × days (no insurance).
}  // End Bike class.

class Truck extends Vehicle implements Insurable {
    // Truck with higher costs and insurance.

    private String insurancePolicyNumber = "TRK-INS-201"; // encapsulated
    // Encapsulated truck policy number.

    Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        // Includes extra charge for trucks.

        return (getRentalRate() * days) + 1000; // extra charge
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance";
    }
}  // End Truck class.
