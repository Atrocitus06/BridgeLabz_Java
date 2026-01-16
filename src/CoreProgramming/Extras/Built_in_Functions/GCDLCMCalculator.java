package core_programming.Extras.Built_in_Functions;
/*
7. GCD and LCM Calculator:
○ Create a program that calculates the Greatest Common Divisor (GCD) and Least
Common Multiple (LCM) of two numbers using functions.
○ Use separate functions for GCD and LCM calculations, showcasing how modular
code works.
 */

import java.util.Scanner;

public class GCDLCMCalculator {

    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
}
