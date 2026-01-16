package CoreProgramming.Arrays.Level2;
// Package declaration categorizes under CoreProgramming.Arrays.Level2 for digit analysis exercises.

/*
DigitFrequency
This class counts digit occurrences (0-9) in user integer using extraction array and fixed freq[10] counter.
Dynamically sizes digits array via digit count loop, extracts via %10 /10, tallies frequencies, reports non-zero only.
Handles multi-digit positives; no leading zeros issue since int input.
Usage: Enter 12234; outputs "Digit 1 occurs 1 time(s)", "2 occurs 2", etc.
*/

import java.util.Scanner;
// Imports Scanner for integer input parsing.

public class DigitFrequency {
    // Public class implements digit histogram.

    public static void main(String[] args) {
        // Starts frequency computation flow.

        Scanner input = new Scanner(System.in);
        // Enables console number entry.

        int number, temp, count = 0;
        // number: input; temp: copy for destruction; count: digit length.

        System.out.print("Enter a number: ");
        // Inline prompt for target number.

        number = input.nextInt();
        // Reads int to analyze (assumes non-negative).

        temp = number;
        // Copies for non-destructive length calc.

        // Loop: Determine digit count via division
        while (temp != 0) {
            // Repeats until temp reduces to 0.

            count++;
            // Increments total digits.

            temp = temp / 10;
            // Integer divides by 10, drops rightmost digit.
        }

        int[] digits = new int[count];
        // Dynamically allocates exact digit storage.

        temp = number;
        // Resets temp for extraction.

        // Loop: Extract digits right-to-left into array
        for (int i = 0; i < count; i++) {
            // Fills from index 0 (units) upward.

            digits[i] = temp % 10;
            // Modulo 10 yields rightmost digit.

            temp = temp / 10;
            // Shifts right by removing digit.
        }

        int[] frequency = new int[10];
        // Fixed size-10 counter: index=digit, value=occurrences.

        // Loop: Tally frequencies from digits array
        for (int i = 0; i < count; i++) {
            // Scans each extracted digit.

            frequency[digits[i]]++;
            // Increments count at digit-as-index position.
        }

        System.out.println("\nDigit Frequency:");
        // Results header.

        // Loop: Report only present digits
        for (int i = 0; i < 10; i++) {
            // Checks all possible digits 0-9.

            if (frequency[i] > 0) {
                // Skips absent digits.

                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
                // Prints count for occurring digit.
            }
        }
    }
    // Exits main.
}
// Seals class.
