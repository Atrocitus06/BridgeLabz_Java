package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration targets CoreProgramming.ControlFlowPractices.Level1 for break-controlled summing.

/*
SumUntilZeroOrNegative
This class sums positives using infinite while(true) until <=0 sentinel, breaking on check.
total doubles accumulate non-<=0 inputs post-prompt/parse; final sum print.
Per hint: while(true), input, if<=0 break, else add; contrasts prior no-neg handling.
Usage: 4.2, -1.0 -> sums 4.2 "The total sum is 4.2"; initial 0 skips add.
*/

import java.util.Scanner;
// Imports Scanner for conditional double inputs.

public class SumUntilZeroOrNegative {
    // Public class with early-break accumulation.

    public static void main(String[] args) {
        // Breakable summer start.

        Scanner input = new Scanner(System.in);
        // Loop input engine.

        double total = 0.0;
        // Running precise total.

        double number;
        // Transient input.

        // Infinite while with sentinel break
        while (true) {
            // Unconditional loop entry.

            System.out.print("Enter a number (0 or negative to stop): ");
            // Sentinel-clued prompt.

            number = input.nextDouble();
            // Awaits decision value.

            if (number <= 0) {
                // Dual stop: zero or negative.

                break;
                // Immediate loop exit.
            }

            total = total + number;
            // Validates/adds positive.
        }

        System.out.println("The total sum is " + total);
        // Post-break disclosure.
    }
    // Main interrupted successfully.
}
// Class breaks even.
