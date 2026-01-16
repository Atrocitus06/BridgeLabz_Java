package core_programming.ProgrammingElements.Level2;/*1. Calculate Simple Interest
Write a program to calculate simple interest using the formula:
Simple Interest = (Principal * Rate * Time) / 100.
Take Principal, Rate, and Time as inputs from the user.
*/

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double principal;
        double rate;
        double time;
        double simpleInterest;

        System.out.print("Enter Principal: $ ");
        principal = sc.nextDouble();

        System.out.print("Enter Rate: ");
        rate = sc.nextDouble();

        System.out.print("Enter Time: ");
        time = sc.nextDouble();

        simpleInterest = (principal * rate * time) / 100;

        System.out.printf("Simple Interest = $ %.2f", simpleInterest);
    }
}

