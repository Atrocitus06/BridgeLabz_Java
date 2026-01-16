package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration places in CoreProgramming.ControlFlowPractices.Level1 for conditional bonus logic.

/*
EmployeeBonus
This class calculates Zara employee bonus: 5% salary if years>5, else zero.
Simple if-else on service tenure; bonus = salary * 0.05, prints amount or "No bonus".
Introduces double precision for currency, type mixing (double salary/int years).
Usage: Salary 50000, years 6 -> "The bonus amount is INR 2500.0"; years 4 -> "No bonus".
*/

import java.util.Scanner;
// Imports Scanner supporting double/int inputs.

public class EmployeeBonus {
    // Public class determines service-based bonus.

    public static void main(String[] args) {
        // Starts bonus evaluation.

        Scanner input = new Scanner(System.in);
        // Unified input processor.

        double salary;
        // Annual pay for percentage calc.

        int yearsOfService;
        // Integer tenure threshold.

        double bonus;
        // Computed payout variable.

        System.out.print("Enter salary: ");
        // Requests base salary inline.

        salary = input.nextDouble();
        // Stores precise salary.

        System.out.print("Enter years of service: ");
        // Prompts tenure.

        yearsOfService = input.nextInt();
        // Captures whole years.

        if (yearsOfService > 5) {
            // Loyalty check: exceeds 5 years.

            bonus = salary * 0.05;
            // Applies 5% multiplier.

            System.out.println(
                    "The bonus amount is INR " + bonus
            );
            // Displays exact bonus currency.
        } else {
            // <=5 years: ineligible.

            System.out.println(
                    "No bonus is applicable."
            );
            // Standard denial message.
        }
    }
    // Main scope ends.
}
// Class finalized.
