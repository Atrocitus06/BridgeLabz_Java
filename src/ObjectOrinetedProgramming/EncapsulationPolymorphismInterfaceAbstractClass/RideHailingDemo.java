// ===== RideHailingDemo =====
package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package declaration that organizes this class within the Object_Oriented_Programming namespace.

import java.util.ArrayList;
// Importing ArrayList to store multiple ride vehicle objects dynamically.

import java.util.Scanner;
// Importing Scanner to read user input from the console.

public class RideHailingDemo {
    // Public class declaration for the main demo application.

    public static void main(String[] args) {
        // Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read input from System.in (keyboard).

        ArrayList<RideVehicle> rides = new ArrayList<>();
        // Creating an ArrayList to store RideVehicle objects for multiple rides.

        System.out.print("Enter number of rides: ");
        // Prompting the user to enter the total number of rides.

        int n = sc.nextInt();
        // Reading the number of rides from user input.

        sc.nextLine();
        // Consuming the newline character left in the input buffer.

        for (int i = 0; i < n; i++) {
            // Looping 'n' times to collect details for each ride.

            System.out.println("\nRide " + (i + 1));
            // Printing the current ride number for user reference.

            System.out.print("Choose Vehicle Type (1-Car, 2-Bike, 3-Auto): ");
            // Prompting user to select vehicle type using numeric choice.

            int type = sc.nextInt();
            // Reading the vehicle type choice (1, 2, or 3).

            sc.nextLine();
            // Consuming the newline character after reading int.

            System.out.print("Enter Vehicle ID: ");
            // Prompting for unique vehicle identifier.

            int id = sc.nextInt();
            // Reading vehicle ID as integer.

            sc.nextLine();
            // Consuming newline after integer input.

            System.out.print("Enter Driver Name: ");
            // Prompting for driver's name.

            String driver = sc.nextLine();
            // Reading driver name as string (may contain spaces).

            System.out.print("Enter Rate per Km: ");
            // Prompting for rate charged per kilometer.

            double rate = sc.nextDouble();
            // Reading rate as double value.

            RideVehicle v;
            // Declaring reference variable for RideVehicle (polymorphic).

            if (type == 1) {
                // Checking if user selected Car (type 1).

                v = new CarRide(id, driver, rate);
                // Creating CarRide object and assigning to RideVehicle reference.

            } else if (type == 2) {
                // Checking if user selected Bike (type 2).

                v = new BikeRide(id, driver, rate);
                // Creating BikeRide object and assigning to RideVehicle reference.

            } else {
                // Default case for Auto (type 3 or any other).

                v = new Auto(id, driver, rate);
                // Creating Auto object and assigning to RideVehicle reference.
            }

            rides.add(v);
            // Adding the created vehicle object to the rides ArrayList.

        }  // End of ride input loop.

        System.out.print("\nEnter Distance (in km): ");
        // Prompting for total distance traveled (applies to all rides).

        double distance = sc.nextDouble();
        // Reading distance as double value.

        System.out.println("\n===== FARE DETAILS =====");
        // Printing header for fare calculation results.

        for (RideVehicle v : rides) {
            // Iterating through all stored rides using enhanced for loop.

            calculateFareForRide(v, distance);
            // Calling polymorphic method to calculate and display fare for each ride.
        }

        sc.close();
        // Closing the Scanner to prevent resource leak.

    }  // End of main method.

    // Polymorphic method to handle fare calculation for any RideVehicle type.
    static void calculateFareForRide(RideVehicle v, double distance) {
        // Static utility method that works with any RideVehicle subclass.

        v.getVehicleDetails();
        // Calling concrete method to display vehicle and driver details.

        double fare = v.calculateFare(distance);
        // Calling abstract method (overridden in subclasses) to compute fare polymorphically.

        System.out.println("Distance: " + distance + " km");
        // Displaying the distance used for fare calculation.

        System.out.println("Total Fare: ₹" + fare);
        // Displaying the computed total fare with currency symbol.

        if (v instanceof GPS) {
            // Checking if the vehicle implements GPS interface using instanceof.

            GPS g = (GPS) v;
            // Downcasting RideVehicle reference to GPS interface.

            g.updateLocation("City Center");
            // Calling interface method to update current location.

            System.out.println("Current Location: " + g.getCurrentLocation());
            // Displaying updated location via getter method.
        }

        System.out.println("------------------------");
        // Printing separator line between different ride details.
    }
    // End of calculateFareForRide method.

}  // End of RideHailingDemo class (inner classes follow).

