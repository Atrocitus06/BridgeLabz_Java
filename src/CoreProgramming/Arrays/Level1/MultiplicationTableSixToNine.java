package CoreProgramming.Arrays.Level1;
// Package declaration organizes this class within CoreProgramming.Arrays.Level1 for targeted array exercises.

/*
MultiplicationTableSixToNine
This class generates multiplication table for user integer from 6 to 9 only.
Uses size-4 int array, index tracker for filling/printing via loops.
Shows array storage for subset range (6-9), manual indexing, and formatted display.
Usage: Execute main, input number (e.g., 7), outputs "7 * 6 = 42" through "7 * 9 = 63".
*/

import java.util.Scanner;
// Imports Scanner for capturing integer input from standard input.

public class MultiplicationTableSixToNine {
    // Declares public class for external access and direct compilation/run.

    public static void main(String[] args) {
        // Establishes static main as starting execution point.

        Scanner input = new Scanner(System.in);
        // Creates Scanner instance linked to console for input reading.

        int number;
        // Declares variable to store base number for multiplication.

        int[] multiplicationResult = new int[4]; // for 6,7,8,9
        // Allocates int array of length 4 to hold results for multipliers 6-9.

        System.out.print("Enter a number: ");
        // Displays input prompt on same line without trailing newline.

        number = input.nextInt();
        // Captures and stores next available integer as 'number'.

        int index = 0;
        // Initializes array index tracker starting at 0 for sequential filling.

        // Loop 1: Compute and store results for 6 to 9
        for (int i = 6; i <= 9; i++) {
            // Loops i over multipliers 6,7,8,9 inclusive.

            multiplicationResult[index] = number * i;
            // Multiplies number by i, saves product at current index position.

            index++;
            // Increments index to point to next array slot.
        }

        System.out.println("\nMultiplication Table of " + number + " from 6 to 9:");
        // Prints header with newline, number, and range descriptor.

        index = 0;
        // Resets index tracker to 0 for output traversal.

        // Loop 2: Display stored results in format
        for (int i = 6; i <= 9; i++) {
            // Reiterates i over 6-9 to match output order.

            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            // Prints line in exact format: number * i = array_value.

            index++;
            // Advances index for next result retrieval.
        }
    }
    // Terminates main method.
}
// Concludes class definition.
