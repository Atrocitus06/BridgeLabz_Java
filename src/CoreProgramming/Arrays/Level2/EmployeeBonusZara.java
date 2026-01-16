package CoreProgramming.Arrays.Level2;
// Package declaration files under CoreProgramming.Arrays.Level2 for HR payroll simulations.

/*
EmployeeBonusZara
This class computes Zara bonuses for 10 employees: 5% if >5 yrs service, 2% otherwise.
Parallel double arrays track salary/yrs/bonus/new_salary; validates >0 salary, >=0 yrs with i-- retry.
Aggregates totals during calc loop, reports sums only (no per-employee detail).
Usage: Enter 10 valid salary/yr pairs; see total old/new salary + bonus payout.
*/

import java.util.Scanner;
// Imports Scanner for double precision inputs.

public class EmployeeBonusZara {
    // Public class models company bonus system.

    public static void main(String[] args) {
        // Executes payroll processing.

        Scanner input = new Scanner(System.in);
        // Console reader for employee data.

        double[] salary = new double[10];
        // Base pay per employee (fixed 10).

        double[] yearsOfService = new double[10];
        // Service tenure array.

        double[] bonus = new double[10];
        // Individual bonus amounts.

        double[] newSalary = new double[10];
        // Post-bonus updated salaries.

        double totalBonus = 0.0;
        // Company-wide bonus accumulator.

        double totalOldSalary = 0.0;
        // Sum of original salaries.

        double totalNewSalary = 0.0;
        // Sum of enhanced salaries.

        // Loop 1: Input with validation/retry
        for (int i = 0; i < 10; i++) {
            // Targets 10 employees.

            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            // Salary prompt, 1-based.

            salary[i] = input.nextDouble();
            // Tentative assignment.

            System.out.print("Enter years of service of employee " + (i + 1) + ": ");
            // Service years prompt.

            yearsOfService[i] = input.nextDouble();
            // Tentative store.

            if (salary[i] <= 0 || yearsOfService[i] < 0) {
                // Dual validation: salary positive, years non-negative.

                System.out.println("Invalid input. Please enter again.\n");
                // User error notice.

                i--; // decrement index to re-enter data
                // Backtracks i for re-prompt same employee.

                continue;
                // Skips to next for iteration.
            }
        }

        // Loop 2: Bonus calc, updates, totals
        for (int i = 0; i < 10; i++) {
            // Reprocesses validated data.

            if (yearsOfService[i] > 5) {
                // Loyalty tier: >5 years qualifies high bonus.

                bonus[i] = salary[i] * 0.05;
                // 5% of salary.
            } else {
                // Default: <=5 years.

                bonus[i] = salary[i] * 0.02;
                // 2% bonus rate.
            }

            newSalary[i] = salary[i] + bonus[i];
            // Adds bonus to base for new total pay.

            totalBonus = totalBonus + bonus[i];
            // Accumulates company bonus liability.

            totalOldSalary = totalOldSalary + salary[i];
            // Sums pre-bonus payroll.

            totalNewSalary = totalNewSalary + newSalary[i];
            // Tracks post-bonus total.
        }

        System.out.println("\n Zara Employee Salary Summary ");
        // Summary banner.

        System.out.println("Total Old Salary = INR " + totalOldSalary);
        // Pre-bonus aggregate.

        System.out.println("Total Bonus Paid = INR " + totalBonus);
        // Bonus expenditure.

        System.out.println("Total New Salary = INR " + totalNewSalary);
        // Final payroll projection.
    }
    // Main complete.
}
// Class closure.
