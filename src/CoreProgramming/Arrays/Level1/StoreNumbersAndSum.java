package CoreProgramming.Arrays.Level1;
// Package declaration groups this class under CoreProgramming.Arrays.Level1 for dynamic array handling exercises.

/*
StoreNumbersAndSum
This class collects positive doubles into fixed 10-element array until 0/negative or full.
Uses infinite while(true) with breaks, computes/runs sum post-input via for loop.
Handles early termination, partial fills; prints list then total sum.
Usage: Enter positives (e.g., 1.5 2.3); stop with 0; see numbers listed and sum.
*/

import java.util.Scanner;
// Imports Scanner to parse double inputs from console stream.

public class StoreNumbersAndSum {
    // Public class allows direct javac/java execution.

    public static void main(String[] args) {
        // Main method launches program logic.

        Scanner input = new Scanner(System.in);
        // Instantiates Scanner bound to System.in for double reads.

        double[] numbers = new double[10];
        // Reserves 10-slot double array for storing input values.

        double total = 0.0;
        // Initializes sum accumulator to zero for precise double addition.

        int index = 0;
        // Sets array write/read tracker starting at 0.

        // Infinite loop for input collection with break conditions
        while (true) {
            // Continues indefinitely until explicit break.

            System.out.print("Enter a number (0 or negative to stop): ");
            // Prompts inline for next double input with stop hint.

            double value = input.nextDouble();
            // Reads and stores current double input.

            if (value <= 0) {
                // Sentinel check: <=0 signals end of valid inputs.

                break;
                // Exits while loop on non-positive entry.
            }

            if (index == 10) {
                // Capacity check: prevents overflow beyond array bounds.

                break;
                // Terminates on array full (10 elements).
            }

            numbers[index] = value;
            // Assigns valid positive value to current array slot.

            index++;
            // Advances index for next potential insertion/print.
        }

        System.out.println("\nEntered numbers are:");
        // Header for listing stored numbers with newline.

        // Loop: Print numbers and accumulate sum simultaneously
        for (int i = 0; i < index; i++) {
            // Iterates only filled portion (0 to index-1).

            System.out.println(numbers[i]);
            // Displays each stored number on new line.

            total = total + numbers[i];
            // Adds current element to running total sum.
        }

        System.out.println("\nTotal sum = " + total);
        // Final output: sum prefixed with label and newline.
    }
    // Closes main method.
}
// Finishes class declaration.
