package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

public class EmployeeTest {
// Public class declaration for EmployeeTest demonstrating multiple parallel inheritance branches.

    public static void main(String[] args) {
// Main method: entry point of the program where polymorphism with subclasses is demonstrated.

        Employee e1 = new Manager("Amit", 101, 50000, 5);
// Creating Manager object referenced by superclass Employee type (polymorphism).

        Employee e2 = new Developer("Riya", 102, 40000, "Java");
// Creating Developer object referenced by superclass Employee type (polymorphism).

        Employee e3 = new Intern("Karan", 103, 15000, 6);
// Creating Intern object referenced by superclass Employee type (polymorphism).

        e1.displayDetails();
// Calling overridden displayDetails() on e1; Manager version executes.

        e2.displayDetails();
// Calling overridden displayDetails() on e2; Developer version executes.

        e3.displayDetails();
// Calling overridden displayDetails() on e3; Intern version executes.

    } // End of main method.

    class Employee {
// Inner class declaration for Employee as the superclass/base class for all employee types.

        String name;
// Instance variable to store employee name.

        int id;
// Instance variable to store employee ID.

        double salary;
// Instance variable to store salary as double for precision.

        Employee(String name, int id, double salary) {
// Constructor declaration that initializes common employee fields.

            this.name = name;
// Assigning parameter to instance variable (distinguished by 'this').

            this.id = id;
// Assigning parameter to instance variable (distinguished by 'this').

            this.salary = salary;
// Assigning parameter to instance variable (distinguished by 'this').

        } // End of Employee constructor.

        void displayDetails() {
// Method declaration providing basic employee information display.

            System.out.println("Name: " + name);
// Printing name with label.

            System.out.println("ID: " + id);
// Printing ID with label.

            System.out.println("Salary: " + salary);
// Printing salary with label.

        } // End of displayDetails method in superclass.

    } // End of Employee superclass.

    // Manager subclass
    class Manager extends Employee {
// Inner class declaration for Manager subclass inheriting from Employee.

        int teamSize;
// Subclass-specific instance variable for managed team size.

        Manager(String name, int id, double salary, int teamSize) {
// Constructor chaining to superclass plus subclass initialization.

            super(name, id, salary);
// Calling superclass Employee constructor with common parameters.

            this.teamSize = teamSize;
// Assigning parameter to subclass instance variable.

        } // End of Manager constructor.

        void displayDetails() {
// Overriding superclass displayDetails() to include manager-specific info.

            super.displayDetails();
// Calling superclass Employee's displayDetails() first.

            System.out.println("Team Size: " + teamSize);
// Printing team size detail.

            System.out.println();
// Printing blank line after manager details.

        } // End of overridden displayDetails in Manager.

    } // End of Manager subclass.

    // Developer subclass
    class Developer extends Employee {
// Inner class declaration for Developer subclass inheriting from Employee.

        String programmingLanguage;
// Subclass-specific instance variable for primary language.

        Developer(String name, int id, double salary, String programmingLanguage) {
// Constructor chaining to superclass plus subclass initialization.

            super(name, id, salary);
// Calling superclass Employee constructor with common parameters.

            this.programmingLanguage = programmingLanguage;
// Assigning parameter to subclass instance variable.

        } // End of Developer constructor.

        void displayDetails() {
// Overriding superclass displayDetails() to include developer-specific info.

            super.displayDetails();
// Calling superclass Employee's displayDetails() first.

            System.out.println("Programming Language: " + programmingLanguage);
// Printing programming language detail.

            System.out.println();
// Printing blank line after developer details.

        } // End of overridden displayDetails in Developer.

    } // End of Developer subclass.

    // Intern subclass
    class Intern extends Employee {
// Inner class declaration for Intern subclass inheriting from Employee.

        int duration;
// Subclass-specific instance variable for internship length.

        Intern(String name, int id, double salary, int duration) {
// Constructor chaining to superclass plus subclass initialization.

            super(name, id, salary);
// Calling superclass Employee constructor with common parameters.

            this.duration = duration;
// Assigning parameter to subclass instance variable.

        } // End of Intern constructor.

        void displayDetails() {
// Overriding superclass displayDetails() to include intern-specific info.

            super.displayDetails();
// Calling superclass Employee's displayDetails() first.

            System.out.println("Internship Duration: " + duration + " months");
// Printing duration with unit.

            System.out.println();
// Printing blank line after intern details.

        } // End of overridden displayDetails in Intern.

    } // End of Intern subclass.

} // End of EmployeeTest class.
