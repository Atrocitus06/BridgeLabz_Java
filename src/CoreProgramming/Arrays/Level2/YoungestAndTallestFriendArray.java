package CoreProgramming.Arrays.Level2;
// Package declaration organizes within CoreProgramming.Arrays.Level2 for comparative friend metrics.

/*
YoungestAndTallestFriendArray
This class determines youngest (min age) and tallest (max height) among fixed 3 friends: Amar/Akbar/Anthony.
Uses parallel arrays (names/ages/heights); input loop fills, comparison assumes index0 start, scans 1-2 for updates.
Outputs names via indices; efficient O(n=3) linear search.
Usage: Enter ages/heights; e.g., Amar20/170, Akbar18/175, Anthony22/165 -> Youngest:Akbar, Tallest:Akbar.
*/

import java.util.Scanner;
// Imports Scanner supporting int/double inputs.

public class YoungestAndTallestFriendArray {
    // Public class ranks friends by age/height.

    public static void main(String[] args) {
        // Executes friend comparison.

        Scanner input = new Scanner(System.in);
        // Handles mixed-type entries.

        String[] names = {"Amar", "Akbar", "Anthony"};
        // Fixed friend labels index-matched.

        int[] ages = new int[3];
        // Integer ages array size 3.

        double[] heights = new double[3];
        // Double heights for precision.

        // Input loop: Collect age/height per friend
        for (int i = 0; i < 3; i++) {
            // Exact 3 iterations.

            System.out.print("Enter age of " + names[i] + ": ");
            // Personalized age prompt.

            ages[i] = input.nextInt();
            // Stores age at matching index.

            System.out.print("Enter height of " + names[i] + ": ");
            // Height follow-up.

            heights[i] = input.nextDouble();
            // Precision height store.
        }

        int youngestIndex = 0;
        // Starts with Amar as tentative min age.

        int tallestIndex = 0;
        // Amar as initial max height.

        // Comparison loop: Scan from index 1
        for (int i = 1; i < 3; i++) {
            // Compares Akbar/Anthony vs current champs.

            if (ages[i] < ages[youngestIndex]) {
                // Newer age beats min.

                youngestIndex = i;
                // Updates min holder.
            }

            if (heights[i] > heights[tallestIndex]) {
                // Height exceeds current max.

                tallestIndex = i;
                // New tallest index.
            }
        }

        System.out.println("\nYoungest friend is: " + names[youngestIndex]);
        // Reveals min age name.

        System.out.println("Tallest friend is: " + names[tallestIndex]);
        // Max height name.
    }
    // Main concludes.
}
// Class terminates.
