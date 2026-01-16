package core_programming.String.Level1;
/*
Write a program to demonstrate NullPointerException.
Hint =>
Write a Method to generate the Exception. Here define the variable text and initialize it to null. Then call one of the String Method to generate the exception
Write the Method to demonstrate NullPointerException. Here define the variable text and initialize it to null. Then write try catch block for handling the Exception while accessing one of the String method
From the main Firstly call the method to generate the Exception then refactor the code to call the method to handle the RuntimeException
*/

public class NullPointerDemo {

    // Method to generate NullPointerException
    static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    // Method to handle NullPointerException
    static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled successfully");
        }
    }

    public static void main(String[] args) {

        System.out.println("Generating NullPointerException:");
        try {
            generateException();   // exception occurs
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main()");
        }

        System.out.println("\nHandling NullPointerException:");
        handleException();        // program continues normally
    }
}
