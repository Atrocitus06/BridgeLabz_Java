// ===== 2. FizzBuzzArray =====
package CoreProgramming.Arrays.Level1;
// Package declaration that organizes this class in the core_programming.Arrays.Level1 hierarchy for array-related exercises.

import java.util.Scanner;
// Importing the Scanner class to read user input from the console.

public class FizzBuzzArray {
    // Public class declaration so this FizzBuzz implementation can be used from other packages.

    public static void main(String[] args) {
        // Main method: program entry point where execution begins.

        Scanner input = new Scanner(System.in);
        // Creating a Scanner object to capture user input from System.in (keyboard).

        System.out.print("Enter a positive integer: ");
        // Prompting the user to enter the upper bound for the FizzBuzz sequence.

        int number = input.nextInt();
        // Reading an integer from the user and storing it in 'number'.

        if (number <= 0) {
            // Checking if the user entered a non-positive value, which is invalid for this program.

            System.out.println("Please enter a positive integer.");
            // Informing the user that only positive integers are accepted.
        } else {
            // If the input is valid (positive), continue with FizzBuzz processing.

            String[] result = new String[number + 1];
            // Creating a String array to hold FizzBuzz results from index 0 to 'number' (inclusive).

            for(int i = 0; i <= number; ++i) {
                // Looping from 0 up to the user-provided number to generate FizzBuzz values for each index.

                if (i == 0) {
                    // Special case for index 0, since standard FizzBuzz usually starts from 1.

                    result[i] = "0";
                    // Storing the string "0" at position 0 to represent the starting element.
                } else if (i % 3 == 0 && i % 5 == 0) {
                    // Checking if 'i' is divisible by both 3 and 5; this is the "FizzBuzz" case.

                    result[i] = "ControlFlowPractices.Level2.FizzBuzz";
                    // Assigning a combined label string when the number is divisible by both 3 and 5.
                } else if (i % 3 == 0) {
                    // Checking if 'i' is divisible only by 3.

                    result[i] = "Fizz";
                    // Storing "Fizz" for numbers divisible by 3.
                } else if (i % 5 == 0) {
                    // Checking if 'i' is divisible only by 5.

                    result[i] = "Buzz";
                    // Storing "Buzz" for numbers divisible by 5.
                } else {
                    // For numbers not divisible by 3 or 5, use the number itself as a string.

                    result[i] = String.valueOf(i);
                    // Converting the integer 'i' to its string representation and storing it.
                }
            }

            System.out.println("\nControlFlowPractices.Level2.FizzBuzz Results:");
            // Printing a header line indicating the start of the FizzBuzz results.

            for(int i = 0; i <= number; ++i) {
                // Looping through all positions of the result array to print contents.

                System.out.println("Position " + i + " = " + result[i]);
                // Printing the index and its corresponding FizzBuzz value in a readable format.
            }

        }
        // End of conditional block handling valid and invalid inputs.
    }
    // End of main method.

}
// End of FizzBuzzArray class.
