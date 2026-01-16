package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration fits CoreProgramming.ControlFlowPractices.Level1 for countdown simulation.

/*
RocketLaunchCountdown
This class performs backward countdown from user N to 1 using while >=1 loop.
Prints each counter value descending, -- post-print; adds launch emoji finale.
While condition ensures 1 prints, stops at 0; assumes positive input.
Usage: 5 -> 5\n4\n3\n2\n1\n🚀 Rocket Launched!.
*/

import java.util.Scanner;
// Imports Scanner for countdown origin.

public class RocketLaunchCountdown {
    // Public class simulates launch sequence.

    public static void main(String[] args) {
        // Countdown initiator.

        Scanner input = new Scanner(System.in);
        // Reads start value.

        int counter;
        // Decrementing timer variable.

        System.out.print("Enter countdown start number: ");
        // Descriptive prompt.

        counter = input.nextInt();
        // Sets initial count.

        // While: Descend to 1 inclusive
        while (counter >= 1) {
            // Loops while positive inclusive 1.

            System.out.println(counter);
            // Displays current tick.

            counter--;
            // Pre-decrements for next.
        }

        System.out.println("🚀 Rocket Launched!");
        // Celebratory post-countdown.
    }
    // Main liftoff complete.
}
// Class orbit achieved.
