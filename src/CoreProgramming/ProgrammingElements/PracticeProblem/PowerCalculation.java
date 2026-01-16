package core_programming.ProgrammingElements.PracticeProblem;/*
3. Power Calculation
Write a program that takes two numbers as input: a base and an exponent,
and prints the result of base raised to the exponent (without using loops or
conditionals).
*/

import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base;
        double exponent;
        double result;

        System.out.print("Enter base: ");
        base = sc.nextDouble();

        System.out.print("Enter exponent: ");
        exponent = sc.nextDouble();

        result = Math.pow(base, exponent);

        System.out.println("Result = " + result);
    }
}
