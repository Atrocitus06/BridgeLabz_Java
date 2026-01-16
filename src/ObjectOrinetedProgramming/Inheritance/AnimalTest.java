package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

public class AnimalTest {
// Public class declaration for AnimalTest as the main demonstration class for inheritance.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins and polymorphism is demonstrated.

        Animal a1 = new Dog();
// Creating a Dog object but referencing it with superclass Animal type (polymorphism).

        Animal a2 = new Cat();
// Creating a Cat object but referencing it with superclass Animal type (polymorphism).

        Animal a3 = new Bird();
// Creating a Bird object but referencing it with superclass Animal type (polymorphism).

        a1.makeSound();
// Calling makeSound() on a1; Dog's overridden version executes due to dynamic binding.

        a2.makeSound();
// Calling makeSound() on a2; Cat's overridden version executes due to dynamic binding.

        a3.makeSound();
// Calling makeSound() on a3; Bird's overridden version executes due to dynamic binding.

    } // End of main method.

    // Superclass
    class Animal {
// Inner class declaration for Animal as the superclass/base class.

        String name;
// Instance variable to store the animal's name (though unused in this demo).

        int age;
// Instance variable to store the animal's age (though unused in this demo).

        void makeSound() {
// Method declaration providing default sound behavior for any Animal.

            System.out.println("Animal makes a sound");
// Printing generic animal sound message.

        } // End of makeSound method in superclass.

    } // End of Animal superclass.

    // Subclass Dog
    class Dog extends Animal {
// Inner class declaration for Dog subclass that inherits from Animal superclass.

        void makeSound() {
// Overriding superclass makeSound() method with Dog-specific behavior.

            System.out.println("Dog barks");
// Printing Dog-specific sound instead of generic animal sound.

        } // End of overridden makeSound method in Dog subclass.

    } // End of Dog subclass.

    // Subclass Cat
    class Cat extends Animal {
// Inner class declaration for Cat subclass that inherits from Animal superclass.

        void makeSound() {
// Overriding superclass makeSound() method with Cat-specific behavior.

            System.out.println("Cat meows");
// Printing Cat-specific sound instead of generic animal sound.

        } // End of overridden makeSound method in Cat subclass.

    } // End of Cat subclass.

    // Subclass Bird
    class Bird extends Animal {
// Inner class declaration for Bird subclass that inherits from Animal superclass.

        void makeSound() {
// Overriding superclass makeSound() method with Bird-specific behavior.

            System.out.println("Bird chirps");
// Printing Bird-specific sound instead of generic animal sound.

        } // End of overridden makeSound method in Bird subclass.

    } // End of Bird subclass.

} // End of AnimalTest class.
