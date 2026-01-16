package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Write a Circle class with a radius attribute. Use constructor chaining to initialize radius
with default and user-provided values.
*/
// Comment describing the exercise: demonstrates constructor chaining.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Circle {
    // Class representing a circle with a radius and constructor chaining.

    double radius;
    // Instance variable to store the radius of the circle.

    Circle() {
        // Default constructor that initializes the radius using constructor chaining.

        this(1.0);
        // Calling the parameterized constructor with a default radius value of 1.0.
    }

    Circle(double r) {
        // Parameterized constructor that initializes the circle with a user-provided radius.

        radius = r;
        // Assigning the constructor parameter 'r' to the instance variable 'radius'.
    }

    void display() {
        // Instance method to display the radius of the circle.

        System.out.println("Radius of the circle: " + radius);
        // Printing the current radius of the circle.
    }

    public static void main(String[] args) {
        // Main method: entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        Circle c1 = new Circle();
        // Creating a Circle object using the default constructor (radius = 1.0).

        System.out.println("Using default constructor:");
        // Indicating that the following output corresponds to the default constructor.

        c1.display();
        // Displaying the radius of the circle created with the default constructor.

        System.out.print("\nEnter radius: ");
        // Prompting the user to enter a custom radius.

        double r = sc.nextDouble();
        // Reading the radius value as a double.

        Circle c2 = new Circle(r);
        // Creating a Circle object using the parameterized constructor with the user-provided radius.

        System.out.println("Using parameterized constructor:");
        // Indicating that the following output corresponds to the parameterized constructor.

        c2.display();
        // Displaying the radius of the circle created with the user-provided radius.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Circle class.
