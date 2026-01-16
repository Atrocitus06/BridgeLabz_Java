package core_programming.ProgrammingElements.Level2;//7. Java Program to Swap Two Numbers

import java.util.Scanner;

public class Swap_num {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.printf("Enter 1st number: a = ");
        int a = s.nextInt();
        System.out.printf("Enter 2nd number: b = ");
        int b = s.nextInt();

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After swapping: ");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
