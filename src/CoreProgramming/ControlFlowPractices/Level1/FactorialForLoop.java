package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration fits CoreProgramming.ControlFlowPractices.Level1 for iterative factorial.

/*
FactorialForLoop
This class computes N! for natural number (>=0) using for loop product accumulation.
Validates input post-read (number >=0), initializes factorial=1, multiplies 1 to N inclusive.
For loop replaces while; prints result or error; handles 0!=1 correctly.
Usage: 5 -> "The factorial of 5 is 120"; -3 -> "Please enter a natural number.".
*/

import java.util.Scanner;
// Imports Scanner for natural number input.

public class FactorialForLoop {
    // Public class calculates factorial iteratively.

    public static void main(String[] args) {
        // Launches factorial routine.

        Scanner input = new Scanner(System.in);
        // Input mechanism.

        int number;
        // Input operand.

        int factorial = 1;
        // Product init (multiplicative identity).

        System.out.print("Enter a natural number: ");
        // Guided prompt.

        number = input.nextInt();
        // Parses candidate N.

        if (number >= 0) {
            // Natural incl. zero validation.

            // For loop: Iterative multiplication 1 to N
            for (int i = 1; i <= number; i++) {
                // i from 1 to inclusive N.

                factorial = factorial * i;
                // Running *= i.
            }

            System.out.println(
                    "The factorial of " + number + " is " + factorial
            );
            // Formatted exact output.
        } else {
            // Negative rejection.

            System.out.println(
                    "Please enter a natural number."
            );
            // Standard correction.
        }
    }
    // Main termination.
}
// Class complete.
