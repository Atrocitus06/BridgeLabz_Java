package core_programming.Extras.Built_in_Functions;
/*
6. Factorial Using Recursion:
○ Write a program that calculates the factorial of a number using a recursive
function.
○ Include modular code to separate input, calculation, and output processes.
 */

import java.util.Scanner;

public class FactorialRecursion {

    public static int takeInput(Scanner sc) {
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void displayResult(int n, int result) {
        System.out.println("Factorial of " + n + " is: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = takeInput(sc);
        int result = factorial(number);
        displayResult(number, result);
    }
}
