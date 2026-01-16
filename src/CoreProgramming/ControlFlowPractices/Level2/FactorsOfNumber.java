package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration organizes in CoreProgramming.ControlFlowPractices.Level2 for factorization.

/*
FactorsOfNumber
This class lists all positive divisors of N>0: for i=1 to <=N, if N%i==0 print i.
Validates input >0 pre-loop; header "Factors of N are:", each factor new line.
Matches hint except i<=number (covers N itself, standard); efficient for small N.
Usage: 12 -> Factors...\n1\n2\n3\n4\n6\n12; <=0 -> "Please enter...".
*/

import java.util.Scanner;
// Imports Scanner for positive int input.

public class FactorsOfNumber {
    // Public class divisor enumerator.

    public static void main(String[] args) {
        // Factor finder.

        Scanner input = new Scanner(System.in);
        // Input validator.

        int number;
        // Target for division.

        System.out.print("Enter a positive integer: ");
        // Qualified request.

        number = input.nextInt();
        // Candidate parse.

        if (number > 0) {
            // Positive guard.

            System.out.println("Factors of " + number + " are:");
            // List intro.

            // For: Trial division 1 to N
            for (int i = 1; i <= number; i++) {
                // Full range inclusive N.

                if (number % i == 0) {
                    // Perfect divisor test.

                    System.out.println(i);
                    // Each factor alone.
                }
            }
        } else {
            // Invalid handler.

            System.out.println("Please enter a positive integer.");
            // Reiterates.
        }
    }
    // Main factored.
}
// Class divides evenly.
