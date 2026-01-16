package core_programming.String.Level2;
/*
Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade as shown in figure below

Hint =>
Write a method to generate random 2-digit scores for Physics, Chemistry and Math (PCM) for the students and return the scores. This method returns a 2D array with PCM scores for all students
Write a Method to calculate the total, average, and percentages for each student and return a 2D array with the corresponding values. Please ensure to round off the values to 2 Digits using Math.round() method
Write a Method to calculate the grade based on the percentage as shown in the ref table and return a 2D array of students' grade
Finally write a Method to display the scorecard of all students with their scores, total, average, percentage, and grade in a tabular format.
*/

import java.util.Scanner;

public class StudentGrade {

    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];

        for (int i = 0; i < n; i++) {
            scores[i][0] = (int) (Math.random() * 51) + 50; // Physics
            scores[i][1] = (int) (Math.random() * 51) + 50; // Chemistry
            scores[i][2] = (int) (Math.random() * 51) + 50; // Maths
        }
        return scores;
    }

    static double[][] calculateResults(int[][] scores) {

        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    static String[] calculateGrade(double[][] result) {

        String[] grades = new String[result.length];

        for (int i = 0; i < result.length; i++) {
            double percent = result[i][2];

            if (percent >= 80)
                grades[i] = "A";
            else if (percent >= 70)
                grades[i] = "B";
            else if (percent >= 60)
                grades[i] = "C";
            else if (percent >= 50)
                grades[i] = "D";
            else if (percent >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }
        return grades;
    }

    static void displayScorecard(int[][] scores, double[][] result, String[] grades) {

        System.out.println("\nSTUDENT SCORECARD");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t" +
                    scores[i][2] + "\t" +
                    (int) result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +
                    grades[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] result = calculateResults(scores);
        String[] grades = calculateGrade(result);

        displayScorecard(scores, result, grades);

        sc.close();
    }
}
