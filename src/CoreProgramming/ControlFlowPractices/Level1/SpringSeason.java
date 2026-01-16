package CoreProgramming.ControlFlowPractices.Level1;
// Package declaration correctly scopes SpringSeason in CoreProgramming.ControlFlowPractices.Level1 for date ranges.

/*
SpringSeason
This class checks if (month,day) falls in spring: Mar20-Jun20 using compound or conditions.
Args-based: parseInt args[0/1] to int; logical || chains March(>=20), Apr(all), May(all), June(<=20).
Exact outputs match hint; assumes valid 1-12 month, valid day.
Usage: java SpringSeason 4 15 -> "Its a Spring Season"; 7 1 -> "Not a Spring Season".
*/

public class SpringSeason {
    // Public class validates spring window.

    public static void main(String[] args) {
        // Command-line date processor.

        int month = Integer.parseInt(args[0]);   //To convert string to integer for calculations(parseInt)
        // Parses first arg as month (1-12 expected).

        int day = Integer.parseInt(args[1]);
        // Parses second arg as day-of-month.

        if ((month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20)) {
            // Compound spring criteria: Mar>=20d OR Apr(any) OR May(any) OR Jun<=20d.

            System.out.println("Its a Spring Season");
            // Positive exact phrase.
        } else {
            // Outside window.

            System.out.println("Not a Spring Season");
            // Negative confirmation.
        }
    }
    // Main args handling ends.
}
// Class seasonal check done.
