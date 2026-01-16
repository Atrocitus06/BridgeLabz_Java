package core_programming.ProgrammingElements.PracticeProblem;/*4. Calculate Average of Three Numbers
Write a program that takes three numbers as input from the user and prints
their average.
*/

import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a;
        double b;
        double c;
        double average;

        System.out.print("Enter first number: ");
        a = sc.nextDouble();

        System.out.print("Enter second number: ");
        b = sc.nextDouble();

        System.out.print("Enter third number: ");
        c = sc.nextDouble();

        average = (a + b + c) / 3;

        System.out.println("Average = " + average);
    }
}
