package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

public class VehicleTest {
    // Public class declaration for the main test driver demonstrating vehicle inheritance hierarchy.

    public static void main(String[] args) {
        // Main method: entry point of the program where execution begins.

        Vehicle[] vehicles = new Vehicle[3];
        // Creating an array of Vehicle references with capacity for 3 vehicles (polymorphic array).

        vehicles[0] = new Car(180, "Petrol", 5);
        // Initializing index 0 with a Car object: max speed 180 km/h, petrol fuel, 5 seats.

        vehicles[1] = new Truck(120, "Diesel", 10);
        // Initializing index 1 with a Truck object: max speed 120 km/h, diesel fuel, 10 tons capacity.

        vehicles[2] = new Motorcycle(150, "Petrol", false);
        // Initializing index 2 with a Motorcycle object: max speed 150 km/h, petrol fuel, no gears.

        for (Vehicle v : vehicles) {
            // Enhanced for-each loop iterating through all Vehicle references in the array.

            v.displayInfo();
            // Calling displayInfo() on each vehicle object (polymorphism in action).

            System.out.println();
            // Printing a blank line after each vehicle's information for better readability.

        }
    }
    // End of main method.
}
// End of VehicleTest class.

// ===== Superclass =====
class Vehicle {
    // Base superclass Vehicle that defines common properties for all vehicles.

    int maxSpeed;
    // Field storing the maximum speed capability in km/h.

    String fuelType;
    // Field storing the type of fuel used by the vehicle.

    Vehicle(int maxSpeed, String fuelType) {
        // Constructor for Vehicle class that initializes common vehicle properties.

        this.maxSpeed = maxSpeed;
        // Assigning the passed maximum speed to the instance field.

        this.fuelType = fuelType;
        // Assigning the passed fuel type to the instance field.

    }

    void displayInfo() {
        // Base method to display common vehicle information.

        System.out.println("Max Speed: " + maxSpeed + " km/h");
        // Printing the maximum speed with units.

        System.out.println("Fuel Type: " + fuelType);
        // Printing the fuel type.

    }
}
// End of Vehicle superclass.

// ===== Car subclass =====
class Car extends Vehicle {
    // Car subclass that inherits from Vehicle and adds seat capacity.

    int seatCapacity;
    // Field storing the number of seats in the car.

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        // Constructor for Car class that initializes both superclass and subclass fields.

        super(maxSpeed, fuelType);
        // Calling the superclass Vehicle constructor with maxSpeed and fuelType.

        this.seatCapacity = seatCapacity;
        // Assigning the passed seat capacity to the instance field.

    }

    void displayInfo() {
        // Overridden displayInfo method that extends superclass functionality.

        super.displayInfo();
        // Calling the superclass displayInfo to print common vehicle information first.

        System.out.println("Seat Capacity: " + seatCapacity);
        // Printing the Car-specific seat capacity information.

    }
}
// End of Car subclass.

// ===== Truck subclass =====
class Truck extends Vehicle {
    // Truck subclass that inherits from Vehicle and adds load capacity.

    int loadCapacity;
    // Field storing the maximum load capacity in tons.

    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        // Constructor for Truck class that initializes superclass and subclass fields.

        super(maxSpeed, fuelType);
        // Calling superclass Vehicle constructor with maxSpeed and fuelType.

        this.loadCapacity = loadCapacity;
        // Assigning the passed load capacity to the instance field.

    }

    void displayInfo() {
        // Overridden displayInfo method specific to Truck.

        super.displayInfo();
        // Calling superclass displayInfo for common vehicle properties.

        System.out.println("Load Capacity: " + loadCapacity + " tons");
        // Printing the Truck-specific load capacity with units.

    }
}
// End of Truck subclass.

// ===== Motorcycle subclass =====
class Motorcycle extends Vehicle {
    // Motorcycle subclass that inherits from Vehicle and adds gear information.

    boolean hasGear;
    // Boolean field indicating whether the motorcycle has gears.

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        // Constructor for Motorcycle class.

        super(maxSpeed, fuelType);
        // Calling superclass Vehicle constructor.

        this.hasGear = hasGear;
        // Assigning the gear status to the instance field.

    }

    void displayInfo() {
        // Overridden displayInfo method for Motorcycle.

        super.displayInfo();
        // Calling superclass method for common information.

        System.out.println("Has Gear: " + hasGear);
        // Printing whether the motorcycle has gears (true/false).

    }
}
// End of Motorcycle subclass.
