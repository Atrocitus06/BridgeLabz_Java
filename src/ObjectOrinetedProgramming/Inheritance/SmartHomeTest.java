package ObjectOrientedProgramming.Inheritance;
// Package declaration that organizes this class within the ObjectOrientedProgramming.Inheritance namespace.

import java.util.Scanner;
// Importing Scanner to read user input from the console.

public class SmartHomeTest {
// Public class declaration for the main test driver class demonstrating inheritance.

    public static void main(String[] args) {
    // Main method: entry point of the program where execution begins.

    Scanner sc = new Scanner(System.in);
    // Creating a Scanner object to read input from System.in (keyboard).

    System.out.print("Enter Device ID: ");
    // Prompting the user to enter the device ID.

    int deviceId = sc.nextInt();
    // Reading an integer device ID from the user.

    sc.nextLine();
    // Consuming the newline character left in the input buffer after reading int.

    System.out.print("Enter Device Status (ON/OFF): ");
    // Prompting the user to enter the device status as ON or OFF.

    String status = sc.nextLine();
    // Reading the device status string from the user.

    System.out.print("Enter Temperature Setting: ");
    // Prompting the user to enter the temperature setting.

    int temperature = sc.nextInt();
    // Reading the temperature integer from the user.

    Thermostat t1 = new Thermostat(deviceId, status, temperature);
    // Creating a new Thermostat object with user-provided device ID, status, and temperature.

    System.out.println("\n--- Device Status ---");
    // Printing a header line to separate output.

    t1.displayStatus();
    // Calling the displayStatus method on the Thermostat object to show its details.

    sc.close();
    // Closing the Scanner to free up system resources.

    // ===== Superclass =====
    // Section comment indicating the start of the superclass definition.

}
// End of main method.


// ===== Superclass =====
// Class comment describing the base Device class.

static class Device {
    // Static nested class for the base Device superclass.

    int deviceId;
    // Field to store the unique device identifier.

    String status;
    // Field to store the current ON/OFF status of the device.

    Device(int deviceId, String status) {
        // Constructor for Device class that initializes deviceId and status.

        this.deviceId = deviceId;
        // Assigning the passed deviceId to the instance field.

        this.status = status;
        // Assigning the passed status to the instance field.

    }

    void displayStatus() {
        // Method to display the basic status information of the device.

        System.out.println("Device ID: " + deviceId);
        // Printing the device ID.

        System.out.println("Status: " + status);
        // Printing the device status.

    }
}
// End of Device superclass.

// ===== Subclass =====
// Section comment indicating the start of the Thermostat subclass.

static class Thermostat extends Device {
    // Static nested subclass Thermostat that extends the Device superclass.

    int temperatureSetting;
    // Additional field specific to Thermostat for temperature value.

    Thermostat(int deviceId, String status, int temperatureSetting) {
        // Constructor for Thermostat that calls superclass constructor and sets temperature.

        super(deviceId, status);
        // Calling the superclass Device constructor with deviceId and status.

        this.temperatureSetting = temperatureSetting;
        // Assigning the passed temperature to the instance field.

    }

    void displayStatus() {
        // Overridden displayStatus method that extends superclass functionality.

        super.displayStatus();
        // Calling the superclass displayStatus to print common device info.

        System.out.println("Temperature Setting: " + temperatureSetting);
        // Printing the Thermostat-specific temperature setting.

    }
}
// End of Thermostat subclass.
}
// End of SmartHomeTest class.
