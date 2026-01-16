package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration scopes GreatestFactor to CoreProgramming.ControlFlowPractices.Level2 for divisor max.

/*
GreatestFactor
This class finds largest proper divisor (<N) of N>1: for i=N-1 downto >=1, first %==0 sets greatestFactor, breaks.
Validates >1 (primes>1 have 1, but 1/0 handled); efficient early stop first match.
Per hint: init1, reverse loop, assign/break on divide, print outside.
Usage: 12 -> "greatest...beside itself is 6"; prime 7->1; <=1->"greater than 1.".
*/

import java.util.Scanner;
// Imports Scanner for N input.

public class GreatestFactor {
    // Public class proper divisor hunter.

    public static void main(String[] args) {
        // Largest-below-N seeker.

        Scanner input = new Scanner(System.in);
        // Value intake.

        int number;
        // Divid end target.

        int greatestFactor = 1;
        // Default/min proper (self excluded).

        System.out.print("Enter a positive integer: ");
        // Candidate call.

        number = input.nextInt();
        // Loads N.

        if (number > 1) {
            // Enables search (>1).

            // For: Reverse high-to-low first match
            for (int i = number - 1; i >= 1; i--) {
                // N-1 downto 1 inclusive.

                if (number % i == 0) {
                    // Largest divisor hit.

                    greatestFactor = i;
                    // Records max proper.

                    break;
                    // Early termination.
                }
            }

            System.out.println(
                    "The greatest factor of " + number + " beside itself is " + greatestFactor
            );
            // Precise phrase.
        } else {
            // Edge reject.

            System.out.println("Please enter an integer greater than 1.");
        }
    }
    // Main factored max.
}
// Class divides tops.
