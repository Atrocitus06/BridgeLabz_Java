// ===== 1. FactorsUsingArray =====
package CoreProgramming.Arrays.Level1;
// Package declaration that organizes this class within the CoreProgramming.Arrays.Level1 namespace.

import java.util.Scanner;
// Importing Scanner to read user input from the console.

public class FactorsUsingArray {
    // Public class declaration so it can be accessed from other packages.

    public static void main(String[] args) {
        // Main method: entry point of the program where execution begins.

        Scanner input = new Scanner(System.in);
        // Creating a Scanner object to read input from System.in (keyboard).

        int maxFactor = 10;
        // Initial capacity for the factors array; starts with space for 10 factors.

        int[] factors = new int[maxFactor];
        // Creating an integer array to store the factors of the user-provided number.

        int index = 0;
        // Variable to track how many factors have been stored and the next insertion position.

        System.out.print("Enter a number: ");
        // Prompting the user to enter a number.

        int number = input.nextInt();
        // Reading an integer from the user and storing it in 'number'.

        if (number <= 0) {
            // Checking if the user entered a non-positive integer.

            System.out.println("Please enter a positive integer.");
            // Informing the user that only positive integers are allowed.
        } else {
            // If the number is positive, proceed to find its factors.

            for(int i = 1; i <= number; ++i) {
                // Looping from 1 to the number to check each value as a potential factor.

                if (number % i == 0) {
                    // If remainder is 0, 'i' is a factor of 'number'.

                    if (index == maxFactor) {
                        // If the array is full (no more space), trigger a resize.

                        maxFactor *= 2;
                        // Doubling the maximum capacity of the array.

                        int[] temp = new int[maxFactor];
                        // Creating a new temporary array with the increased capacity.

                        for(int j = 0; j < factors.length; ++j) {
                            // Looping over the old array to copy existing factors.

                            temp[j] = factors[j];
                            // Copying each factor from the old array to the new array.
                        }

                        factors = temp;
                        // Reassigning 'factors' to reference the new larger array.
                    }

                    factors[index] = i;
                    // Storing the current factor 'i' in the array at the current index.

                    ++index;
                    // Incrementing index to point to the next free position.
                }
            }

            System.out.println("\nFactors of " + number + " are:");
            // Printing a header line indicating the factors of the given number.

            for(int i = 0; i < index; ++i) {
                // Looping through all stored factors in the array.

                System.out.print(factors[i] + " ");
                // Printing each factor followed by a space on the same line.
            }

        }
        // End of if-else block handling positive vs non-positive input.

    }
    // End of main method.

}
// End of FactorsUsingArray class.
