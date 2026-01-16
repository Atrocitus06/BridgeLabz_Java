package core_programming.String.Level1;
/*
Write a program to demonstrate StringIndexOutOfBoundsException
Hint =>
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Access the index using charAt() beyond the length of the String. This will generate a runtime exception and abruptly stop the program.
Write the Method to demonstrate StringIndexOutOfBoundsException. Access the index using charAt() beyond the length of the String. Then write try catch block for Exception while accessing the String method
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/


import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    static void generateException(String text) {

        System.out.println(text.charAt(text.length()));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled successfully");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("Generating StringIndexOutOfBoundsException:");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main()");
        }

        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleException(text);

        sc.close();
    }
}
