package core_programming.Extras.Built_in_Functions;
/*
2. Maximum of Three Numbers:
○ Write a program that takes three integer inputs from the user and finds the
maximum of the three numbers.
○ Ensure your program follows best practices for organizing code into modular
functions, such as separate functions for taking input and calculating the
maximum value.
 */

import java.util.Scanner;

public class MaximumOfThree {

    public static int takeInput(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    public static int findMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = takeInput(sc, "Enter first number: ");
        int num2 = takeInput(sc, "Enter second number: ");
        int num3 = takeInput(sc, "Enter third number: ");

        int max = findMaximum(num1, num2, num3);

        System.out.println("Maximum of the three numbers is: " + max);
    }
}
