package CoreProgramming.Arrays.Level1;
// Package declaration organizes this class in CoreProgramming hierarchy for Level 1 array exercises.

import java.util.Scanner;
// Imports Scanner utility for reading double inputs from console.

/*
MeanHeightFootballTeam
This class calculates average height of 11 football players.
Reads heights into fixed-size double array, sums values via loop, computes mean using sum / count formula.
Prints result; demonstrates array input, accumulation, and division operations.
Usage: Compile/run directly; enter 11 heights when prompted.
*/

public class MeanHeightFootballTeam {
    // Declares public class accessible from other packages.

    public static void main(String[] args) {
        // Defines static main method as program entry point.

        Scanner input = new Scanner(System.in);
        // Creates Scanner instance tied to standard input stream.

        double[] heights = new double[11];
        // Initializes double array of size 11 for player heights.

        double sum = 0.0;
        // Initializes sum accumulator to zero for total height calculation.

        // Loop 1: Populate array with user-input heights
        for (int i = 0; i < heights.length; i++) {
            // Iterates from index 0 to 10 (11 elements).

            System.out.print("Enter height of player " + (i + 1) + ": ");
            // Prompts user for next player's height with 1-based index.

            heights[i] = input.nextDouble();
            // Stores entered double value at current array index.
        }

        // Loop 2: Accumulate total sum of all heights
        for (int i = 0; i < heights.length; i++) {
            // Iterates through all array elements again.

            sum = sum + heights[i];
            // Adds current height to running total sum.
        }

        double mean = sum / heights.length;
        // Computes mean by dividing total sum by array length (11).

        System.out.println("\nMean height of the football team = " + mean);
        // Outputs mean height prefixed with descriptive message.
    }
    // Closes main method body.
}
// Ends class declaration.
