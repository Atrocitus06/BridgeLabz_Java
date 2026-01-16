package CoreProgramming.Arrays.Level1;
// Package declaration locates class in CoreProgramming.Arrays.Level1 for eligibility-checking array exercises.

/*
VotingEligibilityArray
This class assesses voting eligibility for 10 students based on ages >=18.
Fixed int array stores inputs, loops validate (negative=invalid) and classify vote rights.
Outputs per-student status; covers input validation, conditional branching per element.
Usage: Enter 10 ages; see "can vote"/"cannot vote"/"invalid" for each.
*/

import java.util.Scanner;
// Imports Scanner for sequential integer age inputs.

public class VotingEligibilityArray {
    // Public class supports independent compilation/run.

    public static void main(String[] args) {
        // Entry point method begins execution sequence.

        Scanner input = new Scanner(System.in);
        // Creates input handler for console integers.

        int[] ages = new int[10];
        // Defines 10-element int array dedicated to student ages.

        // Loop 1: Gather ages for all 10 students
        for (int i = 0; i < ages.length; i++) {
            // Counts from 0 to 9 using length for exact 10 iterations.

            System.out.print("Enter age of student " + (i + 1) + ": ");
            // Prompts with 1-based student number inline.

            ages[i] = input.nextInt();
            // Loads input int into corresponding array index.
        }

        System.out.println("\nVoting Eligibility Results:");
        // Section header with newline for output organization.

        // Loop 2: Evaluate and report eligibility per student
        for (int i = 0; i < ages.length; i++) {
            // Re-scans full array indices 0-9.

            if (ages[i] < 0) {
                // Primary guard: detects invalid negative ages.

                System.out.println("Invalid age entered: " + ages[i]);
                // Reports invalid with value, skips further checks.
            } else if (ages[i] >= 18) {
                // Voting age threshold: 18 or higher qualifies.

                System.out.println("The student with the age " + ages[i] + " can vote.");
                // Prints affirmative voting message with age.
            } else {
                // Ages 0-17: eligible but underage.

                System.out.println("The student with the age " + ages[i] + " cannot vote.");
                // Prints denial message with specific age.
            }
        }
    }
    // Terminates main logic.
}
// Closes class entirely
