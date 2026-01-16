package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration aligns with CoreProgramming.ControlFlowPractices.Level1 for for-loop sum variant.

/*
SumOfNaturalNumbersForLoop
This class ported to for loop: identical logic/verification as while version but for(i=1<=n;i++) sum+=i.
Natural >0 check, formula N(N+1)/2, prints both sums + equality test.
Proves for/while equivalence for summation; compact for syntax.
Usage: Matches while: 6 -> loop=21, formula=21, "Both...equal."; invalid->"not natural".
*/

import java.util.Scanner;
// Imports Scanner for input validation.

public class SumOfNaturalNumbersForLoop {
    // Public class confirms for summation parity.

    public static void main(String[] args) {
        // For summation verifier.

        Scanner input = new Scanner(System.in);
        // Natural inputter.

        int n;
        // Shared limit.

        int sumByLoop = 0;
        // Accum starts zero.

        int sumByFormula;
        // Formula holder.

        System.out.print("Enter a natural number: ");
        // Consistent prompt.

        n = input.nextInt();
        // Candidate N.

        if (n > 0) {
            // Natural admission.

            // For loop: Clean 1 to N summation
            for (int i = 1; i <= n; i++) {
                // Init/test/step all-in-one.

                sumByLoop = sumByLoop + i;
                // Loop total builds.
            }

            sumByFormula = n * (n + 1) / 2;
            // Instant calc.

            System.out.println("Sum using for loop = " + sumByLoop);
            // Loop disclosure.

            System.out.println("Sum using formula = " + sumByFormula);
            // Formula parallel.

            if (sumByLoop == sumByFormula) {
                // Integrity assert.

                System.out.println("Both results are correct and equal.");
                // Validation pass.
            } else {
                System.out.println("The results are not equal.");
                // Theoretical fail.
            }
        } else {
            // Guard clause.

            System.out.println("The number " + n + " is not a natural number.");
            // Input fault.
        }
    }
    // Main loops closed.
}
// Class iterated.
