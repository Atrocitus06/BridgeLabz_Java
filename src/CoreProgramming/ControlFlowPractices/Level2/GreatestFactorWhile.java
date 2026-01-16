package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration aligns GreatestFactorWhile with CoreProgramming.ControlFlowPractices.Level2 for while divisor.

/*
GreatestFactorWhile
This class ports greatest proper factor to while: counter=number-1, while >=1, %==0 assign/break, counter--.
Identical to for version functionally; manual counter per hint, validates >1.
Reverse search guarantees first match=largest; efficient break.
Usage: Same outputs: 20->10; 17->1; <=1->"greater than 1.".
*/

import java.util.Scanner;
// Imports Scanner N validator.

public class GreatestFactorWhile {
    // Public class manual while max divisor.

    public static void main(String[] args) {
        // While largest proper finder.

        Scanner input = new Scanner(System.in);
        // Input channel.

        int number;
        // Number to factor.

        int greatestFactor = 1;
        // Fallback proper divisor.

        System.out.print("Enter a positive integer: ");
        // Query.

        number = input.nextInt();
        // Sets target.

        if (number > 1) {
            // Search space exists.

            int counter = number - 1;
            // Starts penultimate.

            // While: Descending divisibility probe
            while (counter >= 1) {
                // Down to 1 inclusive.

                if (number % counter == 0) {
                    // Divides evenly.

                    greatestFactor = counter;
                    // Captures largest.

                    break;
                    // Done searching.
                }
                counter--;
                // Next candidate down.
            }

            System.out.println(
                    "The greatest factor of " + number + " beside itself is " + greatestFactor
            );
            // Report verbatim.
        } else {
            // No proper factors defined.

            System.out.println("Please enter an integer greater than 1.");
        }
    }
    // Main probed complete.
}
// Class maximally divided.
