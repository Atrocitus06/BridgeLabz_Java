package core_programming.ProgrammingElements.PracticeProblem;/*
4. Area of a Circle
Write a program to calculate the area of a circle. Take the radius as input
and use the formula:
Area = π * radius^2.
*/

import java.util.Scanner;

public class AreaCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double radius;
        double area;

        System.out.print("Enter radius: ");
        radius = sc.nextDouble();

        area = Math.PI * Math.pow(radius, 2);

        System.out.printf("Area of Circle = %.2f cm^2", area);
    }
}
