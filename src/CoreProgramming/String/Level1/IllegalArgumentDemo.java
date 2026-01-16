package core_programming.String.Level1;
/*
Write a program to demonstrate IllegalArgumentException
Hint =>
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Here use the subString() and set the start index to be greater than the end index. This will generate a runtime exception and abruptly stop the program.
Write the Method to demonstrate IllegalArgumentException. Here use the subString() and set the start index to be greater than the end index. This will generate a runtime exception. Use the try-catch block to handle the IllegalArgumentException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/


import java.util.Scanner;

public class IllegalArgumentDemo {

    static void generateException(String text) {

        System.out.println(text.substring(5, 2));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled successfully");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("Generating IllegalArgumentException:");
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception caught in main()");
        }

        System.out.println("\nHandling IllegalArgumentException:");
        handleException(text);

        sc.close();
    }
}
