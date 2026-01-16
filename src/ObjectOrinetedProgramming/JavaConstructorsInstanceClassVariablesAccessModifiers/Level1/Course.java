package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Problem 2: Online Course Management

Design a Course class with:
Instance Variables: courseName, duration, fee.
Class Variable: instituteName (common for all courses).

Methods:
An instance method displayCourseDetails() to display the course details.
A class method updateInstituteName() to modify the institute name for all courses.
*/
// Block comment describing the problem statement and requirements.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Course {
    // Class representing an online course with instance and class variables.

    String courseName;
    // Instance variable to store the name of the course.

    int duration;
    // Instance variable to store the duration of the course in months.

    double fee;
    // Instance variable to store the fee for the course.

    static String instituteName = "Default Institute";
    // Static variable shared among all Course objects that stores the institute name.

    Course(String c, int d, double f) {
        // Constructor to initialize a Course object with course name, duration, and fee.

        courseName = c;
        // Assigning the constructor parameter 'c' to the instance variable 'courseName'.

        duration = d;
        // Assigning the constructor parameter 'd' to the instance variable 'duration'.

        fee = f;
        // Assigning the constructor parameter 'f' to the instance variable 'fee'.
    }

    void displayCourseDetails() {
        // Instance method to display all details of the course.

        System.out.println("Institute Name : " + instituteName);
        // Printing the static institute name shared by all courses.

        System.out.println("Course Name : " + courseName);
        // Printing the name of this course.

        System.out.println("Duration : " + duration + " months");
        // Printing the duration of the course in months.

        System.out.println("Fee : " + fee);
        // Printing the fee of the course.

        System.out.println();
        // Printing a blank line for better readability.
    }

    static void updateInstituteName(String newName) {
        // Static method to update the institute name for all Course objects.

        instituteName = newName;
        // Assigning the new institute name to the static variable 'instituteName'.
    }

    public static void main(String[] args) {
        // Main method: entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        System.out.print("Enter institute name: ");
        // Prompting the user to enter a new institute name.

        String instName = sc.nextLine();
        // Reading the full line as the institute name.

        Course.updateInstituteName(instName);
        // Updating the static institute name using the class method.

        System.out.print("Enter number of courses: ");
        // Prompting the user to enter how many courses will be created.

        int n = sc.nextInt();
        // Reading the number of courses as an integer.

        sc.nextLine();
        // Clearing the newline character left in the buffer after nextInt().

        Course[] courses = new Course[n];
        // Creating an array to store references to multiple Course objects.

        for (int i = 0; i < n; i++) {
            // Looping 'n' times to collect details for each course.

            System.out.println("\nEnter details for course " + (i + 1));
            // Indicating which course details are being entered (1-based index).

            System.out.print("Course Name: ");
            // Prompting the user to enter the course name.

            String name = sc.nextLine();
            // Reading the full line as the course name.

            System.out.print("Duration (in months): ");
            // Prompting the user to enter the course duration.

            int duration = sc.nextInt();
            // Reading the duration as an integer.

            System.out.print("Fee: ");
            // Prompting the user to enter the course fee.

            double fee = sc.nextDouble();
            // Reading the fee as a double.

            sc.nextLine();
            // Clearing the newline character left in the buffer after nextDouble().

            courses[i] = new Course(name, duration, fee);
            // Creating a new Course object with the entered details and storing it in the array.
        }

        System.out.println("\n--- Course Details ---");
        // Printing a header to indicate the beginning of the course details section.

        for (int i = 0; i < n; i++) {
            // Looping through each Course object in the array.

            courses[i].displayCourseDetails();
            // Displaying the details of each Course object.
        }

        sc.close();
        // Closing the Scanner to release system resources.
    }
    // End of main method.
}
// End of Course class.
