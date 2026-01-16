package core_programming.ProgrammingElements.PracticeProblem;/*
2. Perimeter of a Rectangle
Write a program to calculate the perimeter of a rectangle. Take the length
and width as inputs and use the formula:
Perimeter = 2 * (length + width).
*/

import java.util.Scanner;

public class PeriRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double length;
        double width;
        double perimeter;

        System.out.print("Enter length: ");
        length = sc.nextDouble();

        System.out.print("Enter width: ");
        width = sc.nextDouble();

        perimeter = 2 * (length + width);

        System.out.println("Perimeter of Rectangle = " + perimeter);
    }
}
