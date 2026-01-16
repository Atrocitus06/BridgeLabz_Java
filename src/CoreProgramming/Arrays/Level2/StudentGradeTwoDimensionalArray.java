package core_programming.Arrays.Level2;/*
Rewrite the above program to store the marks of the students in physics, chemistry, and maths in a 2D array and then compute the percentage and grade
Hint =>
All the steps are the same as the problem 8 except the marks are stored in a 2D array
Use the 2D array to calculate the percentages, and grades of the students
*/

import java.util.Scanner;

public class StudentGradeTwoDimensionalArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfStudents;

        System.out.print("Enter number of students: ");
        numberOfStudents = input.nextInt();

        int[][] marks = new int[numberOfStudents][3];

        double[] percentage = new double[numberOfStudents];
        char[] grade = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            marks[i][0] = input.nextInt();

            System.out.print("Chemistry: ");
            marks[i][1] = input.nextInt();

            System.out.print("Maths: ");
            marks[i][2] = input.nextInt();

            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Invalid marks! Please enter positive values.");
                i--; // re-enter marks for same student
                continue;
            }

            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(
                    "Student " + (i + 1) +
                            " | Physics: " + marks[i][0] +
                            " | Chemistry: " + marks[i][1] +
                            " | Maths: " + marks[i][2] +
                            " | Percentage: " + percentage[i] + "%" +
                            " | Grade: " + grade[i]
            );
        }
    }
}
