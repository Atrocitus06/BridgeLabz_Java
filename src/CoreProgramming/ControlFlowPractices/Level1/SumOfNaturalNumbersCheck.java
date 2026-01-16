package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration sets CoreProgramming.ControlFlowPractices.Level1 for dual sum verification.

/*
SumOfNaturalNumbersCheck
This class validates Gauss formula vs while loop sum for N>0 naturals: loop 1+=i, formula N(N+1)/2.
If natural, computes/prints both sums, compares ==, confirms equal or not.
Demonstrates equivalence, loop accum vs closed-form, equality check.
Usage: 10 -> loop=55, formula=55, "Both...equal."; <=0 -> "not a natural".
*/

import java.util.Scanner;
// Imports Scanner for N input.

public class SumOfNaturalNumbersCheck {
    // Public class cross-verifies summation methods.

    public static void main(String[] args) {
        // Verification engine.

        Scanner input = new Scanner(System.in);
        // Natural candidate reader.

        int n;
        // Upper limit.

        int sumByLoop = 0;
        // Iterative accumulator.

        int sumByFormula;
        // Formula result.

        System.out.print("Enter a natural number: ");
        // Qualified prompt.

        n = input.nextInt();
        // Input parse.

        if (n > 0) {
            // Natural (>0) gate.

            int i = 1;
            // Loop starts at 1.

            while (i <= n) {
                // Inclusive to N.

                sumByLoop = sumByLoop + i;
                // Progressive addition.

                i++;
                // Counter advance.
            }

            sumByFormula = n * (n + 1) / 2;
            // Direct Gauss computation.

            System.out.println("Sum using while loop = " + sumByLoop);
            // Loop method report.

            System.out.println("Sum using formula = " + sumByFormula);
            // Closed-form show.

            if (sumByLoop == sumByFormula) {
                // Mathematical proof check.

                System.out.println("Both results are correct and equal.");
                // Affirmation.
            } else {
                System.out.println("The results are not equal.");
                // Anomaly (impossible).
            }
        } else {
            // Invalid input.

            System.out.println("The number " + n + " is not a natural number.");
            // Echoed rejection.
        }
    }
    // Main validated.
}
// Class certified.
