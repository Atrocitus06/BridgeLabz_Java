package CoreProgramming.Arrays.Level2;
// Package declaration groups in CoreProgramming.Arrays.Level2 for digit extremum finding.

/*
LargestAndSecondLargestDigit
This class extracts digits (max 10) from input number into array, identifies largest/second-largest.
While loop pulls %10 digits right-to-left with 10-cap; two-pass scan finds max then second via conditionals.
Handles numbers up to 10 digits, prints extracted digits + top two (0 if insufficient distinct).
Usage: Input 98172; digits:2 7 1 8 9; largest=9, second=8.
*/

import java.util.Scanner;
// Imports Scanner to read input integer.

public class LargestAndSecondLargestDigit {
    // Public class extracts and ranks digits.

    public static void main(String[] args) {
        // Begins digit analysis routine.

        Scanner input = new Scanner(System.in);
        // Console input facilitator.

        int number;
        // Holds original number for digit extraction.

        int maxDigit = 10;
        // Caps array/digits at 10 (first 10 processed).

        int[] digits = new int[maxDigit];
        // Fixed buffer for extracted digits.

        int index = 0;
        // Tracks filled positions (0-based).

        System.out.print("Enter a number: ");
        // Prompts for multi-digit integer.

        number = input.nextInt();
        // Loads number (positive assumed).

        // While: Extract digits until 0 or cap
        while (number != 0 && index < maxDigit) {
            // Dual stop: exhausted or full array.

            digits[index] = number % 10;  // get last digit
            // Remainder isolates rightmost digit.

            number = number / 10;         // remove last digit
            // Floor divide shifts digits left.

            index++;
            // Preps next slot.
        }

        int largest = 0;
        // Initial max sentinel (digits 0-9).

        int secondLargest = 0;
        // Initial second sentinel.

        // For: Find largest/second via single pass
        for (int i = 0; i < index; i++) {
            // Scans actual filled digits only.

            if (digits[i] > largest) {
                // New max detected.

                secondLargest = largest;
                // Promotes prior largest to second.

                largest = digits[i];
                // Updates max.
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                // Candidate for second (not max, beats current second).

                secondLargest = digits[i];
                // Elevates second.
            }
        }

        System.out.println("\nDigits stored in the array:");
        // Extraction verification header.

        for (int i = 0; i < index; i++) {
            // Prints filled portion reversed order.

            System.out.print(digits[i] + " ");
            // Space-separated digits.
        }

        System.out.println("\n\nLargest digit = " + largest);
        // Top digit report.

        System.out.println("Second largest digit = " + secondLargest);
        // Runner-up display.
    }
    // Main termination.
}
// Class finalizes.
