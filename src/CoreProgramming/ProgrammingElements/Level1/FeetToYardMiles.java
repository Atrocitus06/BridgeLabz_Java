package core_programming.ProgrammingElements.Level1;/*
Write a program the find the distance in yards and miles for the distance provided by user in feets
Hint => 1 mile = 1760 yards and 1 yard is 3 feet
I/P => distanceInFeet
O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
*/

import java.util.Scanner;

public class FeetToYardMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double distanceInFeet;
        double distanceInYards;
        double distanceInMiles;

        System.out.print("Enter distance in feet: ");
        distanceInFeet = input.nextDouble();

        distanceInYards = distanceInFeet / 3;
        distanceInMiles = distanceInYards / 1760;

        System.out.println(
                "Your distance in feet is " + distanceInFeet +
                        " while in yards is " + distanceInYards +
                        " and miles is " + distanceInMiles
        );
    }
}
