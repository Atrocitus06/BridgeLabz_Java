package CoreProgramming.ControlFlowPractices.Level2;
// Package declaration locates YoungestAndTallest in CoreProgramming.ControlFlowPractices.Level2 for friend rankings.

/*
YoungestAndTallest
This class compares ages (< min youngest) and heights (> max tallest) among fixed 3 friends via if-else chains.
Individual vars per trait/friend; pairwise < > conditions pick Amar/Akbar/Anthony, ties default last.
Sequential prompts, separate min/max logics; no arrays per hint "store in variable".
Usage: Amar25/170, Akbar22/175, Anthony28/168 -> "Akbar youngest", "Akbar tallest".
*/

import java.util.Scanner;
// Imports Scanner mixed int/double inputs.

public class YoungestAndTallest {
    // Public class friend extremum finder.

    public static void main(String[] args) {
        // Trait comparator.

        Scanner input = new Scanner(System.in);
        // Multi-type reader.

        int ageAmar, ageAkbar, ageAnthony;
        // Per-friend ages.

        double heightAmar, heightAkbar, heightAnthony;
        // Heights precise.

        System.out.print("Enter Amar's age: ");
        ageAmar = input.nextInt();

        System.out.print("Enter Amar's height: ");
        heightAmar = input.nextDouble();

        System.out.print("Enter Akbar's age: ");
        ageAkbar = input.nextInt();

        System.out.print("Enter Akbar's height: ");
        heightAkbar = input.nextDouble();

        System.out.print("Enter Anthony's age: ");
        ageAnthony = input.nextInt();

        System.out.print("Enter Anthony's height: ");
        heightAnthony = input.nextDouble();

        // Find youngest: Nested if-else min age
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            // Amar beats both.

            System.out.println("Amar is the youngest friend.");
        } else if (ageAkbar < ageAmar && ageAkbar < ageAnthony) {
            // Akbar strict min.

            System.out.println("Akbar is the youngest friend.");
        } else {
            // Anthony (incl. ties).

            System.out.println("Anthony is the youngest friend.");
        }

        // Find tallest: Nested max height
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            // Amar tallest.

            System.out.println("Amar is the tallest friend.");
        } else if (heightAkbar > heightAmar && heightAkbar > heightAnthony) {
            // Akbar peak.

            System.out.println("Akbar is the tallest friend.");
        } else {
            // Anthony (ties to last).

            System.out.println("Anthony is the tallest friend.");
        }
    }
    // Main ranked.
}
// Class sized up.
