package core_programming.ProgrammingElements.PracticeProblem;/*2. Add Two Numbers
Write a program that takes two numbers as input from the user and prints
their sum.
*/

import java.util.Scanner;

public class AddtwoNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int sum = a + b;

        System.out.println("Sum = " + sum);
    }
}
