package core_programming.Extras.Built_in_Functions;
/*
4. Fibonacci Sequence Generator:
○ Write a program that generates the Fibonacci sequence up to a specified number
of terms entered by the user.
○ Organize the code by creating a function that calculates and prints the Fibonacci
sequence.
 */

import java.util.Scanner;

public class Fibonacci {


    public static void generateFibonacci(int n) {
        int a = 0, b = 1;

        if (n <= 0) {
            return;
        }

        System.out.print("Fibonacci Sequence: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        generateFibonacci(n);
    }
}
