package core_programming.ProgrammingElements.Level2;/*
An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
I/P => side1, side2, side3
O/P => The total number of rounds the athlete will run is ___ to complete 5 km
*/

import java.util.Scanner;

public class AtheleteRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double side1;
        double side2;
        double side3;
        double perimeter;
        double totalDistance;
        double rounds;

        System.out.print("Enter side 1 of the triangular park (in meters): ");
        side1 = input.nextDouble();

        System.out.print("Enter side 2 of the triangular park (in meters): ");
        side2 = input.nextDouble();

        System.out.print("Enter side 3 of the triangular park (in meters): ");
        side3 = input.nextDouble();

        perimeter = side1 + side2 + side3;
        totalDistance = 5000; // 5 km = 5000 meters

        rounds = totalDistance / perimeter;

        System.out.println(
                "The total number of rounds the athlete will run is " + rounds +
                        " to complete 5 km"
        );
    }
}
