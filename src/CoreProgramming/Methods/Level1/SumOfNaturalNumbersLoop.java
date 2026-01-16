package core_programming.Methods.Level1;
/*
Write a program to find the sum of n natural numbers using loop
Hint => Get integer input from the user. Write a Method to find the sum of
n natural numbers using loop
*/



import java.util.Scanner;

public class SumOfNaturalNumbersLoop {

    static int findSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int result = findSum(n);

        System.out.println("Sum of first " + n + " natural numbers is: " + result);

        sc.close();
    }
}
