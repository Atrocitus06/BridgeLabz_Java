package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

// Main class
public class RestaurantTest {
// Public class declaration for RestaurantTest demonstrating hybrid inheritance with interface.

    public static void main(String[] args) {
// Main method: entry point of the program showing polymorphism via interface references.

        Worker chef = new Chef("Rahul", 30, 101);
// Creating Chef object referenced by Worker interface type (polymorphism).

        Worker waiter = new Waiter("Amit", 25, 102);
// Creating Waiter object referenced by Worker interface type (polymorphism).

        chef.performDuties();
// Calling performDuties() on chef; Chef's implementation executes.

        waiter.performDuties();
// Calling performDuties() on waiter; Waiter's implementation executes.

    } // End of main method.

    // Superclass
    class EmployeeBase {
// Inner class declaration for EmployeeBase as common superclass for restaurant staff.

        String name;
// Instance variable to store employee name.

        int age;
// Instance variable to store employee age.

        EmployeeBase(String name, int age) {
// Constructor declaration initializing common employee fields.

            this.name = name;
// Assigning parameter to instance variable (distinguished by 'this').

            this.age = age;
// Assigning parameter to instance variable (distinguished by 'this').

        } // End of EmployeeBase constructor.

        void displayDetails() {
// Method declaration for displaying basic employee info (unused in demo).

            System.out.println("Name: " + name);
// Printing name.

            System.out.println("Age: " + age);
// Printing age.

        } // End of displayDetails method.

    } // End of EmployeeBase superclass.

    // Interface
    interface Worker {
// Interface declaration defining work contract for restaurant roles.

        void performDuties();
// Abstract method that all Worker implementations must provide.

    } // End of Worker interface.

    // Chef class
    class Chef extends EmployeeBase implements Worker {
// Inner class declaration for Chef using hybrid inheritance (extends superclass + implements interface).

        int id;
// Instance-specific variable for chef ID.

        Chef(String name, int age, int id) {
// Constructor chaining to superclass plus ID initialization.

            super(name, age);
// Calling superclass EmployeeBase constructor.

            this.id = id;
// Assigning parameter to instance variable.

        } // End of Chef constructor.

        public void performDuties() {
// Implementing Worker interface's performDuties() method (public required).

            System.out.println("Chef " + name + " is cooking food.");
// Printing Chef-specific duty description using name.

        } // End of implemented performDuties in Chef.

    } // End of Chef class.

    // Waiter class
    class Waiter extends EmployeeBase implements Worker {
// Inner class declaration for Waiter using hybrid inheritance (extends superclass + implements interface).

        int id;
// Instance-specific variable for waiter ID.

        Waiter(String name, int age, int id) {
// Constructor chaining to superclass plus ID initialization.

            super(name, age);
// Calling superclass EmployeeBase constructor.

            this.id = id;
// Assigning parameter to instance variable.

        } // End of Waiter constructor.

        public void performDuties() {
// Implementing Worker interface's performDuties() method (public required).

            System.out.println("Waiter " + name + " is serving customers.");
// Printing Waiter-specific duty description using name.

        } // End of implemented performDuties in Waiter.

    } // End of Waiter class.

} // End of RestaurantTest class.
