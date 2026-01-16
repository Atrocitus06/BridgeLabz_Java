package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration scopes MultiplesBelowHundredWhile to CoreProgramming.ControlFlowPractices.Level2 for while multiples.

/*
MultiplesBelowHundredWhile
This class reworks multiples to while(counter>=1): counter=100--, i%number==0 print.
Same validation/output as for; manual decrement achieves reverse descending list.
Per hint adjusted: counter=100 (not number-1, hint mismatch?), while >1 approx >=1.
Usage: Identical: 5 -> 100\n95\n...5; outrange->"Please...".
*/

import java.util.Scanner;
// Imports Scanner bounded input.

public class MultiplesBelowHundredWhile {
    // Public class manual while multiples.

    public static void main(String[] args) {
        // While descending multiples.

        Scanner input = new Scanner(System.in);
        // Range input.

        int number;
        // Step size.

        int counter = 100;
        // Descend from 100.

        System.out.print("Enter a positive number less than 100: ");
        // Constraint prompt.

        number = input.nextInt();
        // Base.

        if (number > 0 && number < 100) {
            // Bounds ok.

            System.out.println("Multiples of " + number + " below 100 are:");
            // List lead-in.

            // While: Manual reverse traversal
            while (counter >= 1) {
                // 100 to 1 inclusive.

                if (counter % number == 0) {
                    // Multiple detect.

                    System.out.println(counter);
                    // High-to-low print.
                }
                counter--;
                // Step down.
            }
        } else {
            // Reject.

            System.out.println("Please enter a positive integer less than 100.");
        }
    }
    // Main counted down.
}
// Class looped multiples.
