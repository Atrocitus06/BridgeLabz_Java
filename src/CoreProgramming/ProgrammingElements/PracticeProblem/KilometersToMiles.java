package core_programming.ProgrammingElements.PracticeProblem;/*5. Convert Kilometers to Miles
Write a program that takes the distance in kilometers as input from the user
and converts it into miles using the formula:
Miles = Kilometers * 0.621371.
*/

import java.util.Scanner;

public class KilometersToMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double kilometers;
        double miles;

        System.out.print("Enter distance in kilometers: ");
        kilometers = sc.nextDouble();

        miles = kilometers * 0.621371;

        System.out.printf("Distance in Miles = %.2f", miles);
    }
}
