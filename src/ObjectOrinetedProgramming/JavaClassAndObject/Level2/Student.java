package ObjectOrientedProgramming.JavaClassAndObject.Level2;
// Package declaration that organizes this class within the ObjectOrientedProgramming.JavaClassAndObject.Level2 namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

class Student {
// Class declaration for Student to encapsulate student-related data and grade calculation behavior.

    String name;
// Instance variable to store the student's name as a string.

    int rollNumber;
// Instance variable to store the student's roll number as an integer.

    int marks;
// Instance variable to store the student's marks as an integer.

    char calculateGrade() {
// Method declaration that calculates and returns the grade character based on marks.

        if (marks >= 90)
// Checking if marks qualify for grade 'A' (90 and above).

            return 'A';
// Returning grade 'A' character.

        else if (marks >= 75)
// Checking if marks qualify for grade 'B' (75-89).

            return 'B';
// Returning grade 'B' character.

        else if (marks >= 60)
// Checking if marks qualify for grade 'C' (60-74).

            return 'C';
// Returning grade 'C' character.

        else if (marks >= 40)
// Checking if marks qualify for grade 'D' (40-59).

            return 'D';
// Returning grade 'D' character.

        else
// Default case for marks below 40.

            return 'F';
// Returning failing grade 'F' character.

    } // End of calculateGrade method.

    void displayDetails() {
// Method declaration to display student details including calculated grade.

        System.out.println("\nStudent Report:");
// Printing a header line with newline for better readability.

        System.out.println("Name: " + name);
// Printing the student's name prefixed with "Name: " label.

        System.out.println("Roll Number: " + rollNumber);
// Printing the roll number prefixed with "Roll Number: " label.

        System.out.println("Marks: " + marks);
// Printing the marks prefixed with "Marks: " label.

        System.out.println("Grade: " + calculateGrade());
// Printing the calculated grade by calling calculateGrade() method.

    } // End of displayDetails method.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        Student s = new Student();
// Creating a new Student object instance named 's' using default constructor.

        System.out.print("Enter student name: ");
// Prompting the user to enter the student name.

        s.name = sc.nextLine();
// Reading a line of input (name) and assigning it to the object's name field.

        System.out.print("Enter roll number: ");
// Prompting the user to enter the roll number.

        s.rollNumber = sc.nextInt();
// Reading an integer input (roll number) and assigning it to the object's rollNumber field.

        System.out.print("Enter marks: ");
// Prompting the user to enter the marks.

        s.marks = sc.nextInt();
// Reading an integer input (marks) and assigning it to the object's marks field.

        s.displayDetails();
// Calling the displayDetails method on the 's' object to print report.

        sc.close(); // Closing the Scanner to prevent resource leak (good practice).
    } // End of main method.

} // End of Student class.
