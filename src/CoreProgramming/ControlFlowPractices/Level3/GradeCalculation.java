package core_programming.ControlFlowPractices.Level3;/*
Write a program to input marks and 3 subjects physics, chemistry and maths. Compute the percentage and then calculate the grade as per the following guidelines

Hint =>
Ensure the Output clearly shows the Average Mark as well as the Grade and Remarks
*/

import java.util.Scanner;

public class GradeCalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double physics;
        double chemistry;
        double maths;
        double average;
        String grade;
        String remarks;

        System.out.print("Enter Physics marks: ");
        physics = input.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        chemistry = input.nextDouble();

        System.out.print("Enter Maths marks: ");
        maths = input.nextDouble();

        average = (physics + chemistry + maths) / 3;

        if (average >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Level 2, below but approaching standards";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Level 1, well below standards";
        } else if (average >= 40) {
            grade = "E";
            remarks = "Too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        System.out.println("\nAverage Mark = " + average + "%");
        System.out.println("Grade = " + grade);
        System.out.println("Remarks = " + remarks);
    }
}
