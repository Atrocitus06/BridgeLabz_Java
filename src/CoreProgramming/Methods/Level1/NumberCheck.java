package core_programming.Methods.Level1;
/*
Write a program to check whether a number is positive, negative, or zero.
Hint => Get integer input from the user. Write a Method to return
-1 for negative number, 1 for positive number and 0 if number is zero
*/

import java.util.Scanner;

public class NumberCheck {

    static int checkNumber(int num) {
        if (num > 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int result = checkNumber(number);

        System.out.println("Result: " + result);

        sc.close();
    }
}
