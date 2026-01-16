package ObjectOrientedProgramming.JavaClassAndObject.Level2;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level2 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class MovieTicket {
// Class declaration for MovieTicket to model movie ticket booking and details.

    String movieName;
// Instance variable to store the movie name as a string.

    int seatNumber;
// Instance variable to store the seat number as an integer.

    double price;
// Instance variable to store the ticket price as a double for decimal precision.

    void bookTicket(String movie, int seat, double ticketPrice) {
// Method declaration to book a ticket by assigning movie, seat, and price details.

        movieName = movie;
// Assigning the provided movie name to the instance movieName field.

        seatNumber = seat;
// Assigning the provided seat number to the instance seatNumber field.

        price = ticketPrice;
// Assigning the provided ticket price to the instance price field.

    } // End of bookTicket method. Note: No confirmation print; booking is silent.

    void displayTicket() {
// Method declaration to display the booked ticket details.

        System.out.println("\nTicket Details:");
// Printing a header line with newline for better readability.

        System.out.println("Movie Name: " + movieName);
// Printing the movie name prefixed with "Movie Name: " label.

        System.out.println("Seat Number: " + seatNumber);
// Printing the seat number prefixed with "Seat Number: " label.

        System.out.println("Price: " + price);
// Printing the price prefixed with "Price: " label.

    } // End of displayTicket method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        MovieTicket ticket = new MovieTicket();
// Creating a new MovieTicket object instance named 'ticket' using default constructor.

        System.out.print("Enter movie name: ");
// Prompting the user to enter the movie name.

        String movie = sc.nextLine();
// Reading a line of input (movie name) and storing in local variable.

        System.out.print("Enter seat number: ");
// Prompting the user to enter the seat number.

        int seat = sc.nextInt();
// Reading an integer input (seat number) and storing in local variable.

        System.out.print("Enter ticket price: ");
// Prompting the user to enter the ticket price.

        double price = sc.nextDouble();
// Reading a double input (price) and storing in local variable.

        ticket.bookTicket(movie, seat, price);
// Calling bookTicket method on 'ticket' object with input parameters.

        ticket.displayTicket();
// Calling displayTicket method to show booked ticket details.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of MovieTicket class.
