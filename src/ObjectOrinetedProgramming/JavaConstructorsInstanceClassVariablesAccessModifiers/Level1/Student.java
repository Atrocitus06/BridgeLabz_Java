package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Problem 1: University Management System
Create a Student class with:
rollNumber (public).
name (protected).
CGPA (private).
Write methods to:
Access and modify CGPA using public methods.
Create a subclass PostgraduateStudent to demonstrate the use of protected members.
*/
// Block comment describing the university management system problem.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Student {
    // Class representing a student with different access modifiers for its fields.

    public int rollNumber;
    // Public instance variable to store the student's roll number, accessible from anywhere.

    protected String name;
    // Protected instance variable to store the student's name, accessible in the same package and subclasses.

    private double cgpa;
    // Private instance variable to store the student's CGPA, accessible only within this class.

    Student(int r, String n, double c) {
        // Constructor to initialize a Student object with roll number, name, and CGPA.

        rollNumber = r;
        // Assigning the constructor parameter 'r' to the instance variable 'rollNumber'.

        name = n;
        // Assigning the constructor parameter 'n' to the instance variable 'name'.

        cgpa = c;
        // Assigning the constructor parameter 'c' to the private instance variable 'cgpa'.
    }

    // Getter
    public double getCGPA() {
        // Public getter method to retrieve the student's CGPA.

        return cgpa;
        // Returning the value of the private variable 'cgpa'.
    }

    // Setter
    public void setCGPA(double c) {
        // Public setter method to update the student's CGPA.

        cgpa = c;
        // Assigning the parameter 'c' to the private instance variable 'cgpa'.
    }
    // End of Student class.
}

class PostgraduateStudent extends Student {
    // Subclass extending Student to represent a postgraduate student.

    PostgraduateStudent(int r, String n, double c) {
        // Constructor for PostgraduateStudent that forwards parameters to the Student superclass constructor.

        super(r, n, c);
        // Calling the parent class (Student) constructor using super() to initialize inherited fields.
    }

    void display() {
        // Instance method to display postgraduate student details, demonstrating access control.

        System.out.println("Roll No : " + rollNumber);
        // Printing the public rollNumber accessed directly from the superclass.

        System.out.println("Name    : " + name);
        // Printing the protected name accessed directly from the superclass.

        System.out.println("CGPA    : " + getCGPA());
        // Printing the private CGPA accessed via the public getter method from the superclass.
    }
    // End of PostgraduateStudent class.
}

class Main {
    // Class containing the main method to test Student and PostgraduateStudent functionality.

    public static void main(String[] args) {
        // Main method: entry point of the university management program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        System.out.print("Enter Roll Number: ");
        // Prompting the user to enter the student's roll number.

        int roll = sc.nextInt();
        // Reading the roll number as an integer.

        sc.nextLine();
        // Clearing the newline character left in the buffer after nextInt().

        System.out.print("Enter Name: ");
        // Prompting the user to enter the student's name.

        String name = sc.nextLine();
        // Reading the full line as the student's name.

        System.out.print("Enter CGPA: ");
        // Prompting the user to enter the student's CGPA.

        double cgpa = sc.nextDouble();
        // Reading the CGPA as a double value.

        PostgraduateStudent pg = new PostgraduateStudent(roll, name, cgpa);
        // Creating a PostgraduateStudent object using the entered roll number, name, and CGPA.

        System.out.println("\nStudent Details:");
        // Printing a header to indicate the start of student details.

        pg.display();
        // Calling the display method to show the postgraduate student's details.

        System.out.print("\nEnter new CGPA: ");
        // Prompting the user to enter an updated CGPA value.

        double newCgpa = sc.nextDouble();
        // Reading the new CGPA as a double value.

        pg.setCGPA(newCgpa);
        // Updating the CGPA using the inherited public setter method.

        System.out.println("Updated CGPA: " + pg.getCGPA());
        // Printing the updated CGPA using the inherited public getter method.

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Main class and university management example.
