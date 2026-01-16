package CoreProgramming.Arrays.Level2;
// Package declaration already correctly set for Level2 grading logic.

import java.util.Scanner;
// Imports Scanner for handling student data inputs.

/*
StudentGradeArray - Confirmed Correct
Class processes variable students' 3-subject marks into %/grades with validation.
Parallel arrays enable per-student storage; i-- retries invalid negatives post-input.
Percentage calc/grade mapping immediate; report loop consolidates output cleanly.
No changes needed: follows exact hint (input N, arrays, validate/decrement, calc grade, display).
*/

public class StudentGradeArray {
    // Public declaration maintains accessibility.

    public static void main(String[] args) {
        // Standard entry point unchanged.

        Scanner input = new Scanner(System.in);
        // Persistent input source.

        int numberOfStudents;
        // Flexible sizing mechanism.

        System.out.print("Enter number of students: ");
        // Initial query intact.

        numberOfStudents = input.nextInt();
        // Sets all array dimensions.

        int[] physics = new int[numberOfStudents];
        // Physics marks storage.

        int[] chemistry = new int[numberOfStudents];
        // Chemistry marks.

        int[] maths = new int[numberOfStudents];
        // Maths marks.

        double[] percentage = new double[numberOfStudents];
        // Derived performance metric.

        char[] grade = new char[numberOfStudents];
        // Assigned letter grade.

        // Unified loop: input + validate + compute
        for (int i = 0; i < numberOfStudents; i++) {
            // Advances per student.

            System.out.println("\nEnter marks for Student " + (i + 1));
            // Clear sectioning.

            System.out.print("Physics: ");
            physics[i] = input.nextInt();
            // Direct assignment.

            System.out.print("Chemistry: ");
            chemistry[i] = input.nextInt();

            System.out.print("Maths: ");
            maths[i] = input.nextInt();

            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                // Holistic mark validation.

                System.out.println("Invalid marks! Please enter positive values.");
                // Instructional error.

                i--; // decrement index to re-enter marks
                // Precise retry via pre-increment for.

                continue;
                // Clean loop restart.
            }

            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            // Precise average computation.

            // Tiered grading logic preserved
            if (percentage[i] >= 80) {
                grade[i] = 'A';
                // Top tier.
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
                // Lowest/fail.
            }
        }

        System.out.println("\n--- Student Results ---");
        // Output demarcation.

        // Reporting traversal
        for (int i = 0; i < numberOfStudents; i++) {
            // Full roster print.

            System.out.println(
                    "Student " + (i + 1) +
                            " | Physics: " + physics[i] +
                            " | Chemistry: " + chemistry[i] +
                            " | Maths: " + maths[i] +
                            " | Percentage: " + percentage[i] +
                            "% | Grade: " + grade[i]
            );
            // Comprehensive single-line summary.
        }
    }
    // Scope end.
}
// Structure complete.
