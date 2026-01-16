package ObjectOrientedProgramming.Inheritance;
// Package declaration that organizes this class within the ObjectOrientedProgramming.Inheritance namespace.

import java.util.Scanner;
// Importing Scanner to read user input from the console.

public class SchoolTest {
// Public class declaration for the main test driver class demonstrating multiple inheritance examples.

    public static void main(String[] args) {
    // Main method: entry point of the program where execution begins.

    Scanner sc = new Scanner(System.in);
    // Creating a Scanner object to read input from System.in (keyboard).

    System.out.println("Enter Teacher Details:");
    // Printing a header for teacher input section.

    System.out.print("Name: ");
    // Prompting for teacher name.

    String tName = sc.nextLine();
    // Reading teacher name as string.

    System.out.print("Age: ");
    // Prompting for teacher age.

    int tAge = sc.nextInt();
    // Reading teacher age as integer.

    sc.nextLine();
    // Consuming newline after int input.

    System.out.print("Subject: ");
    // Prompting for teacher subject.

    String subject = sc.nextLine();
    // Reading teacher subject as string.

    Teacher teacher = new Teacher(tName, tAge, subject);
    // Creating Teacher object with input values.

    System.out.println(teacher.displayRole());
    // Calling and printing the role from teacher object.

    teacher.displayDetails();
    // Calling displayDetails on teacher.

    System.out.println("------------------");
    // Separator line between sections.

    System.out.println("Enter Student Details:");
    // Header for student input.

    System.out.print("Name: ");
    // Prompting for student name.

    String sName = sc.nextLine();
    // Reading student name.

    System.out.print("Age: ");
    // Prompting for student age.

    int sAge = sc.nextInt();
    // Reading student age.

    sc.nextLine();
    // Consuming newline.

    System.out.print("Grade: ");
    // Prompting for student grade.

    String grade = sc.nextLine();
    // Reading student grade.

    Student student = new Student(sName, sAge, grade);
    // Creating Student object.

    System.out.println(student.displayRole());
    // Printing student role.

    student.displayDetails();
    // Calling student details display.

    System.out.println("------------------");
    // Separator.

    System.out.println("Enter Staff Details:");
    // Header for staff input.

    System.out.print("Name: ");
    // Prompting staff name.

    String stName = sc.nextLine();
    // Reading staff name.

    System.out.print("Age: ");
    // Prompting staff age.

    int stAge = sc.nextInt();
    // Reading staff age.

    sc.nextLine();
    // Consuming newline.

    System.out.print("Department: ");
    // Prompting department.

    String department = sc.nextLine();
    // Reading department.

    Staff staff = new Staff(stName, stAge, department);
    // Creating Staff object.

    System.out.println(staff.displayRole());
    // Printing staff role.

    staff.displayDetails();
    // Calling staff details.

    sc.close();
    // Closing scanner.

    // ===== Superclass =====
    // Section for Person superclass.

    }
    // End main.
}

// ===== Superclass =====
static class Person {
    // Base Person class for common attributes.

    String name;
    // Field for person's name.

    int age;
    // Field for person's age.

    Person(String name, int age) {
        // Constructor initializing name and age.

        this.name = name;
        // Setting name field.

        this.age = age;
        // Setting age field.

    }

    void displayDetails() {
        // Method to show name and age.

        System.out.println("Name: " + name);
        // Printing name.

        System.out.println("Age: " + age);
        // Printing age.

    }
}
// End Person.

// ===== Teacher subclass =====
static class Teacher extends Person {
    // Teacher subclass extending Person.

    String subject;
    // Subject taught by teacher.

    Teacher(String name, int age, String subject) {
        // Constructor calling super and setting subject.

        super(name, age);
        // Superclass constructor call.

        this.subject = subject;
        // Setting subject.

    }

    String displayRole() {
        // Method returning teacher's role.

        return "Role: Teacher";
        // Returning role string.

    }
}
// End Teacher.

// ===== Student subclass =====
static class Student extends Person {
    // Student subclass.

    String grade;
    // Student's grade level.

    Student(String name, int age, String grade) {
        // Constructor.

        super(name, age);
        // Super call.

        this.grade = grade;
        // Setting grade.

    }

    String displayRole() {
        // Role method.

        return "Role: Student";
        // Student role.

    }
}
// End Student.

// ===== Staff subclass =====
static class Staff extends Person {
    // Staff subclass.

    String department;
    // Department field.

    Staff(String name, int age, String department) {
        // Constructor.

        super(name, age);
        // Super.

        this.department = department;
        // Setting department.

    }

    String displayRole() {
        // Role.

        return "Role: Staff";
        // Staff role.

    }
// End Staff.

}
// End SchoolTest.
