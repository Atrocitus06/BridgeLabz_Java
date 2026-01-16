package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights.
Use default, parameterized, and copy constructors to initialize bookings.
*/
// Block comment describing the hotel booking system problem.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class HotelBooking {
    // Class representing a hotel booking with different constructor types.

    String guestName;
    // Instance variable to store the guest's name.

    String roomType;
    // Instance variable to store the type of room.

    int nights;
    // Instance variable to store the number of nights booked.

    HotelBooking() {
        // Default constructor that initializes a basic default booking.

        guestName = "Guest";
        // Setting a default guest name.

        roomType = "Standard";
        // Setting a default room type.

        nights = 1;
        // Setting a default of one night for the stay.
    }

    HotelBooking(String g, String r, int n) {
        // Parameterized constructor to initialize the booking with user-defined values.

        guestName = g;
        // Assigning the constructor parameter 'g' to the instance variable 'guestName'.

        roomType = r;
        // Assigning the constructor parameter 'r' to the instance variable 'roomType'.

        nights = n;
        // Assigning the constructor parameter 'n' to the instance variable 'nights'.
    }

    HotelBooking(HotelBooking hb) {
        // Copy constructor that duplicates another HotelBooking object's details.

        guestName = hb.guestName;
        // Copying the guest name from the given HotelBooking object.

        roomType = hb.roomType;
        // Copying the room type from the given HotelBooking object.

        nights = hb.nights;
        // Copying the number of nights from the given HotelBooking object.
    }

    void display() {
        // Instance method to display the booking details.

        System.out.println("Guest Name : " + guestName);
        // Printing the guest's name.

        System.out.println("Room Type : " + roomType);
        // Printing the room type.

        System.out.println("Nights : " + nights);
        // Printing the number of nights booked.

        System.out.println();
        // Printing a blank line for readability.
    }

    public static void main(String[] args) {
        // Main method: entry point of the hotel booking application.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        HotelBooking b1 = new HotelBooking();
        // Creating a booking using the default constructor.

        System.out.println("Default Booking:");
        // Indicating that the following output shows the default booking.

        b1.display();
        // Displaying the details of the default booking.

        System.out.print("Enter guest name: ");
        // Prompting the user to enter the guest's name.

        String name = sc.nextLine();
        // Reading the full line as the guest's name.

        System.out.print("Enter room type: ");
        // Prompting the user to enter the room type.

        String room = sc.nextLine();
        // Reading the full line as the room type.

        System.out.print("Enter number of nights: ");
        // Prompting the user to enter how many nights will be booked.

        int nights = sc.nextInt();
        // Reading the number of nights as an integer.

        HotelBooking b2 = new HotelBooking(name, room, nights);
        // Creating a booking using the parameterized constructor.

        System.out.println("\nUser Booking:");
        // Indicating that the following output shows the user-defined booking.

        b2.display();
        // Displaying the details of the user-defined booking.

        HotelBooking b3 = new HotelBooking(b2);
        // Creating a booking using the copy constructor, duplicating b2.

        System.out.println("Copied Booking:");
        // Indicating that the following output shows the copied booking.

        b3.display();
        // Displaying the details of the copied booking.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of HotelBooking class.
