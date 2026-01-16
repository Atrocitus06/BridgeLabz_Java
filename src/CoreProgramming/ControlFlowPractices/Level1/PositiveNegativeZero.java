package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration belongs in CoreProgramming.ControlFlowPractices.Level1 for sign classification.

/*
PositiveNegativeZero
This class categorizes integer sign: >0 positive, <0 negative, ==0 zero using if-else-if-else chain.
Direct input to ternary decision tree per hint; exact output phrases.
Covers exhaustive cases, relational operators, branching flow.
Usage: 5->"The number is positive."; -3->"negative."; 0->"zero.".
*/

import java.util.Scanner;
// Imports Scanner for single int input.

public class PositiveNegativeZero {
    // Public class determines number sign.

    public static void main(String[] args) {
        // Sign evaluator launch.

        Scanner input = new Scanner(System.in);
        // Input conduit.

        int number;
        // Test subject declaration.

        System.out.print("Enter a number: ");
        // Simple prompt.

        number = input.nextInt();
        // Receives value.

        if (number > 0) {
            // Positive quadrant.

            System.out.println("The number is positive.");
            // Matches hint phrasing.
        } else if (number < 0) {
            // Negative quadrant.

            System.out.println("The number is negative.");
            // Exact negative message.
        } else {
            // Zero boundary.

            System.out.println("The number is zero.");
            // Zero confirmation.
        }
    }
    // Main closure.
}
// Class wrap.
