package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration scopes PowerOfNumber to CoreProgramming.ControlFlowPractices.Level2 for exponentiation.

/*
PowerOfNumber
This class computes number^power (base>0, exp>=0) via loop mult: result=1, *=number power times.
Validates positives pre-loop; for 1<=power handles 0^0=1 implicitly (result=1 no loop).
Exact output phrasing; int limits overflow risk for large power.
Usage: 2 3 -> "2 raised to the power 3 is 8"; 3 0 -> "3 raised...0 is 1"; invalid->"positive values.".
*/

import java.util.Scanner;
// Imports Scanner dual int input.

public class PowerOfNumber {
    // Public class repeated multiplier.

    public static void main(String[] args) {
        // Exponent evaluator.

        Scanner input = new Scanner(System.in);
        // Paired inputs.

        int number;
        // Base operand.

        int power;
        // Exponent.

        int result = 1;
        // Neutral mult start.

        System.out.print("Enter the number: ");
        // Base first.

        number = input.nextInt();

        System.out.print("Enter the power: ");
        // Exponent next.

        power = input.nextInt();

        if (number > 0 && power >= 0) {
            // Base positive, power non-neg.

            // For: power multiplications
            for (int i = 1; i <= power; i++) {
                // Counts 1 to power inclusive.

                result = result * number;
                // Progressive power.
            }

            System.out.println(
                    number + " raised to the power " + power + " is " + result
            );
            // Formatted power reveal.
        } else {
            // Constraint violation.

            System.out.println("Please enter positive values.");
        }
    }
    // Main powered up.
}
// Class exponentiated.
