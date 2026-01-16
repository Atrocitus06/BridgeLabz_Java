package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration fits CoreProgramming.ControlFlowPractices.Level2 for while exponentiation.

/*
PowerUsingWhile
This class ports power to while(counter < power): counter=0++, result *=number each iter.
Same validation/output as for; manual counter per hint (while <power equiv <=power-1 but mult power times).
Handles power=0 (no loop, result=1); int overflow possible.
Usage: Matches: 3 4 -> 81; invalid->"valid positive values.".
*/

import java.util.Scanner;
// Imports Scanner base/exp inputs.

public class PowerUsingWhile {
    // Public class counter-controlled power.

    public static void main(String[] args) {
        // While pow calc.

        Scanner input = new Scanner(System.in);
        // Dual fetcher.

        int number;
        // Multiplicand.

        int power;
        // Repetition count.

        int result = 1;
        // Power seed.

        int counter = 0;
        // Iteration tracker.

        System.out.print("Enter the number: ");
        number = input.nextInt();

        System.out.print("Enter the power: ");
        power = input.nextInt();

        if (number > 0 && power >= 0) {
            // Safe domain.

            // While: Manual multiplication loop
            while (counter < power) {
                // Runs power times (0..<power).

                result = result * number;
                // Builds exponent.

                counter++;
                // Progresses count.
            }

            System.out.println(
                    number + " raised to the power " + power + " is " + result
            );
            // Canonical reveal.
        } else {
            // Domain error.

            System.out.println("Please enter valid positive values.");
        }
    }
    // Main to the power.
}
// Class raised accordingly.
