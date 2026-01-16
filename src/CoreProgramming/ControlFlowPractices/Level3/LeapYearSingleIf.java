package core_programming.ControlFlowPractices.Level3;/*
Rewrite program 1 to determine Leap Year with single if condition using logical and && and
or || operators
*/

import java.util.Scanner;

public class LeapYearSingleIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int year;

        System.out.print("Enter a year: ");
        year = input.nextInt();

        if (year >= 1582 &&
                (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {

            System.out.println("Year is a Leap Year");
        } else {
            System.out.println("Year is not a Leap Year");
        }
    }
}
