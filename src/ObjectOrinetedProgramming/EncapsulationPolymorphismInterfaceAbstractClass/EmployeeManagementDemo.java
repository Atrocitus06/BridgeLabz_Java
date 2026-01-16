// ===== EmployeeManagementDemo =====
package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package declaration organizing the class under OOP advanced concepts namespace.

import java.util.ArrayList;
// Importing ArrayList for dynamic collection of Employee objects.

import java.util.Scanner;
// Importing Scanner for reading user input from console.

public class EmployeeManagementDemo {
    // Public main class demonstrating encapsulation, polymorphism, abstract classes, and interfaces.

    public static void main(String[] args) {
        // Main method: program entry point for employee management simulation.

        Scanner sc = new Scanner(System.in);
        // Creating Scanner object to handle console input.

        ArrayList<Employee> employees = new ArrayList<>();
        // Creating dynamic ArrayList to store polymorphic Employee references.

        System.out.print("Enter number of employees: ");
        // Prompting user for total number of employees to add.

        int n = sc.nextInt();
        // Reading the number of employees as integer.

        sc.nextLine();
        // Consuming leftover newline after integer input.

        for (int i = 0; i < n; i++) {
            // Loop iterating n times to input each employee.

            System.out.println((i + 1) + ".");
            // Printing current employee number (1-based indexing).

            System.out.print("Enter Employee Type (1-FullTime, 2-PartTime): ");
            // Prompting for employee type selection.

            int type = sc.nextInt();
            // Reading type choice (1 or 2).

            sc.nextLine();
            // Clearing input buffer.

            System.out.print("Enter Employee ID: ");
            // Prompting for unique employee ID.

            int id = sc.nextInt();
            // Reading employee ID.

            sc.nextLine();
            // Buffer clear.

            System.out.print("Enter Name: ");
            // Prompting for employee name.

            String name = sc.nextLine();
            // Reading full name as string.

            System.out.print("Enter Base Salary: ");
            // Prompting for base salary/hourly rate.

            double baseSalary = sc.nextDouble();
            // Reading base salary value.

            Employee emp;
            // Declaring polymorphic Employee reference.

            if (type == 1) {
                // Checking if FullTime employee selected.

                emp = new FullTimeEmployee(id, name, baseSalary);
                // Creating FullTimeEmployee instance.

            } else {
                // Else branch for PartTime.

                System.out.print("Enter Hours Worked: ");
                // Additional prompt for part-time hours.

                int hours = sc.nextInt();
                // Reading hours worked.

                emp = new PartTimeEmployee(id, name, baseSalary, hours);
                // Creating PartTimeEmployee with hours.

                sc.nextLine();
                // Buffer clear after hours.

            }

            System.out.print("Enter Department: ");
            // Prompting for department assignment.

            String dept = sc.nextLine();
            // Reading department name.

            emp.assignDepartment(dept);
            // Calling interface method to assign department polymorphically.

            employees.add(emp);
            // Adding employee reference to ArrayList.

        }

        System.out.println("\nEMPLOYEE DETAILS:");
        // Header for displaying all employees.

        for (Employee e : employees) {
            // Polymorphic loop over all employees.

            e.displayDetails();
            // Calling overridden displayDetails (encapsulation).

            System.out.println("Calculated Salary: " + e.calculateSalary());
            // Calling abstract method polymorphically.

            System.out.println("Department: " + e.getDepartmentDetails());
            // Calling interface method.

            System.out.println("----------------------------");
            // Separator between employees.

        }

        sc.close();
        // Closing Scanner to prevent resource leak.

    }
    // End of main method.
}
// End of EmployeeManagementDemo class.

// ===== Abstract superclass with Interface =====
abstract class Employee implements Department {
    // Abstract Employee class providing common structure, implementing Department interface.

    private int employeeId;
    // Encapsulated private field for employee ID (encapsulation).

    private String name;
    // Encapsulated private field for employee name.

    private double baseSalary;
    // Encapsulated private field for base salary/hourly rate.

    Employee(int employeeId, String name, double baseSalary) {
        // Constructor initializing encapsulated fields.

        this.employeeId = employeeId;
        // Setting private employeeId.

        this.name = name;
        // Setting private name.

        this.baseSalary = baseSalary;
        // Setting private baseSalary.

    }

    // ===== Getters (Encapsulation) =====
    public int getEmployeeId() {
        // Public getter for employeeId.

        return employeeId;
        // Returning private field value.

    }

    public String getName() {
        // Getter for name.

        return name;
    }

    public double getBaseSalary() {
        // Getter for baseSalary.

        return baseSalary;
    }

    // ===== Setter =====
    public void setBaseSalary(double baseSalary) {
        // Public setter for baseSalary (controlled modification).

        this.baseSalary = baseSalary;
        // Updating private field.

    }

    // ===== Concrete method =====
    public void displayDetails() {
        // Concrete method accessible to subclasses.

        System.out.println("Employee ID: " + employeeId);
        // Displaying ID via getter indirectly (but direct access internally).

        System.out.println("Name: " + name);
        // Displaying name.

        System.out.println("Base Salary: " + baseSalary);
        // Displaying base salary.

    }

    // ===== Abstract method =====
    public abstract double calculateSalary();
    // Abstract method forcing subclasses to implement salary calculation (polymorphism).

    // Interface methods implemented below.
}
// End of abstract Employee class.

// ===== Department Interface =====
interface Department {
    // Interface defining department-related contract.

    void assignDepartment(String dept);
    // Abstract method signature for assigning department.

    String getDepartmentDetails();
    // Abstract method signature for retrieving department info.

}
// End of Department interface.

// ===== FullTimeEmployee subclass =====
class FullTimeEmployee extends Employee {
    // Concrete subclass for full-time employees extending abstract Employee.

    private String department;
    // Private department field implementing interface.

    FullTimeEmployee(int id, String name, double salary) {
        // Constructor delegating to superclass.

        super(id, name, salary);
        // Calling parent constructor.

    }

    public double calculateSalary() {
        // Implementing abstract method: fixed salary.

        return getBaseSalary();
        // Returning base salary as fixed pay.

    }

    public void assignDepartment(String dept) {
        // Implementing interface: setting department.

        this.department = dept;
        // Assigning to private field.

    }

    public String getDepartmentDetails() {
        // Implementing interface: returning department.

        return department;
    }
}
// End of FullTimeEmployee.

// ===== PartTimeEmployee subclass =====
class PartTimeEmployee extends Employee {
    // Concrete subclass for part-time employees.

    private int hoursWorked;
    // Private field for hours tracking.

    private String department;
    // Private department field.

    PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        // Constructor with hourly rate and hours.

        super(id, name, hourlyRate);
        // Super with hourly rate as baseSalary.

        this.hoursWorked = hoursWorked;
        // Setting hours worked.

    }

    public double calculateSalary() {
        // Polymorphic salary calculation for part-time.

        return getBaseSalary() * hoursWorked;
        // Hourly rate multiplied by hours.

    }

    public void assignDepartment(String dept) {
        // Interface implementation.

        this.department = dept;
    }

    public String getDepartmentDetails() {
        // Returning department details.

        return department;
    }
}
// End of PartTimeEmployee.
