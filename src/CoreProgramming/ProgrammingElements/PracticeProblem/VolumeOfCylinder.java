package core_programming.ProgrammingElements.PracticeProblem;/*
5. Volume of a Cylinder
Write a program to calculate the volume of a cylinder. Take the radius and
height as inputs and use the formula:
Volume = π * radius^2 * height.
*/


import java.util.Scanner;

public class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double radius;
        double height;
        double volume;

        System.out.print("Enter radius: ");
        radius = sc.nextDouble();

        System.out.print("Enter height: ");
        height = sc.nextDouble();

        volume = Math.PI * Math.pow(radius, 2) * height;

        System.out.printf("Volume of Cylinder = %.2f cm^3", volume);
    }
}
