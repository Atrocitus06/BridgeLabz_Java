package CoreProgramming.Arrays.Level1;
// Package declaration organizes this class within CoreProgramming.Arrays.Level1 for basic array exercises.

/*
MultiplicationTableArray
This class generates and prints multiplication table (1-10) for user-provided integer.
Stores results in fixed-size int array using loop-based calculation.
Demonstrates array population via multiplication, indexing adjustment (1-based to 0-based), and formatted output.
Usage: Run main, enter number (e.g., 5), see table like "5 * 1 = 5" up to 10.
*/

import java.util.Scanner;
// Imports Scanner class for reading integer input from console.

public class MultiplicationTableArray {
    // Declares public class accessible externally for standalone execution.

    public static void main(String[] args) {
        // Defines static main method as program entry point for execution.

        Scanner input = new Scanner(System.in);
        // Instantiates Scanner object connected to standard input for user data.

        int number;
        // Declares int variable to hold user-entered multiplication base number.

        int[] table = new int[10];
        // Creates int array of size 10 to store table results (indices 0-9 for 1-10).

        System.out.print("Enter a number: ");
        // Prints prompt without newline for number input.

        number = input.nextInt();
        // Reads and assigns next integer input to 'number' variable.

        // Loop 1: Populate array with multiplication results 1 to 10
        for (int i = 1; i <= 10; i++) {
            // Initializes loop counter i from 1 to 10 inclusive for table rows.

            table[i - 1] = number * i;
            // Calculates product (number * i), stores at 0-based index (i-1).
        }

        System.out.println("\nMultiplication Table of " + number + ":");
        // Prints table header with newline and user number for clarity.

        // Loop 2: Print table entries in specified format
        for (int i = 1; i <= 10; i++) {
            // Reuses loop counter i from 1 to 10 for output order.

            System.out.println(number + " * " + i + " = " + table[i - 1]);
            // Outputs formatted line: base * multiplier = result from array.
        }
    }
    // Ends main method body.
}
// Closes class declaration.
