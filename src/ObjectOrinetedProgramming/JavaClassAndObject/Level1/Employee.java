package ObjectOrientedProgramming.JavaClassAndObject.Level1;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level1 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class Employee {
// Class declaration for Employee to encapsulate employee-related data and behavior.

    String name;
// Instance variable to store the employee's name as a string.

    int id;
// Instance variable to store the employee's unique identifier as an integer.

    double salary;
// Instance variable to store the employee's salary as a double for decimal precision.

    void displayDetails() {
// Method declaration to display all employee details in a formatted manner.

        System.out.println("\nEmployee Details:");
// Printing a header line with newline for better readability.

        System.out.println("Name: " + name);
// Printing the employee's name prefixed with "Name: " label.

        System.out.println("ID: " + id);
// Printing the employee's ID prefixed with "ID: " label.

        System.out.println("Salary: " + salary);
// Printing the employee's salary prefixed with "Salary: " label.

    } // End of displayDetails method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        Employee emp = new Employee();
// Creating a new Employee object instance named 'emp' using default constructor.

        System.out.print("Enter employee name: ");
// Prompting the user to enter the employee's name.

        emp.name = sc.nextLine();
// Reading a line of input (name) and assigning it to the object's name field.

        System.out.print("Enter employee id: ");
// Prompting the user to enter the employee's ID.

        emp.id = sc.nextInt();
// Reading an integer input (ID) and assigning it to the object's id field.

        System.out.print("Enter employee salary: ");
// Prompting the user to enter the employee's salary.

        emp.salary = sc.nextDouble();
// Reading a double input (salary) and assigning it to the object's salary field.

        emp.displayDetails();
// Calling the displayDetails method on the emp object to print all details.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of Employee class.
