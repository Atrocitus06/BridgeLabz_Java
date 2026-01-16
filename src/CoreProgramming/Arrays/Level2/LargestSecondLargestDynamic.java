package CoreProgramming.Arrays.Level2;
// Package declaration fits in CoreProgramming.Arrays.Level2 for dynamic resizing demos.

/*
LargestSecondLargestDynamic
This class extends digit extractor to arbitrary length via manual resize: +10 slots on full, copy/assign.
While loop now unbounded (number!=0), inserts %10, triggers grow/copy if index==maxDigit.
Post-extraction, same largest/second scan; handles any int size up to Integer.MAX.
Usage: Large number like 12345678901234567890; resizes as needed, finds 9/8.
*/

import java.util.Scanner;
// Imports for user number input.

public class LargestSecondLargestDynamic {
    // Public class with resizable digit buffer.

    public static void main(String[] args) {
        // Runtime entry for unbounded digit processing.

        Scanner input = new Scanner(System.in);
        // Input stream handler.

        int number;
        // Input number to decompose.

        int maxDigit = 10;              // initial size
        // Starting capacity (multiples of 10).

        int[] digits = new int[maxDigit];
        // Initial backing array.

        int index = 0;
        // Current fill position.

        System.out.print("Enter a number: ");
        // Number request.

        number = input.nextInt();
        // Captures potentially long int.

        // While: Full extraction with dynamic growth
        while (number != 0) {
            // Processes all digits (no cap).

            if (index == maxDigit) {
                // Overflow detect: full current capacity.

                maxDigit = maxDigit + 10;
                // Expands capacity by 10 slots.

                int[] temp = new int[maxDigit];
                // Allocates larger temporary array.

                for (int i = 0; i < digits.length; i++) {
                    // Copies existing contents.

                    temp[i] = digits[i];
                    // Transfers each old element.
                }

                digits = temp; // assign expanded array
                // Reassigns reference: digits now points to larger.
            }

            digits[index] = number % 10; // get last digit
            // Stores newest rightmost digit.

            number = number / 10;        // remove last digit
            // Discards processed digit.

            index++;
            // Advances write position.
        }

        int largest = 0;
        // Max digit init (safe for 0-9).

        int secondLargest = 0;
        // Second max init.

        // For: Extremum discovery across all digits
        for (int i = 0; i < index; i++) {
            // Exact filled length traversal.

            if (digits[i] > largest) {
                // Surpasses current max.

                secondLargest = largest;
                // Demotes old max.

                largest = digits[i];
                // New champion.
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                // Second-tier update (distinct from max).

                secondLargest = digits[i];
            }
        }

        System.out.println("\nDigits stored in array:");
        // Digit list intro.

        for (int i = 0; i < index; i++) {
            // Outputs actual digits.

            System.out.print(digits[i] + " ");
            // Space-delimited (reverse order).
        }

        System.out.println("\n\nLargest digit = " + largest);
        // Peak report.

        System.out.println("Second largest digit = " + secondLargest);
        // Vice-peak.
    }
    // Main done.
}
// Class wraps.
