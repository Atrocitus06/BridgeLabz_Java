package core_programming.Methods.Level3;
/*
Create a program to take input marks of students in 3 subjects physics, chemistry,
and maths. Compute the total, average, and the percentage score
Hint =>
Take input for the number of students
Write a method to generate random 2-digit scores for Physics, Chemistry,
and Math (PCM) for the students and return the scores. This method returns a 2D
array with PCM scores for all students
Write a Method to calculate the total, average, and percentages for each student and
return a 2D array with the corresponding values. Please ensure to round off the
values to 2 Digits using the Math.round() method.
Finally, write a Method to display the scorecard of all students with their scores,
total, average, and percentage in a tabular format using "\t".
*/

import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] generatePCMScores(int students) {

        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10; // Physics
            scores[i][1] = (int) (Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int) (Math.random() * 90) + 10; // Maths
        }

        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {

        double[][] results = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {

            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }

        return results;
    }

    public static void displayScoreCard(int[][] scores, double[][] results) {

        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                            scores[i][0] + "\t" +
                            scores[i][1] + "\t\t" +
                            scores[i][2] + "\t" +
                            (int) results[i][0] + "\t" +
                            results[i][1] + "\t" +
                            results[i][2]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] scores = generatePCMScores(students);

        double[][] results = calculateResults(scores);

        System.out.println("\nSTUDENT SCORECARD");
        displayScoreCard(scores, results);

        sc.close();
    }
}
