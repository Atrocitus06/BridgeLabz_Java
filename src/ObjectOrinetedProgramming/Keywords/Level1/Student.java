package Object_Oriented_Programming.Keywords.Level1;
// Package declaration that places this class under the Keywords.Level1 package.

import java.util.Scanner;
// Importing the Scanner class to enable reading input from the console.

public class Student {
    // Public class representing a student with static and instance information.

    /* ---------- STATIC ---------- */

    static String universityName = "Global Tech University";
    // Static variable storing the name of the university shared by all Student objects.

    static int totalStudents = 0;
    // Static counter that keeps track of how many Student objects have been created.

    static void displayTotalStudents() {
        // Static method to display the total number of students enrolled.

        System.out.println("Total Students Enrolled: " + totalStudents);
        // Printing the current value of the static counter 'totalStudents'.
    }

    /* ---------- INSTANCE VARIABLES ---------- */

    String name;
    // Instance variable storing the name of the student.

    final int rollNumber;
    // Final instance variable storing the roll number, which cannot be changed after initialization.

    char grade;
    // Instance variable storing the student's grade, which can be updated later.

    /* ---------- CONSTRUCTOR (THIS) ---------- */

    Student(String name, int rollNumber, char grade) {
        // Constructor used to initialize a Student object with name, roll number, and grade.

        this.name = name;
        // Using 'this' to assign the constructor parameter to the instance variable 'name'.

        this.rollNumber = rollNumber;
        // Using 'this' to assign the constructor parameter to the final instance variable 'rollNumber'.

        this.grade = grade;
        // Using 'this' to assign the constructor parameter to the instance variable 'grade'.

        totalStudents++;
        // Incrementing the static students counter whenever a new Student object is created.
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */

    void manageStudent(Object obj, char newGrade) {
        // Instance method that prints student details and updates the grade if the object is a Student.

        if (obj instanceof Student) {
            // Checking whether the provided object is actually an instance of Student.

            System.out.println("\n--- Student Details ---");
            // Printing a header to indicate the start of the student details section.

            System.out.println("University : " + universityName);
            // Printing the static university name associated with all students.

            System.out.println("Name : " + name);
            // Printing this student's name.

            System.out.println("Roll No : " + rollNumber);
            // Printing this student's roll number.

            System.out.println("Grade : " + grade);
            // Printing the current grade of this student.

            // Update grade
            grade = newGrade;
            // Updating the student's grade to the new grade passed as a parameter.

            System.out.println("Updated Grade: " + grade);
            // Printing the updated grade to confirm the change.

        } else {
            // Executed if the given object is not an instance of Student.

            System.out.println("Object is not a Student");
            // Informing that the provided object is of a different type.
        }
        // End of instanceof check and grade management.
    }
    // End of manageStudent method.

    /* ---------- MAIN METHOD (SAME FILE) ---------- */

    public static void main(String[] args) {
        // Main method serving as the entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input from the console.

        System.out.print("Enter Student Name: ");
        // Prompting the user to enter the student's name.

        String name = sc.nextLine();
        // Reading the full line of text as the student's name.

        System.out.print("Enter Roll Number: ");
        // Prompting the user to enter the student's roll number.

        int roll = sc.nextInt();
        // Reading the roll number as an integer.

        System.out.print("Enter Grade: ");
        // Prompting the user to enter the student's grade.

        char grade = sc.next().charAt(0);
        // Reading a single character from the input as the student's grade.

        // Create Student object
        Student student = new Student(name, roll, grade);
        // Creating a new Student object using the data entered by the user.

        // Validate using instanceof and manage student
        student.manageStudent(student, 'A');
        // Passing the same Student object to manageStudent with a new grade to update and display details.

        // Display total students (static)
        Student.displayTotalStudents();
        // Calling the static method to display how many students have been enrolled.

        sc.close();
        // Closing the Scanner to release its system resources.
    }
    // End of main method.
}
// End of Student class.
