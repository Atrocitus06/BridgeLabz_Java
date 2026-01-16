package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration aligns with CoreProgramming.ControlFlowPractices.Level1 for while-based factorial.

/*
FactorialNumber
This class computes factorial via while loop for non-negative integers (0!=1).
Validates input (>=0), initializes factorial=1/i=1, loops i<=number multiplying.
Matches hint: user int input, positive check, while compute, print result/error.
Usage: 0->"The factorial of 0 is 1"; 4->24; negative->"Please enter a positive integer.".
*/

import java.util.Scanner;
// Imports Scanner parsing integer input.

public class FactorialNumber {
    // Public class implements while factorial.

    public static void main(String[] args) {
        // Begins computation.

        Scanner input = new Scanner(System.in);
        // Console integer reader.

        int number;
        // User-supplied N.

        int factorial = 1;
        // Accumulator starts at identity.

        System.out.print("Enter a positive integer: ");
        // Specific prompt.

        number = input.nextInt();
        // Assigns input value.

        if (number >= 0) {
            // Includes 0 as valid (per math).

            int i = 1;
            // Loop counter init.

            while (i <= number) {
                // Continues to inclusive N.

                factorial = factorial * i;
                // *= current i.

                i++;
                // Advances multiplier.
            }

            System.out.println(
                    "The factorial of " + number + " is " + factorial
            );
            // Precise result phrase.
        } else {
            // Invalid input handler.

            System.out.println(
                    "Please enter a positive integer."
            );
            // Echoes prompt correction.
        }
    }
    // Main wraps.
}
// Class seals.
