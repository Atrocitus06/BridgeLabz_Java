package CoreProgramming.Arrays.Level2;
// Package declaration organizes under CoreProgramming.Arrays.Level2 for multi-dimensional array applications.

/*
BMIMultiDimensional
This class computes BMI and weight status for variable persons using 2D double array (rows:persons, cols:weight,height,BMI).
Validates positive inputs via while loops, categorizes BMI ranges into parallel String array.
Outputs formatted report; demonstrates jagged sizing, nested loops, array math/formulas.
Usage: Enter N persons, then wt/ht pairs; view per-person summary table.
*/

import java.util.Scanner;
// Imports Scanner for multi-type inputs (int,double).

public class BMIMultiDimensional {
    // Public class for executable BMI calculator.

    public static void main(String[] args) {
        // Launches BMI processing pipeline.

        Scanner input = new Scanner(System.in);
        // Initializes universal input reader.

        int number;
        // Temp holder for person count.

        System.out.print("Enter number of persons: ");
        // Solicits dynamic array sizing.

        number = input.nextInt();
        // Captures N to dimension arrays.

        double[][] personData = new double[number][3];
        // 2D array: N rows x 3 cols [0:weight(kg),1:height(cm),2:BMI].

        String[] weightStatus = new String[number];
        // 1D parallel array for textual BMI classifications.

        // Outer loop: Input data per person with validation
        for (int i = 0; i < number; i++) {
            // Iterates over each person row (0 to N-1).

            System.out.println("\nPerson " + (i + 1));
            // Person-specific header with 1-based ID.

            // Nested while: Ensure positive weight
            while (true) {
                // Loops until valid positive weight.

                System.out.print("Enter weight (kg): ");
                // Weight prompt.

                personData[i][0] = input.nextDouble();
                // Tentative store in col0.

                if (personData[i][0] > 0)
                    // Success condition.

                    break;
                // Exits weight validation.
                System.out.println("Invalid weight. Enter a positive value.");
                // Error feedback loop.
            }

            // Nested while: Ensure positive height
            while (true) {
                // Repeats for height validation.

                System.out.print("Enter height (cm): ");
                // Height prompt.

                personData[i][1] = input.nextDouble();
                // Tentative col1 assignment.

                if (personData[i][1] > 0)
                    // Positive check.

                    break;
                // Height validated.
                System.out.println("Invalid height. Enter a positive value.");
                // Re-prompt message.
            }
        }

        // Loop: Compute BMI and classify status
        for (int i = 0; i < number; i++) {
            // Processes each person's row.

            double heightInMeter = personData[i][1] / 100;
            // Converts cm to meters (divide by 100).

            personData[i][2] = personData[i][0] / (heightInMeter * heightInMeter);
            // BMI formula: weight / (height_m^2), overwrites col2.

            // Multi-conditional BMI ranges (standard adult categories)
            if (personData[i][2] <= 18.4) {
                // Underweight threshold.

                weightStatus[i] = "Underweight";
                // Assigns status string.
            } else if (personData[i][2] <= 24.9) {
                // Normal weight band.

                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                // Overweight up to severe.

                weightStatus[i] = "Overweight";
            } else {
                // Extreme high BMI.

                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI REPORT ---");
        // Report title separator.

        // Final loop: Formatted tabular output
        for (int i = 0; i < number; i++) {
            // Rows through all persons.

            System.out.println(
                    // Concatenated single-line report.

                    "Person " + (i + 1) +
                            // 1-based identifier.

                            " | Height: " + personData[i][1] + " cm" +
                            // Col1 formatted.

                            " | Weight: " + personData[i][0] + " kg" +
                            // Col0 with unit.

                            " | BMI: " + personData[i][2] +
                            // Computed col2.

                            " | Status: " + weightStatus[i]
                    // Parallel classification.
            );
        }
    }
    // Ends execution.
}
// Completes class.
