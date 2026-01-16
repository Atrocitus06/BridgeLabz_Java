package ObjectOrientedProgramming.JavaConstructorsInstanceClassVariablesAccessModifiers.Level1;
// Package declaration that organizes this class within the Constructors/AccessModifiers Level1 module.

/*
Create a Person class with a copy constructor that clones another person's attributes.
*/
// Comment describing the exercise: demonstrates use of a copy constructor.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

class Person {
    // Class representing a person with name and age, including a copy constructor.

    String name;
    // Instance variable to store the person's name.

    int age;
    // Instance variable to store the person's age.

    Person(String n, int a) {
        // Parameterized constructor to initialize a Person object with a name and age.

        name = n;
        // Assigning the constructor parameter 'n' to the instance variable 'name'.

        age = a;
        // Assigning the constructor parameter 'a' to the instance variable 'age'.
    }

    Person(Person p) {
        // Copy constructor that initializes this Person using another Person object's attributes.

        name = p.name;
        // Copying the 'name' field from the given Person object 'p'.

        age = p.age;
        // Copying the 'age' field from the given Person object 'p'.
    }

    void display() {
        // Instance method to display the details of the person.

        System.out.println("Name: " + name);
        // Printing the person's name.

        System.out.println("Age : " + age);
        // Printing the person's age.

        System.out.println();
        // Printing a blank line for better readability.
    }

    public static void main(String[] args) {
        // Main method: entry point of the program.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object to read user input.

        System.out.print("Enter name: ");
        // Prompting the user to enter a name.

        String name = sc.nextLine();
        // Reading the full line as the person's name.

        System.out.print("Enter age: ");
        // Prompting the user to enter an age.

        int age = sc.nextInt();
        // Reading the age as an integer value.

        Person p1 = new Person(name, age);
        // Creating the original Person object using the entered data.

        Person p2 = new Person(p1);
        // Creating a second Person object by copying the attributes of p1.

        System.out.println("\nOriginal Person:");
        // Printing a header for the original person's details.

        p1.display();
        // Displaying the details of the original Person object.

        System.out.println("Copied Person:");
        // Printing a header for the copied person's details.

        p2.display();
        // Displaying the details of the copied Person object.

        sc.close();
        // Closing the Scanner to release resources.
    }
    // End of main method.
}
// End of Person class.
