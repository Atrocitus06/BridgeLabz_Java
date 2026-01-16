package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration locates in CoreProgramming.ControlFlowPractices.Level1 for max-of-three checks.

/*
LargestOfThree
This class independently tests each of three numbers as strictly largest (> both others).
Three parallel if statements with compound > conditions; outputs Yes/No per position matching spec.
Always prints three lines regardless; handles ties as No for all.
Usage: 3 1 2 -> first:Yes, second:No, third:No; 1 3 2 -> second:Yes others:No.
*/

import java.util.Scanner;
// Imports Scanner for triple integer inputs.

public class LargestOfThree {
    // Public class evaluates largest status per position.

    public static void main(String[] args) {
        // Initiates three-way max queries.

        Scanner input = new Scanner(System.in);
        // Reads three numbers.

        int number1;
        // First candidate.

        int number2;
        // Second.

        int number3;
        // Third.

        System.out.print("Enter first number: ");
        // Positioned prompt.

        number1 = input.nextInt();
        // Assigns first.

        System.out.print("Enter second number: ");
        number2 = input.nextInt();

        System.out.print("Enter third number: ");
        number3 = input.nextInt();

        // First largest check
        if (number1 > number2 && number1 > number3) {
            // Strictly exceeds both.

            System.out.println("Is the first number the largest? Yes");
            // Positive confirmation.
        } else {
            System.out.println("Is the first number the largest? No");
            // Negative.
        }

        // Second largest check
        if (number2 > number1 && number2 > number3) {
            System.out.println("Is the second number the largest? Yes");
        } else {
            System.out.println("Is the second number the largest? No");
        }

        // Third largest check
        if (number3 > number1 && number3 > number2) {
            System.out.println("Is the third number the largest? Yes");
        } else {
            System.out.println("Is the third number the largest? No");
        }
    }
    // Main execution ends.
}
// Class definition closes.
