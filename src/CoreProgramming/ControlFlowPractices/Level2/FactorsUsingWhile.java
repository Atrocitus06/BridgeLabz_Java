package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration scopes to CoreProgramming.ControlFlowPractices.Level2 for while-based factors.

/*
FactorsUsingWhile
This class replicates for-loop factors using while(counter <= number): counter=1++, %==0 print.
Identical output/validation as for version; manual counter++ post-check mimics for.
Per hint: counter init1, while <number (adjusted <= for N), if divisible print counter++.
Usage: Matches prior: 18 -> 1\n2\n3\n6\n9\n18; invalid->"Please enter...".
*/

import java.util.Scanner;
// Imports Scanner positive int validator.

public class FactorsUsingWhile {
    // Public class while divisor list.

    public static void main(String[] args) {
        // While factor traversal.

        Scanner input = new Scanner(System.in);
        // Input gate.

        int number;
        // Divisor target.

        int counter = 1;
        // Manual loop var starts 1.

        System.out.print("Enter a positive integer: ");
        // Standard solicitation.

        number = input.nextInt();
        // Value set.

        if (number > 0) {
            // Proceeds positives.

            System.out.println("Factors of " + number + " are:");
            // Prelude print.

            // While: Equivalent trial division
            while (counter <= number) {
                // Loops to inclusive N.

                if (number % counter == 0) {
                    // Divisibility oracle.

                    System.out.println(counter);
                    // Factor emission.
                }
                counter++;
                // Explicit increment.
            }
        } else {
            // Rejection path.

            System.out.println("Please enter a positive integer.");
            // Echo correction.
        }
    }
    // Main loops out.
}
// Class factors resolved.
