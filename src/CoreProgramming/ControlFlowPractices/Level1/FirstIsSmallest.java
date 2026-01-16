package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration positions in CoreProgramming.ControlFlowPractices.Level1 for triple comparison.

/*
FirstIsSmallest
This class verifies if first of three integers is strictly smallest (number1 < number2 && number1 < number3).
Sequential inputs, single compound if condition, Yes/No output matches I/O spec.
Logical AND ensures both comparisons true; handles equals as No.
Usage: 1 2 3 -> "Yes"; 2 1 3 -> "No"; 1 1 2 -> "No".
*/

import java.util.Scanner;
// Imports Scanner for three int reads.

public class FirstIsSmallest {
    // Public class checks primacy of minimum.

    public static void main(String[] args) {
        // Starts comparison logic.

        Scanner input = new Scanner(System.in);
        // Sequential input tool.

        int number1;
        // Primary candidate.

        int number2;
        // Second comparator.

        int number3;
        // Third comparator.

        System.out.print("Enter first number: ");
        // Targets first inline.

        number1 = input.nextInt();
        // Loads candidate.

        System.out.print("Enter second number: ");
        // Second prompt.

        number2 = input.nextInt();

        System.out.print("Enter third number: ");
        // Final input.

        number3 = input.nextInt();

        if (number1 < number2 && number1 < number3) {
            // Strict less-than both others.

            System.out.println(
                    "Is the first number the smallest? Yes"
            );
            // Affirmative spec output.
        } else {
            // Fails at least one comparison.

            System.out.println(
                    "Is the first number the smallest? No"
            );
            // Negative response.
        }
    }
    // Main done.
}
// Class ends.
