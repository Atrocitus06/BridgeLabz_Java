package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Problem 4: Employee Records

Develop an Employee class with:
employeeID (public).
department (protected).
salary (private).

Write methods to:
Modify salary using a public method.
Create a subclass Manager to access employeeID and department.
*/
// Block comment describing the employee records problem.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Employee {
    // Class representing an employee with different access modifiers on its fields.

    public int employeeID;
    // Public instance variable to store the employee ID, accessible from anywhere.

    protected String department;
    // Protected instance variable to store the department, accessible in the same package and subclasses.

    private double salary;
    // Private instance variable to store the salary, accessible only within this class.

    Employee(int id, String dept, double sal) {
        // Constructor to initialize an Employee object with ID, department, and salary.

        employeeID = id;
        // Assigning the constructor parameter 'id' to the instance variable 'employeeID'.

        department = dept;
        // Assigning the constructor parameter 'dept' to the instance variable 'department'.

        salary = sal;
        // Assigning the constructor parameter 'sal' to the private instance variable 'salary'.
    }

    // Setter
    public void setSalary(double sal) {
        // Public setter method to modify the salary.

        salary = sal;
        // Assigning the new salary value to the private instance variable 'salary'.
    }

    // Getter
    public double getSalary() {
        // Public getter method to access the employee's salary.

        return salary;
        // Returning the value of the private variable 'salary'.
    }

    // Subclass
    class Manager extends Employee {
        // Inner subclass representing a Manager, which is a type of Employee.

        Manager(int id, String dept, double sal) {
            // Constructor for Manager that forwards parameters to the Employee constructor.

            super(id, dept, sal);
            // Calling the superclass (Employee) constructor to initialize the inherited fields.
        }

        void displayDetails() {
            // Instance method to display manager details, demonstrating access levels.

            System.out.println("Employee ID : " + employeeID);
            // Accessing and printing the public employeeID directly.

            System.out.println("Department : " + department);
            // Accessing and printing the protected department directly.

            System.out.println("Salary : " + getSalary());
            // Accessing and printing the private salary via the public getter.
        }
        // End of displayDetails method.
    }
    // End of Manager inner subclass.
}

// Separate test class to demonstrate usage of Employee and Manager.
class TestEmployee {
    // Class containing the main method to test employee records.

    public static void main(String[] args) {
        // Main method: entry point of the employee test program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        System.out.print("Enter Employee ID: ");
        // Prompting the user to enter the employee ID.

        int id = sc.nextInt();
        // Reading the employee ID as an integer.

        sc.nextLine();
        // Clearing the newline character left after nextInt().

        System.out.print("Enter Department: ");
        // Prompting the user to enter the department.

        String dept = sc.nextLine();
        // Reading the full line as the department name.

        System.out.print("Enter Salary: ");
        // Prompting the user to enter the salary.

        double sal = sc.nextDouble();
        // Reading the salary as a double.

        Employee outer = new Employee(id, dept, sal);
        // Creating an outer Employee object to associate with the inner Manager object.

        Employee.Manager m = outer.new Manager(id, dept, sal);
        // Creating an instance of the inner Manager class using the outer Employee instance.

        System.out.println("\nEmployee Details:");
        // Printing a header to indicate the start of employee details.

        m.displayDetails();
        // Displaying the manager's details using the displayDetails method.

        System.out.print("\nEnter new Salary: ");
        // Prompting the user to enter a new salary.

        double newSal = sc.nextDouble();
        // Reading the new salary as a double.

        m.setSalary(newSal);
        // Updating the salary using the public setter method.

        System.out.println("Updated Salary: " + m.getSalary());
        // Printing the updated salary using the public getter method.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of TestEmployee class and employee records example.
