package CoreProgramming.Arrays.Level1;
// Package declaration organizes class in CoreProgramming.Arrays.Level1 for separation of concerns in array problems.

/*
OddEvenArray
This class separates numbers 1 to user-input N into odd/even arrays if N is natural (>0).
Uses dynamic sizing (approx N/2 +1), index trackers for filling, validation for positive input.
Prints odds then evens space-separated; teaches conditional array population and bounds-aware printing.
Usage: Input natural number (e.g., 10); outputs odds:1 3 5 7 9; evens:2 4 6 8 10.
*/

import java.util.Scanner;
// Imports Scanner class to facilitate integer input from console.

public class OddEvenArray {
    // Public class enables compilation and execution from command line.

    public static void main(String[] args) {
        // Static main method initializes program flow.

        Scanner input = new Scanner(System.in);
        // Constructs Scanner instance for System.in to parse ints.

        int number;
        // Declares variable for storing user-supplied upper limit.

        System.out.print("Enter a natural number: ");
        // Prompts user inline for natural number input.

        number = input.nextInt();
        // Parses and assigns next integer token to number.

        if (number <= 0) {
            // Validates input: natural numbers start from 1 (positive integers).

            System.out.println("Error: Please enter a natural number.");
            // Displays error message for invalid (<=0) input.

            return;
            // Exits main method early, terminating program.
        }

        int[] odd = new int[number / 2 + 1];
        // Allocates oversized odd array: floor(N/2)+1 covers max possible odds.

        int[] even = new int[number / 2 + 1];
        // Allocates similar oversized even array for max possible evens.

        int oddIndex = 0;
        // Initializes write position for odd array at start.

        int evenIndex = 0;
        // Initializes write position for even array at start.

        // Loop 1: Classify and store 1 to number
        for (int i = 1; i <= number; i++) {
            // Counts i from 1 up to inclusive number limit.

            if (i % 2 == 0) {
                // Modulo test: even if remainder zero when divided by 2.

                even[evenIndex] = i;
                // Places even i into even array at current tracker position.

                evenIndex++;
                // Advances even array write index forward.
            } else {
                // Else branch: odd numbers (non-zero %2 remainder).

                odd[oddIndex] = i;
                // Inserts odd i into odd array at current position.

                oddIndex++;
                // Increments odd array write index.
            }
        }

        System.out.println("\nOdd Numbers:");
        // Prints odd section header with leading newline.

        // Loop 2: Output populated odd array elements
        for (int i = 0; i < oddIndex; i++) {
            // Loops only up to actual filled count (oddIndex), not full size.

            System.out.print(odd[i] + " ");
            // Prints each odd value followed by space (no newline).
        }

        System.out.println("\n\nEven Numbers:");
        // Prints even section header with double newline for separation.

        // Loop 3: Output populated even array elements
        for (int i = 0; i < evenIndex; i++) {
            // Iterates precisely to filled even count.

            System.out.print(even[i] + " ");
            // Displays each even with trailing space.
        }
    }
    // Ends main method execution block.
}
// Completes class structure.
