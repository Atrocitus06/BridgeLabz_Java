package CoreProgramming.Arrays.Level1;
// Package declaration changed from core_programming to CoreProgramming for consistency across snippets.

/*
ConvertTwoDimensionalToOneDimensionalArray
This class flattens user-defined 2D matrix (rows x cols) into 1D array of size rows*cols using nested loops.
Outer/inner for input matrix[][] row-major, then copy to 1D array[index++] row-major order.
Final print space-separated 1D elements; no validation assumes positive dims/valid ints.
Usage: 2 rows, 3 cols, input 1 2 3 4 5 6 -> 1D: 1 2 3 4 5 6.
*/

import java.util.Scanner;
// Imports Scanner for dimensions/elements.

public class ConvertTwoDimensionalToOneDimensionalArray {
    // Public class matrix flattener.

    public static void main(String[] args) {
        // 2D to 1D converter.

        Scanner input = new Scanner(System.in);
        // Multi-int reader.

        int rows;
        // Matrix height.

        int columns;
        // Matrix width.

        System.out.print("Enter number of rows: ");
        // Height query.

        rows = input.nextInt();
        // Sets rows.

        System.out.print("Enter number of columns: ");
        // Width ask.

        columns = input.nextInt();
        // Defines cols.

        int[][] matrix = new int[rows][columns];
        // Dynamic 2D jagged init.

        System.out.println("Enter elements of the matrix:");
        // Bulk input header.

        // Nested input: Fill matrix row-by-row
        for (int i = 0; i < rows; i++) {
            // Outer: rows.

            for (int j = 0; j < columns; j++) {
                // Inner: cols per row.

                matrix[i][j] = input.nextInt();
                // Populates cell.
            }
        }

        int[] array = new int[rows * columns];
        // Exact flattened size.

        int index = 0;
        // Linear position.

        // Nested copy: Row-major to 1D
        for (int i = 0; i < rows; i++) {
            // Row traversal.

            for (int j = 0; j < columns; j++) {
                // Col access.

                array[index] = matrix[i][j];
                // Transfers element.

                index++;
                // Advances 1D slot.
            }
        }

        System.out.println("\nElements of 1D array:");
        // Output section.

        for (int i = 0; i < array.length; i++) {
            // Full 1D scan.

            System.out.print(array[i] + " ");
            // Space-trailing prints.
        }
    }
    // Main flattened.
}
// Class dimension-reduced.
