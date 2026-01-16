package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration locates in CoreProgramming.ControlFlowPractices.Level1 for age-based eligibility.

/*
VotingEligibility
This class assesses voting rights: >=18 "can vote", else "cannot" with age echo per exact O/P spec.
Simple if-else on age input; interpolates age in phrase matching hint.
Binary decision tree covers all integers; assumes valid non-neg age input.
Usage: 20 -> "The person's age is 20 and can vote."; 16 -> "...cannot vote.".
*/

import java.util.Scanner;
// Imports Scanner for age input.

public class VotingEligibility {
    // Public class gatekeeps suffrage.

    public static void main(String[] args) {
        // Eligibility decider.

        Scanner input = new Scanner(System.in);
        // Age intake.

        int age;
        // Threshold subject.

        System.out.print("Enter age: ");
        // Minimal prompt.

        age = input.nextInt();
        // Stores years.

        if (age >= 18) {
            // Legal voting age inclusive.

            System.out.println(
                    "The person's age is " + age + " and can vote."
            );
            // Precise affirmative.
        } else {
            // Underage case.

            System.out.println(
                    "The person's age is " + age + " and cannot vote."
            );
            // Exact denial with age.
        }
    }
    // Main verdict rendered.
}
// Class enfranchised.
