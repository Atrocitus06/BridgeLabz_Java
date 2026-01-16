package core_programming.ProgrammingElements.Level2;/*
Write a program to take 2 numbers and print their quotient and reminder
Hint => Use division operator (/) for quotient and moduli operator (%) for reminder
I/P => number1, number2
O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___
*/

import java.util.Scanner;

public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number1;
        int number2;
        int quotient;
        int remainder;

        System.out.print("Enter first number: ");
        number1 = input.nextInt();

        System.out.print("Enter second number: ");
        number2 = input.nextInt();

        quotient = number1 / number2;
        remainder = number1 % number2;

        System.out.println(
                "The Quotient is " + quotient +
                        " and Reminder is " + remainder +
                        " of two number " + number1 +
                        " and " + number2
        );
    }
}
