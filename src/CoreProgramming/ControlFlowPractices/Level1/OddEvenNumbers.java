package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration suits CoreProgramming.ControlFlowPractices.Level1 for parity classification.

/*
OddEvenNumbers
This class lists parity for 1 to N (natural): even/odd via %2 per hint.
Outer if validates >0, nested for 1<=N prints "i is an even/odd number" each line.
Covers validation, iteration, modulo conditional.
Usage: 5 -> "1 is an odd number"..."5 is an odd number"; 0/neg -> "Please enter...".
*/

import java.util.Scanner;
// Imports Scanner validating natural input.

public class OddEvenNumbers {
    // Public class announces number parities.

    public static void main(String[] args) {
        // Parity printer start.

        Scanner input = new Scanner(System.in);
        // Single input capture.

        int number;
        // Upper inclusive limit.

        System.out.print("Enter a natural number: ");
        // Natural hint prompt.

        number = input.nextInt();
        // Tentative assignment.

        if (number > 0) {
            // Strict natural (>0) filter.

            // For: Traverse 1 to N inclusive
            for (int i = 1; i <= number; i++) {
                // Sequential integers.

                if (i % 2 == 0) {
                    // Even: zero remainder.

                    System.out.println(i + " is an even number");
                    // Exact even phrase.
                } else {
                    // Odd remainder.

                    System.out.println(i + " is an odd number");
                    // Odd declaration.
                }
            }
        } else {
            // Invalid (<=0).

            System.out.println("Please enter a natural number.");
            // Reiterates requirement.
        }
    }
    // Main over.
}
// Class signed off.
