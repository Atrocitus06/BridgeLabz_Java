package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration maintains CoreProgramming.ControlFlowPractices.Level2 for while FizzBuzz port.

/*
FizzBuzzWhile
This class ports FizzBuzz to manual while(i<=number): i=1++, identical logic/output as for version.
Positive validation, same nested % conditions printing FizzBuzz/Fizz/Buzz/number.
Proves for/while interchangeability; explicit i++ post-logic.
Usage: Exact match to for: 10 -> 1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz; invalid->"Please...".
*/

import java.util.Scanner;
// Imports Scanner for range input.

public class FizzBuzzWhile {
    // Public class while-variant FizzBuzz.

    public static void main(String[] args) {
        // While game executor.

        Scanner input = new Scanner(System.in);
        // N provider.

        int number;
        // Iteration ceiling.

        System.out.print("Enter a positive integer: ");
        // Limit request.

        number = input.nextInt();
        // Sets bound.

        if (number > 0) {
            // Proceeds valid.

            int i = 1;
            // Counter init.

            while (i <= number) {
                // Test inclusive N.

                // Identical decision tree
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("ControlFlowPractices.Level2.FizzBuzz");
                    // Dual hit.
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }

                i++;
                // Manual advance.
            }
        } else {
            // Fail-fast.

            System.out.println("Please enter a positive integer.");
        }
    }
    // Main iterated.
}
// Class looped.
