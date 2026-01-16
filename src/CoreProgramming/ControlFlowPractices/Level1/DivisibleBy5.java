package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration organizes under CoreProgramming.ControlFlowPractices.Level1 for basic modulo checks.

/*
DivisibleBy5
This class tests integer divisibility by 5 using % remainder operator.
Single if-else branches on (number % 5 == 0); outputs formatted Yes/No per spec.
Demonstrates conditional flow, string interpolation, modulo arithmetic.
Usage: Input any int; e.g., 25 -> "Is the number 25 divisible by 5? Yes".
*/

import java.util.Scanner;
// Imports Scanner for console integer input.

public class DivisibleBy5 {
    // Public class performs 5-divisibility verdict.

    public static void main(String[] args) {
        // Entry method launches check.

        Scanner input = new Scanner(System.in);
        // Creates input reader.

        int number;
        // Declares variable for test subject.

        System.out.print("Enter a number: ");
        // Inline prompt without newline.

        number = input.nextInt();
        // Parses and stores integer.

        if (number % 5 == 0) {
            // Condition: zero remainder on divide by 5.

            System.out.println(
                    "Is the number " + number + " divisible by 5? Yes"
            );
            // Prints affirmative exact format.
        } else {
            // Non-zero remainder case.

            System.out.println(
                    "Is the number " + number + " divisible by 5? No"
            );
            // Exact negative response.
        }
    }
    // Ends main execution.
}
// Closes class definition.
