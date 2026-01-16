package core_programming.String.Level1;
/*
Write a program to demonstrate ArrayIndexOutOfBoundsException
Hint =>
Define a variable of array of names and take input from the user
Write a Method to generate the Exception. Here access index larger then the length of the array. This will generate a runtime exception and abruptly stop the program.
Write the Method to demonstrate ArrayIndexOutOfBoundsException. Here access index larger then the length of the array. This will generate a runtime exception. Use the try-catch block to handle the ArrayIndexOutOfBoundsException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/


import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    static void generateException(String[] names) {

        System.out.println(names[names.length]);
    }

    static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled successfully");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }


        System.out.println("Generating ArrayIndexOutOfBoundsException:");
        try {
            generateException(names);
        } catch (RuntimeException e) {
            System.out.println("Exception caught in main()");
        }

        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleException(names);

        sc.close();
    }
}
