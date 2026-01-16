package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration groups in CoreProgramming.ControlFlowPractices.Level1 for limited-range tables.

/*
MultiplicationTable
This class prints multiplication table for input number strictly 6x to 9x.
For loop i=6 to <=9 inclusive, inline computes/formats each line per hint spec.
Simple input/process/output; no validation assumes valid int.
Usage: 7 -> "7 * 6 = 42" through "7 * 9 = 63" each on new line.
*/

import java.util.Scanner;
// Imports Scanner reading single integer.

public class MultiplicationTable {
    // Public class generates 6-9 table slice.

    public static void main(String[] args) {
        // Executes table print.

        Scanner input = new Scanner(System.in);
        // Input singleton.

        int number;
        // Base multiplier.

        System.out.print("Enter a number: ");
        // Concise prompt.

        number = input.nextInt();
        // Stores operand.

        // For loop: Exact 6-9 range
        for (int i = 6; i <= 9; i++) {
            // Initializes i=6, condition <=9, implicit ++.

            System.out.println(number + " * " + i + " = " + (number * i));
            // Exact format: base * i = product.
        }
    }
    // Main finishes.
}
// Class concludes.
