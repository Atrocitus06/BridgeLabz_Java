package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration scopes to CoreProgramming.ControlFlowPractices.Level1 for accumulative summing.

/*
SumUntilZero
This class sums doubles until sentinel 0 input using while(number != 0).
total=0.0 init, loop adds non-zero then re-prompts; prints final sum post-loop.
Matches hint: double total/number, while !0 add+reask, display outside.
Usage: 1.5 Enter, 2.3 Enter, 0 Enter -> "The total sum is 3.8".
*/

import java.util.Scanner;
// Imports Scanner for repeated double reads.

public class SumUntilZero {
    // Public class running summer.

    public static void main(String[] args) {
        // Accumulator engine.

        Scanner input = new Scanner(System.in);
        // Perpetual input source.

        double total = 0.0;
        // Precise sum holder init zero.

        double number;
        // Current addend.

        System.out.print("Enter a number (0 to stop): ");
        // Initial guided prompt.

        number = input.nextDouble();
        // First candidate.

        // While: Sentinel-terminated accumulation
        while (number != 0) {
            // Non-zero continue.

            total = total + number;
            // Appends to running total.

            System.out.print("Enter a number (0 to stop): ");
            // Reprompt loop.

            number = input.nextDouble();
            // Next input.
        }

        System.out.println("The total sum is " + total);
        // Final reveal post-zero.
    }
    // Main tallies complete.
}
// Class balances.