// Abstract base class for all ride vehicles demonstrating encapsulation.
abstract class RideVehicle {
    // Abstract class providing common structure for vehicle types.

    // Encapsulation: private fields accessible only through methods.
    private int vehicleId;
    // Private field storing unique vehicle identifier.

    private String driverName;
    // Private field storing driver's full name.

    private double ratePerKm;
    // Private field storing rate charged per kilometer.

    RideVehicle(int vehicleId, String driverName, double ratePerKm) {
        // Constructor to initialize all private fields.

        this.vehicleId = vehicleId;
        // Assigning parameter to instance field (this reference avoids shadowing).

        this.driverName = driverName;
        // Assigning driver name to instance field.

        this.ratePerKm = ratePerKm;
        // Assigning rate to instance field.
    }

    // Getters for encapsulated private fields (no setters for immutability).
    public int getVehicleId() {
        // Public getter method for vehicleId field.

        return vehicleId;
        // Returning the private field value.
    }

    public String getDriverName() {
        // Public getter method for driverName field.

        return driverName;
        // Returning the private field value.
    }

    public double getRatePerKm() {
        // Public getter method for ratePerKm field.

        return ratePerKm;
        // Returning the private field value.
    }

    // Concrete method available to all subclasses.
    public void getVehicleDetails() {
        // Public method to display all vehicle details using getters.

        System.out.println("Vehicle ID: " + vehicleId);
        // Direct access to private field within same class.

        System.out.println("Driver Name: " + driverName);
        // Direct access to private field within same class.

        System.out.println("Rate per Km: ₹" + ratePerKm);
        // Direct access to private field within same class.
    }

    // Abstract method forcing subclasses to implement fare calculation.
    public abstract double calculateFare(double distance);
    // Must be overridden by concrete subclasses.

}  // End of RideVehicle abstract class.

// GPS interface defining location tracking contract.
interface GPS {
    // Interface declaring methods for location services.

    String getCurrentLocation();
    // Abstract method to retrieve current location string.

    void updateLocation(String location);
    // Abstract method to set new location string.
}  // End of GPS interface.

// Concrete CarRide class extending abstract class and implementing interface.
class CarRide extends RideVehicle implements GPS {
    // Subclass for car rides with GPS capability.

    private String location = "Unknown";
    // Private field storing current GPS location (encapsulated).

    CarRide(int id, String driver, double rate) {
        // Constructor delegating to superclass constructor.

        super(id, driver, rate);
        // Calling parent class constructor with all parameters.
    }

    public double calculateFare(double distance) {
        // Overriding abstract method for car-specific fare logic.

        return getRatePerKm() * distance + 50; // base charge
        // Multiplying rate by distance and adding fixed ₹50 base charge.
    }

    public String getCurrentLocation() {
        // Implementing GPS interface method.

        return location;
        // Returning private location field.
    }

    public void updateLocation(String location) {
        // Implementing GPS interface method.

        this.location = location;
        // Updating private location field.
    }
}  // End of CarRide class.

class BikeRide extends RideVehicle implements GPS {
    // Subclass for bike rides with GPS capability.

    private String location = "Unknown";
    // Private field for current GPS location.

    BikeRide(int id, String driver, double rate) {
        // Constructor calling superclass.

        super(id, driver, rate);
        // Delegating initialization to parent constructor.
    }

    public double calculateFare(double distance) {
        // Overriding for bike-specific logic (no base charge).

        return getRatePerKm() * distance;
        // Simple rate × distance calculation.
    }

    public String getCurrentLocation() {
        // GPS getter implementation.

        return location;
    }

    public void updateLocation(String location) {
        // GPS setter implementation.

        this.location = location;
    }
}  // End of BikeRide class.

class Auto extends RideVehicle implements GPS {
    // Subclass for auto-rickshaw rides with GPS.

    private String location = "Unknown";
    // Encapsulated GPS location field.

    Auto(int id, String driver, double rate) {
        // Constructor for Auto objects.

        super(id, driver, rate);
        // Using superclass constructor.
    }

    public double calculateFare(double distance) {
        // Auto-specific fare with small base charge.

        return getRatePerKm() * distance + 20;
        // Rate × distance + ₹20 base.
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}  // End of Auto class.
