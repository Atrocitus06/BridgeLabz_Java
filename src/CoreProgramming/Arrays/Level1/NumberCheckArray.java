package CoreProgramming.Arrays.Level1;
// Package declaration places this class in CoreProgramming.Arrays.Level1 namespace for foundational array tasks.

/*
NumberCheckArray
This class processes 5 user integers: classifies each as positive(even/odd), negative, or zero; then compares first/last elements.
Uses fixed-size int array, nested conditionals for sign/parity, final relational check.
Illustrates array input loop, element-wise analysis, edge indexing (0 and length-1).
Usage: Run, enter 5 numbers sequentially; see classifications and first-last comparison.
*/

import java.util.Scanner;
// Imports Scanner utility to handle integer inputs from console.

public class NumberCheckArray {
    // Public class declaration enables access and standalone execution.

    public static void main(String[] args) {
        // Static main method serves as program entry and execution start.

        Scanner input = new Scanner(System.in);
        // Initializes Scanner for reading from standard input stream.

        int[] numbers = new int[5];
        // Declares and allocates int array with exactly 5 slots for user numbers.

        // Loop 1: Collect 5 numbers into array
        for (int i = 0; i < numbers.length; i++) {
            // Iterates i from 0 to 4 using array length for bounds.

            System.out.print("Enter number " + (i + 1) + ": ");
            // Prompts with 1-based position (i+1) on same line.

            numbers[i] = input.nextInt();
            // Reads next int, stores at current array index i.
        }

        System.out.println("\nNumber Analysis:");
        // Outputs section header with leading newline for readability.

        // Loop 2: Analyze and classify each number
        for (int i = 0; i < numbers.length; i++) {
            // Traverses array indices 0 through 4 again.

            int num = numbers[i];
            // Extracts current array element into local variable for checks.

            if (num > 0) {
                // Tests if number is positive (greater than zero).

                if (num % 2 == 0) {
                    // Nested check: positive number even (divisible by 2 with no remainder).

                    System.out.println(num + " is a positive even number");
                    // Prints classification for positive even case.
                } else {
                    // Handles positive but odd (non-zero remainder on %2).

                    System.out.println(num + " is a positive odd number");
                    // Prints classification for positive odd case.
                }
            } else if (num < 0) {
                // Checks for negative numbers (less than zero).

                System.out.println(num + " is a negative number");
                // Prints negative classification.
            } else {
                // Catches zero case (neither >0 nor <0).

                System.out.println(num + " is zero");
                // Prints zero classification.
            }
        }

        int first = numbers[0];
        // Captures first element at index 0 for comparison.

        int last = numbers[numbers.length - 1];
        // Retrieves last element using length-1 formula for end index.

        System.out.println("\nComparison of first and last elements:");
        // Prints comparison section header with newline.

        if (first == last) {
            // Equality check between first and last values.

            System.out.println("First and last elements are equal");
            // Outputs equal result message.
        } else if (first > last) {
            // Greater-than test if first exceeds last.

            System.out.println("First element is greater than last element");
            // Outputs first-greater message.
        } else {
            // Default: first less than last.

            System.out.println("First element is less than last element");
            // Outputs first-lesser message.
        }
    }
    // Closes main method scope.
}
// Ends class body.
