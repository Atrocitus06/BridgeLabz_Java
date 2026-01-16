package core_programming.ProgrammingElements.Level1;/*Write a program that takes the base and height to find area of a triangle in square inches and square centimeters
Hint => Area of a Triangle is ½ * base * height
I/P => base, height
O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
*/

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double base;
        double height;
        double areaInSquareInches;
        double areaInSquareCm;

        System.out.print("Enter base in inches: ");
        base = input.nextDouble();

        System.out.print("Enter height in inches: ");
        height = input.nextDouble();

        areaInSquareInches = 0.5 * base * height;
        areaInSquareCm = areaInSquareInches * 2.54 * 2.54;

        System.out.println(
                "The area of triangle in square inches is " + areaInSquareInches +
                        " and in square centimeters is " + areaInSquareCm
        );
    }
}
