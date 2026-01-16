package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration correctly scopes FizzBuzz to CoreProgramming.ControlFlowPractices.Level2 for game logic.

/*
FizzBuzz
This class implements classic FizzBuzz 1 to N>0: FizzBuzz(3&5), Fizz(3), Buzz(5), else number.
Nested modulo if prioritizes both first; for 1<=N, validation >0, exact outputs incl. "ControlFlowPractices.Level2.FizzBuzz".
Per hint: positive check, for loop display rules.
Usage: 15 -> 1\n2\nFizz\n4\nBuzz...\nFizzBuzz\n; <=0 -> "Please...".
*/

import java.util.Scanner;
// Imports Scanner positive N input.

public class FizzBuzz {
    // Public class executes FizzBuzz ruleset.

    public static void main(String[] args) {
        // Game runner.

        Scanner input = new Scanner(System.in);
        // N acquirer.

        int number;
        // Upper print limit.

        System.out.print("Enter a positive integer: ");
        // Range setter.

        number = input.nextInt();
        // Validates later.

        if (number > 0) {
            // Enables game.

            // For: 1 to N inclusive FizzBuzz
            for (int i = 1; i <= number; i++) {
                // Sequential challenger.

                if (i % 3 == 0 && i % 5 == 0) {
                    // LCM 15 both multiples.

                    System.out.println("ControlFlowPractices.Level2.FizzBuzz");
                    // Composite word.
                } else if (i % 3 == 0) {
                    // Solo 3.

                    System.out.println("Fizz");
                    // 3-marker.
                } else if (i % 5 == 0) {
                    // Solo 5.

                    System.out.println("Buzz");
                    // 5-marker.
                } else {
                    // Neither.

                    System.out.println(i);
                    // Numeric echo.
                }
            }
        } else {
            // Gatekeeper.

            System.out.println("Please enter a positive integer.");
            // Input nudge.
        }
    }
    // Main buzzed.
}
// Class fizzical.
