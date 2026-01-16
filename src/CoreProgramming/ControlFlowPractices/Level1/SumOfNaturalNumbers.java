package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration matches CoreProgramming.ControlFlowPractices.Level1 for sum formula application.

/*
SumOfNaturalNumbers
This class computes sum 1+2+...+N = N*(N+1)/2 for positive integers only (>0).
If validates natural, applies Gauss formula (int div truncates); exact O/P phrasing.
Excludes 0 despite hint mention; error for <=0 with number echo.
Usage: 5 -> "The sum of 5 natural numbers is 15"; 0 -> "The number 0 is not a natural number".
*/

import java.util.Scanner;
// Imports Scanner for single int input.

public class SumOfNaturalNumbers {
    // Public class leverages arithmetic series.

    public static void main(String[] args) {
        // Formula applicator start.

        Scanner input = new Scanner(System.in);
        // Input reader.

        int number;
        // N for summation.

        int sum;
        // Formula result holder.

        System.out.print("Enter a number: ");
        // Neutral prompt.

        number = input.nextInt();
        // Receives candidate.

        if (number > 0) {
            // Strict positive natural filter.

            sum = number * (number + 1) / 2;
            // Gauss: N(N+1)/2 integer math.

            System.out.println(
                    "The sum of " + number + " natural numbers is " + sum
            );
            // Template-filled success.
        } else {
            // Non-positive rejection.

            System.out.println(
                    "The number " + number + " is not a natural number"
            );
            // Personalized invalidation.
        }
    }
    // Main sums up.
}
// Class totals.
