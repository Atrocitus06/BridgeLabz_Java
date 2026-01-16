package core_programming.ControlFlowPractices.Level3;/*
Write a ControlFlowPractices.Level3.LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year.
Hint =>
The ControlFlowPractices.Level3.LeapYear program only works for year >= 1582, corresponding to a year in the Gregorian calendar.
 So ensure to check for the same.
Further, the Leap Year is a Year divisible by 4 and not 100 unless it is divisible by 400.
 E.g. 1800 is not a Leap Year and 2000 is a Leap Year.
Write code having multiple if else statements based on conditions provided above and a
second part having only one if statement and multiple logical
 */

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int year;

        System.out.print("Enter a year: ");
        year = input.nextInt();

        // ---------- PART 1: Using multiple if-else ----------
        if (year >= 1582) {

            if (year % 400 == 0) {
                System.out.println("Using multiple if-else: Year is a Leap Year");
            } else if (year % 100 == 0) {
                System.out.println("Using multiple if-else: Year is NOT a Leap Year");
            } else if (year % 4 == 0) {
                System.out.println("Using multiple if-else: Year is a Leap Year");
            } else {
                System.out.println("Using multiple if-else: Year is NOT a Leap Year");
            }

        } else {
            System.out.println("Year should be greater than or equal to 1582");
        }

        // ---------- PART 2: Using single if with logical operators ----------
        if (year >= 1582 &&
                (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {

            System.out.println("Using single if: Year is a Leap Year");
        } else if (year >= 1582) {
            System.out.println("Using single if: Year is NOT a Leap Year");
        }
    }
}
