package core_programming.ProgrammingElements.Level2;/*
Rewrite the Sample Program 2 with user inputs
Hint =>
Create variables and take user inputs for name, fromCity, viaCity, toCity
Create variables and take user inputs for distances fromToVia and viaToFinalCity in Miles
Create Variables and take time taken
Finally, print the result and try to understand operator precedence.
I/P => fee, discountPrecent
O/P => The results of Int Operations are ___, ___, and ___
*/

import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name;
        String fromCity;
        String viaCity;
        String toCity;

        double fromToVia;
        double viaToFinalCity;
        double timeTaken;
        double totalDistance;
        double speed;

        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.print("Enter starting city: ");
        fromCity = input.nextLine();

        System.out.print("Enter via city: ");
        viaCity = input.nextLine();

        System.out.print("Enter destination city: ");
        toCity = input.nextLine();

        System.out.print("Enter distance from start to via city (miles): ");
        fromToVia = input.nextDouble();

        System.out.print("Enter distance from via city to destination (miles): ");
        viaToFinalCity = input.nextDouble();

        System.out.print("Enter time taken (hours): ");
        timeTaken = input.nextDouble();

        totalDistance = fromToVia + viaToFinalCity;
        speed = totalDistance / timeTaken;

        System.out.println(
                name + " travelled from " + fromCity + " to " + toCity +
                        " via " + viaCity +
                        ". Total distance is " + totalDistance +
                        " miles and speed is " + speed + " miles/hour."
        );
    }
}
