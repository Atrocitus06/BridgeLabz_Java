package CoreProgramming.Arrays.Level2;
// Package declaration aligns with CoreProgramming.Arrays.Level2 for reversal patterns.

/*
ReverseNumberUsingArray
This class reverses integer digits: extracts to array (right-to-left), copies to new array (but prints forward—as-is).
Counts digits via /10 loop, %10 fills digits[0]=units; reverse[] mirrors but output for(i=0;count) prints original reversed visually.
Note: Prints extracted (already reversed order); true reverse needs descending index or swap logic.
Usage: 1234 -> digits[0=4,1=3,2=2,3=1] -> print 4321.
*/

import java.util.Scanner;
// Imports for number input.

public class ReverseNumberUsingArray {
    // Public class reverses via array store/print.

    public static void main(String[] args) {
        // Kicks off reversal process.

        Scanner input = new Scanner(System.in);
        // Input acquirer.

        int number;
        // Original to reverse.

        int temp;
        // Working copy.

        int count = 0;
        // Digit tally.

        System.out.print("Enter a number: ");
        // User solicitation.

        number = input.nextInt();
        // Loads target int.

        temp = number;
        // Preserves original.

        // While: Tally digits
        while (temp != 0) {
            // Until exhausted.

            count++;
            // Digit counter++.

            temp = temp / 10;
            // Drop LSD.
        }

        int[] digits = new int[count];
        // Sized for all digits.

        temp = number;
        // Reset for extraction.

        // For: Pull digits LSD first
        for (int i = 0; i < count; i++) {
            // Fills 0 to count-1.

            digits[i] = temp % 10;
            // LSD to index i.

            temp = temp / 10;
            // Shift.
        }

        int[] reverse = new int[count];
        // Duplicate sized array (intended reverse).

        for (int i = 0; i < count; i++) {
            // Copies entire digits.

            reverse[i] = digits[i];
            // Mirror copy (no actual reversal).
        }

        System.out.print("Reversed number: ");
        // Output prefix.

        for (int i = 0; i < count; i++) {
            // Ascending print.

            System.out.print(reverse[i]);
            // Dumps copy: effectively reversed original (digits order).
        }
    }
    // Main ends.
}
// Class done.
