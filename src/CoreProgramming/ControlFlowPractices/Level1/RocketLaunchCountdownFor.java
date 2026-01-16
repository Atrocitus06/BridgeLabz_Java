package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration consistent with CoreProgramming.ControlFlowPractices.Level1 for for-loop countdown variant.

/*
RocketLaunchCountdownFor
This class reimplements countdown using for loop: init i=counter, condition >=1, decrement i--.
Prints descending  N to 1, identical output to while version + launch emoji.
For elegantly encapsulates init/test/step; no mutable counter outside loop.
Usage: Same as while: 3 -> 3\n2\n1\n🚀 Rocket Launched!.
*/

import java.util.Scanner;
// Imports Scanner sourcing start value.

public class RocketLaunchCountdownFor {
    // Public class delivers for-loop countdown.

    public static void main(String[] args) {
        // For-variant launch.

        Scanner input = new Scanner(System.in);
        // Input accessor.

        int counter;
        // Sole input holder.

        System.out.print("Enter countdown start number: ");
        // User start directive.

        counter = input.nextInt();
        // Captures origin.

        // For loop: Compact countdown from counter to 1
        for (int i = counter; i >= 1; i--) {
            // i starts at counter, >=1 test, -- step.

            System.out.println(i);
            // Ticks down visibly.
        }

        System.out.println("🚀 Rocket Launched!");
        // Ignition finale.
    }
    // Main descent complete.
}
// Class touchdown.
