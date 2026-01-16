package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

public class HybridVehicleDemo {
// Public class declaration for HybridVehicleDemo demonstrating class inheritance + interface implementation.

    public static void main(String[] args) {
// Main method: entry point of the program where polymorphism and hybrid inheritance are shown.

        TransportUnit ev = new ElectricVehicle(150, "Tesla Model 3");
// Creating ElectricVehicle object referenced by superclass TransportUnit (polymorphism).

        TransportUnit pv = new PetrolVehicle(180, "Honda City");
// Creating PetrolVehicle object referenced by superclass TransportUnit (polymorphism).

        System.out.println("Electric Vehicle:");
// Printing header for Electric Vehicle demonstration.

        ev.displayInfo();
// Calling inherited displayInfo() on ev; shows common vehicle details.

        ((ElectricVehicle) ev).charge();
// Downcasting ev to ElectricVehicle type to access subclass-specific charge() method.

        System.out.println();
// Printing blank line for separation.

        System.out.println("Petrol Vehicle:");
// Printing header for Petrol Vehicle demonstration.

        pv.displayInfo();
// Calling inherited displayInfo() on pv; shows common vehicle details.

        ((PetrolVehicle) pv).refuel();
// Downcasting pv to PetrolVehicle type to access implemented refuel() method.

    } // End of main method.

    // Superclass
    class TransportUnit {
// Inner class declaration for TransportUnit as the superclass/base class for vehicles.

        int maxSpeed;
// Instance variable to store maximum speed in km/h.

        String model;
// Instance variable to store vehicle model name.

        TransportUnit(int maxSpeed, String model) {
// Constructor declaration that initializes common vehicle fields.

            this.maxSpeed = maxSpeed;
// Assigning parameter to instance variable (distinguished by 'this').

            this.model = model;
// Assigning parameter to instance variable (distinguished by 'this').

        } // End of TransportUnit constructor.

        void displayInfo() {
// Method declaration providing common vehicle information display.

            System.out.println("Model: " + model);
// Printing the vehicle model.

            System.out.println("Max Speed: " + maxSpeed + " km/h");
// Printing max speed with unit.

        } // End of displayInfo method in superclass.

    } // End of TransportUnit superclass.

    // Interface
    interface Refuelable {
// Interface declaration defining refuel contract for refuelable vehicles.

        void refuel();
// Abstract method declaration that must be implemented by classes.

    } // End of Refuelable interface.

    // ElectricVehicle subclass
    class ElectricVehicle extends TransportUnit {
// Inner class declaration for ElectricVehicle subclass inheriting only from TransportUnit.

        ElectricVehicle(int maxSpeed, String model) {
// Constructor declaration that chains to superclass.

            super(maxSpeed, model);
// Calling superclass TransportUnit constructor with parameters.

        } // End of ElectricVehicle constructor.

        void charge() {
// Subclass-specific method for electric charging operation.

            System.out.println("Electric vehicle is charging.");
// Printing charging status message.

        } // End of charge method.

    } // End of ElectricVehicle subclass.

    // PetrolVehicle subclass (Hybrid inheritance)
    class PetrolVehicle extends TransportUnit implements Refuelable {
// Inner class declaration for PetrolVehicle using hybrid inheritance (extends + implements).

        PetrolVehicle(int maxSpeed, String model) {
// Constructor declaration that chains to superclass.

            super(maxSpeed, model);
// Calling superclass TransportUnit constructor with parameters.

        } // End of PetrolVehicle constructor.

        public void refuel() {
// Implementing the Refuelable interface's refuel() method (public required).

            System.out.println("Petrol vehicle is being refueled.");
// Printing refueling status message.

        } // End of implemented refuel method.

    } // End of PetrolVehicle subclass.

} // End of HybridVehicleDemo class.
