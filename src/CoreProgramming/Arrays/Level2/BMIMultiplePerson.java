package CoreProgramming.Arrays.Level2;
// Package declaration positions class in CoreProgramming.Arrays.Level2 for parallel array BMI variant.

/*
BMIMultiplePerson
This class tracks multiple persons' BMI using four parallel 1D arrays: weight, height, bmi, status.
No input validation; direct loops for data entry, BMI calc (wt/(ht_m^2)), status assignment.
Generates identical report to 2D version; contrasts multi-array vs multi-dim approaches.
Usage: Input N, then wt/ht per person; outputs formatted BMI table.
*/

import java.util.Scanner;
// Imports Scanner handling ints/doubles for inputs.

public class BMIMultiplePerson {
    // Public class for BMI multi-person tracker.

    public static void main(String[] args) {
        // Initiates program runtime.

        Scanner input = new Scanner(System.in);
        // Sets up console input parser.

        int numberOfPersons;
        // Local var for dynamic sizing all arrays.

        System.out.print("Enter number of persons: ");
        // Queries total persons inline.

        numberOfPersons = input.nextInt();
        // Stores count to size arrays.

        double[] weight = new double[numberOfPersons];
        // Array exclusively for kg weights per person.

        double[] height = new double[numberOfPersons];
        // Dedicated cm heights array.

        double[] bmi = new double[numberOfPersons];
        // Prepares for computed BMI values.

        String[] status = new String[numberOfPersons];
        // Holds categorical weight descriptions.

        // Loop 1: Sequential input for weight/height pairs
        for (int i = 0; i < numberOfPersons; i++) {
            // Person index 0 to N-1.

            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            // Weight prompt with 1-based person ID.

            weight[i] = input.nextDouble();
            // Fills corresponding weight slot.

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            // Immediate height request same person.

            height[i] = input.nextDouble();
            // Populates height array position.
        }

        // Loop 2: BMI computation and status categorization
        for (int i = 0; i < numberOfPersons; i++) {
            // Reprocesses each person index.

            double heightInMeter = height[i] / 100;
            // Converts this person's height to meters.

            bmi[i] = weight[i] / (heightInMeter * heightInMeter);
            // Stores BMI: weight / height_squared.

            // Chained if-else for WHO BMI adult ranges
            if (bmi[i] <= 18.4) {
                // Low BMI cutoff.

                status[i] = "Underweight";
                // Sets string label.
            } else if (bmi[i] <= 24.9) {
                // Healthy range.

                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                // Excess weight.

                status[i] = "Overweight";
            } else {
                // Highest category.

                status[i] = "Obese";
            }
        }

        System.out.println("\n BMI Report ");
        // Simple report header.

        // Loop 3: Consolidated person summary print
        for (int i = 0; i < numberOfPersons; i++) {
            // Final traversal across parallels.

            System.out.println(
                    // Builds one-line profile from arrays.

                    "Person " + (i + 1) +
                            // Identifier prefix.

                            " | Height: " + height[i] + " cm" +
                            // Height pull.

                            " | Weight: " + weight[i] + " kg" +
                            // Weight value.

                            " | BMI: " + bmi[i] +
                            // Calculated metric.

                            " | Status: " + status[i]
                    // Status string.
            );
        }
    }
    // Halts main.
}
// Defines class end.
