package Object_Oriented_Programming.Keywords.Level1;
// Package declaration that places this class under the Keywords.Level1 package.

import java.util.Scanner;
// Importing the Scanner class to allow reading user input from the console.

public class Employee {
    // Public class representing an employee with company-related details.

    /* ---------- STATIC ---------- */

    static String companyName = "TechNova Solutions";
    // Static variable storing the name of the company shared by all Employee objects.

    static int totalEmployees = 0;
    // Static counter that tracks how many Employee objects have been created.

    static void displayTotalEmployees() {
        // Static method to display the total number of employees.

        System.out.println("Total Employees: " + totalEmployees);
        // Printing the current value of the static counter 'totalEmployees'.
    }

    /* ---------- INSTANCE VARIABLES ---------- */

    String name;
    // Instance variable storing the employee's name.

    final int id;
    // Final instance variable storing the employee's ID, which cannot be modified after initialization.

    String designation;
    // Instance variable storing the employee's job designation.

    /* ---------- CONSTRUCTOR (THIS) ---------- */

    Employee(String name, int id, String designation) {
        // Constructor used to initialize an Employee object with name, ID, and designation.

        this.name = name;
        // Using 'this' to assign the constructor parameter to the instance variable 'name'.

        this.id = id;
        // Using 'this' to assign the constructor parameter to the final instance variable 'id'.

        this.designation = designation;
        // Using 'this' to assign the constructor parameter to the instance variable 'designation'.

        totalEmployees++;
        // Incrementing the static employee counter whenever a new Employee object is created.
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */

    void displayDetails(Object obj) {
        // Instance method that displays employee details if the passed object is an Employee.

        if (obj instanceof Employee) {
            // Checking whether the provided object is actually an instance of Employee.

            System.out.println("\n--- Employee Details ---");
            // Printing a header to indicate the beginning of employee details.

            System.out.println("Company : " + companyName);
            // Printing the static company name shared by all Employee objects.

            System.out.println("Name : " + name);
            // Printing the employee's name.

            System.out.println("Employee ID : " + id);
            // Printing the employee's unique ID.

            System.out.println("Designation : " + designation);
            // Printing the employee's job designation.

        } else {
            // Executed if the given object is not an instance of Employee.

            System.out.println("Object is not an Employee");
            // Informing that the provided object is not of type Employee.
        }
        // End of instanceof check and display logic.
    }
    // End of displayDetails method.

    /* ---------- MAIN METHOD (SAME FILE) ---------- */

    public static void main(String[] args) {
        // Main method serving as the entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        System.out.print("Enter Employee Name: ");
        // Prompting the user to enter the employee's name.

        String name = sc.nextLine();
        // Reading the full line as the employee's name.

        System.out.print("Enter Employee ID: ");
        // Prompting the user to enter the employee's ID.

        int id = sc.nextInt();
        // Reading the employee's ID as an integer.

        sc.nextLine();
        // Consuming the leftover newline character from the input buffer after nextInt().

        System.out.print("Enter Designation: ");
        // Prompting the user to enter the employee's designation.

        String designation = sc.nextLine();
        // Reading the full line as the employee's designation.

        // Create Employee object
        Employee emp = new Employee(name, id, designation);
        // Creating a new Employee object using the values entered by the user.

        // Display employee details using instanceof
        emp.displayDetails(emp);
        // Passing the same Employee object to displayDetails to verify instanceof and print details.

        // Display total employees (static)
        Employee.displayTotalEmployees();
        // Calling the static method to display how many employees have been created.

        sc.close();
        // Closing the Scanner to release its system resources.
    }
    // End of main method.
}
// End of Employee class.
