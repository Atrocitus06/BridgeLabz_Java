package ObjectOrientedProgramming.JavaClassAndObject.Level1;
// Package declaration that organizes this class within the Java_Class_And_Object Level1 module.

/*
Program to Compute Area of a Circle

Problem Statement: Write a program to create a Circle class with an attribute radius.
Add methods to calculate and display the area and circumference of the circle.
*/
// Block comment describing the circle computation program.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Circle {
    // Class representing a circle with radius and computation methods.

    double radius;
    // Instance variable to store the radius of the circle.

    void calculateAndDisplay() {
        // Instance method to calculate and display the area and circumference of the circle.

        double area = 3.14 * radius * radius;
        // Calculating the area using the formula π × radius², where π is approximated as 3.14.

        double circumference = 2 * 3.14 * radius;
        // Calculating the circumference using the formula 2 × π × radius.

        System.out.println("\nCircle Details:");
        // Printing a header to indicate the start of circle details.

        System.out.println("Radius: " + radius);
        // Printing the radius of the circle.

        System.out.println("Area: " + area);
        // Printing the calculated area of the circle.

        System.out.println("Circumference: " + circumference);
        // Printing the calculated circumference of the circle.
    }

    public static void main(String[] args) {
        // Main method: entry point of the circle computation program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read input from the console.

        Circle c = new Circle();
        // Creating a new Circle object using the default constructor.

        System.out.print("Enter radius of the circle: ");
        // Prompting the user to enter the circle's radius.

        c.radius = sc.nextDouble();
        // Directly assigning the read radius to the object's instance variable.

        c.calculateAndDisplay();
        // Calling the instance method to calculate and display the circle's details.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Circle class.
