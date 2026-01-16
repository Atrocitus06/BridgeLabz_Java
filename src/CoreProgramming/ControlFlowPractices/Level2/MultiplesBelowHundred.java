package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration positions MultiplesBelowHundred in CoreProgramming.ControlFlowPractices.Level2 for reverse multiples.

/*
MultiplesBelowHundred
This class lists all multiples of number (0<number<100) from 99 down to number: for i=100>=1 --, if i%number==0 print i.
Validates range pre-loop; descending per hint (backward for); header lists below 100.
Efficient % check each i; 100%number==0 always if valid.
Usage: 7 -> Multiples...\n98\n91\n...7; invalid->"Please enter...".
*/

import java.util.Scanner;
// Imports Scanner range-checked input.

public class MultiplesBelowHundred {
    // Public class descending multiples enumerator.

    public static void main(String[] args) {
        // Reverse multiples generator.

        Scanner input = new Scanner(System.in);
        // Bounded input.

        int number;
        // Multiplier base.

        System.out.print("Enter a positive number less than 100: ");
        // Range hint prompt.

        number = input.nextInt();
        // Candidate.

        if (number > 0 && number < 100) {
            // Strict open interval (1-99).

            System.out.println("Multiples of " + number + " below 100 are:");
            // Descriptive head.

            // For: Backward scan 100 to 1
            for (int i = 100; i >= 1; i--) {
                // High-to-low inclusive 1.

                if (i % number == 0) {
                    // i divisible by number.

                    System.out.println(i);
                    // Each multiple alone.
                }
            }
        } else {
            // Out-of-range.

            System.out.println("Please enter a positive integer less than 100.");
            // Echoes constraint.
        }
    }
    // Main multiplied down.
}
// Class ranges covered.
